package project.comp3717.hungryhelper;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MatchesActivity extends AppCompatActivity {
    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);



          Bundle b = this.getIntent().getExtras();
          String[] words = b.getStringArray("key");
          int  length = words.length;
          String searchFor = "";
          String protein = "";
          String vegetable = "";
          String carb = "";

        switch(length){
            case 1:
                searchFor += words[0];
                break;
            case 2:
                searchFor += words[0] + " OR " + words[1];
                break;
            case 3:
                searchFor += words[0] + " OR " + words[1] + " OR " + words[2];
                break;
        }

          for(int i = 0; i < words.length; i++){

              Log.d("From spinner: ",words[i]);
        }
        if(words.length != 0) {
            db = (new MyDBHandler(this, null, null, 1)).getWritableDatabase();
            lv = (ListView) findViewById(R.id.list);
            //et_db = (EditText) findViewById(R.id.et);

            try {
                cursor = db.rawQuery("SELECT * FROM Recipes WHERE INGREDIENTS LIKE \'%Chicken%\'"  , null);
                Log.d("count : ", "" + cursor.getCount());
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            styleList();

        } else {
            String fail = " You failed to enter any delicious ingredients ";
            Toast.makeText(this, fail, Toast.LENGTH_LONG).show();

        }


    }
    public void styleList(){
       // lv.setTextColor(Color.argb(255,255,165,0));
        //lv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
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


    protected void onListItemClick(ListView l, final View v, int position, long id) {

        onListItemClick(l, v, position, id);
        //int itemPosition     = position;
        final String  itemValue    = (String) l.getItemAtPosition(position);
        Log.d("im clicking on ", itemValue);
        Intent intent = new Intent(this, DisplayRecipeActivity.class);
        //intent.putExtra("courses",itemValue);
        startActivity(intent);
    }
}
