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
                                                                                                        "' 1.) Bring a large pot of lightly salted water to a boil. Cook noodles in boiling water for 8 to 10 minutes, or until al dente; drain. \n\n 2.) In a large skillet over medium heat, saute ground beef, onions, salt and garlic salt until meat is brown. Drain excess fat, add spaghetti sauce to beef mixture, and bring to a boil. Reduce heat, and simmer for 15 to 20 minutes. \n\n 3.) Preheat oven to 350 degrees F (175 degrees C). Grease a 9x13 inch glass baking pan. \n\n 4.) Line bottom of pan with three lasagna noodles. Spread 1/3 of sauce mixture over noodles. Layer 1/3 of the cottage cheese over the sauce. Sprinkle 1/3 of the mozzarella over the cottage cheese. Repeat this layering process until all ingredients are used up. \n\n 5.) Bake in the preheated oven for one hour. Let stand for 10 minutes before serving. '," +
                                                                                                        R.drawable.lasanga +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Bolognese Stuffed Bell Peppers', " +
                                                                                                        "' 1/2 cup cooked rice \n 2 tablespoons olive oil, divided \n 1/8 cup minced carrots \n 1/8 cup celery \n 6 bell peppers (any color) stems and seeds removed, cut in half lengthwise \n 1/2 pound ground beef \n 1/4 pound pancetta or lightly smoked bacon, diced \n  1 1/2 cups prepared marinara sauce \n 1/4 cup red wine \n 1/2 teaspoon red pepper flakes \n 1/3 cup heavy cream \n 1/2 cup grated Parmesan cheese, divided' ," +
                                                                                                        "' 1.) Preheat oven to 375 degrees F (190 degrees C). \n\n 2.) Heat 1 tablespoon olive oil in a skillet over medium heat. Stir in the carrots and celery; cook and stir until the vegetables are tender, about 5 minutes. \n\n  3.) Stir in ground beef and pancetta, and cook until browned and crumbled; drain off any excess liquid, and return to heat. Add marinara sauce, wine, and red pepper flakes, and simmer for 10 minutes. Stir in cream, half of the Parmesan cheese, and rice. Simmer 5 minutes more, or until most liquid has absorbed. \n\n 4.) Place peppers in a shallow baking dish, and fill with beef mixture. Drizzle with remaining olive oil and top with remaining Parmesan cheese. \n\n 5.) Bake, uncovered, for 30 minutes in the preheated oven. Serve hot. ', " +
                                                                                                        R.drawable.peppers +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Slow Cooker Beef Stew', " +
                                                                                                        "' 2 pounds beef stew meat, cut into 1 inch cubes \n 1/4 cup all-purpose flour \n 1/2 teaspoon salt \n 1/2 teaspoon ground black pepper \n 1 clove garlic, minced \n 1 bay leaf \n 1 teaspoon paprika \n 1 teaspoon Worcestershire sauce \n 1 onion, chopped \n 1 1/2 cups beef broth \n  3 potatoes, diced \n 4 carrots, sliced \n 1 stalk celery, chopped' ," +
                                                                                                        "' 1.) Place meat in slow cooker. In a small bowl mix together the flour, salt, and pepper; pour over meat, and stir to coat meat with flour mixture. Stir in the garlic, bay leaf, paprika, Worcestershire sauce, onion, beef broth, potatoes, carrots, and celery. \n\n 2.) Cover, and cook on Low setting for 10 to 12 hours, or on High setting for 4 to 6 hours. ', " +
                                                                                                        R.drawable.beefstew +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Pot Roast', " +
                                                                                                        "' 2 (10.75 ounce) cans condensed cream of mushroom soup \n 1 (1 ounce) package dry onion soup mix \n 1 1/4 cups water \n 5 1/2 pounds pot roast' , " +
                                                                                                        "' 1.) In a slow cooker, mix cream of mushroom soup, dry onion soup mix and water. Place pot roast in slow cooker and coat with soup mixture. \n\n 2.) Cook on High setting for 3 to 4 hours, or on Low setting for 8 to 9 hours.', " +
                                                                                                        R.drawable.potroast +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Filet Mignon with Balsamic Glaze', " +
                                                                                                        "' 2 (4 ounce) filet mignon steaks \n 1/2 teaspoon freshly ground black pepper to taste \n salt to taste \n 1/4 cup balsamic vinegar \n 1/4 cup dry red wine', " +
                                                                                                        "' 1.) Sprinkle freshly ground pepper over both sides of each steak, and sprinkle with salt to taste. \n\n 2.) Heat a nonstick skillet over medium-high heat. Place steaks in hot pan, and cook for 1 minute on each side, or until browned. Reduce heat to medium-low, and add balsamic vinegar and red wine. Cover, and cook for 4 minutes on each side, basting with sauce when you turn the meat over. \n\n 3.) Remove steaks to two warmed plates, spoon one tablespoon of glaze over each, and serve immediately. ', " +
                                                                                                        R.drawable.filet +
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
     *
     * @return a recipe name
     */
    public ArrayList<String> getName(){
        SQLiteDatabase db = this.getWritableDatabase();
        // Select distinct
        String sqlStatement = "SELECT DISTINCT " + COLUMN_RECIPE_NAME + " FROM " + TABLE_RECIPES ;
        Cursor c = db.rawQuery(sqlStatement, null);

        ArrayList<String> list = new ArrayList<String>();
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        db.close();
        return list;
    }
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
