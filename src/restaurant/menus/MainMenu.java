package restaurant.menus;

public class MainMenu extends Menu {
    public static void showMain() {
        clearConsole();
        System.out.println(SEPARATOR_BAR + "\n" + RESTAURANT_NAME + "\n" + SEPARATOR_BAR + "\n");
        System.out.println("1 - Ingredientes");
        System.out.println("2 - Itens");
        System.out.println("3 - Funcionários");
        System.out.println("4 - Pedidos");
        System.out.println("\n" + SEPARATOR_BAR);
        requestOption();
    }

    public static void startMainMenu() {
        MainMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                IngredientsMenu.startIngredientsMenu();
                break;
            case "2":
                ItemsMenu.startItensMenu();
                break;
            case "3":
                EmployeesMenu.startEmployeesMenu();
                break;
            case "4":
                OrdersMenu.startOrdersMenu();
                break;
            case "v":
                startMainMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startMainMenu();
        }
    }
}
