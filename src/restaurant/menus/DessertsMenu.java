package restaurant.menus;

import java.util.ArrayList;

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

    public static void showMainCourses(ArrayList<Dessert> items) {
        clearConsole();
        showHead();
        listMainCourses(items);
        showFooter();
        requestOption();
    }

    public static void listMainCourses(ArrayList<Dessert> items) {
        for (int i = 0; i < items.size(); i++) {
            Dessert item = items.get(i);
            System.out.println((i + 1) + " - " + item);
        }
    }

    public static void showRemoveMainCourse(ArrayList<Dessert> items) {
        clearConsole();
        showHead();
        listMainCourses(items);
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
}
