package restaurante.enums;

public enum PackageType {
    CAN("Lata"),
    PLASTIC_BOTTLE("Garrafa Plástica"),
    GLASS_BOTTLE("Garrafa de Vidro"),
    OTHERS("Outros");

    private final String description;

    PackageType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
