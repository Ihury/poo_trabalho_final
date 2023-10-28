package restaurante.itens;

import restaurante.exceptions.InvalidIdException;
import restaurante.utils.NumberFormatter;

public class Dessert extends ItemWithIngredients {
    private String description;
    private String preparationTime;
    private double calorieCount;

    public Dessert(String id, String name, double unitPrice, double costPrice, String description,
            String preparationTime, double calorieCount) throws InvalidIdException, IllegalArgumentException {
        super(id, name, unitPrice, costPrice);
        this.description = description;
        this.preparationTime = preparationTime;
        this.calorieCount = calorieCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getpreparationTime() {
        return preparationTime;
    }

    public void setpreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public double getCalorieCount() {
        return calorieCount;
    }

    public void setCalorieCount(double calorieCount) {
        this.calorieCount = calorieCount;
    }

    @Override
    public String toString() {
        return getId() +
                " - " + getName() +
                "\n\tDescrição: " + description +
                "\n\tPreço: " + NumberFormatter.formatPrice(getUnitPrice());
    }
}
