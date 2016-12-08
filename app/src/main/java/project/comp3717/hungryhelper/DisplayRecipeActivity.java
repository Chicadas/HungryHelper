package project.comp3717.hungryhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageButton btn = (ImageButton)findViewById(R.id.imageButton);
        btn.setImageResource(R.drawable.heartbutton4);
        MyDBHandler db = (new MyDBHandler(this, null, null, 1));
        db.AddFavourite(myName, myInstructions, myIngredients, myImage);
        db.close();

        Toast.makeText(DisplayRecipeActivity.this,
                "Added to favourites ",
                Toast.LENGTH_SHORT).show();
    }

}
