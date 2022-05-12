
/*
(The Person, Student, Employee, Faculty, and Staff classes) Design a
class named Person and its two subclasses named Student and Employee.
Make Faculty and Staff subclasses of Employee. A person has a name,
address, phone number, and e-mail address. A student has a class status (freshman,
sophomore, junior, or senior). Define the status as a constant. An employee
has an office, salary, and date hired. Use the MyDate class defined in Programming
Exercise 10.14 to create an object for date hired. A faculty member has
office hours and a rank. A staff member has a title. Override the toString
method in each class to display the class name and the person’s name.
Draw the UML diagram for the classes and implement them. Write a test program
that creates a Person, Student, Employee, Faculty, and Staff, and invokes
their toString() methods.
*/

import java.util.Date;
import java.util.Scanner;

public class E1102 {
    public static void main(String[] args){
        m(new Student());
        m(new Employee());
        m(new Person());
        m(new Object());
    }

    public static void m(Object o){
        System.out.println(o.toString());
    }
}

class Student extends Person{
    private int status;
    private final int FRESHMAN = 1;
    private final int SOPHOMORE = 2;
    private final int JUNIOR = 3;
    private final int SENIOR = 4;

    public Student(){
    }
    
    public Student(String name, String address, String phoneNumber, String email){
        super(name, address, phoneNumber, email);
    }
    @Override
    public String toString(){
        return "Student";
    }
}

class Employee extends Person{
    private String office;
    private double salary;
    private Date dateHired;

    public Employee(){
    }

    public Employee(String name, String address, String phoneNumber, String email, String office, double salary){
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        dateHired = new Date();
    }
    @Override
    public String toString(){
        return "Employee";
    }
}

class Person{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person(){
    }

    public Person(String name, String address, String phoneNumber, String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString(){
        return "Person";
    }
}
