package project.comp3717.hungryhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by shanejackson on 2016-11-06.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HungryHelper.db";
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
                + COLUMN_RECIPE_IMAGE + " BLOB EXT NOT NULL"
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INTSTRUCTIONS, IMAGE) VALUES ('Lasagna', 'Beef and Noodles what else', 'In a Dutch oven, cook sausage, ground beef, onion, and garlic over medium heat until well browned. Stir in crushed tomatoes, tomato paste, tomato sauce, and water. Season with sugar, basil, fennel seeds, Italian seasoning, 1 tablespoon salt, pepper, and 2 tablespoons parsley. Simmer, covered, for about 1 1/2 hours, stirring occasionally.\n" +
                "Bring a large pot of lightly salted water to a boil. Cook lasagna noodles in boiling water for 8 to 10 minutes. Drain noodles, and rinse with cold water. In a mixing bowl, combine ricotta cheese with egg, remaining parsley, and 1/2 teaspoon salt.\n" +
                "Preheat oven to 375 degrees F (190 degrees C).\n" +
                "To assemble, spread 1 1/2 cups of meat sauce in the bottom of a 9x13 inch baking dish. Arrange 6 noodles lengthwise over meat sauce. Spread with one half of the ricotta cheese mixture. Top with a third of mozzarella cheese slices. Spoon 1 1/2 cups meat sauce over mozzarella, and sprinkle with 1/4 cup Parmesan cheese. Repeat layers, and top with remaining mozzarella and Parmesan cheese. Cover with foil: to prevent sticking, either spray foil with cooking spray, or make sure the foil does not touch the cheese.\n" +
                "Bake in preheated oven for 25 minutes. Remove foil, and bake an additional 25 minutes. Cool for 15 minutes before serving.', ''img )");
    }
    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion,
                           int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }
}
