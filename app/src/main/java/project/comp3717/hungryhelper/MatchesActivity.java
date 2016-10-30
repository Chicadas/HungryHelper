package project.comp3717.hungryhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MatchesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        Bundle b = this.getIntent().getExtras();
        String[] words = b.getStringArray("key");

        TextView text = (TextView)findViewById(R.id.textView6);
        for(int i = 0; i < words.length; i++){
            text.setText(words[i]);
            Log.d("From spinner: ",words[i]);
        }
    }
}
