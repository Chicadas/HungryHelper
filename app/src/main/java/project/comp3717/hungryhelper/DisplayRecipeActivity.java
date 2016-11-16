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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);
        int myImage = 0;
        String myName = "";
        String myInstructions = "";
        String myIngredients = "";
        Bundle b = this.getIntent().getExtras();

        myName = b.getString("recipeName");
        myIngredients = b.getString("recipeIngredients");
        myInstructions = b.getString("recipeInstructions");
        myImage = b.getInt("recipeImage");


        setTitle(myName);


        TextView ingredientText = (TextView)findViewById(R.id.ingredients);
        ingredientText.setText(myIngredients);

        TextView instructionText = (TextView)findViewById(R.id.instructions);
        instructionText.setText(myInstructions);

        ImageView imageView = (ImageView)findViewById(R.id.recipeImage);
        imageView.setImageResource(myImage);



    }


}
