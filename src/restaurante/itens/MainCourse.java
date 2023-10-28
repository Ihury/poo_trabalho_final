package restaurante.itens;

import restaurante.exceptions.InvalidIdException;
import restaurante.utils.NumberFormatter;

public class MainCourse extends ItemWithIngredients {
    private String description;
    private String preparationTime;

    public MainCourse(String id, String name, double unitPrice, double costPrice, String description,
            String preparationTime) throws InvalidIdException, IllegalArgumentException {
        super(id, name, unitPrice, costPrice);
        this.description = description;
        this.preparationTime = preparationTime;
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

    @Override
    public String toString() {
        return getId() +
                " - " + getName() +
                "\n\tDescrição: " + description +
                "\n\tPreço: " + NumberFormatter.formatPrice(getUnitPrice());
    }
}
