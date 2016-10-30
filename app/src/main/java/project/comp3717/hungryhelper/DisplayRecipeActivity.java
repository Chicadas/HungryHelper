package project.comp3717.hungryhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recipe);

        Bundle b = this.getIntent().getExtras();
        String[] words = b.getStringArray("key");
        String everything = "";
        TextView text = (TextView)findViewById(R.id.textView6);
        for(int i = 0; i < words.length; i++){
            everything += words[i] + ", ";
        }
        text.setText(everything);
    }
}
