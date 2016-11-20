package project.comp3717.hungryhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayRecipeActivity extends AppCompatActivity {

    private String myName;
    private String myInstructions;
    private String myIngredients;
    private int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);
        myImage = 0;
        myName = "";
        myInstructions = "";
        myIngredients = "";
        Bundle b = this.getIntent().getExtras();

        myName = b.getString("recipeName");
        myIngredients = b.getString("recipeIngredients");
        myInstructions = b.getString("recipeInstructions");
        myImage = b.getInt("recipeImage");


        TextView recipeTitle = (TextView) findViewById(R.id.recipe_title);

        recipeTitle.setText(myName);

        setTitle(myName);


        TextView ingredientText = (TextView)findViewById(R.id.ingredients);
        ingredientText.setText(myIngredients);

        TextView instructionText = (TextView)findViewById(R.id.instructions);
        instructionText.setText(myInstructions);

        ImageView imageView = (ImageView)findViewById(R.id.recipeImage);
        imageView.setImageResource(myImage);

    }

    public void favourite(View view){
        MyDBHandler db = (new MyDBHandler(this, null, null, 1));
        db.AddFavourite(myName, myInstructions, myIngredients, myImage);
        db.close();
    }

}
