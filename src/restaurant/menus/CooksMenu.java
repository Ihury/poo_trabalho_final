package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.employees.Cook;
import restaurant.items.ItemWithIngredients;

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
            System.out.print("Informe o nome do cozinheiro: ");
            String name = sc.nextLine();
            System.out.print("Informe o CPF do cozinheiro: ");
            String cpf = sc.nextLine();
            System.out.print("Informe o RG do cozinheiro: ");
            String rg = sc.nextLine();
            System.out.print("Informe o estado civil do cozinheiro: ");
            String maritalStatus = sc.nextLine();
            System.out.print("Informe o endereço do cozinheiro: ");
            String address = sc.nextLine();
            System.out.print("Informe a carteira de trabalho do cozinheiro: ");
            String workCard = sc.nextLine();

            Cook cook = new Cook(name, cpf, rg, maritalStatus, address, workCard);
            addFoodsToCook(cook);
            Restaurant.addCook(cook);
            infoMessage("Cozinheiro adicionado!");
        } catch (IllegalArgumentException e) {
            infoMessage(e.getMessage());
        } finally {
            startCooksMenu();
        }
    }

    public static void removeCook() {
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

    public static void addFoodsToCook(Cook cook) {
        boolean showMainCoursesOption = !Restaurant.getMainCourses().isEmpty(),
                showDessertsOption = !Restaurant.getDesserts().isEmpty();

        if (!showMainCoursesOption && !showDessertsOption) return;

        if (!Restaurant.getIngredients().isEmpty()) {
            System.out.print("Deseja adicionar um prato ao cozinheiro?\n1 - Sim\n2 - Não\nEscolha: ");
            String choose = sc.nextLine();

            switch (choose) {
                case "1":
                    addFoodToCook(cook);
                    break;
                case "2":
                    break;
                default:
                    invalidOption();
                    startCooksMenu();
            }
        }
    }

    public static void addFoodToCook(Cook cook) {
        boolean showMainCoursesOption = !Restaurant.getMainCourses().isEmpty(),
                showDessertsOption = !Restaurant.getDesserts().isEmpty();
        clearConsole();
        showHead();
        System.out.println("Qual tipo de comida você deseja adicionar ao cozinheiro?");
        if (showMainCoursesOption) System.out.println("1 - Prato principal");
        if (showDessertsOption) System.out.println("2 - Sobremesa");
        showFooter();
        requestOption();

        String opt = sc.nextLine();
        switch (opt) {
            case "1":
                addMainCourseToCook(cook);
                break;
            case "2":
                addDessertToCook(cook);
                break;
            case "v":
                startCooksMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                addFoodsToCook(cook);
        }
    }

    private static void addMainCourseToCook(Cook cook) {
        clearConsole();
        showHead();
        MainCoursesMenu.listMainCourses(Restaurant.getMainCourses());
        showFooter();
        System.out.println("Qual prato principal você deseja adicionar ao cozinheiro: ");

        String opt = sc.nextLine();
        switch (opt) {
            case "v":
                addFoodsToCook(cook);
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int mainCourseIndex = Integer.parseInt(opt);
                    if (mainCourseIndex > 0 && mainCourseIndex <= Restaurant.getMainCourses().size()) {
                        cook.addFood(Restaurant.getMainCourses().get(mainCourseIndex - 1));
                    }
                    Restaurant.updateCooks();
                    infoMessage("Prato adicionado com sucesso!");
                    clearConsole();
                    ArrayList<ItemWithIngredients> mainCourses = cook.getFoods();
                    if (!mainCourses.isEmpty()) {
                        System.out.println(SEPARATOR_BAR);
                        System.out.println("PRATOS ADICIONADOS");
                        System.out.println(SEPARATOR_BAR);
                        for (int i = 0; i < mainCourses.size(); i++) {
                            ItemWithIngredients item = mainCourses.get(i);
                            System.out.println((i + 1) + " - " + item);
                        }
                        System.out.println(SEPARATOR_BAR);
                    }

                    System.out.print("Deseja adicionar outro prato?\n1 - Sim\n2 - Não\nEscolha: ");
                    String choose = sc.nextLine();
                    switch (choose) {
                        case "1":
                            addFoodToCook(cook);
                            break;
                        case "2":
                            break;
                        default:
                            invalidOption();
                            addFoodsToCook(cook);
                    }
                } catch (NumberFormatException e) {
                    invalidOption();
                    addMainCourseToCook(cook);
                }
        }
    }
    
    private static void addDessertToCook(Cook cook) {
        clearConsole();
        showHead();        
        DessertsMenu.listDesserts(Restaurant.getDesserts());
        showFooter();
        System.out.println("Qual sobremesa você deseja adicionar ao cozinheiro: ");

        String opt = sc.nextLine();
        switch (opt) {
            case "v":
                addFoodsToCook(cook);
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int dessertIndex = Integer.parseInt(opt);
                    if (dessertIndex > 0 && dessertIndex <= Restaurant.getDesserts().size()) {
                        cook.addFood(Restaurant.getDesserts().get(dessertIndex - 1));
                    }
                    Restaurant.updateCooks();
                    infoMessage("Sobremesa adicionada com sucesso!");
                    clearConsole();
                    ArrayList<ItemWithIngredients> items = cook.getFoods();
                    if (!items.isEmpty()) {
                        System.out.println(SEPARATOR_BAR);
                        System.out.println("PRATOS ADICIONADOS");
                        System.out.println(SEPARATOR_BAR);
                        for (int i = 0; i < items.size(); i++) {
                            ItemWithIngredients item = items.get(i);
                            System.out.println((i + 1) + " - " + item);
                        }
                        System.out.println(SEPARATOR_BAR);
                    }

                    System.out.print("Deseja adicionar outro prato?\n1 - Sim\n2 - Não\nEscolha: ");
                    String choose = sc.nextLine();
                    switch (choose) {
                        case "1":
                            addFoodToCook(cook);
                            break;
                        case "2":
                            break;
                        default:
                            invalidOption();
                            addFoodsToCook(cook);
                    }
                } catch (NumberFormatException e) {
                    invalidOption();
                    addDessertToCook(cook);
                }
        }
    }
}
