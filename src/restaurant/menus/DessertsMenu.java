package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.exceptions.InvalidIdException;
import restaurant.items.Dessert;

public class DessertsMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar sobremesas");
        System.out.println("2 - Adicionar sobremesa");
        System.out.println("3 - Remover sobremesa");
        showFooter();
        requestOption();
    }

    public static void showDesserts(ArrayList<Dessert> items) {
        clearConsole();
        showHead();
        listDesserts(items);
        showFooter();
        requestOption();
    }

    public static void listDesserts(ArrayList<Dessert> items) {
        for (int i = 0; i < items.size(); i++) {
            Dessert item = items.get(i);
            System.out.println((i + 1) + " - " + item);
        }
    }

    public static void showRemoveDessert(ArrayList<Dessert> items) {
        clearConsole();
        showHead();
        listDesserts(items);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o número da sobremesa que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nSOBREMESAS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startDessertsMenu() {
        DessertsMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showDesserts();
                break;
            case "2":
                addDessert();
                break;
            case "3":
                removeDessert();
                break;
            case "v":
                ItemsMenu.startItensMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startDessertsMenu();
        }
    }

    public static void showDesserts() {
        DessertsMenu.showDesserts(Restaurant.desserts);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startDessertsMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                showDesserts();
        }
    }

    public static void addDessert() {
        Menu.clearConsole();
        try {
            System.out.print("Informe o ID da sobremesa: ");
            String id = sc.nextLine();
            System.out.print("Informe o nome da sobremesa: ");
            String name = sc.nextLine();
            System.out.print("Informe o preço da sobremesa: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o preço de custo da sobremesa: ");
            double costPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Informe a descrição da sobremesa: ");
            String description = sc.nextLine();
            System.out.print("Informe o tempo de preparo da sobremesa: ");
            String preparationTime = sc.nextLine();
            System.out.print("Informe a quantidade de calorias da sobremesa: ");
            double calorieCount = Double.parseDouble(sc.nextLine());
            Dessert dessert = new Dessert(id, name, price, costPrice, description, preparationTime, calorieCount);
            Restaurant.desserts.add(dessert);
            infoMessage("Sobremesa adicionada!");
        } catch (InvalidIdException | IllegalArgumentException e) {
            infoMessage(e.getMessage());
        } finally {
            startDessertsMenu();
        }
    }

    public static void removeDessert() {
        DessertsMenu.showRemoveDessert(Restaurant.desserts);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startDessertsMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int dessertIndex = Integer.parseInt(opt);
                    if (dessertIndex > 0 && dessertIndex <= Restaurant.desserts.size()) {
                        Restaurant.desserts.remove(dessertIndex - 1);
                    }
                    startDessertsMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeDessert();
                }
        }
    }
}
