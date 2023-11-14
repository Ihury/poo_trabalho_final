package restaurant.items;

import java.io.Serializable;
import java.util.ArrayList;

import restaurant.exceptions.InvalidIdException;
import restaurant.utils.NumberFormatter;

public class MainCourse extends ItemWithIngredients implements Serializable {
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
        String mainCourseString = getId() +
                " - " + getName() +
                "\n\tDescrição: " + description +
                "\n\tPreço: " + NumberFormatter.formatPrice(getUnitPrice());

        ArrayList<Ingredient> ingredients = getIngredients();
        if (ingredients.size() > 0) {
            mainCourseString += "\n\tIngredientes: ";
            for (int i = 0; i < ingredients.size(); i++) {
                Ingredient ingredient = ingredients.get(i);
                mainCourseString += ingredient.getName();
                if (i < ingredients.size() - 1) {
                    mainCourseString += ", ";
                }
            }
        }

        return mainCourseString;
    }
}
