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
    private static final String TABLE_FAVOURITES = "Favourites";

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

        ////////// FAVOURITES //////////////
        String CREATE_FAVOURITES_TABLE = "CREATE TABLE " +
                TABLE_FAVOURITES + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RECIPE_NAME + " TEXT NOT NULL, "
                + COLUMN_RECIPE_INGREDIENTS + "  TEXT NOT NULL, "
                + COLUMN_RECIPE_INSTRUCTIONS + " TEXT NOT NULL, "
                + COLUMN_RECIPE_IMAGE + " INTEGER "
                + ")";
        db.execSQL(CREATE_FAVOURITES_TABLE);

        ////////// RECIPES //////////////
        String CREATE_RECIPE_TABLE = "CREATE TABLE " +
                TABLE_RECIPES + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_RECIPE_NAME + " TEXT NOT NULL, "
                + COLUMN_RECIPE_INGREDIENTS + "  TEXT NOT NULL, "
                + COLUMN_RECIPE_INSTRUCTIONS + " TEXT NOT NULL, "
                + COLUMN_RECIPE_IMAGE + " INTEGER "
                + ")";
        db.execSQL(CREATE_RECIPE_TABLE);

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
                "('Filet Mignon', " +
                "' 2 (4 ounce) filet mignon steaks \n 1/2 teaspoon freshly ground black pepper to taste \n salt to taste \n 1/4 cup balsamic vinegar \n 1/4 cup dry red wine'," +
                "' 1.) Sprinkle freshly ground pepper over both sides of each steak, and sprinkle with salt to taste. \n\n 2.) Heat a nonstick skillet over medium-high heat. Place steaks in hot pan, and cook for 1 minute on each side, or until browned. Reduce heat to medium-low, and add balsamic vinegar and red wine. Cover, and cook for 4 minutes on each side, basting with sauce when you turn the meat over. \n\n 3.) Remove steaks to two warmed plates, spoon one tablespoon of glaze over each, and serve immediately. ', " +
                R.drawable.filet +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Best Lasagna Ever' ," +
                "' 1 pound sweet Italian sausage \n 3/4 pound lean ground beef \n 1/2 cup minced onion \n 2 cloves garlic, crushed \n 1 (28 ounce) can crushed tomatoes \n 2 (6 ounce) cans tomato paste \n 2 (6.5 ounce) cans canned tomato sauce \n 1/2 cup water \n 2 tablespoons white sugar \n 1 1/2 teaspoons dried basil leaves \n 1/2 teaspoon fennel seeds \n 1 teaspoon Italian seasoning \n 1 tablespoon salt \n 1/4 teaspoon ground black pepper \n 4 tablespoons chopped fresh parsley \n 12 lasagna noodles \n 12 lasagna noodles \n 16 ounces ricotta cheese \n 1 egg \n 3/4 pound mozzarella cheese, sliced \n 3/4 cup grated Parmesan cheese' ," +
                "' 1.) In a Dutch oven, cook sausage, ground beef, onion, and garlic over medium heat until well browned. Stir in crushed tomatoes, tomato paste, tomato sauce, and water. Season with sugar, basil, fennel seeds, Italian seasoning, 1 tablespoon salt, pepper, and 2 tablespoons parsley. Simmer, covered, for about 1 1/2 hours, stirring occasionally. \n\n 2.) Bring a large pot of lightly salted water to a boil. Cook lasagna noodles in boiling water for 8 to 10 minutes. Drain noodles, and rinse with cold water. In a mixing bowl, combine ricotta cheese with egg, remaining parsley, and 1/2 teaspoon salt. \n\n 3.) Preheat oven to 375 degrees F (190 degrees C). \n\n 4.) To assemble, spread 1 1/2 cups of meat sauce in the bottom of a 9x13 inch baking dish. Arrange 6 noodles lengthwise over meat sauce. Spread with one half of the ricotta cheese mixture. Top with a third of mozzarella cheese slices. Spoon 1 1/2 cups meat sauce over mozzarella, and sprinkle with 1/4 cup Parmesan cheese. Repeat layers, and top with remaining mozzarella and Parmesan cheese. Cover with foil: to prevent sticking, either spray foil with cooking spray, or make sure the foil does not touch the cheese. \n\n 5.) Bake in preheated oven for 25 minutes. Remove foil, and bake an additional 25 minutes. Cool for 15 minutes before serving.' ," +
                R.drawable.lasanga +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Taco Pie' ," +
                "' 1 (8 ounce) package refrigerated crescent rolls \n 1 pound ground beef \n 1 (1 ounce) package taco seasoning mix \n 1 (16 ounce) container sour cream \n 8 ounces shredded Mexican-style cheese blend \n 1 (14 ounce) bag tortilla chips, crushed' ," +
                "' 1.) Preheat oven to 350 degrees F (175 degrees C). \n\n 2.) Lay crescent dough flat on the bottom of a square cake pan and bake according to package directions. \n\n 3.) Meanwhile, brown the ground beef in a large skillet over medium high heat. Add the taco seasoning and stir together well. When dough is done, remove from oven and place meat mixture on top, then layer with sour cream and cheese, and then top off with the crushed nacho chips. \n\n 4.) Return to oven and bake at 350 degrees F (175 degrees C) for 10 minutes, or until cheese has melted.' ," +
                R.drawable.tacopie +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Hamburger Steak ' ," +
                "' 1 pound ground beef \n 1 egg \n 1/4 cup bread crumbs \n 1/8 teaspoon ground black pepper \n 1/2 teaspoon seasoned salt \n 1/2 teaspoon onion powder \n 1/2 teaspoon garlic powder \n 1 teaspoon Worcestershire sauce \n 1 tablespoon vegetable oil \n 1 cup thinly sliced onion \n 2 tablespoons all-purpose flour \n 1 cup beef broth \n 1 tablespoon cooking sherry \n 1/2 teaspoon seasoned salt' ," +
                "' 1.) In a large bowl, mix together the ground beef, egg, bread crumbs, pepper, salt, onion powder, garlic powder, and Worcestershire sauce. Form into 8 balls, and flatten into patties. \n\n 2.) Heat the oil in a large skillet over medium heat. Fry the patties and onion in the oil until patties are nicely browned, about 4 minutes per side. Remove the beef patties to a plate, and keep warm. \n\n Sprinkle flour over the onions and drippings in the skillet. Stir in flour with a fork, scraping bits of beef off of the bottom as you stir. Gradually mix in the beef broth and sherry. Season with seasoned salt. Simmer and stir over medium-low heat for about 5 minutes, until the gravy thickens. Turn heat to low, return patties to the gravy, cover, and simmer for another 15 minutes.' ," +
                R.drawable.hamburgersteak +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "(' Spaghetti with Meatballs' ," +
                "' 1 pound lean ground beef \n 1 cup fresh bread crumbs \n 1 tablespoon dried parsley \n 1 tablespoon grated Parmesan cheese \n 1/4 teaspoon ground black pepper \n 1/8 teaspoon garlic powder \n 1 egg, beaten \n 3/4 cup chopped onion \n 5 cloves garlic, minced \n 1/4 cup olive oil \n 2 (28 ounce) cans whole peeled tomatoes \n 2 teaspoons salt \n 1 teaspoon white sugar \n 1 bay leaf \n 1 (6 ounce) can tomato paste \n 3/4 teaspoon dried basil \n 1/2 teaspoon ground black pepper' ," +
                "' 1.) In a large bowl, combine ground beef, bread crumbs, parsley, Parmesan, 1/4 teaspoon black pepper, garlic powder and beaten egg. Mix well and form into 12 balls. Store, covered, in refrigerator until needed. \n\n 2.) In a large saucepan over medium heat, saute onion and garlic in olive oil until onion is translucent. Stir in tomatoes, salt, sugar and bay leaf. Cover, reduce heat to low, and simmer 90 minutes. Stir in tomato paste, basil, 1/2 teaspoon pepper and meatballs and simmer 30 minutes more. Serve.' ," +
                R.drawable.sauceandballs +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Meatball Nirvana' ," +
                "' 1 pound extra lean ground beef \n 1/2 teaspoon sea salt \n 1 small onion, diced \n 1/2 teaspoon garlic salt \n 1 1/2 teaspoons Italian seasoning \n 3/4 teaspoon dried oregano \n 3/4 teaspoon crushed red pepper flakes \n 1 dash hot pepper sauce (such as Franks RedHot®), or to taste \n 1 1/2 tablespoons Worcestershire sauce \n 1/3 cup skim milk \n 1/4 cup grated Parmesan cheese \n 1/2 cup seasoned bread crumbs' ," +
                "' 1.) Preheat an oven to 400 degrees F (200 degrees C). \n\n 2.) Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. \n\n 3.) Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.' ," +
                R.drawable.nirvana +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Chili' ," +
                "' 2 tablespoons vegetable oil \n 2 onions, chopped \n 3 cloves garlic, minced \n 1 pound ground beef \n 3/4 pound beef sirloin, cubed \n 1 (14.5 ounce) can peeled and diced tomatoes with juice \n 1 (12 fluid ounce) can or bottle dark beer \n 1 cup strong brewed coffee \n 2 (6 ounce) cans tomato paste \n 1 (14 ounce) can beef broth \n 1/2 cup packed brown sugar \n 3 1/2 tablespoons chili powder \n 1 tablespoon cumin seeds \n 1 tablespoon unsweetened cocoa powder \n 1 teaspoon salt \n 1 teaspoon dried oregano \n 4 (15 ounce) cans kidney beans \n 4 fresh hot chile peppers, seeded and chopped' ," +
                "' 1.) Heat oil in a large saucepan over medium heat. Cook onions, garlic, ground beef and cubed sirloin in oil for 10 minutes, or until the meat is well browned and the onions are tender. \n\n 2.) Mix in the diced tomatoes with juice, dark beer, coffee, tomato paste and beef broth. Season with brown sugar, chili powder, cumin, cocoa powder, oregano, cayenne pepper, coriander and salt. Stir in 2 cans of the beans and hot chile peppers. Reduce heat to low, and simmer for 1 1/2 hours. \n\n 3.) Stir in the 2 remaining cans of beans, and simmer for another 30 minutes.' ," +
                R.drawable.chili +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Barbecued Beef' ," +
                "' 1 1/2 cups ketchup \n 1/4 cup packed brown sugar \n 1/4 cup red wine vinegar \n 2 tablespoons prepared Dijon-style mustard \n 2 tablespoons Worcestershire sauce \n 1 teaspoon liquid smoke flavoring \n 1/4 teaspoon garlic powder \n 1 (4 pound) boneless chuck beef roast' ," +
                "' 1.) In a large bowl, combine ketchup, brown sugar, red wine vinegar, Dijon-style mustard, Worcestershire sauce, and liquid smoke. Stir in salt, pepper, and garlic powder. \n\n 2.) Place chuck roast in a slow cooker. Pour ketchup mixture over chuck roast. Cover, and cook on Low for 8 to 10 hours. \n\n 3.) Remove chuck roast from slow cooker, shred with a fork, and return to the slow cooker. Stir meat to evenly coat with sauce. Continue cooking approximately 1 hour.' ," +
                R.drawable.bbqbeef +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('French Dip Sandwiches' ," +
                "' 1 (4 pound) boneless beef roast \n 1/2 cup soy sauce \n 1 beef bouillon cube \n 1 bay leaf \n 3 whole black peppercorns \n 1 teaspoon dried rosemary, crushed \n 1 teaspoon dried thyme \n 1 teaspoon garlic powder \n 20 slices French bread' ," +
                "' 1.) Remove and discard all visible fat from the roast. Place trimmed roast in a slow cooker. \n\n 2.) In a medium bowl, combine soy sauce, bouillon, bay leaf, peppercorns, rosemary, thyme, and garlic powder. Pour mixture over roast, and add enough water to almost cover roast. Cover, and cook on Low heat for 10 to 12 hours, or until meat is very tender. \n\n Remove meat from broth, reserving broth. Shred meat with a fork, and distribute on bread for sandwiches. Used reserved broth for dipping.' ," +
                R.drawable.frenchdip +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Cheeseburger Meatloaf' ," +
                "' 2 pounds ground beef \n 3/4 cup fresh bread crumbs \n 1/2 cup minced onion \n 2 eggs, beaten \n 1 1/2 teaspoons salt \n 1 1/2 teaspoons ground black pepper \n 3 cups shredded Cheddar cheese' ," +
                "' 1.) Preheat oven to 350 degrees F (175 degrees C). \n\n 2.) In a large bowl, combine the beef, bread crumbs, onion, eggs, salt and pepper, and mix well. Pat out meat mixture into a 14x18 inch rectangle on a piece of wax paper. Spread cheese over the meat, leaving a 3/4 inch border around the edges. Roll up jelly roll fashion to enclose the filling and form a pinwheel loaf. Press beef in on both ends to enclose the cheese. Place in a 10x15 inch baking dish. \n\n  3.) Bake in the preheated oven 1 hour, or until internal temperature reaches 160 degrees F (70 degrees C).' ," +
                R.drawable.cheeseburgermeatloaf +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Crispy Orange Beef' ," +
                "' 1 1/2 pounds beef top sirloin, thinly sliced \n 1/3 cup white sugar \n 1/3 cup rice wine vinegar \n 2 tablespoons frozen orange juice concentrate \n 1 tablespoon soy sauce \n 1 cup long grain rice \n 1/4 cup cornstarch \n 2 teaspoons orange zest \n 3 tablespoons grated fresh ginger \n 1 1/2 tablespoons minced garlic \n 8 broccoli florets, lightly steamed or blanched' ," +
                "' 1.) Lay beef strips out in a single layer on a baking sheet lined with paper towels. Allow to dry in the refrigerator for 30 minutes. In a small bowl, mix together the sugar, rice vinegar, orange juice concentrate, salt and soy sauce. Set aside. \n\n 2.) Meanwhile, combine rice and water in a medium saucepan. Bring to a boil, then reduce heat to medium-low and simmer for 20 minutes, or until rice is tender. Add more water at the end if necessary. \n\n 3.) Heat oil in a wok over medium-high heat. Toss dried beef in cornstarch to coat. Fry in the hot oil in small batches until crispy and golden brown; set aside. Drain all of the oil from the wok except about 1 tablespoon. \n\n .4) Add orange zest, ginger and garlic to the remaining oil, and cook briefly until fragrant. Add the soy sauce mixture to the wok, bring to a boil, and cook until thick and syrupy, about 5 minutes. Add beef, and heat through, stirring to coat. Serve immediately over steamed rice, and garnish with broccoli.' ," +
                R.drawable.crispyorangebeef +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Garlic Prime Rib' ," +
                "' 1 (10 pound) prime rib beef roast \n 10 cloves garlic, minced \n 2 tablespoons olive oil \n 2 teaspoons salt \n 2 teaspoons ground black pepper \n 2 teaspoons dried thyme' ," +
                "' 1.) Place the roast in a roasting pan with the fatty side up. In a small bowl, mix together the garlic, olive oil, salt, pepper and thyme. Spread the mixture over the fatty layer of the roast, and let the roast sit out until it is at room temperature, no longer than 1 hour. \n\n 2.) Preheat the oven to 500 degrees F (260 degrees C). \n\n 3.) Bake the roast for 20 minutes in the preheated oven, then reduce the temperature to 325 degrees F (165 degrees C), and continue roasting for an additional 60 to 75 minutes. The internal temperature of the roast should be at 135 degrees F (57 degrees C) for medium rare. \n\n 4.) Allow the roast to rest for 10 or 15 minutes before carving so the meat can retain its juices.' ," +
                R.drawable.garlicprimerib +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Beef Wellington' ," +
                "' 1 pound fresh mushrooms, sliced \n 1/2 cup chopped onion \n 1/2 cup dry sherry \n 1/4 cup butter \n 1/4 cup chopped parsley \n 6 (8 ounce) fillets beef tenderloin \n 1 (17.5 ounce) package frozen puff pastry, thawed' ," +
                "' 1.) In a large skillet over medium heat, combine the mushrooms, onion, sherry, butter or margarine and parsley and saute until all the liquid is absorbed and the mixture resembles a paste. Cover the top of each steak with the mixture. \n\n 2.) Partially thaw the puff pastry sheets and roll out pieces thin enough to cover the top, sides and bottom of each steak. Place the steaks on a baking sheet, cover with plastic wrap and store in the refrigerator until serving time. \n\n 3.) Preheat oven to 425 degrees F (220 degrees C). \n\n 4.) Bake steaks uncovered in the preheated oven for 25 minutes. (Note: They will be rare but will continue cooking while dish is sitting.)' ," +
                R.drawable.beefwellington +
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
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Chicken Fried Rice' ," +
                "' 1 egg \n 1 tablespoon water \n 1 tablespoon butter \n 1 tablespoon vegetable oil \n 1 onion, chopped \n 2 cups cooked white rice, cold \n  2 tablespoons soy sauce \n 1 teaspoon ground black pepper \n 1 cup cooked, chopped chicken meat \n' ," +
                "'1.) In a small bowl, beat egg with water. Melt butter in a large skillet over medium low heat. Add egg and leave flat for 1 to 2 minutes. Remove from skillet and cut into shreds. \n\n 2.) Heat oil in same skillet; add onion and saute until soft. Then add rice, soy sauce, pepper and chicken. Stir fry together for about 5 minutes, then stir in egg. Serve hot.' ," +
                R.drawable.friedrice +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Sweet & Spicy Chicken' ," +
                "' 1 tablespoon brown sugar \n 2 tablespoons honey \n 1/4 cup soy sauce \n 2 teaspoons chopped fresh ginger root \n 2 teaspoons chopped garlic \n 2 tablespoons hot sauce \n  salt and pepper to taste \n 4 skinless, boneless chicken breast halves - cut into 1/2 inch strips \n 1 tablespoon vegetable oil \n' ," +
                "'1.) Mix together brown sugar, honey, soy sauce, ginger, garlic and hot sauce in a small bowl. \n\n 2.) Lightly salt and pepper the chicken strips. \n\n 3.) Heat oil in a large skillet over medium heat. Add chicken strips and brown on both sides, about 1 minute per side. Pour the sauce over the chicken. Simmer uncovered until the sauce thickens, 8 to 10 minutes.' ," +
                R.drawable.spicychicken +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Indian Chicken Curry' ," +
                "' 3 tablespoons olive oil \n 1 small onion, chopped \n 2 cloves garlic, minced \n 3 tablespoons curry powder \n 1 teaspoon ground cinnamon \n 1 teaspoon paprika \n 1 bay leaf \n 1/2 teaspoon grated fresh ginger root \n 1/2 teaspoon white sugar \n salt to taste \n 2 skinless, boneless chicken breast halves - cut into bite-size pieces \n 1 tablespoon tomato paste \n 1 cup plain yogurt \n 3/4 cup coconut milk \n 1/2 lemon, juiced \n 1/2 teaspoon cayenne pepper' ," +
                "'1.) Heat olive oil in a skillet over medium heat. Saute onion until lightly browned. Stir in garlic, curry powder, cinnamon, paprika, bay leaf, ginger, sugar and salt. Continue stirring for 2 minutes. Add chicken pieces, tomato paste, yogurt, and coconut milk. Bring to a boil, reduce heat, and simmer for 20 to 25 minutes. \n\n 2.) Remove bay leaf, and stir in lemon juice and cayenne pepper. Simmer 5 more minutes.' ," +
                R.drawable.indiancurry +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Curry Coconut Chicken' ," +
                "' 2 pounds boneless skinless chicken breasts, cut into 1/2-inch chunks \n 1 teaspoon salt and pepper, or to taste \n 1 1/2 tablespoons vegetable oil \n 2 tablespoons curry powder \n 1/2 onion, thinly sliced \n 2 cloves garlic, crushed \n  1 (14 ounce) can coconut milk \n 1 (14.5 ounce) can stewed, diced tomatoes \n 1 (8 ounce) can tomato sauce \n 3 tablespoons sugar \n' ," +
                "'1.) Season chicken pieces with salt and pepper. \n\n 2.) Heat oil and curry powder in a large skillet over medium-high heat for two minutes. Stir in onions and garlic, and cook 1 minute more. Add chicken, tossing lightly to coat with curry oil. Reduce heat to medium, and cook for 7 to 10 minutes, or until chicken is no longer pink in center and juices run clear. \n\n 3.) Pour coconut milk, tomatoes, tomato sauce, and sugar into the pan, and stir to combine. Cover and simmer, stirring occasionally, approximately 30 to 40 minutes. ' ," +
                R.drawable.cocunut +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Honey Chicken Kabobs' ," +
                "' 1/4 cup vegetable oil \n 1/3 cup honey \n 1/3 cup soy sauce \n 1/4 teaspoon ground black pepper \n 8 skinless, boneless chicken breast halves - cut into 1 inch cubes \n  2 cloves garlic \n 5 small onions, cut into 2 inch pieces \n 2 red bell peppers, cut into 2 inch pieces \n skewers \n' ," +
                "'1.) In a large bowl, whisk together oil, honey, soy sauce, and pepper. Before adding chicken, reserve a small amount of marinade to brush onto kabobs while cooking. Place the chicken, garlic, onions and peppers in the bowl, and marinate in the refrigerator at least 2 hours (the longer the better). \n\n 2.) Preheat the grill for high heat. \n\n 3.) Drain marinade from the chicken and vegetables, and discard marinade. Thread chicken and vegetables alternately onto the skewers. \n\n 4.) Lightly oil the grill grate. Place the skewers on the grill. Cook for 12 to 15 minutes, until chicken juices run clear. Turn and brush with reserved marinade frequently. ' ," +
                R.drawable.kabob +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Roasted Chicken' ," +
                "' 1 (3 pound) whole chicken, giblets removed \n salt and black pepper to taste \n 1 tablespoon onion powder, or to taste \n 2 tablespoons curry powder \n 1/2 cup margarine, divided \n 1 stalk celery, leaves removed ' ," +
                "'1.) Preheat oven to 350 degrees F (175 degrees C). \n\n 2.) Place chicken in a roasting pan, and season generously inside and out with salt and pepper. Sprinkle inside and out with onion powder. Place 3 tablespoons margarine in the chicken cavity. Arrange dollops of the remaining margarine around the chicken exterior. Cut the celery into 3 or 4 pieces, and place in the chicken cavity. \n\n 3.) Bake uncovered 1 hour and 15 minutes in the preheated oven, to a minimum internal temperature of 180 degrees F (82 degrees C). Remove from heat, and baste with melted margarine and drippings. Cover with aluminum foil, and allow to rest about 30 minutes before serving. ' ," +
                R.drawable.rstchicken +
                ")");

        //////////////////////////// TOFU ///////////////////////////////////////////
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Thai Tofu' ," +
                "' 1 (14 ounce) package firm tofu, cut into 3/4 inch cubes \n 1/3 cup chopped green onion \n 1 1/2 teaspoons olive oil \n 1/2 teaspoon sesame oil \n 1 teaspoon soy sauce \n 2 teaspoons grated fresh ginger root \n  1/4 cup chunky peanut butter \n 3 tablespoons flaked coconut \n sesame seeds \n' ," +
                "'1.) Heat olive oil and sesame oil in a skillet over medium-high heat. Reduce heat to medium, and cook green onions for one minute. Add tofu, and continue cooking 4 minutes more, sprinkling with soy sauce halfway through. Gently stir in the peanut butter and ginger, being careful not to break the tofu, until well incorporated. \n\n 2.) Remove from heat, and toss in coconut. Transfer to a serving dish, and sprinkle with sesame seeds. ' ," +
                R.drawable.thaitofu +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Coconut Tofu Keema' ," +
                "' 1/4 cup olive oil \n 4 cloves garlic, pressed \n 1 medium onions, minced \n 1 (14 ounce) package extra firm tofu, diced \n 1 (16 ounce) can coconut milk \n 1 tablespoon ground cumin \n  1 teaspoon curry powder \n 1 1/2 teaspoons ground ginger \n 1 teaspoon salt \n 1 tablespoon red pepper paste \n 6 cups tomato sauce \n 1 1/2 cups frozen peas, thawed \n 1 1/2 cups chopped carrot \n' ," +
                "'1.) Heat olive oil in a large saucepan over medium heat. Stir in garlic, onion, and tofu; cover, and cook, stirring occasionally for 5 to 10 minutes. Stir in coconut milk, cumin, curry powder, ginger, salt, and red pepper paste; bring to a simmer. Stir in tomato sauce, peas, and carrots; simmer, covered, about 30 minutes. ' ," +
                R.drawable.coconuttofu +
                ")");
        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Garlic Ginger Tofu' ," +
                "' 3 tablespoons canola oil \n 2 teaspoons minced garlic \n 2 teaspoons minced fresh ginger root \n 1 lime \n 1 tablespoon tamari, or to taste \n 2 pounds firm tofu \n' ," +
                "'1.) Heat oil in a wok or skillet over medium heat. Stir in garlic and ginger, and cook for 1 minute. Add tofu to the pan with tamari, and stir to coat. Cover, and continue cooking for 20 to 30 minutes. \n\n 2.) Squeeze lime juice over tofu before serving. ' ," +
                R.drawable.garilictofu +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Tofu Veggie Pot Pie' ," +
                "' 1/3 cup butter \n 1/2 cup thinly sliced onion \n 1 stalk celery, thinly sliced \n 2 cloves garlic, minced \n 1/3 (12 ounce) package extra-firm tofu, cubed \n 1/4 cup cubed red potatoes \n  1/2 teaspoon oregano \n  \n 1 teaspoon salt \n 1 tablespoon redsalt and ground black pepper to taste \n 1/3 cup all-purpose flour \n 2/3 cup milk \n 1 1/2 cups vegetable broth \n 1 cup frozen mixed vegetables \n 1 pastry for double-crust pie \n' ," +
                "'1.) Preheat oven to 425 degrees F (220 degrees C). \n\n 2.) Heat butter in a large skillet over medium heat; cook and stir onion, celery, garlic, and tofu until onion is tender and translucent, 10 to 15 minutes. Season with oregano, salt, and black pepper. Stir flour into vegetable mixture; toss to coat. \n\n 3.) Slowly stir milk into vegetable mixture until thickened; about 5 minutes. Stir in vegetable broth; cook and stir until filling is thickened, about 5 minutes. Stir in frozen vegetables. Fit one pie crust into a 9-inch pie pan. \n\n 4.) Pour filling into prepared pie crust. Top with second pie crust; crimp edges together to seal. Poke holes into top crust for ventilation during baking. \n\n 5.) Bake pie in the preheated oven until crust is golden brown and filling is bubbling, 30 to 35 minutes. Let cool for 10 to 15 minutes before serving. ' ," +
                R.drawable.tofuveggiepotpie +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Tofu Vindaloo' ," +
                "' 3 tablespoons vegetable oil \n 2 inch piece fresh ginger root, peeled and minced \n 2 onions, halved and sliced \n 1/2 head cauliflower, cut into florets \n 3 carrots, peeled and sliced \n 3 tablespoons vindaloo curry powder \n  6 tablespoons tomato paste \n 1 (15 ounce) can coconut milk \n 1 cup vegetable broth \n 1 (15 ounce) can garbanzo beans (chickpeas), drained and rinsed \n 1 pound extra-firm tofu, cut into 1-inch cubes \n 1 cup mushrooms, sliced \n salt to taste \n' ," +
                "'1.) Heat the vegetable oil in a Dutch oven or large pot over medium-high heat. Stir in the ginger, and cook until fragrant and beginning to brown, about 2 minutes. Stir in the onions, cauliflower, and carrots. Cook and stir until the vegetables have softened, about 5 minutes. \n\n 2.) Stir in the vindaloo powder and tomato paste until no lumps of tomato paste remain. Stir in the coconut milk, vegetable broth, and garbanzo beans. Gently fold in the tofu and mushrooms, and season to taste with salt. Bring to a simmer, then reduce heat to medium-low, cover, and simmer until the vegetables are tender, about 15 minutes. Stir occasionally as the vindaloo cooks. ' ," +
                R.drawable.tofuvindaloo +
                ")");








        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Coconut Fish Curry' ," +
                "' 1 1/2 teaspoons curry powder \n 1/2 teaspoon ground ginger \n 1/4 teaspoon ground turmeric \n 1/4 teaspoon olive oil \n 3 cloves garlic, minced \n 1 onion, chopped \n  4 1/4 ounces coconut milk, divided \n 4 1/4 ounces water, divided \n 3 1/2 ounces cod, cut into bite-size pieces \n 1 large tomato, diced \n' ," +
                "'1.) Combine curry powder, ground ginger, and ground turmeric in a skillet; toast the spices over medium heat until browned, about 5 minutes. Pour olive oil and garlic into the spice mixture and stir to make a paste. \n\n 2.) Stir onion into the spice mixture; cook and stir until the onion is tender, 5 to 7 minutes. Stir about half the coconut milk and half the water into the onion mixture; simmer together for 5 minutes. Add cod to the mixture; continue cooking until the fish is firm, about 5 minutes. Add tomato, remaining coconut milk, and remaining water to the skillet; cook until the tomato is softened, about 5 minutes.' ," +
                R.drawable.coconutfishcurry +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Fish Chowder' ," +
                "' 2 tablespoons vegetable oil \n 3 stalks celery, chopped \n 2 carrots, chopped \n 1 onion, chopped \n 1 green bell pepper, chopped \n 3 cloves garlic, minced \n 3 tablespoons tomato paste \n 4 cups clam juice \n 2 potatoes, peeled and cubed \n 1 (14.5 ounce) can peeled and diced tomatoes \n 2 tablespoons Worcestershire sauce \n 1 jalapeno pepper, seeded and minced \n 1 teaspoon ground black pepper \n 1 bay leaf \n 1 pound red snapper fillets, cut into 1 inch pieces \n' ," +
                "'1.) Heat oil in a large soup pot over medium heat. Add celery, carrots, onion, green pepper, and garlic; saute about 8 minutes. \n\n 2.) Stir in tomato paste, and cook 1 minute. Add clam juice, potatoes, canned tomatoes with juice, Worcestershire sauce, jalapeno pepper, bay leaf, and ground black pepper. Simmer until potatoes are tender, stirring about every 30 minutes. \n\n 3.) Add fish. Simmer until snapper is easily flaked with fork, about 10 minutes.' ," +
                R.drawable.fishchowder +
                ")");







        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Fancy Fish Italiano' ," +
                "' 1 tablespoon olive oil \n  1 cup thinly sliced onion \n 3 cloves garlic, minced \n 1 1/2 teaspoons Italian seasoning, divided \n 1 cup 1/2-inch sliced zucchini \n 1 cup 1/2-inch sliced yellow squash \n 1/4 cup chopped black olives \n 1/4 cup capers (optional) \n 4 (4 ounce) cod fillets \n 2 tomatoes, chopped \n 1/2 teaspoon kosher salt \n 1/4 teaspoon ground black pepper \n 1 cup shredded mozzarella cheese \n ' ," +
                "'1.) Heat olive oil in a skillet over medium heat; cook and stir onion in the hot oil until almost tender, about 5 minutes. Add garlic and 1/2 teaspoon Italian seasoning to onion; cook and stir until garlic is fragrant, 2 to 3 minutes. \n\n 2.) Stir zucchini, yellow squash, olives, and capers into onion mixture; top with cod fillets. Sprinkle tomatoes, remaining 1 teaspoon Italian seasoning, salt, and pepper onto cod fillets. Reduce heat, cover skillet, and cook until fish flakes easily with a fork and zucchini is tender, about 10 minutes. Sprinkle mozzarella cheese over fish; cover skillet until cheese melts, about 2 minutes.' ," +
                R.drawable.fishitaliano +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Tomato Fish Stew' ," +
                "' 3 1/2 ounces sun-dried tomatoes \n 2 tablespoons olive oil \n 1 large yellow onion, chopped \n 1 green bell pepper, chopped \n 2 (8 ounce) bottles clam juice \n 2 (14 ounce) cans diced tomatoes (no salt added) \n 1 cup dry red wine (or substitute broth or tomato juice) \n 4 garlic cloves, crushed \n 4 tablespoons fresh herbs (such as thyme, rosemary or basil) \n 2 bay leaves \n 1/2 cup kalamata olives, sliced \n 1 (15 ounce) can navy beans, drained and rinsed \n 1 pound firm fish (grouper, tilapia or tuna), cut in 2- to 3-inch chunks \n 2 teaspoons fennel seeds, lightly crushed \n 1 pinch Salt and pepper, to taste \n 1/2 cup grated Parmesan cheese \n ' ," +
                "'1.) In a pan, simmer sun-dried tomatoes in 1 1/2 cups water until very soft; discard water. \n\n 2.) In a large pot, saute onion and green pepper in oil until softened. \n\n 3.) In a food processor or blender, combine sun-dried tomatoes and 1 bottle clam juice until smooth; add to pot. Stir in remaining clam juice, diced tomatoes, wine, garlic, herbs, bay leaves and olives. Simmer 20 minutes. \n\n 4.) Add beans, fish, fennel seeds, salt and pepper. Simmer until fish is done, about 10 minutes. Remove bay leaves. Ladle into bowls; sprinkle with cheese. ' ," +
                R.drawable.tomatofishstew +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Tandoori Fish' ," +
                "' 1/3 cup vinegar \n 4 cloves garlic \n 1 tablespoon chopped fresh ginger \n 1/2 teaspoon salt \n 1 tablespoon cayenne pepper \n 1 tablespoon ground coriander \n 1 tablespoon ground cumin \n 1/2 cup vegetable oil \n 2 pounds thick catfish fillets, cut into large chunks \n ' ," +
                "'1.) Blend the vinegar, garlic, ginger, salt, cayenne, coriander, cumin, and oil in a blender until you have a thick paste. Brush the fish chunks with the mixture to coat evenly and place in a shallow dish; pour the remaining marinade over the fish. Allow to marinate in refrigerator at least 4 hours. \n\n 2.) Preheat the oven broiler. Arrange the marinated fish in a broiler-safe dish, reserving the marinade. \n\n 3.) Broil the fish under the preheated broiler on the oven center rack for 10 minutes; turn the fish and brush with reserved marinade. Continue cooking until the fish flakes easily with a fork, about 7 minutes more. Serve hot.' ," +
                R.drawable.tandorifish +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Fish Tacos' ," +
                "' 1 cup all-purpose flour \n 2 tablespoons cornstarch \n 1 teaspoon baking powder \n 1/2 teaspoon salt \n 1 egg \n 1 cup beer \n 1/2 cup plain yogurt \n 1/2 cup mayonnaise \n 1 lime, juiced \n 1 jalapeno pepper, minced \n 1 teaspoon minced capers \n 1/2 teaspoon dried oregano \n 1/2 teaspoon ground cumin \n 1/2 teaspoon dried dill weed \n 1 teaspoon ground cayenne pepper \n 1 quart oil for frying \n 1 pound cod fillets, cut into 2 to 3 ounce portions \n 1 (12 ounce) package corn tortillas \n 1/2 medium head cabbage, finely shredded \n' ," +
                "'1.) To make beer batter: In a large bowl, combine flour, cornstarch, baking powder, and salt. Blend egg and beer, then quickly stir into the flour mixture (do not worry about a few lumps). \n\n 2.) To make white sauce: In a medium bowl, mix together yogurt and mayonnaise. Gradually stir in fresh lime juice until consistency is slightly runny. Season with jalapeno, capers, oregano, cumin, dill, and cayenne. 3.) Heat oil in deep-fryer to 375 degrees F (190 degrees C). 4.) Dust fish pieces lightly with flour. Dip into beer batter, and fry until crisp and golden brown. Drain on paper towels. Lightly fry tortillas; not too crisp. To serve, place fried fish in a tortilla, and top with shredded cabbage, and white sauce.' ," +
                R.drawable.fishtacos +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Blackened Fish' ," +
                "' 1 tablespoon paprika \n 2 teaspoons dry mustard \n 1 teaspoon cayenne pepper \n 1 teaspoon ground cumin \n 1 teaspoon black pepper \n 1 teaspoon white pepper \n 1 teaspoon dried thyme \n 1 teaspoon salt \n 3/4 cup unsalted butter, melted \n 6 (4 ounce) fillets trout \n 1/4 cup unsalted butter, melted \n' ," +
                "'1.) In a small bowl, mix together paprika, dry mustard, cayenne pepper, cumin, black pepper, white pepper, thyme and salt; set aside. Heat a heavy cast iron pan on high heat until extremely hot, about 10 minutes.\n\n 2.) Pour 3/4 cup melted butter into a shallow dish. Dip each fillet into butter, turning once to coat both sides. Sprinkle both sides of fillets with spice mixture, and gently pat mixture onto fish. \n\n 3.) Place fillets into hot pan without crowding. Carefully pour about 1 teaspoon melted butter over each fillet. Cook until fish has a charred appearance, about 2 minutes. Turn fillets, spoon 1 teaspoon melted butter over each, and cook until charred. Repeat with remaining fish.' ," +
                R.drawable.blackenedfish +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Fish Taquitos' ," +
                "' 1 pound shark fish fillets \n 12 (6 inch) corn tortillas \n 1/4 cup canola oil \n 1/4 cup lemon juice \n 1 clove garlic, minced \n 1 teaspoon dried oregano \n 1 teaspoon Cajun seasoning \n 1 cup shredded Cheddar cheese \n 2 quarts vegetable oil for frying \n' ," +
                "'1.) Cut shark into strips 3/4 inch thick and 3 inches long. Mix canola oil, lemon juice, garlic, oregano, and Cajun style spice mix in a plastic container. Place shark strips in container, and marinate for 1 hour. \n\n 2.) Warm tortillas in a microwave to make them pliable. \n\n 3.) Drain marinade, and pat shark dry with paper towels. Place a strip of shark at one end of a tortilla, roll tightly, and secure with a toothpick. \n\n 4.) Heat oil in a deep fryer. Submerge taquitos in hot oil. Fry until golden brown, no more than 3 or 4 minutes each. Drain on paper towels. \n\n 5.) Place taquitos in a baking dish large enough to accommodate all twelve. Sprinkle with shredded cheese. \n\n 6.) Bake at 350 degrees F (175 degrees C) for 5 minutes, or until cheese melts.' ," +
                R.drawable.fishtaquitos +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Chicken Potpie' ," +
                "' 2 tablespoons butter \n 2 tablespoons olive oil \n 3 cups diced red potato (about 1 pound) \n 2 cups diced onion \n 2 cups sliced mushrooms (about 8 ounces) \n 1 cup diced celery \n 1 cup diced carrot \n 1/4 cup chopped fresh parsley \n 2 teaspoons chopped fresh thyme \n 6 1/2 tablespoons all-purpose flour \n 3 cups fat-free milk \n 1/2 cup fat-free, less-sodium chicken broth \n 2 cups chopped cooked chicken breast (about 12 ounces) \n 1 cup frozen green peas \n 1 teaspoon salt \n 1/2 teaspoon freshly ground black pepper \n 6 (14 x 9-inch) sheets frozen phyllo dough, thawed \n Cooking spray \n ' ," +
                "'1.) Preheat oven to 375°. \n\n 2.) Melt butter in a large Dutch oven over medium-high heat; add oil. Add potatoes and next 6 ingredients (through thyme), and sauté for 5 minutes. Reduce heat to medium-low; sprinkle flour over vegetables. Cook for 5 minutes, stirring frequently. Stir in milk and broth. Increase heat to medium-high; bring to a boil. Reduce heat, and simmer 5 minutes or until thickened. Add chicken, peas, salt, and pepper. \n\n 3.) Spoon mixture into a 3-quart baking dish. Place 1 phyllo sheet on a large cutting board or work surface (cover remaining dough to keep from drying); lightly spray with cooking spray. Repeat layers with cooking spray and remaining phyllo. Place phyllo layers loosely on top of mixture in dish. Place dish on a baking sheet. Bake at 375° for 30 minutes or until top is golden.' ," +
                R.drawable.chickenpotpie +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Honey Broccoli Chicken' ," +
                "' 6–8 boneless chicken thighs \n kosher salt \n Freshly ground black pepper \n extra-virgin olive oil \n 3 garlic cloves, minced \n 1 onion, chopped \n 1/2 c. dry white wine, such as Sauvignon Blanc \n 1 c. low-sodium chicken stock \n 1/4 c. sriracha \n 1 tbsp. soy sauce \n 1/2 c. honey \n 1 head broccoli, cut into large florets \n 1/4 c. chopped parsley \n' ," +
                "'1.) Preheat the oven to 475 degrees F. Preheat large skillet on high heat. Rinse chicken and pat dry thoroughly; season with salt and pepper. Drizzle olive oil and sear chicken skin-side down until skin is crisp and deep golden brown, about 5 minutes. Transfer to a dish skin-side up and set aside. \n\n 2.) Reduce skillet heat to medium; add garlic, onion, 1 teaspoon salt, and 1/2 teaspoon pepper and cook for 1 minute. Deglaze pan with white wine using a wooden spoon to scrape bottom of pan. Add chicken stock, Sriracha, soy sauce, and honey. Stir well and place chicken in the skillet skin side up in a single layer. Add broccoli florets. Bake until chicken is cooked through, approximately 15 to 20 minutes. \n\n 3.) Garnish with parsley and serve immediately.' ," +
                R.drawable.honeybroccolichicken +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Pork Medallions' ," +
                "' 8 slices bacon \n 1 tablespoon garlic powder \n 1 teaspoon seasoned salt \n 1 teaspoon dried basil \n 1 teaspoon dried oregano \n 2 pounds pork tenderloin \n 2 tablespoons butter \n 2 tablespoons olive oil \n' ," +
                "'1.) Preheat an oven to 400 degrees F (200 degrees C). \n\n 2.) Place the bacon in a large, oven-safe skillet, and cook over medium-high heat, turning occasionally, until lightly browned and still flexible, 6 to 7 minutes. Drain the bacon slices on a paper towel-lined plate. Remove any excess bacon grease from the skillet. Combine garlic powder, seasoning salt, basil, and oregano in a small bowl. Set aside. \n\n 3.) Wrap the pork tenderloin with the bacon strips securing with 1 or 2 toothpicks per strip of bacon. Slice the tenderloin between each bacon strip to create the medallions. Dip both sides of the medallions in seasoning mix. Melt butter and oil together in the same skillet over medium-high heat. Cook each medallion for 4 minutes on each side. \n\n 4.) Place skillet into the preheated oven and bake until the pork is no longer pink in the center, 17 to 20 minutes. An instant-read thermometer inserted into the center should read 145 degrees F (63 degrees C).' ," +
                R.drawable.porkmedallions +
                ")");



        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Black Bean Pork Chops' ," +
                "' 4 bone-in pork chops \n ground black pepper to taste \n 1 tablespoon olive oil \n 1 (15 ounce) can black beans, with liquid \n 1 cup salsa \n 1 tablespoon chopped fresh cilantro \n' ," +
                "'1.) Season pork chops with pepper. \n\n 2.) Heat oil in a large skillet over medium-high heat. Cook pork chops in hot oil until browned, 3 to 5 minutes per side. \n\n 3.) Pour beans and salsa over pork chops and season with cilantro. Bring to a boil, reduce heat to medium-low, cover the skillet, and simmer until pork chops are cooked no longer pink in the center, 20 to 35 minutes. An instant-read thermometer inserted into the center should read 145 degrees F (63 degrees C).' ," +
                R.drawable.blackbeanporkchop +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Pork Enchiladas' ," +
                "' 2 cups shredded cooked pork \n 1 (10 ounce) can enchilada sauce \n 1/2 teaspoon onion powder \n 1 cup reduced fat sour cream \n 1 (4 ounce) can chopped green chilies \n 2 cups shredded Colby-Monterey Jack cheese \n 1 (10.75 ounce) can condensed tomato soup \n 1/4 teaspoon garlic powder \n 1/2 teaspoon ground cumin \n 6 (7 inch) flour tortillas \n ' ," +
                "'1.) Preheat an oven to 350 degrees F (175 degrees C). \n\n 2.) Combine cooked pork, enchilada sauce, onion powder, 1/2 cup sour cream, green chilies, and one cup of the shredded cheese in a large bowl. In a separate bowl, stir together tomato soup, remaining 1/2 cup sour cream, garlic powder, and cumin. \n\n 3.) Pour a thin layer of the tomato soup mixture into a 9x13 baking dish. Spread pork mixture down the center of each tortilla. Roll tortillas to enclose filling; place seam side down in the baking dish. Pour the remaining soup mixture over the filled tortillas. Top with the remaining 1 cup cheese. \n\n 4.) Bake in preheated oven until hot and bubbly, about 30 minutes.' ," +
                R.drawable.porkenchiladas +
                ")");

        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Pork Fries' ," +
                "' 1 (19 ounce) package Smithfield® Peppercorn & Garlic Seasoned Pork Tenderloin \n 4 eggs, beaten \n 1 (8 ounce) package panko (Japanese-style bread crumbs) \n 2/3 cup all-purpose flour \n Vegetable oil for frying \n' ," +
                "'1.) Remove tenderloin from packaging and place on cutting board; cut into 3 equal length sections, each about 3 inches long. Slice each section into 1/4- to 1/2-inch diameter strips. You will end up with approximately 34 strips that are similar in size and shape to French fries. \n\n 2.) Place eggs, breadcrumbs and flour into separate bowls. Dredge pork strips in flour, coat with beaten egg, and toss in breadcrumbs. \n\n 3.) Pour oil into large skillet until 1/4 inch deep; heat over medium-high until breadcrumb dropped in oil sizzles. Gently place approximately 8 breaded pork strips into oil, making sure not to overcrowd them. Fry approximately 1 1/2 minutes per side until golden brown, crisp, and internal temperature of pork is at least 150 degrees F.; drain on paper towels. Repeat until all pork strips are fried. Note that stove temperature may need to be reduced to prevent burning when the oil level lowers after a few batches. \n\n 4.) Serve with BBQ sauce, sriracha mayonnaise, or ranch dressing for dipping.' ," +
                R.drawable.porkfries +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Tomatoed Pork' ," +
                "' 2 tablespoons canola oil \n 2 pounds pork shoulder, cut into 1-inch chunks \n 2 teaspoons salt \n 2 teaspoons ground black pepper \n 2 large fresh jalapeno peppers, stems removed \n 1/4 cup sliced onion \n 1 clove garlic, crushed \n 1 (6 ounce) can mushroom stems and pieces, drained \n 1 (12 ounce) can diced tomatoes \n 1/2 teaspoon ground cumin \n' ," +
                "'1.) Heat the oil in a large skillet over medium heat. Season the pork with salt and pepper. Add the pork to skillet and stir to coat with oil. Place the jalapeno peppers into the pan and cover; allow to simmer 20 minutes. Uncover and remove the jalapenos from the pan; chop roughly and set aside. Continue cooking the pork, uncovered, until it browns completely and the liquid evaporates, about 10 minutes. \n\n 2.) Mix in the onion and garlic; cook and stir about 2 minutes. Add the mushrooms and cook 1 minute more. Pour the tomatoes and chopped jalapenos into the pan and stir through the pork. Season with the cumin. Stir, cover, and reduce heat to low; simmer another 10 minutes.' ," +
                R.drawable.tomatoedpork +
                ")");


        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Pork Carnitas' ," +
                "' 1/4 cup vegetable oil \n 4 pounds pork shoulder, cut into several large pieces \n 3 tablespoons kosher salt \n 1 onion, chopped \n 1 clove garlic, crushed \n 3 tablespoons lime juice \n 1 tablespoon chili powder \n 1/2 teaspoon dried oregano \n 1/2 teaspoon ground cumin \n 4 (14.5 ounce) cans chicken broth \n' ," +
                "'1.) Preheat an oven to 400 degrees F (200 degrees C). \n\n 2.) Heat the vegetable oil in a large Dutch oven over high heat. Season the pork shoulder with salt, then arrange the pork in the Dutch oven. Cook until browned on all sides, about 10 minutes. Add the onion, garlic, lime juice, chili powder, oregano, and cumin. Pour in the chicken broth, and bring to a boil. Reduce heat to medium-low, cover, and continue to simmer until pork is very tender, about 2 1/2 hours. \n\n 3.) Transfer the pork shoulder to a large baking sheet, reserving the cooking liquid. Drizzle with a small amount of the reserved cooking liquid and lightly season with salt. \n\n 4.) Bake the pork in the preheated oven until browned, about 30 minutes. Drizzle more of the cooking liquid on the meat every 10 minutes, and use two forks to shred the meat as it browns.' ," +
                R.drawable.porkcarnitas +
                ")");




        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('BBQ Pork Sandwich' ," +
                "' 1 (14 ounce) can beef broth \n 3 pounds boneless pork ribs \n 1 (18 ounce) bottle barbeque sauce \n ' ," +
                "'1.) Pour can of beef broth into slow cooker, and add boneless pork ribs. Cook on High heat for 4 hours, or until meat shreds easily. Remove meat, and shred with two forks. It will seem that it is not working right away, but it will.\n\n 2.) Preheat oven to 350 degrees F (175 degrees C). Transfer the shredded pork to a Dutch oven or iron skillet, and stir in barbeque sauce. \n\n 3.) Bake in the preheated oven for 30 minutes, or until heated through.' ," +
                R.drawable.bbqporksandwich +
                ")");



        db.execSQL("INSERT INTO " + TABLE_RECIPES + "(NAME, INGREDIENTS, INSTRUCTIONS, IMAGE) VALUES " +
                "('Maple Pork Loin' ," +
                "' 1 quart cold water \n 1/4 cup salt \n 1/3 cup maple syrup \n 3 cloves garlic, crushed \n 3 tablespoons chopped fresh ginger \n 2 teaspoons dried rosemary \n 1 tablespoon cracked black pepper \n 1/2 teaspoon red pepper flakes \n 1 (2 1/2 pound) boneless pork loin roast \n salt and freshly ground black pepper \n 1 tablespoon vegetable oil \n 2 tablespoons maple syrup \n 2 tablespoons Dijon mustard \n' ," +
                "'1.) Mix water, salt, 1/3 cup maple syrup, garlic, ginger, rosemary, black pepper, and red pepper flakes in a large bowl. Place pork loin in brine mixture and refrigerate for 8 to 10 hours.\n\n 2.) Remove pork from brine, pat dry, and season all sides with salt and black pepper. \n\n 3.) Preheat oven to 325 degrees F (165 degrees C). \n\n 4.) Heat vegetable oil in an oven-proof skillet over high heat. Cook pork, turning to brown each side, about 10 minutes total. \n\n 5.) Transfer skillet to the oven and roast until pork is browned, about 40 minutes. \n\n 6.) Mix 2 tablespoons maple syrup and Dijon mustard together in a small bowl. \n\n 7.) Remove pork roast from the oven and spread maple syrup mixture on all sides. Cook for an additional 15 minutes, until the pork is no longer pink in the center. An instant-read thermometer inserted into the center should read 145 degrees F (63 degrees C).' ," +
                R.drawable.mapleporkloin +
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
    public void AddFavourite(String recipe[]){

        SQLiteDatabase db = this.getWritableDatabase();
        // Select distinct
        String sqlStatement = "INSERT INTO " + TABLE_FAVOURITES +
                "( "+ COLUMN_RECIPE_NAME + ", " + COLUMN_RECIPE_INGREDIENTS + ", "+
                COLUMN_RECIPE_INSTRUCTIONS + ", " + COLUMN_RECIPE_IMAGE + ")" + " VALUES ( "+
                recipe[0] + ", " + recipe[1] + ", " + recipe[2] + ", " + recipe[3] + ")";

        db.execSQL(sqlStatement);
    }
     */

    public void AddFavourite(String name, String ingredients, String instructions, int image){

        SQLiteDatabase db = this.getWritableDatabase();
        // Select distinct
        String sqlStatement = "INSERT INTO " + TABLE_FAVOURITES +
                "( "+ COLUMN_RECIPE_NAME + ", " + COLUMN_RECIPE_INGREDIENTS + ", "+
                COLUMN_RECIPE_INSTRUCTIONS + ", " + COLUMN_RECIPE_IMAGE + ")" + " VALUES ( "+
                name + ", " + ingredients + ", " + instructions + ", " + image + ")";

        db.execSQL(sqlStatement);
    }




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
