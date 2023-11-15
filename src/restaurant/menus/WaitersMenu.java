package restaurant.menus;

import java.util.ArrayList;

import restaurant.Restaurant;
import restaurant.employees.Waiter;
import restaurant.enums.WeekDay;

public class WaitersMenu extends Menu {
    public static void showMain() {
        clearConsole();
        showHead();
        System.out.println("1 - Listar garçons");
        System.out.println("2 - Adicionar garçom");
        System.out.println("3 - Remover garçom");
        showFooter();
        requestOption();
    }

    public static void showWaiters(ArrayList<Waiter> waiters) {
        clearConsole();
        showHead();
        listWaiters(waiters);
        showFooter();
        requestOption();
    }

    public static void listWaiters(ArrayList<Waiter> waiters) {
        for (int i = 0; i < waiters.size(); i++) {
            Waiter waiter = waiters.get(i);
            System.out.println((i + 1) + " - " + waiter);
        }
    }

    public static void showRemoveWaiter(ArrayList<Waiter> waiters) {
        clearConsole();
        showHead();
        listWaiters(waiters);
        showFooter();
        showExtraOptions();
        System.out.println("Digite o número do garçom que deseja remover: ");
    }

    public static void showHead() {
        System.out.println(SEPARATOR_BAR + "\nGARÇONS\n" + SEPARATOR_BAR + "\n");
    }

    public static void showFooter() {
        System.out.println("\n" + SEPARATOR_BAR);
    }

    public static void startWaitersMenu() {
        showMain();
        String opt = sc.nextLine();

        switch (opt) {
            case "1":
                showWaiters();
                break;
            case "2":
                addWaiter();
                break;
            case "3":
                removeWaiter();
                break;
            case "v":
                EmployeesMenu.startEmployeesMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                startWaitersMenu();
        }
    }

    public static void showWaiters() {
        showWaiters(Restaurant.getWaiters());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startWaitersMenu();
                break;
            case "s":
                leave();
                break;
            default:
                invalidOption();
                showWaiters();
        }
    }

    public static void addWaiter() {
        clearConsole();
        try {
            System.out.print("Informe o nome do garçom: ");
            String name = sc.nextLine();
            System.out.print("Informe o CPF do garçom: ");
            String cpf = sc.nextLine();
            System.out.print("Informe o RG do garçom: ");
            String rg = sc.nextLine();
            System.out.print("Informe o estado civil do garçom: ");
            String maritalStatus = sc.nextLine();
            System.out.print("Informe o endereço do garçom: ");
            String address = sc.nextLine();
            System.out.print("Informe a carteira de trabalho do garçom: ");
            String workCard = sc.nextLine();
            System.out.print("Informe o salário base do garçom: ");
            double baseSalary = Double.parseDouble(sc.nextLine());
            showWeekDays();
            System.out.println("Escolha o dia de folga do garçom: ");
            int dayOffIndex = Integer.parseInt(sc.nextLine());
            if (dayOffIndex > 0 && dayOffIndex <= WeekDay.values().length) {
                Waiter waiter = new Waiter(name, cpf, rg, maritalStatus, address, workCard, baseSalary,
                        WeekDay.values()[dayOffIndex - 1]);
                Restaurant.addWaiter(waiter);
                infoMessage("Garçom adicionado!");
            } else {
                invalidOption();
            }
        } catch (IllegalArgumentException e) {
            infoMessage(e.getMessage());
        } finally {
            startWaitersMenu();
        }
    }

    private static void showWeekDays() {
        for (WeekDay weekDay : WeekDay.values()) {
            System.out.println((weekDay.ordinal() + 1) + " - " + weekDay.getName());
        }
    }

    public static void removeWaiter() {
        showRemoveWaiter(Restaurant.getWaiters());
        String opt = sc.nextLine();

        switch (opt) {
            case "v":
                startWaitersMenu();
                break;
            case "s":
                leave();
                break;
            default:
                try {
                    int waiterIndex = Integer.parseInt(opt);
                    if (waiterIndex > 0 && waiterIndex <= Restaurant.getWaiters().size()) {
                        Restaurant.removeWaiter(waiterIndex - 1);
                    }
                    startWaitersMenu();
                } catch (NumberFormatException e) {
                    invalidOption();
                    removeWaiter();
                }
        }
    }
}
