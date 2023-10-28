package restaurante.enums;

public enum UnitOfMeasure {
    KILOGRAMS("kg"),
    GRAMS("g"),
    LITERS("L"),
    MILLILITERS("ml");

    private final String abbreviation;

    UnitOfMeasure(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
