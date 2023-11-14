package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.employees.Cook;
import restaurant.exceptions.InvalidIdException;
import restaurant.items.MainCourse;

public class CooksMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar cozinheiros");
        System.out.println("2 - Adicionar cozinheiro");
        System.out.println("3 - Remover cozinheiro");
        showFooter();
        requestOption();
    }

    public static void showCooks(ArrayList<Cook> cooks) {
        clearConsole();
        showHead();
        listCooks(cooks);
        showFooter();
        requestOption();
    }

    public static void listCooks(ArrayList<Cook> cooks) {
        for (int i = 0; i < cooks.size(); i++) {
            Cook cook = cooks.get(i);
            System.out.println((i + 1) + " - " + cook);
        }
    }

    public static void showRemoveCook(ArrayList<Cook> cooks) {
        clearConsole();
        showHead();
        listCooks(cooks);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o número do cozinheiro que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nCOZINHEIROS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startCooksMenu() {
        showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showCooks();
                break;
            case "2":
                addCook();
                break;
            case "3":
                removeCook();
                break;
            case "v":
                EmployeesMenu.startEmployeesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startCooksMenu();
        }
    }

    public static void showCooks() {
        showCooks(Restaurant.getCooks());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startCooksMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                showCooks();
        }
    }

    public static void addCook() {
        clearConsole();
        try {
            System.out.println("Informe o nome do cozinheiro: ");
            String name = sc.nextLine();
            System.out.println("Informe o CPF do cozinheiro: ");
            String cpf = sc.nextLine();
            System.out.println("Informe o RG do cozinheiro: ");
            String rg = sc.nextLine();
            System.out.println("Informe o estado civil do cozinheiro: ");
            String maritalStatus = sc.nextLine();
            System.out.println("Informe o endereço do cozinheiro: ");
            String address = sc.nextLine();

            Cook cook = new Cook(name, cpf, rg, maritalStatus, address);
//            addFoodsToCook(cook);
            Restaurant.addCook(cook);
            infoMessage("Cozinheiro adicionado!");
        } catch (IllegalArgumentException e) {
            infoMessage(e.getMessage());
        } finally {
            startCooksMenu();
        }
    }

    public static void removeCook() {
        MainCoursesMenu.showRemoveMainCourse(Restaurant.getMainCourses());
        showRemoveCook(Restaurant.getCooks());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startCooksMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int cookIndex = Integer.parseInt(opt);
                    if (cookIndex > 0 && cookIndex <= Restaurant.getCooks().size()) {
                        Restaurant.removeCook(cookIndex - 1);
                    }
                    startCooksMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeCook();
                }
        }
    }
}
