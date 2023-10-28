package restaurante.menus;

public class MainMenu extends Menu {
    public static void showMain() {
        clearConsole();
        System.out.println(SEPARATOR_BAR + "\n" + RESTAURANT_NAME + "\n" + SEPARATOR_BAR + "\n");
        System.out.println("1 - Ingredientes");
        System.out.println("2 - Itens");
        System.out.println("\n" + SEPARATOR_BAR);
        requestOption();
    }
}
