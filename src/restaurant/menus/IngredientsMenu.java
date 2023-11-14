package restaurant.menus;

import restaurant.Restaurant;
import restaurant.items.Dessert;
import restaurant.items.Ingredient;
import restaurant.items.ItemWithIngredients;
import restaurant.items.MainCourse;

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
        IngredientsMenu.showIngredients(Restaurant.getIngredients());
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
                showIngredients();
        }
    }

    public static void addIngredient() {
        Menu.clearConsole();
        System.out.print("Informe o nome do ingrediente: ");
        String name = sc.nextLine();
        Restaurant.addIngredient(new Ingredient(name));
        infoMessage("Ingrediente adicionado com sucesso!");
        startIngredientsMenu();
    }

    public static void removeIngredient() {
        IngredientsMenu.showRemoveIngredient(Restaurant.getIngredients());
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
                    if (ingredientIndex > 0 && ingredientIndex <= Restaurant.getIngredients().size()) {
                        Restaurant.removeIngredient(ingredientIndex - 1);
                    }
                    startIngredientsMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeIngredient();
                }
        }
    }

    public static void addIngredientsToItem(ItemWithIngredients item) {
        if (!Restaurant.getIngredients().isEmpty()) {
            System.out.print("Deseja adicionar um ingrediente ao item?\n1 - Sim\n2 - Não\nEscolha: ");
            String choose = sc.nextLine();

            switch (choose) {
                case "1":
                    addIngredientToItem(item);
                    break;
                case "2":
                    break;
                default:
                    invalidOption();
                    returnToItemMenu(item);
            }
        }
    }

    private static void addIngredientToItem(ItemWithIngredients item) {
        clearConsole();
        showHead();
        listIngredients(Restaurant.getIngredients());
        showFooter();
        System.out.print("Informe o ingrediente que deseja adicionar: ");
        String opt = sc.nextLine();
        switch (opt) {
            case "s":
                leave();
                break;
            case "v":
                break;
            default:
                int ingredientIndex = Integer.parseInt(opt);
                Ingredient ingredient = Restaurant.getIngredients().get(ingredientIndex - 1);
                item.addIngredient(ingredient);
                Restaurant.updateItens();
                infoMessage("Ingrediente adicionado com sucesso!");
                clearConsole();
                ArrayList<Ingredient> ingredients = item.getIngredients();
                if (!ingredients.isEmpty()) {
                    System.out.println(SEPARATOR_BAR);
                    System.out.println("INGREDIENTES ADICIONADOS");
                    System.out.println(SEPARATOR_BAR);
                    for (int i = 0; i < ingredients.size(); i++) {
                        Ingredient itemIngredient = ingredients.get(i);
                        System.out.println((i + 1) + " - " + itemIngredient);
                    }
                    System.out.println(SEPARATOR_BAR);
                }
                System.out.print("Deseja adicionar outro ingrediente?\n1 - Sim\n2 - Não\nEscolha: ");
                String choose = sc.nextLine();
                switch (choose) {
                    case "1":
                        addIngredientToItem(item);
                        break;
                    case "2":
                        break;
                    default:
                        invalidOption();
                        returnToItemMenu(item);
                }
        }
    }

    public static void returnToItemMenu(ItemWithIngredients item) {
        if (item instanceof MainCourse)
            MainCoursesMenu.startMainCoursesMenu();
        else if (item instanceof Dessert)
            DessertsMenu.startDessertsMenu();
        else
            MainMenu.startMainMenu();
    }
}
