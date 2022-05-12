import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(course1.toString());

        input.close();
    }

    public static void printStudents(ArrayList list){
       System.out.println(list.toString());
    }
    
}

class Course {
    //Data fields
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();
    private int numberOfStudents = students.size();

    // Constructor
    public Course(){
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student){
        students.add(student);
    }

    public void dropStudent(String student) {
        if (students.remove(student)) System.out.println(student + " removed");
        else System.out.println("Student is not in the course.");
    }

    public void clear(){
        students.clear();
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public String getCourseNmae(){
        return courseName;
    }

    public ArrayList getStudents(){
        return students;
    }

    @Override
    public String toString(){
        return "Course name: " + courseName + "\nStudents registerd:\n" + getStudents().toString();
    }
   
}
