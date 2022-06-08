package c10_ObjectOrientedThinking;

/*
(The BMI class) Add the following new constructor in the BMI class:
Construct a BMI with the specified name, age, weight, feet, and inches
public BMI(String name, int age, double weight, double feet, double inches)
*/
public class E1002 {
    public static void main(String[] args) {
        BMI person1 = new BMI("Jack", 28, 70, 6, 8);
        System.out.println(person1.getName() + ", " + person1.getAge() + ", BMI: " + person1.getBMI() 
                            + ", " + person1.getStatus());
    }
}