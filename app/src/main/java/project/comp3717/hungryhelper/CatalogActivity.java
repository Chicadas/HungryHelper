package project.comp3717.hungryhelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CatalogActivity extends AppCompatActivity {

    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        db = (new MyDBHandler(this, null, null, 1)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.catalog);

        cursor = db.rawQuery("SELECT * FROM Recipes"  , null);
        adapter = new SimpleCursorAdapter(this, R.layout.custom_listview, cursor,
                new String[] { "NAME", "IMAGE"}, new int[] {
                R.id.recipeTitle, R.id.imageView});

        lv.setAdapter(adapter);
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                detail(position);

            }

        });
    }

    public void detail(int position) {
        int image = 0;
        String _id = "";
        String name = "";
        String ingredients = "";
        String instructions = "";
        if (cursor.moveToFirst()) {
            cursor.moveToPosition(position);
            image = cursor.getInt(cursor.getColumnIndex("IMAGE"));
            name = cursor.getString(cursor.getColumnIndex("NAME"));
            ingredients = cursor.getString(cursor.getColumnIndex("INGREDIENTS"));
            instructions = cursor.getString(cursor.getColumnIndex("INSTRUCTIONS"));
        }

        Intent iIntent = new Intent(this, DisplayRecipeActivity.class);
        iIntent.putExtra("recipeImage", image);
        iIntent.putExtra("recipeName", name);
        iIntent.putExtra("recipeIngredients", ingredients);
        iIntent.putExtra("recipeInstructions", instructions);
        setResult(RESULT_OK, iIntent);
        startActivityForResult(iIntent, 99);
    }
}
