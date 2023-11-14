package restaurant.menus;

public class EmployeesMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Cozinheiros");
        System.out.println("2 - Garçons");
        showFooter();
        requestOption();
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nFUNCIONÁRIOS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startEmployeesMenu() {
        showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                CooksMenu.startCooksMenu();
                break;
            case "2":
//                DessertsMenu.startDessertsMenu();
                break;
            case "v":
                MainMenu.startMainMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startEmployeesMenu();
        }
    }
}
