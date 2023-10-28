package restaurante.items;

import restaurante.enums.PackageType;
import restaurante.exceptions.InvalidIdException;
import restaurante.utils.NumberFormatter;

public class Beverage extends Item {
    private double packageSizeInMilliliters;
    private PackageType packageType;

    public Beverage(String id, String name, double unitPrice, double costPrice, double packageSizeInMilliliters, PackageType packageType) throws InvalidIdException, IllegalArgumentException {
        super(id, name, unitPrice, costPrice);
        this.packageSizeInMilliliters = packageSizeInMilliliters;
        this.packageType = packageType;
    }

    public double getPackageSizeInMilliliters() {
        return packageSizeInMilliliters;
    }

    public void setPackageSizeInMilliliters(double packageSizeInMilliliters) {
        this.packageSizeInMilliliters = packageSizeInMilliliters;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    @Override
    public String toString() {
        return getId() +
                " - " + getName() +
                "\n\tTamanho: " + packageSizeInMilliliters + "ml" +
                "\n\tPreço: " + NumberFormatter.formatPrice(getUnitPrice());
    }
}
