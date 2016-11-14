package project.comp3717.hungryhelper;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MatchesActivity extends AppCompatActivity {
    protected ListView lv;
    protected ListAdapter adapter;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);



//        Bundle b = this.getIntent().getExtras();
//        String[] words = b.getStringArray("key");
//        TextView text = (TextView)findViewById(R.id.textView6);
//        for(int i = 0; i < words.length; i++){
//            text.setText(words[i]);
//            Log.d("From spinner: ",words[i]);
//        }
        db = (new MyDBHandler(this, null, null, 1)).getWritableDatabase();
        lv = (ListView) findViewById(R.id.list);
        //et_db = (EditText) findViewById(R.id.et);

        try {
            cursor = db.rawQuery("SELECT * FROM Recipes", null);
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

    }
    public void styleList(){
       // lv.setTextColor(Color.argb(255,255,165,0));
        //lv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
    }

    public void detail(int position) {
        int im = 0;
        String _id = "";String nama = "";
        String bahan = "";
        String cara = "";
        if (cursor.moveToFirst()) {
              cursor.moveToPosition(position);
              image = cursor.getInt(cursor.getColumnIndex("img"));
              nama = cursor.getString(cursor.getColumnIndex("nama"));
              bahan = cursor.getString(cursor.getColumnIndex("bahan"));
              cara = cursor.getString(cursor.getColumnIndex("cara"));
//        }

        Intent iIntent = new Intent(this, DisplayRecipeActivity.class);
//        iIntent.putExtra("dataIM", im);
//        iIntent.putExtra("dataNama", nama);
//        iIntent.putExtra("dataBahan", bahan);
//        iIntent.putExtra("dataCara", cara);
//        setResult(RESULT_OK, iIntent);
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
