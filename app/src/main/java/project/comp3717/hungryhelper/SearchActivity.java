package project.comp3717.hungryhelper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static android.graphics.Color.WHITE;

public class SearchActivity extends AppCompatActivity {
    Button search;
    Button reset;
    EditText searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }
    public void init(){
        searchBar = (EditText) findViewById(R.id.editText);

        search = (Button) findViewById(R.id.searchButton);
        search.setBackgroundColor(Color.argb(255,255,165,0));
        search.setTextColor(WHITE);
        search.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        reset = (Button) findViewById(R.id.resetButton);
        reset.setBackgroundColor(Color.argb(255,255,165,0));
        reset.setTextColor(WHITE);
        reset.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    }
    public void resetField(View V){
        searchBar.setText("");
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