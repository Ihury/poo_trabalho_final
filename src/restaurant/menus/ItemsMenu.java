package restaurant.menus;

public class ItemsMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Pratos principais");
        System.out.println("2 - Sobremesas");
        System.out.println("3 - Bebidas");
        showFooter();
        requestOption();
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nITENS DO RESTAURANTE\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startItensMenu() {
        ItemsMenu.showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                MainCoursesMenu.startMainCoursesMenu();
                break;
            case "2":
                DessertsMenu.startDessertsMenu();
                break;
            case "3":
                BeveragesMenu.startBeveragesMenu();
                break;
            case "v":
                MainMenu.startMainMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startItensMenu();
        }
    }
}
