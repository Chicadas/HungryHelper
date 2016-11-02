package project.comp3717.hungryhelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static android.graphics.Color.WHITE;

public class SearchActivity extends AppCompatActivity {
    Button search;
    Button reset;
    EditText searchBar;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
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

        t1 = (TextView) findViewById(R.id.textView);
        t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        t1.setTextColor(Color.argb(255,255,165,0));
        t2 = (TextView) findViewById(R.id.textView2);
        t2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        t2.setTextColor(Color.argb(255,255,165,0));
        t3 = (TextView) findViewById(R.id.textView3);
        t3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        t3.setTextColor(Color.argb(255,255,165,0));
        t4 = (TextView) findViewById(R.id.textView4);
        t4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        t4.setTextColor(Color.argb(255,255,165,0));
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
