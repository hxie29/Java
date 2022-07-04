/*(Sort students) Rewrite Programming Exercise 7.17 using streams. Define a
class named Student with data fields name and score and their getter methods.
Store each student in a Student object.*/

/* Write a program that prompts the user to enter the number of students,
the students’ names, and their scores and prints student names in decreasing
order of their scores. Assume the name is a string without spaces, use the Scanner’s
next() method to read a name. */
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.stream.Stream;

public class E3009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        Student[] list = new Student[input.nextInt()];
        for (int i = 0; i < list.length; i++) {
            String name = input.next();
            int score = input.nextInt();
            list[i] = new Student(name, score);
        }
        input.close();

        Stream.of(list).sorted().forEach(e -> System.out.println( "Name: "+ e.getName() + " Score: " + e.getScore()));
    }

}
