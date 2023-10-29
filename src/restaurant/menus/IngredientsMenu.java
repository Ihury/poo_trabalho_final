package restaurant.menus;

import restaurant.Restaurant;
import restaurant.items.Ingredient;

import java.util.ArrayList;

public class IngredientsMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar ingredientes");
        System.out.println("2 - Adicionar ingrediente");
        System.out.println("3 - Remover ingrediente");
        showFooter();
        requestOption();
    }

    public static void showIngredients(ArrayList<Ingredient> ingredients) {
        clearConsole();
        showHead();
        listIngredients(ingredients);
        showFooter();
        requestOption();
    }

    public static void listIngredients(ArrayList<Ingredient> ingredients) {
        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            System.out.println((i + 1) + " - " + ingredient);
        }
    }

    public static void showRemoveIngredient(ArrayList<Ingredient> ingredients) {
        clearConsole();
        showHead();
        listIngredients(ingredients);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o ingrediente que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nINGREDIENTES\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startIngredientsMenu() {
        IngredientsMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showIngredients();
                break;
            case "2":
                addIngredient();
                break;
            case "3":
                removeIngredient();
                break;
            case "v":
                MainMenu.startMainMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startIngredientsMenu();
        }
    }

    public static void showIngredients() {
        IngredientsMenu.showIngredients(Restaurant.ingredients);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startIngredientsMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
        }
    }

    public static void addIngredient() {
        Menu.clearConsole();
        System.out.print("Informe o nome do ingrediente: ");
        String name = sc.nextLine();
        Restaurant.ingredients.add(new Ingredient(name));
        infoMessage("Ingrediente adicionado com sucesso!");
        startIngredientsMenu();
    }

    public static void removeIngredient() {
        IngredientsMenu.showRemoveIngredient(Restaurant.ingredients);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startIngredientsMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int ingredientIndex = Integer.parseInt(opt);
                    if (ingredientIndex > 0 && ingredientIndex <= Restaurant.ingredients.size()) {
                        Restaurant.ingredients.remove(ingredientIndex - 1);
                    }
                    startIngredientsMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeIngredient();
                }
        }
    }
}
