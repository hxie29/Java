package c11_InheritancePolymorphism;

import java.util.Date;

class Employee extends Person {
    private String office;
    private double salary;
    private Date dateHired;

    public Employee() {
    }

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        dateHired = new Date();
    }

    @Override
    public String toString() {
        return "Employee";
    }
}
