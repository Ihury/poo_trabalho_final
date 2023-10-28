package restaurant.menus;

public class Menu {
    public static final String RESTAURANT_NAME = "RESTAURANTE DELÍCIAS DE UDIA";
    public static final String SEPARATOR_BAR = "======================================";

    public static void showExtraOptions() {
        System.out.println("Digite 's' para sair ou 'v' para voltar.");
    }

    public static void requestOption() {
        showExtraOptions();
        System.out.print("Escolha uma opção: ");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
