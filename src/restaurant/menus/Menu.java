package restaurant.menus;

import java.util.Scanner;

public class Menu {
    protected static final Scanner sc = new Scanner(System.in);
    public static final String RESTAURANT_NAME = "RESTAURANTE DELÍCIAS DE UDIA";
    public static final String SEPARATOR_BAR = "======================================";

    public static void showExtraOptions() {
        System.out.println("(s) sair\n(v) voltar");
    }

    public static void requestOption() {
        showExtraOptions();
        System.out.print("Escolha uma opção: ");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected static void invalidOption() {
        infoMessage("Opção inválida!");
    }

    public static void infoMessage(String text) {
        clearConsole();
        System.out.println(text);
        waitEnter();
    }

    protected static void waitEnter() {
        System.out.println("Pressione ENTER para continuar...");
        sc.nextLine();
    }

    protected static void leave() {
        clearConsole();
        System.exit(0);
    }
}
