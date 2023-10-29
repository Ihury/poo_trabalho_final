package restaurant;

import restaurant.items.Beverage;
import restaurant.items.Dessert;
import restaurant.items.Ingredient;
import restaurant.items.MainCourse;

import java.util.ArrayList;

public class Restaurant {
    public static final ArrayList<Ingredient> ingredients = new ArrayList<>();
    public static final ArrayList<MainCourse> mainCourses = new ArrayList<>();
    public static final ArrayList<Dessert> desserts = new ArrayList<>();
    public static final ArrayList<Beverage> beverages = new ArrayList<>();
}
