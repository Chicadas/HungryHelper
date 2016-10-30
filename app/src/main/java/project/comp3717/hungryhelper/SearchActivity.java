package project.comp3717.hungryhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchMatches(View view){
        Intent intent = new Intent(this, DisplayRecipeActivity.class);
        final Spinner proteinSpinner = (Spinner)findViewById(R.id.proteinSpinner);
        final Spinner vegetableSpinner = (Spinner)findViewById(R.id.vegetableSpinner);
        final Spinner carbSpinner = (Spinner)findViewById(R.id.carbSpinner);
        String protein = String.valueOf(proteinSpinner.getSelectedItem());
        String vegetable = String.valueOf(vegetableSpinner.getSelectedItem());
        String carb = String.valueOf(carbSpinner.getSelectedItem());

        Bundle b = new Bundle();
        b.putStringArray("key", new String[]{protein, vegetable, carb});
        intent.putExtras(b);
        startActivity(intent);
    }
}
