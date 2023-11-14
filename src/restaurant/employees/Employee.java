package restaurant.employees;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name, CPF, RG, maritalStatus, address;

    public Employee(String name, String CPF, String RG, String civilState, String address) {
        setName(name);
        setCPF(CPF);
        setRG(RG);
        setMaritalStatus(civilState);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
