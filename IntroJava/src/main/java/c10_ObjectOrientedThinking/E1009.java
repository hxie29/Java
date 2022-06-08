package c10_ObjectOrientedThinking;
/*
(The Course class) Revise the Course class as follows:
■■ Revise the getStudents() method to return an array whose length is the
same as the number of students in the course. (Hint: create a new array and copy students to it.)
■■ The array size is fixed in Listing 10.6. Revise the addStudent method to
automatically increase the array size if there is no room to add more students.
This is done by creating a new larger array and copying the contents of the current array to it.
■■ Implement the dropStudent method.
■■ Add a new method named clear() that removes all students from the course.
Write a test program that creates a course, adds three students, removes one, and displays the students in the course.
*/

import java.util.Scanner;
public class E1009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course name:");
        Course course1 = new Course(input.next());
        System.out.println("How many students does the course has ?");
        int number = input.nextInt();
        System.out.println("Enter students' name:");
        for (int i = 0; i < number; i++) {
            course1.addStudent(input.next());
        }
        printStudents(course1.getStudents(), course1.getNumberOfStudents());
        System.out.println("\nStudent to drop:");
        course1.dropStudent(input.next());
        printStudents(course1.getStudents(), course1.getNumberOfStudents());
        input.close();
    }

    public static void printStudents(String[] array, int n){
        for (int i = 0; i< n; i++) {
            System.out.print(((i+1) % 5 ==0) ? array[i] + "\n" : array[i] + " ");
        }
    }
    
}

