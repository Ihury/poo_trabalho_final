package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.exceptions.InvalidIdException;
import restaurant.items.MainCourse;

public class MainCoursesMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar pratos");
        System.out.println("2 - Adicionar prato");
        System.out.println("3 - Remover prato");
        showFooter();
        requestOption();
    }

    public static void showMainCourses(ArrayList<MainCourse> items) {
        clearConsole();
        showHead();
        listMainCourses(items);
        showFooter();
        requestOption();
    }

    public static void listMainCourses(ArrayList<MainCourse> items) {
        for (int i = 0; i < items.size(); i++) {
            MainCourse item = items.get(i);
            System.out.println((i + 1) + " - " + item);
        }
    }

    public static void showRemoveMainCourse(ArrayList<MainCourse> items) {
        clearConsole();
        showHead();
        listMainCourses(items);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o número do prato que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nPRATOS PRINCIPAIS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startMainCoursesMenu() {
        MainCoursesMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showMainCourses();
                break;
            case "2":
                addMainCourse();
                break;
            case "3":
                removeMainCourse();
                break;
            case "v":
                ItemsMenu.startItensMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startMainCoursesMenu();
        }
    }

    public static void showMainCourses() {
        MainCoursesMenu.showMainCourses(Restaurant.mainCourses);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startMainCoursesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                showMainCourses();
        }
    }

    public static void addMainCourse() {
        Menu.clearConsole();
        try {
            System.out.print("Informe o ID do prato: ");
            String id = sc.nextLine();
            System.out.print("Informe o nome do prato: ");
            String name = sc.nextLine();
            System.out.print("Informe o preço do prato: ");
            double price = Double.parseDouble(sc.nextLine());
            System.out.print("Informe o preço de custo do prato: ");
            double costPrice = Double.parseDouble(sc.nextLine());
            System.out.print("Informe a descrição do prato: ");
            String description = sc.nextLine();
            System.out.print("Informe o tempo de preparo do prato: ");
            String preparationTime = sc.nextLine();

            MainCourse mainCourse = new MainCourse(id, name, price, costPrice, description, preparationTime);
            Restaurant.mainCourses.add(mainCourse);
            infoMessage("Prato adicionado!");
        } catch (InvalidIdException | IllegalArgumentException e) {
            infoMessage(e.getMessage());
        }
    }

    public static void removeMainCourse() {
        MainCoursesMenu.showRemoveMainCourse(Restaurant.mainCourses);
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startMainCoursesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int mainCourseIndex = Integer.parseInt(opt);
                    if (mainCourseIndex > 0 && mainCourseIndex <= Restaurant.mainCourses.size()) {
                        Restaurant.mainCourses.remove(mainCourseIndex - 1);
                    }
                    startMainCoursesMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeMainCourse();
                }
        }
    }
}
