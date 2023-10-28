package restaurante.validators;

public class PriceValidator {
    public static void validate(double price) throws IllegalArgumentException {
        if (price <= 0) throw new IllegalArgumentException("O preço deve ser maior que 0!");
    }
}
