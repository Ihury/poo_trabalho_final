package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.enums.PackageType;
import restaurant.exceptions.InvalidIdException;
import restaurant.items.Beverage;

public class BeveragesMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar bebidas");
        System.out.println("2 - Adicionar bebida");
        System.out.println("3 - Remover bebida");
        showFooter();
        requestOption();
    }

    public static void showBeverages(ArrayList<Beverage> items) {
        clearConsole();
        showHead();
        listBeverages(items);
        showFooter();
        requestOption();
    }

    public static void listBeverages(ArrayList<Beverage> items) {
        for (int i = 0; i < items.size(); i++) {
            Beverage item = items.get(i);
            System.out.println((i + 1) + " - " + item);
        }
    }

    public static void showRemoveBeverage(ArrayList<Beverage> items) {
        clearConsole();
        showHead();
        listBeverages(items);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o número da bebida que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nSOBREMESAS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startBeveragesMenu() {
        BeveragesMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showBeverages();
                break;
            case "2":
                addBeverage();
                break;
            case "3":
                removeBeverage();
                break;
            case "v":
                ItemsMenu.startItensMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startBeveragesMenu();
        }
    }

    public static void showBeverages() {
        BeveragesMenu.showBeverages(Restaurant.getBeverages());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startBeveragesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                showBeverages();
        }
    }

    public static void addBeverage() {
        Menu.clearConsole();
        try {
            System.out.print("Informe o ID da bebida: ");
            String id = sc.nextLine();
            System.out.print("Informe o nome da bebida: ");
            String name = sc.nextLine();
            System.out.print("Informe o preço da bebida: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o preço de custo da bebida: ");
            double costPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o tamanho da embalagem (em ml): ");
            double packageSize = Double.parseDouble(sc.nextLine());
            showPackageTypes();
            System.out.print("Escolha o tipo de embalagem: ");
            int packageTypeIndex = Integer.parseInt(sc.nextLine());
            if (packageTypeIndex > 0 && packageTypeIndex <= PackageType.values().length) {
                Beverage beverage = new Beverage(id, name, price, costPrice, packageSize, PackageType.values()[packageTypeIndex - 1]);
                Restaurant.addBeverage(beverage);
                infoMessage("Bebida adicionada!");
            } else {
                invalidOption();
            }
        } catch (InvalidIdException | IllegalArgumentException e) {
            infoMessage(e.getMessage());
        } finally {
            startBeveragesMenu();
        }
    }

    private static void showPackageTypes() {
        for (PackageType packageType : PackageType.values()) {
            System.out.println((packageType.ordinal() + 1) + " - " + packageType.getDescription());
        }
    }

    public static void removeBeverage() {
        BeveragesMenu.showRemoveBeverage(Restaurant.getBeverages());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startBeveragesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int beverageIndex = Integer.parseInt(opt);
                    if (beverageIndex > 0 && beverageIndex <= Restaurant.getBeverages().size()) {
                        Restaurant.removeBeverage(beverageIndex - 1);
                    }
                    startBeveragesMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeBeverage();
                }
        }
    }
}
