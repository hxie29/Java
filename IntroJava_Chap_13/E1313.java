/*
(Enable the Course class cloneable) Rewrite the Course class in Listing 10.6 to
add a clone method to perform a deep copy on the students field.
*/
import java.util.Scanner;
public class E1313 {
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
        System.out.println(course1.toString());

        System.out.println("\nStudent to drop:");
        course1.dropStudent(input.next());
        System.out.println(course1.toString());
        printStudents(course1.getStudents());
        
        Course course2= (Course)course1.clone();
        System.out.println(course1 == course2);
        System.out.println(course1.getStudents() == course2.getStudents());
        System.out.println(course2.toString());
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

class Course implements Cloneable {
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

    @Override
    public Object clone() {
        Course c = new Course(courseName);
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null)
                c.addStudent(students[i]);
        }
        return c;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + "\nStudents' number: " + numberOfStudents;
    }
   
    
}
