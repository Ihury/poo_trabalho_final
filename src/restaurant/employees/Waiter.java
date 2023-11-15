package restaurant.employees;

import restaurant.enums.WeekDay;

public class Waiter extends Employee {
    private double baseSalary;
    private WeekDay dayOff;

    public Waiter (String name, String CPF, String RG, String civilState, String address, String workCard, double baseSalary, WeekDay dayOff) {
        super(name, CPF, RG, civilState, address, workCard);
        setBaseSalary(baseSalary);
        setDayOff(dayOff);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public WeekDay getDayOff() {
        return dayOff;
    }

    public void setDayOff(WeekDay dayOff) {
        this.dayOff = dayOff;
    }

    @Override
    public String toString() {
        return getName() +
                "\n\tCPF: " + getCPF() +
                "\n\tRG: " + getRG() +
                "\n\tCarteira de trabalho: " + getWorkCard() +
                "\n\tEstado civil: " + getMaritalStatus() +
                "\n\tEndereço: " + getAddress() +
                "\n\tSalário base: " + getBaseSalary() +
                "\n\tFolga: " + getDayOff().getName();
    }
}
