package restaurant.items;

import restaurant.exceptions.InvalidIdException;

import java.util.ArrayList;

public class ItemWithIngredients extends Item {
    private final ArrayList<Ingredient> ingredients = new ArrayList<>();

    public ItemWithIngredients(String id, String name, double unitPrice, double costPrice) throws InvalidIdException, IllegalArgumentException {
        super(id, name, unitPrice, costPrice);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public boolean removeIngredient(Ingredient ingredient) {
        return removeIngredient(ingredient.getName());
    }

    public boolean removeIngredient(String ingredientName) {
        int position = -1;
        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient ingredient = ingredients.get(i);
            if (ingredient.getName().equals(ingredientName)) {
                position = i;
                break;
            }
        }

        if (position == -1) return false;
        else {
            ingredients.remove(position);
            return true;
        }
    }

    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }
}
