package restaurant.menus;

import java.util.ArrayList;
import java.util.InputMismatchException;

import restaurant.Restaurant;
import restaurant.employees.Cook;
import restaurant.employees.Waiter;
import restaurant.items.Beverage;
import restaurant.items.Dessert;
import restaurant.items.MainCourse;
import restaurant.order.Order;
import restaurant.order.OrderItem;

public class OrdersMenu extends Menu {
  public static void showMain() {
    clearConsole();
    showHead();
    System.out.println("1 - Listar pedidos");
    System.out.println("2 - Registrar pedido");
    System.out.println("3 - Remover pedido");
    System.out.println("4 - Pagar pedido");
    showFooter();
    requestOption();
  }

  public static void showOrders(ArrayList<Order> orders) {
    clearConsole();
    showHead();
    listOrders(orders);
    showFooter();
    requestOption();
  }

  public static void listOrders(ArrayList<Order> orders) {
    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      System.out.println((i + 1) + " - " + order);
    }
  }

  public static void showRemoveOrder(ArrayList<Order> orders) {
    clearConsole();
    showHead();
    listOrders(orders);
    showFooter();
    showExtraOptions();
    System.out.println("Digite o número do pedido que deseja remover: ");
  }

  public static void showPayOrder(ArrayList<Order> orders) {
    clearConsole();
    showHead();
    listOrders(orders);
    showFooter();
    showExtraOptions();
    System.out.print("Digite o número do pedido que deseja definir como pago: ");
  }

  public static ArrayList<Order> filterNotPaidOrders(ArrayList<Order> orders) {
    ArrayList<Order> filteredOrders = new ArrayList<>();
    for (Order order : orders) {
      if (!order.isPaid()) {
        filteredOrders.add(order);
      }
    }
    return filteredOrders;
  }

  public static void showHead() {
    System.out.println(SEPARATOR_BAR + "\nPEDIDOS\n" + SEPARATOR_BAR + "\n");
  }

  public static void showFooter() {
    System.out.println("\n" + SEPARATOR_BAR);
  }

  public static void startOrdersMenu() {
    showMain();
    String opt = sc.nextLine();

    switch (opt) {
      case "1":
        showOrders();
        break;
      case "2":
        registerOrder();
        break;
      case "3":
        removeOrder();
        break;
      case "4":
        payOrder();
        break;
      case "v":
        MainMenu.startMainMenu();
        break;
      case "s":
        leave();
        break;
      default:
        invalidOption();
        startOrdersMenu();
    }
  }

  public static void showOrders() {
    showOrders(Restaurant.getOrders());
    String opt = sc.nextLine();

    switch (opt) {
      case "v":
        startOrdersMenu();
        break;
      case "s":
        leave();
        break;
      default:
        invalidOption();
        showOrders();
    }
  }

  public static void registerOrder() {
    if (Restaurant.getWaiters().isEmpty()) {
      infoMessage("Não há garçons cadastrados!");
      startOrdersMenu();
    } else if (Restaurant.getCooks().isEmpty()) {
      infoMessage("Não há cozinheiros cadastrados!");
      startOrdersMenu();
    }

    try {
      showWaiters(Restaurant.getWaiters());
      System.out.print("Selecione o garçom que atendeu a mesa: ");      
      int waiterOpt = sc.nextInt();

      showCooks(Restaurant.getCooks());
      System.out.print("Selecione o cozinheiro que preparou o pedido: ");      
      int cookOpt = sc.nextInt();

      Waiter waiter = Restaurant.getWaiters().get(waiterOpt - 1);
      Cook cook = Restaurant.getCooks().get(cookOpt - 1);
      sc.nextLine();

      if (waiter == null) {
        infoMessage("Garçom não encontrado!");
        registerOrder();
        return;
      } else if (cook == null) {
        infoMessage("Cozinheiro não encontrado!");
        registerOrder();
        return;
      } else {
        Order order = new Order(waiter, cook);

        showItems(order);
        System.out.print("Selecione o item que deseja adicionar ao pedido: ");

        Restaurant.addOrder(order);
        infoMessage("Pedido registrado com sucesso!");
      }
    } catch (InputMismatchException e) {
      sc.nextLine();
      infoMessage("Opção inválida!");
    } finally {
      startOrdersMenu();
    }
  }

  private static void showItems(Order order) {
    clearConsole();
    showHead();
    System.out.println("1 - Bebidas");
    System.out.println("2 - Pratos principais");
    System.out.println("3 - Sobremesas");
    showFooter();
    System.out.print("Selecione o tipo de item que deseja adicionar ao pedido: ");

    String opt = sc.nextLine();
    switch (opt) {
      case "1":
        if (Restaurant.getBeverages().isEmpty()) {
          infoMessage("Não há bebidas cadastradas!");
          showItems(order);
        } else {
          addBeverage(order);
        }
        break;
      case "2":
        if (Restaurant.getMainCourses().isEmpty()) {
          infoMessage("Não há pratos principais cadastrados!");
          showItems(order);
        } else {
          addMainCourse(order);
        }
        break;
      case "3":
        if (Restaurant.getDesserts().isEmpty()) {
          infoMessage("Não há sobremesas cadastradas!");
          showItems(order);
        } else {
          addDessert(order);
        }
        break;
      default:
        invalidOption();
        showItems(order);
    }
  }

  public static void addAnotherItem(Order order) {
    clearConsole();
    showHead();
    System.out.println("1 - Adicionar outro item");
    System.out.println("2 - Finalizar pedido");
    showFooter();
    System.out.print("Selecione uma opção: ");

    String opt = sc.nextLine();
    switch (opt) {
      case "1":
        showItems(order);
        break;
      case "2":
        break;
      default:
        invalidOption();
        addAnotherItem(order);
    }
  }

  public static void addBeverage(Order order) {
    showBeverages();
    System.out.print("Selecione a bebida que deseja adicionar: ");
    String opt = sc.nextLine();
    try {
      int beverageOpt = Integer.parseInt(opt);
      if (beverageOpt > 0 && beverageOpt <= Restaurant.getBeverages().size()) {
        Beverage beverage = Restaurant.getBeverages().get(beverageOpt - 1);
        System.out.print("Digite a quantidade de " + beverage.getName() + " que deseja adicionar: ");
        int amount = sc.nextInt();
        sc.nextLine();
        OrderItem orderItem = new OrderItem(beverage, amount);
        order.addOrderItem(orderItem);
        infoMessage("Bebida adicionada com sucesso!");
        addAnotherItem(order);
      } else {
        invalidOption();
        addBeverage(order);
      }
    } catch (NumberFormatException | InputMismatchException e) {
      invalidOption();
      addBeverage(order);
    }
  }

  public static void addMainCourse(Order order) {
    showMainCourses();
    System.out.print("Selecione o prato principal que deseja adicionar: ");
    String opt = sc.nextLine();
    try {
      int mainCourseOpt = Integer.parseInt(opt);
      if (mainCourseOpt > 0 && mainCourseOpt <= Restaurant.getMainCourses().size()) {
        MainCourse mainCourse = Restaurant.getMainCourses().get(mainCourseOpt - 1);
        System.out.print("Digite a quantidade de " + mainCourse.getName() + " que deseja adicionar: ");
        int amount = sc.nextInt();
        OrderItem orderItem = new OrderItem(mainCourse, amount);

        order.addOrderItem(orderItem);
        infoMessage("Prato principal adicionado com sucesso!");
        addAnotherItem(order);
      } else {
        invalidOption();
        addMainCourse(order);
      }
    } catch (NumberFormatException | InputMismatchException e) {
      invalidOption();
      addMainCourse(order);
    }
  }

  public static void addDessert(Order order) {
    showDesserts();
    System.out.print("Selecione a sobremesa que deseja adicionar: ");
    String opt = sc.nextLine();
    try {
      int dessertOpt = Integer.parseInt(opt);
      if (dessertOpt > 0 && dessertOpt <= Restaurant.getDesserts().size()) {
        Dessert dessert = Restaurant.getDesserts().get(dessertOpt - 1);
        System.out.print("Digite a quantidade de " + dessert.getName() + " que deseja adicionar: ");
        int amount = sc.nextInt();
        OrderItem orderItem = new OrderItem(dessert, amount);
        order.addOrderItem(orderItem);
        infoMessage("Sobremesa adicionada com sucesso!");
        addAnotherItem(order);
      } else {
        invalidOption();
        addDessert(order);
      }
    } catch (NumberFormatException | InputMismatchException e) {
      invalidOption();
      addDessert(order);
    }
  }

  public static void showBeverages() {
    clearConsole();
    showHead();
    BeveragesMenu.listBeverages(Restaurant.getBeverages());
    showFooter();
  }

  public static void showMainCourses() {
    clearConsole();
    showHead();
    MainCoursesMenu.listMainCourses(Restaurant.getMainCourses());
    showFooter();
  }

  public static void showDesserts() {
    clearConsole();
    showHead();
    DessertsMenu.listDesserts(Restaurant.getDesserts());
    showFooter();
  }

  public static void showWaiters(ArrayList<Waiter> waiters) {
    clearConsole();
    showHead();
    for (int i = 0; i < waiters.size(); i++) {
      Waiter waiter = waiters.get(i);
      System.out.println((i + 1) + " - " + waiter);
    }
    showFooter();
  }

  public static void showCooks(ArrayList<Cook> cooks) {
    clearConsole();
    showHead();
    for (int i = 0; i < cooks.size(); i++) {
      Cook cook = cooks.get(i);
      System.out.println((i + 1) + " - " + cook);
    }
    showFooter();
  }

  public static void removeOrder() {
    showRemoveOrder(Restaurant.getOrders());
    String opt = sc.nextLine();

    switch (opt) {
      case "v":
        startOrdersMenu();
        break;
      case "s":
        leave();
        break;
      default:
        try {
          int orderIndex = Integer.parseInt(opt);
          if (orderIndex > 0 && orderIndex <= Restaurant.getOrders().size()) {
            Restaurant.removeOrder(orderIndex - 1);
          }
          startOrdersMenu();
        } catch (NumberFormatException e) {
          invalidOption();
          removeOrder();
        }
    }
  }

  public static void payOrder() {
    ArrayList<Order> filteredOrders = filterNotPaidOrders(Restaurant.getOrders());
    if (filteredOrders.isEmpty()) {
      infoMessage("Não há pedidos pendentes!");
      startOrdersMenu();
      return;
    }
    showPayOrder(filteredOrders);
    String opt = sc.nextLine();

    switch (opt) {
      case "v":
        startOrdersMenu();
        break;
      case "s":
        leave();
        break;
      default:
        try {
          int orderIndex = Integer.parseInt(opt);
          if (orderIndex > 0 && orderIndex <= filteredOrders.size()) {
            System.out.print("Informe o método de pagamento: ");
            String paymentMethod = sc.nextLine();
            filteredOrders.get(orderIndex - 1).setPaid(paymentMethod);
            Restaurant.updateOrders();
            infoMessage("Pedido definido como pago!");
          } else {
            infoMessage("Pedido não encontrado!");
          }
          startOrdersMenu();
        } catch (NumberFormatException e) {
          invalidOption();
          removeOrder();
        }
    }
  }
}
