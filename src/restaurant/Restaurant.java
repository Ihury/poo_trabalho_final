package restaurant;

import restaurant.employees.Cook;
import restaurant.employees.Waiter;
import restaurant.items.Beverage;
import restaurant.items.Dessert;
import restaurant.items.Ingredient;
import restaurant.items.MainCourse;
import restaurant.order.Order;

import java.util.ArrayList;

public class Restaurant {
    private static ArrayList<Ingredient> ingredients;
    private static boolean ingredientesLoaded = false;
    private static ArrayList<MainCourse> mainCourses;
    private static boolean mainCoursesLoaded = false;
    private static ArrayList<Dessert> desserts;
    private static boolean dessertsLoaded = false;
    private static ArrayList<Beverage> beverages;
    private static boolean beveragesLoaded = false;
    private static ArrayList<Cook> cooks;
    private static boolean cooksLoaded = false;
    private static ArrayList<Waiter> waiters;
    private static boolean waitersLoaded = false;
    private static ArrayList<Order> orders;
    private static boolean ordersLoaded = false;

    public static boolean addIngredient(Ingredient ingredient) {
        if (!ingredientesLoaded)
            getIngredients();
        if (ingredient == null) return false;
        else {
            ingredients.add(ingredient);
            Persist.save(ingredients, "persistance/ingredients.dat");
            return true;
        }
    }

    public static ArrayList<Ingredient> getIngredients() {
        if (!ingredientesLoaded) {
            ingredients = (ArrayList<Ingredient>) Persist.get("persistance/ingredients.dat");
            if (ingredients == null)
                ingredients = new ArrayList<>();

            ingredientesLoaded = true;
        }        
        return ingredients;
    }

    public static boolean removeIngredient(int position) {
        if (position < 0 || position >= ingredients.size())
            return false;
        else {
            ingredients.remove(position);
            Persist.save(ingredients, "persistance/ingredients.dat");
            return true;
        }
    }

    public static boolean addMainCourse(MainCourse mainCourse) {
        if (!mainCoursesLoaded)
            getMainCourses();
        if (mainCourse == null) return false;
        else {
            mainCourses.add(mainCourse);
            Persist.save(mainCourses, "persistance/mainCourses.dat");
            return true;
        }
    }

    public static ArrayList<MainCourse> getMainCourses() {
        if (!mainCoursesLoaded) {
            mainCourses = (ArrayList<MainCourse>) Persist.get("persistance/mainCourses.dat");
            if (mainCourses == null) mainCourses = new ArrayList<>();
        }
        return mainCourses;
    }

    public static boolean removeMainCourse(int position) {
        if (position < 0 || position >= mainCourses.size()) return false;
        else {
            mainCourses.remove(position);
            Persist.save(mainCourses, "persistance/mainCourses.dat");
            return true;
        }
    }

    public static void updateItens() {
        Persist.save(ingredients, "persistance/ingredients.dat");
        getIngredients();
        Persist.save(mainCourses, "persistance/mainCourses.dat");
        getMainCourses();
    }

    public static boolean addDessert(Dessert dessert) {
        if (!dessertsLoaded)
            getDesserts();
        if (dessert == null)
            return false;
        else {
            desserts.add(dessert);
            Persist.save(desserts, "persistance/desserts.dat");
            return true;
        }
    }
    
    public static ArrayList<Dessert> getDesserts() {
        if (!dessertsLoaded) {
            desserts = (ArrayList<Dessert>) Persist.get("persistance/desserts.dat");
            if (desserts == null)
                desserts = new ArrayList<>();
        }
        return desserts;
    }
    
    public static boolean removeDessert(int position) {
        if (position < 0 || position >= desserts.size())
            return false;
        else {
            desserts.remove(position);
            Persist.save(desserts, "persistance/desserts.dat");
            return true;
        }
    }

    public static boolean addBeverage(Beverage beverage) {
        if (!beveragesLoaded)
            getBeverages();
        if (beverage == null)
            return false;
        else {
            beverages.add(beverage);
            Persist.save(beverages, "persistance/beverages.dat");
            return true;
        }
    }

    public static ArrayList<Beverage> getBeverages() {
        if (!beveragesLoaded) {
            beverages = (ArrayList<Beverage>) Persist.get("persistance/beverages.dat");
            if (beverages == null)
                beverages = new ArrayList<>();
        }
        return beverages;
    }

    public static boolean removeBeverage(int position) {
        if (position < 0 || position >= beverages.size())
            return false;
        else {
            beverages.remove(position);
            Persist.save(beverages, "persistance/beverages.dat");
            return true;
        }
    }

    public static boolean addCook(Cook cook) {
        if (!cooksLoaded)
            getCooks();
        if (cook == null)
            return false;
        else {
            cooks.add(cook);
            Persist.save(cooks, "persistance/cooks.dat");
            return true;
        }
    }

    public static ArrayList<Cook> getCooks() {
        if (!cooksLoaded) {
            cooks = (ArrayList<Cook>) Persist.get("persistance/cooks.dat");
            if (cooks == null)
                cooks = new ArrayList<>();
        }
        return cooks;
    }

    public static boolean removeCook(int position) {
        if (position < 0 || position >= cooks.size())
            return false;
        else {
            cooks.remove(position);
            Persist.save(cooks, "persistance/cooks.dat");
            return true;
        }
    }

    public static void updateCooks() {
        Persist.save(cooks, "persistance/cooks.dat");
        getCooks();
    }

    public static boolean addWaiter(Waiter waiter) {
        if (!waitersLoaded)
            getWaiters();
        if (waiter == null)
            return false;
        else {
            waiters.add(waiter);
            Persist.save(waiters, "persistance/waiters.dat");
            return true;
        }
    }

    public static ArrayList<Waiter> getWaiters() {
        if (!waitersLoaded) {
            waiters = (ArrayList<Waiter>) Persist.get("persistance/waiters.dat");
            if (waiters == null)
                waiters = new ArrayList<>();
        }
        return waiters;
    }

    public static boolean removeWaiter(int position) {
        if (position < 0 || position >= waiters.size())
            return false;
        else {
            waiters.remove(position);
            Persist.save(waiters, "persistance/waiters.dat");
            return true;
        }
    }

    public static void updateWaiters() {
        Persist.save(waiters, "persistance/waiters.dat");
        getWaiters();
    }

    public static boolean addOrder(Order order) {
        if (!ordersLoaded)
            getOrders();
        if (order == null)
            return false;
        else {
            orders.add(order);
            Persist.save(orders, "persistance/orders.dat");
            return true;
        }
    }

    public static ArrayList<Order> getOrders() {
        if (!ordersLoaded) {
            orders = (ArrayList<Order>) Persist.get("persistance/orders.dat");
            if (orders == null)
                orders = new ArrayList<>();
        }
        return orders;
    }

    public static boolean removeOrder(int position) {
        if (position < 0 || position >= orders.size())
            return false;
        else {
            orders.remove(position);
            Persist.save(orders, "persistance/orders.dat");
            return true;
        }
    }

    public static void updateOrders() {
        Persist.save(orders, "persistance/orders.dat");
        getOrders();
    }
}
