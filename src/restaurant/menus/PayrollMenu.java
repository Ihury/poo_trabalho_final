package restaurant.menus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import restaurant.Restaurant;
import restaurant.employees.Cook;
import restaurant.employees.Waiter;
import restaurant.items.Dessert;
import restaurant.items.MainCourse;
import restaurant.order.Order;
import restaurant.order.OrderItem;

public class PayrollMenu extends Menu {
  private static final double VALUE_PER_MAIN_COURSE = 2.0;
  private static final double VALUE_PER_DESSERT = 1.0;
  private static final double WAITERS_BONUS = 100.0;
  private static final int LIMIT_OF_ORDERS_TO_WAITERS_BONUS = 2;

  public static void showMain() {
    clearConsole();
    showHead();
    System.out.println("1 - Folha de pagamento dos cozinheiros");
    System.out.println("2 - Folha de pagamento dos garçons");
    showFooter();
    requestOption();
  }

  public static void showHead() {
    System.out.println(SEPARATOR_BAR + "\nFOLHA DE PAGAMENTO\n" + SEPARATOR_BAR + "\n");
  }

  public static void showFooter() {
    System.out.println("\n" + SEPARATOR_BAR);
  }

  public static void startPayrollMenu() {
    showMain();
    String opt = sc.nextLine();

    switch (opt) {
      case "1":
        showCooksPayroll();
        break;
      case "2":
        showWaitersPayroll();
        break;
      case "v":
        MainMenu.startMainMenu();
        break;
      case "s":
        leave();
        break;
      default:
        invalidOption();
        startPayrollMenu();
    }
  }

  private static void showWaitersPayroll() {
    clearConsole();
    showHead();
    ArrayList<Waiter> waiters = Restaurant.getWaiters();
    ArrayList<Order> orders = Restaurant.getOrders();
    boolean hasBonus = orders.size() >= LIMIT_OF_ORDERS_TO_WAITERS_BONUS;

    for (Waiter waiter : waiters) {
      double value = 0.0;
      if (hasBonus)
        value += WAITERS_BONUS;
      value += waiter.getBaseSalary();
      System.out.println(waiter.getName() + " - R$ " + value);
    }

    showFooter();
    requestOption();
    String opt = sc.nextLine();
    switch (opt) {
      case "v":
        startPayrollMenu();
        break;
      case "s":
        leave();
        break;
      default:
        invalidOption();
        showWaitersPayroll();
    }
  }

  public static void showCooksPayroll() {
    clearConsole();
    showHead();
    Map<String, Double> cooksPayroll = new HashMap<String, Double>();
    ArrayList<Cook> cooks = Restaurant.getCooks();
    ArrayList<Order> orders = Restaurant.getOrders();

    for (Order order : orders) {
      if (order.isPaid()) {
        Cook cook = order.getCook();
        for (OrderItem orderItem : order.getOrderItems()) {
          double multiplier = 0.0;
          if (orderItem.getItem() instanceof MainCourse)
            multiplier = VALUE_PER_MAIN_COURSE;
          else if (orderItem.getItem() instanceof Dessert)
            multiplier = VALUE_PER_DESSERT;
          double value = orderItem.getAmount() * multiplier;
          if (cooksPayroll.containsKey(cook.getCPF()))
            cooksPayroll.put(cook.getCPF(), cooksPayroll.get(cook.getCPF()) + value);
          else
            cooksPayroll.put(cook.getCPF(), value);
        }
      }
    }

    for (Cook cook : cooks) {
      if (!cooksPayroll.containsKey(cook.getCPF()))
        cooksPayroll.put(cook.getCPF(), 0.0);

      System.out.println(cook.getName() + " - R$ " + cooksPayroll.get(cook.getCPF()));
    }

    showFooter();
    requestOption();
    String opt = sc.nextLine();
    switch (opt) {
      case "v":
        startPayrollMenu();
        break;
      case "s":
        leave();
        break;
      default:
        invalidOption();
        showCooksPayroll();
    }
  }
}
