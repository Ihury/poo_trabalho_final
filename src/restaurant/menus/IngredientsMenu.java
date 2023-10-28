package restaurant.menus;

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
}
