package restaurante.menus;

import java.util.ArrayList;

import restaurante.itens.Item;
import restaurante.itens.MainCourse;

public class MainCourseMenu extends Menu {
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
            Item item = items.get(i);
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
}
