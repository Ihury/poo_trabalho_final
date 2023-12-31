package restaurant.employees;

import restaurant.items.ItemWithIngredients;
import java.util.ArrayList;

public class Cook extends Employee {
    private ArrayList<ItemWithIngredients> foods;

    public Cook (String name, String CPF, String RG, String civilState, String address, String workCard) {
        super(name, CPF, RG, civilState, address, workCard);
        foods = new ArrayList<>();
    }

    public ArrayList<ItemWithIngredients> getFoods() {
        return foods;
    }

    public void addFood(ItemWithIngredients food) {
        foods.add(food);
    }

    public void removeFood(int index) {
        foods.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder cookString = new StringBuilder(getName() +
                "\n\tCPF: " + getCPF() +
                "\n\tRG: " + getRG() +
                "\n\tCarteira de trabalho: " + getWorkCard() +
                "\n\tEstado civil: " + getMaritalStatus() +
                "\n\tEndereço: " + getAddress() +
                "\n\tPratos: ");

        if (!foods.isEmpty()) {
            for (int i = 0; i < foods.size(); i++) {
                ItemWithIngredients food = foods.get(i);
                cookString.append(food.getName());
                if (i < foods.size() - 1) {
                    cookString.append(", ");
                }
            }
        }

        return cookString.toString();
    }
}
