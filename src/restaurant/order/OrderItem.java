package restaurant.order;

import java.io.Serializable;

import restaurant.items.Item;

public class OrderItem implements Serializable {
  private Item item;
  private int amount;

  public OrderItem(Item item, int amount) {
    this.item = item;
    this.amount = amount;
  }

  public Item getItem() {
    return item;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return amount + "x " + item.getName() + " - R$ " + item.getUnitPrice() * amount;
  }
}
