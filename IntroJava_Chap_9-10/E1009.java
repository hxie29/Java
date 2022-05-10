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

class Course {
    //Data fields
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    // Constructor
    public Course(){
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student){
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        int index = findStudent(student, students);
        if (index == -1) System.out.println("Student not registered in the course:");
        else{
            String[] temp = new String[students.length];
            if (index == 0) {
                System.arraycopy(students, 1, temp, 0, students.length - 1); 
                students = temp;
            }
            else {
                System.arraycopy(students, 0, temp, 0, index); 
                System.arraycopy(students, index+1, temp, index, students.length - 1- index); 
                students = temp;
            }
            numberOfStudents--;
        }
    }

    public void clear(){
        students = new String[100];
        numberOfStudents = 0;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public String getCourseNmae(){
        return courseName;
    }

    public String[] getStudents(){
        return students;
    }

    private int findStudent(String student, String[]students){
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(student)) {
                index = i;
                break;
            }
        }
        return index;
    }
   
}
