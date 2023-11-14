package restaurant.enums;

public enum WeekDay {
    SUNDAY("Domingo"),
    MONDAY("Segunda-feira"),
    TUESDAY("Terça-feira"),
    WEDNESDAY("Quarta-feira"),
    THURSDAY("Quinta-feira"),
    FRIDAY("Sexta-feira"),
    SATURDAY("Sábado");

    private final String name;

    WeekDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
