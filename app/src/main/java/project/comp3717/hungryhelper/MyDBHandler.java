package project.comp3717.hungryhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shanejackson on 2016-11-06.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    // DatabseUtils.dumbCurstontoString(curstor
    // int numb = cursor.getCount
    // get column names
    // google cusrsor get column names
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Hungry.db";
    private static final String TABLE_RECIPES = "Recipes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RECIPE_NAME = "NAME";
    public static final String COLUMN_RECIPE_INGREDIENTS = "INGREDIENTS";
    public static final String COLUMN_RECIPE_INSTRUCTIONS = "INTSTRUCTIONS";
    public static final String COLUMN_RECIPE_IMAGE = "IMAGE";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_RECIPES + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RECIPE_NAME + " TEXT NOT NULL, "
                + COLUMN_RECIPE_INGREDIENTS + "  TEXT NOT NULL, "
                + COLUMN_RECIPE_INSTRUCTIONS + " TEXT NOT NULL, "
                + COLUMN_RECIPE_IMAGE + " INTEGER "
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Bobs Awesome Lasagna', " +
                                                                                                        "' 8 ounces lasagna noodles \n 1 pound ground beef \n 1/4 cup minced onions \n 1 teaspoon salt \n 1/2 teaspoon garlic salt  \n 1 (32 ounce) jar spaghetti sauce \n 1 (16 ounce) package large curd cottage cheese \n 1 pound mozzarella cheese, shredded', " +
                                                                                                        "'1.) Bring a large pot of lightly salted water to a boil. Cook noodles in boiling water for 8 to 10 minutes, or until al dente; drain. \n 2.) In a large skillet over medium heat, saute ground beef, onions, salt and garlic salt until meat is brown. Drain excess fat, add spaghetti sauce to beef mixture, and bring to a boil. Reduce heat, and simmer for 15 to 20 minutes. \n 3.) Preheat oven to 350 degrees F (175 degrees C). Grease a 9x13 inch glass baking pan. \n 4.) Line bottom of pan with three lasagna noodles. Spread 1/3 of sauce mixture over noodles. Layer 1/3 of the cottage cheese over the sauce. Sprinkle 1/3 of the mozzarella over the cottage cheese. Repeat this layering process until all ingredients are used up. \n 5.) Bake in the preheated oven for one hour. Let stand for 10 minutes before serving. '," +
                                                                                                        R.drawable.lasanga +
                                                                                                        ")");
    }
    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion,
                           int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }

    /*public ArrayList<String> getAllRecipes(){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlStatement = "SELECT * FROM " + TABLE_RECIPES;
        Cursor c = db.rawQuery(sqlStatement, null);

        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<>();
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            map.put();
            list.add(c.getString(2));
            Log.d("TRYING TO CREATE", c.getString(2));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }*/

    /**
     * Returns an ingredient list for a given recipe.
     * @param recipeName
     * @return An arrarylist of  ingredients
     */
    public ArrayList<String> displayIngredients(String recipeName){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlStatement = "SELECT * FROM " + TABLE_RECIPES + " WHERE " + COLUMN_RECIPE_NAME + "=\'"
                + recipeName + "\'";
        Cursor c = db.rawQuery(sqlStatement, null);

        ArrayList<String> list = new ArrayList<String>();
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            list.add(c.getString(2));
            Log.d("TRYING TO CREATE", c.getString(2));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }

    /**
     * Returns an instruction set for a given recipe.
     * @param recipeName
     * @return An arrarylist of instructions
     */
    public ArrayList<String> displayInstructions(String recipeName){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlStatement = "SELECT * FROM " + TABLE_RECIPES + " WHERE " + COLUMN_RECIPE_NAME + "=\'"
                + recipeName + "\'";
        Cursor c = db.rawQuery(sqlStatement, null);

        ArrayList<String> list = new ArrayList<String>();
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            list.add(c.getString(3));
            Log.d("TRYING TO CREATE", c.getString(2));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }
    /**
     * Returns an image for a given recipe.
     * @param recipeName
     * @return An arrarylist of images
     */
    public ArrayList<Integer> displayImage(String recipeName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlStatement = "SELECT * FROM " + TABLE_RECIPES + " WHERE " + COLUMN_RECIPE_NAME + "=\'"
                + recipeName + "\'";

        Cursor c = db.rawQuery(sqlStatement, null);
        ArrayList<Integer> list = new ArrayList<Integer>();
        c.moveToFirst();

        String names[] = c.getColumnNames();
        for(String s: names){
            Log.d("column names ", s);
        }
        while(c.isAfterLast() == false) {
            Log.d("TRYING TO CREATE", c.getString(4));
            list.add(c.getInt(4));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }

}
