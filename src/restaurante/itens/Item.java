package restaurante.itens;

import restaurante.exceptions.InvalidIdException;
import restaurante.validators.IdValidator;
import restaurante.validators.PriceValidator;

public abstract class Item {
    private String id;
    private String name;
    private double unitPrice;
    private double costPrice;

    public Item(String id, String name, double unitPrice, double costPrice)
            throws InvalidIdException, IllegalArgumentException {
        setId(id);
        this.name = name;
        setUnitPrice(unitPrice);
        setCostPrice(costPrice);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidIdException {
        IdValidator.validate(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) throws IllegalArgumentException {
        PriceValidator.validate(unitPrice);
        this.unitPrice = unitPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) throws IllegalArgumentException {
        PriceValidator.validate(costPrice);
        this.costPrice = costPrice;
    }
}
