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

        //MyDBHandler myDBingredients = new MyDBHandler(this, null, null, 1);
        //ArrayList<String> ingredients =  myDBingredients.displayIngredients(myName);
        TextView ingredientText = (TextView)findViewById(R.id.ingredients);
        //String val = ingredients.get(0);
        ingredientText.setText(myIngredients);
       // myDBingredients.close();
        /**
         * Handling instructions
         */
       // MyDBHandler myDBinstructions = new MyDBHandler(this, null, null, 1);
       // ArrayList<String> instructions =  myDBinstructions.displayInstructions(myName);
        TextView instructionText = (TextView)findViewById(R.id.instructions);
        //String val2 = instructions.get(0);
        instructionText.setText(myInstructions);
        //myDBinstructions.close();
        /**
         * Handling images
         */
        // android:src ="@drawable/lasanga"
        //MyDBHandler myDBimages = new MyDBHandler(this, null, null, 1);
        //ArrayList<Integer> images =  myDBimages.displayImage(myName);
        ImageView imageView = (ImageView)findViewById(R.id.recipeImage);
        //int val3 = images.get(0);
        imageView.setImageResource(myImage);
        //myDBimages.close();



    }


}
