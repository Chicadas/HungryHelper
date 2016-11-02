package project.comp3717.hungryhelper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import static android.graphics.Color.WHITE;

public class HomeActivity extends AppCompatActivity {
    Button search;
    Button faves;
    Button catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        init();
    }

    public void init(){
        search = (Button) findViewById(R.id.searchButton);
        search.setBackgroundColor(Color.argb(255,255,165,0));
        search.setTextColor(WHITE);
        search.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        faves = (Button) findViewById(R.id.favouritesButton);
        faves.setBackgroundColor(Color.argb(255,255,165,0));
        faves.setTextColor(WHITE);
        faves.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        catalog = (Button) findViewById(R.id.catalogButton);
        catalog.setBackgroundColor(Color.argb(255,255,165,0));
        catalog.setTextColor(WHITE);
        catalog.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

    }

    public void searchScreen(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void  favouritesScreen(View view){
        Intent intent = new Intent(this, FavouritesActivity.class);
        startActivity(intent);
    }

    public void catalogScreen(View view){
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivity(intent);
    }
}
