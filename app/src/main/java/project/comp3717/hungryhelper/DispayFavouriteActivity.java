package project.comp3717.hungryhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DispayFavouriteActivity extends AppCompatActivity {

    private String myName;
    private String myInstructions;
    private String myIngredients;
    private int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispay_favourite);
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

        TextView ingredientText = (TextView) findViewById(R.id.ingredients);
        ingredientText.setText(myIngredients);

        TextView instructionText = (TextView) findViewById(R.id.instructions);
        instructionText.setText(myInstructions);

        ImageView imageView = (ImageView) findViewById(R.id.recipeImage);
        imageView.setImageResource(myImage);

    }
}