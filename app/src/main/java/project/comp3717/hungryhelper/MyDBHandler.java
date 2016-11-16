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
    public static final String COLUMN_RECIPE_INSTRUCTIONS = "INSTRUCTIONS";
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

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Bobs Awesome Lasagna', " +
                                                                                                        "' 8 ounces lasagna noodles \n 1 pound ground beef \n 1/4 cup minced onions \n 1 teaspoon salt \n 1/2 teaspoon garlic salt  \n 1 (32 ounce) jar spaghetti sauce \n 1 (16 ounce) package large curd cottage cheese \n 1 pound mozzarella cheese, shredded', " +
                                                                                                        "' 1.) Bring a large pot of lightly salted water to a boil. Cook noodles in boiling water for 8 to 10 minutes, or until al dente; drain. \n\n 2.) In a large skillet over medium heat, saute ground beef, onions, salt and garlic salt until meat is brown. Drain excess fat, add spaghetti sauce to beef mixture, and bring to a boil. Reduce heat, and simmer for 15 to 20 minutes. \n\n 3.) Preheat oven to 350 degrees F (175 degrees C). Grease a 9x13 inch glass baking pan. \n\n 4.) Line bottom of pan with three lasagna noodles. Spread 1/3 of sauce mixture over noodles. Layer 1/3 of the cottage cheese over the sauce. Sprinkle 1/3 of the mozzarella over the cottage cheese. Repeat this layering process until all ingredients are used up. \n\n 5.) Bake in the preheated oven for one hour. Let stand for 10 minutes before serving. '," +
                                                                                                        R.drawable.lasanga +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Bolognese Stuffed Bell Peppers', " +
                                                                                                        "' 1/2 cup cooked rice \n 2 tablespoons olive oil, divided \n 1/8 cup minced carrots \n 1/8 cup celery \n 6 bell peppers (any color) stems and seeds removed, cut in half lengthwise \n 1/2 pound ground beef \n 1/4 pound pancetta or lightly smoked bacon, diced \n  1 1/2 cups prepared marinara sauce \n 1/4 cup red wine \n 1/2 teaspoon red pepper flakes \n 1/3 cup heavy cream \n 1/2 cup grated Parmesan cheese, divided' ," +
                                                                                                        "' 1.) Preheat oven to 375 degrees F (190 degrees C). \n\n 2.) Heat 1 tablespoon olive oil in a skillet over medium heat. Stir in the carrots and celery; cook and stir until the vegetables are tender, about 5 minutes. \n\n  3.) Stir in ground beef and pancetta, and cook until browned and crumbled; drain off any excess liquid, and return to heat. Add marinara sauce, wine, and red pepper flakes, and simmer for 10 minutes. Stir in cream, half of the Parmesan cheese, and rice. Simmer 5 minutes more, or until most liquid has absorbed. \n\n 4.) Place peppers in a shallow baking dish, and fill with beef mixture. Drizzle with remaining olive oil and top with remaining Parmesan cheese. \n\n 5.) Bake, uncovered, for 30 minutes in the preheated oven. Serve hot. ', " +
                                                                                                        R.drawable.peppers +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Slow Cooker Beef Stew', " +
                                                                                                        "' 2 pounds beef stew meat, cut into 1 inch cubes \n 1/4 cup all-purpose flour \n 1/2 teaspoon salt \n 1/2 teaspoon ground black pepper \n 1 clove garlic, minced \n 1 bay leaf \n 1 teaspoon paprika \n 1 teaspoon Worcestershire sauce \n 1 onion, chopped \n 1 1/2 cups beef broth \n  3 potatoes, diced \n 4 carrots, sliced \n 1 stalk celery, chopped' ," +
                                                                                                        "' 1.) Place meat in slow cooker. In a small bowl mix together the flour, salt, and pepper; pour over meat, and stir to coat meat with flour mixture. Stir in the garlic, bay leaf, paprika, Worcestershire sauce, onion, beef broth, potatoes, carrots, and celery. \n\n 2.) Cover, and cook on Low setting for 10 to 12 hours, or on High setting for 4 to 6 hours. ', " +
                                                                                                        R.drawable.beefstew +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Pot Roast', " +
                                                                                                        "' 2 (10.75 ounce) cans condensed cream of mushroom soup \n 1 (1 ounce) package dry onion soup mix \n 1 1/4 cups water \n 5 1/2 pounds pot roast' , " +
                                                                                                        "' 1.) In a slow cooker, mix cream of mushroom soup, dry onion soup mix and water. Place pot roast in slow cooker and coat with soup mixture. \n\n 2.) Cook on High setting for 3 to 4 hours, or on Low setting for 8 to 9 hours.', " +
                                                                                                        R.drawable.potroast +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Filet Mignon with Balsamic Glaze', " +
                                                                                                        "' 2 (4 ounce) filet mignon steaks \n 1/2 teaspoon freshly ground black pepper to taste \n salt to taste \n 1/4 cup balsamic vinegar \n 1/4 cup dry red wine'," +
                                                                                                        "' 1.) Sprinkle freshly ground pepper over both sides of each steak, and sprinkle with salt to taste. \n\n 2.) Heat a nonstick skillet over medium-high heat. Place steaks in hot pan, and cook for 1 minute on each side, or until browned. Reduce heat to medium-low, and add balsamic vinegar and red wine. Cover, and cook for 4 minutes on each side, basting with sauce when you turn the meat over. \n\n 3.) Remove steaks to two warmed plates, spoon one tablespoon of glaze over each, and serve immediately. ', " +
                                                                                                        R.drawable.filet +
                                                                                                        ")");
        ////////////////////////////////////////////CHICKEN//////////////////////////////////////////////
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Tender Italian Baked Chicken', " +
                                                                                                        "' 3/4 cup mayonnaise \n 1/2 cup grated Parmesan cheese \n 3/4 teaspoon garlic powder \n 3/4 cup Italian seasoned bread crumbs \n 4 skinless, boneless chicken breast halves' ," +
                                                                                                        "' 1.) Preheat oven to 425 degrees F (220 degrees C). \n\n 2.) In a bowl, mix the mayonnaise, Parmesan cheese, and garlic powder. Place bread crumbs in a separate bowl. Dip chicken into the mayonnaise mixture, then into the bread crumbs to coat. Arrange coated chicken on a baking sheet. \n\n 3.) Bake 20 minutes in the preheated oven, or until chicken juices run clear and coating is golden brown. ' , " +
                                                                                                        R.drawable.tenderchicken +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Chicken Parmesan', " +
                                                                                                        "' 4 skinless, boneless chicken breast halves \n salt and freshly ground black pepper to taste \n 2 eggs \n 4 cups panko bread crumbs \n 1/2 cup grated Parmesan cheese \n 2 tablespoons all-purpose flour, or more if needed \n 1 cup olive oil for frying \n 1/2 cup prepared tomato sauce \n 1/4 cup fresh mozzarella, cut into small cubes \n 1/4 cup chopped fresh basil \n 1/2 cup grated provolone cheese \n 1/4 cup grated Parmesan cheese \n ' ," +
                                                                                                        "' 1.) Preheat an oven to 450 degrees F (230 degrees C). \n\n 2.) Place chicken breasts between two sheets of heavy plastic (resealable freezer bags work well) on a solid, level surface. Firmly pound chicken with the smooth side of a meat mallet to a thickness of 1/2-inch. Season chicken thoroughly with salt and pepper. \n\n 3.) Beat eggs in a shallow bowl and set aside. \n\n 4.) Mix bread crumbs and 1/2 cup Parmesan in a separate bowl, set aside. \n\n 5.) Place flour in a sifter or strainer; sprinkle over chicken breasts, evenly coating both sides. \n\n 6.) Dip flour coated chicken breast in beaten eggs. Transfer breast to breadcrumb mixture, pressing the crumbs into both sides. Repeat for each breast. Set aside breaded chicken breasts for about 15 minutes. \n\n 7.) Heat 1 cup olive oil in a large skillet on medium-high heat until it begins to shimmer. Cook chicken until golden, about 2 minutes on each side. The chicken will finish cooking in the oven. \n\n Place chicken in a baking dish and top each breast with about 1/3 cup of tomato sauce. Layer each chicken breast with equal amounts of mozzarella cheese, fresh basil, and provolone cheese. Sprinkle 1 to 2 tablespoons of Parmesan cheese on top and drizzle with 1 tablespoon olive oil. \n\n 9.) Bake in the preheated oven until cheese is browned and bubbly, and chicken breasts are no longer pink in the center, 15 to 20 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C). ' ," +
                                                                                                        R.drawable.chickenparm +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Chicken Cordon Bleu', " +
                                                                                                        "' 6 skinless, boneless chicken breast halves \n 6 slices Swiss cheese \n 6 slices ham \n 3 tablespoons all-purpose flour \n 1 teaspoon paprika \n 6 tablespoons butter \n 1/2 cup dry white wine \n 1 teaspoon chicken bouillon granules \n 1 tablespoon cornstarch \n 1 cup heavy whipping cream' ," +
                                                                                                        "' 1.) Pound chicken breasts if they are too thick. Place a cheese and ham slice on each breast within 1/2 inch of the edges. Fold the edges of the chicken over the filling, and secure with toothpicks. Mix the flour and paprika in a small bowl, and coat the chicken pieces. \n\n 2.) Heat the butter in a large skillet over medium-high heat, and cook the chicken until browned on all sides. Add the wine and bouillon. Reduce heat to low, cover, and simmer for 30 minutes, until chicken is no longer pink and juices run clear. \n\n 3.) Remove the toothpicks, and transfer the breasts to a warm platter. Blend the cornstarch with the cream in a small bowl, and whisk slowly into the skillet. Cook, stirring until thickened, and pour over the chicken. Serve warm.' ," +
                                                                                                        R.drawable.cordonbleu +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Chicken Enchiladas', " +
                                                                                                        "' 1 tablespoon butter \n 1/2 cup chopped green onions \n 1/2 teaspoon garlic powder \n 1 (4 ounce) can diced green chiles \n 1 (10.75 ounce) can condensed cream of mushroom soup \n 1/2 cup sour cream \n 1 1/2 cups cubed cooked chicken breast meat \n 1 cup shredded Cheddar cheese, divided \n 6 (12 inch) flour tortillas \n 1/4 cup milk' ," +
                                                                                                        "' 1.) Preheat oven to 350 degrees F (175 degrees C). Lightly grease a large baking dish. \n\n 2.) In a medium saucepan over medium heat, melt the butter and saute the green onion until tender (about 3 to 4 minutes). Add the garlic powder, then stir in the green chiles, cream of mushroom soup and sour cream. Mix well. Reserve 3/4 of this sauce and set aside. To the remaining 1/4 of the sauce in the saucepan, add the chicken and 1/2 cup of shredded Cheddar cheese. Stir together. \n\n 3.) Fill each flour tortilla with the chicken mixture and roll up. Place seam side down in the prepared baking dish. \n\n 4.) In a small bowl combine the reserved 3/4 of the sauce with the milk. Spoon this mixture over the rolled tortillas and top with the remaining 1/2 cup of shredded Cheddar cheese. Bake in the preheated oven for 30 to 35 minutes, or until cheese is bubbly.' ," +
                                                                                                        R.drawable.chickenchiladas +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('Chicken and Broccoli Casserole', " +
                                                                                                        "' 3 quarts water \n 1 (12-ounce) package broccoli florets \n 4 (6-ounce) skinless, boneless chicken breast halves \n 1 (12-ounce) can evaporated fat-free milk \n 1/4 cup all-purpose flour (about 1 ounce) \n 1/4 teaspoon salt \n 1/4 teaspoon freshly ground black pepper \n 1 cup fat-free mayonnaise \n 1/2 cup fat-free sour cream \n 1/4 cup dry sherry \n 1 teaspoon Worcestershire sauce \n 1 (10.75-ounce) can condensed 30% reduced-sodium 98% fat-free cream of mushroom soup, undiluted \n 1 cup (4 ounces) grated fresh Parmesan cheese, divided' ," +
                                                                                                        "' 1.) Preheat oven to 400°. \n\n 2.) Bring water to a boil in a large Dutch oven over medium-high heat. Add broccoli, and cook 5 minutes or until crisp-tender. Transfer broccoli to a large bowl with a slotted spoon. Add chicken to boiling water; reduce heat, and simmer 15 minutes or until done. Transfer chicken to a cutting board; cool slightly. Cut chicken into bite-sized pieces, and add chicken to bowl with broccoli. \n\n 3.) Combine evaporated milk, flour, salt, pepper, and nutmeg in a saucepan, stirring with a whisk until smooth. Bring to a boil over medium-high heat; cook 1 minute, stirring constantly. Remove from heat. Add mayonnaise, next 4 ingredients (through soup), and 1/2 cup cheese, stirring until well combined. Add mayonnaise mixture to broccoli mixture; stir gently until combined. \n\n 4.) Spoon mixture into a 13 x 9-inch baking dish coated with cooking spray. Sprinkle with remaining 1/2 cup cheese. Bake at 400° for 50 minutes or until mixture bubbles at the edges and cheese begins to brown. Remove from oven; let cool on a wire rack 5 minutes.' ," +
                                                                                                        R.drawable.chickbroc +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                     "('Chicken Puttanesca' ," +
                                                                                                     "' 8 ounces uncooked angel hair pasta \n 2 teaspoons olive oil \n 4 (6-ounce) skinless, boneless chicken breast halves \n 1/2 teaspoon salt \n 2 cups tomato-basil pasta sauce (such as Muir Glen Organic) \n 1/4 cup pitted and coarsely chopped kalamata olives \n 1 tablespoon capers \n 1/4 teaspoon crushed red pepper \n 1/4 cup (1 ounce) preshredded Parmesan cheese \n Chopped fresh basil or basil sprigs (optional)' ," +
                                                                                                     "' 1.) Cook pasta according to package directions, omitting salt and fat. Drain and keep warm. \n\n 2.) Heat oil in a large nonstick skillet over medium-high heat. Cut chicken into 1-inch pieces. Add chicken to pan; sprinkle evenly with salt. Cook chicken 5 minutes or until lightly browned, stirring occasionally. Stir in pasta sauce, olives, capers, and pepper; bring to a simmer. Cook 5 minutes or until chicken is done, stirring frequently. Arrange 1 cup pasta on each of 4 plates; top with 1 1/2 cups chicken mixture. Sprinkle each serving with 1 tablespoon cheese. Garnish with chopped basil or basil sprigs, if desired.' ," +
                                                                                                     R.drawable.punta +
                                                                                                        ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                     "('Chicken Shawarma' ," +
                                                                                                     "'Chicken: \n 2 tablespoons fresh lemon juice \n 1 teaspoon curry powder \n 2 teaspoons extravirgin olive oil \n 3/4 teaspoon salt \n 1/2 teaspoon ground cumin \n 3 garlic cloves, minced \n 1 pound skinless, boneless chicken breast, cut into 16 (3-inch) strips \n\n Sauce: \n 1/2 cup plain 2% reduced-fat Greek yogurt (such as Fage) \n 2 tablespoons tahini \n 2 teaspoons fresh lemon juice \n 1/4 teaspoon salt \n 1 garlic clove, minced \n\n Remaining ingredients: \n 4 (6-inch) pitas \n 1 cup chopped romaine lettuce \n 8 (1/4-inch-thick) tomato slices' ," +
                                                                                                     "' 1.) Preheat grill to medium-high heat. \n\n 2.) To prepare chicken, combine first 6 ingredients in a medium bowl. Add chicken to bowl; toss well to coat. Let stand at room temperature 20 minutes. \n\n 3.)  To prepare sauce, combine yogurt and next 4 ingredients (through 1 garlic clove), stirring with a whisk. \n\n 4.) Thread 2 chicken strips onto each of 8 (12-inch) skewers. Place kebabs on a grill rack coated with cooking spray; grill 4 minutes on each side or until done. \n\n 5.) Place pitas on grill rack; grill 1 minute on each side or until lightly toasted. Place 1 pita on each of 4 plates; top each serving with 1/4 cup lettuce and 2 tomato slices. Top each serving with 4 chicken pieces; drizzle each serving with 2 tablespoons sauce.' ," +
                                                                                                     R.drawable.shawarma +
                                                                                                      ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                     "('Chicken, Gruyere Quesadillas' ," +
                                                                                                     "' 1 teaspoon olive oil \n 1 cup presliced mushrooms \n 1/2 cup thinly sliced onion \n 1/8 teaspoon salt \n 1/8 teaspoon freshly ground black pepper \n 1 teaspoon bottled minced garlic \n 1 tablespoon sherry or red wine vinegar \n 2 (10-inch) fat-free flour tortillas \n 1 cup shredded cooked chicken breast (about 8 ounces) \n 1 cup arugula \n 1/2 cup (2 ounces) shredded Gruyère cheese' ," +
                                                                                                     "' 1.) Heat a large nonstick skillet over medium-high heat. Add olive oil to pan; swirl to coat. Add mushrooms, sliced onion, salt, and pepper to pan; sauté 5 minutes. Stir in garlic, and sauté 30 seconds. Add vinegar; cook 30 seconds or until liquid almost evaporates. \n\n Arrange half of mushroom mixture over half of each tortilla. Top each tortilla with 1/2 cup chicken, 1/2 cup arugula, and 1/4 cup cheese; fold tortillas in half. \n\n Wipe pan clean with a paper towel. Heat pan over medium heat. Coat pan with cooking spray. Add tortillas to pan. Place a heavy skillet on top of tortillas; cook 2 minutes on each side or until crisp. \n\n Watermelon-jicama salad: Combine 4 cups (1/2-inch) cubed seedless watermelon, 1 1/2 cups (1/2-inch) cubed peeled jicama, 1 cup chopped English cucumber, and 1/2 cup chopped red onion. Add 2 tablespoons fresh lemon juice, 2 teaspoons sugar, and 1 teaspoon olive oil; toss well.' ," +
                                                                                                     R.drawable.quesadillas +
                                                                                                     ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                     "('Garlic Broiled Chicken' ," +
                                                                                                     "' 1/2 cup butter \n 3 tablespoons minced garlic \n 3 tablespoons soy sauce \n 1/4 teaspoon black pepper \n 1 tablespoon dried parsley \n 6 boneless chicken thighs, with skin \n ' ," +
                                                                                                     "'1.) Preheat the oven broiler. Lightly grease a baking pan. \n\n 2.) In a microwave safe bowl, mix the butter, garlic, soy sauce, pepper, and parsley. Cook 2 minutes on High in the microwave, or until butter is melted. \n\n 3.) Arrange chicken on the baking pan, and coat with the butter mixture, reserving some of the mixture for basting. \n\n Broil chicken 20 minutes in the preheated oven, until juices run clear, turning occasionally and basting with remaining butter mixture. Sprinkle with parsley to serve.' ," +
                                                                                                     R.drawable.garlicchick +
                                                                                                     ")");

    }
    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion,
                           int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPES);
        onCreate(db);
    }

    /*
    db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                                                                                                        "('' ," +
                                                                                                        "'' ," +
                                                                                                        "'' ," +
                                                                                                        R.drawable +
                                                                                                        ")");
    public ArrayList<String> getAllRecipes(){
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
