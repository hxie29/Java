package c11_InheritancePolymorphism;

import java.util.Arrays;
import java.util.Scanner;
import c10_ObjectOrientedThinking.Course;


/*
(The Course class) Rewrite the Course class in Listing 10.6. Use an Array-
List to replace an array to store students. Draw the new UML diagram for the
class. You should not change the original contract of the Course class (i.e., the
definition of the constructors and methods should not be changed, but the private members may be changed.)
*/

public class E1105 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course name:");
        Course course1 = new Course(input.nextLine());

        System.out.println("Enter students' name, ending with 0:");
        String name;
        do{
            name = input.next();
            if (!name.equals("0")) course1.addStudent(name);
        } while (!name.equals("0"));
        printStudents(course1.getStudents());

        System.out.println("\nStudent to drop:");
        course1.dropStudent(input.next());
        System.out.println(course1);

        input.close();
    }

    public static void printStudents(String[] list){
       System.out.println(Arrays.toString(list));
    }
}
