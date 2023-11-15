package restaurant.order;

import java.util.Date;

import restaurant.employees.Cook;
import restaurant.employees.Waiter;
import restaurant.utils.TimeFormatter;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
  private ArrayList<OrderItem> orderItems = new ArrayList<>();
  private Date orderDate, paymentDate;
  private double totalValue = 0;
  private String paymentMethod;
  private Waiter waiter;
  private Cook cook;

  public Order(Waiter waiter, Cook cook) {
    orderDate = new Date();
    this.waiter = waiter;
    this.cook = cook;
  }

  public ArrayList<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void addOrderItem(OrderItem orderItem) {
    orderItems.add(orderItem);
    totalValue += orderItem.getAmount() * orderItem.getItem().getUnitPrice();
  }

  public void removeOrderItem(int orderItemIndex) {
    if (orderItemIndex >= 0 && orderItemIndex < orderItems.size()) {
      OrderItem orderItem = orderItems.get(orderItemIndex);
      totalValue -= orderItem.getAmount() * orderItem.getItem().getUnitPrice();
      orderItems.remove(orderItemIndex);
    }
  }

  public boolean isPaid() {
    return paymentDate != null;
  }

  public void setPaid(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    paymentDate = new Date();
  }

  @Override
  public String toString() {
    String orderItemsString = "";
    for (OrderItem orderItem : orderItems) {
      orderItemsString += orderItem + "\n";
    }

    return "Data do pedido: " + TimeFormatter.formatTime(orderDate) + "\n" +
        "Data do pagamento: " + (paymentDate != null ? TimeFormatter.formatTime(paymentDate) : "") + "\n" +
        "Forma de pagamento: " + (paymentMethod != null ? paymentMethod : "") + "\n" +
        "Garçom: " + waiter.getName() + "\n" +
        "Cozinheiro: " + cook.getName() + "\n" +
        "Itens do pedido: \n" + orderItemsString +
        "Valor total: " + totalValue + "\n";
  }
}
