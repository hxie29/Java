package c13_AbstractClassesInterfaces;/*
(Enable the Course class cloneable) Rewrite the Course class in Listing 10.6 to
add a clone method to perform a deep copy on the students field.
*/
import java.util.Scanner;
public class E1313 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course name:");
        Course course1 = new Course(input.next());
        System.out.println("How many students does the course has ?");
        int number = input.nextInt();
        System.out.println("Enter students' name:");
        for (int i = 0; i < number; i++) {
            course1.addStudent(input.next());
        }
        System.out.println(course1);

        System.out.println("\nStudent to drop:");
        course1.dropStudent(input.next());
        System.out.println(course1);
        printStudents(course1.getStudents());
        
        Course course2= (Course)course1.clone();
        System.out.println(course1 == course2);
        System.out.println(course1.getStudents() == course2.getStudents());
        System.out.println(course2);
        printStudents(course2.getStudents());
        input.close();
    }

    private static void printStudents(String[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.out.print(((i+1) % 5 ==0) ? array[i] + "\n" : array[i] + " ");
        }
        System.out.println();
    }

}

