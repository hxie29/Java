/*(Assign grades) Write a program that reads student scores, gets the best score, and
then assigns grades based on the following scheme:
Grade is A if score is Ú best -5
Grade is B if score is Ú best -10;
Grade is C if score is Ú best -15;
Grade is D if score is Ú best -20;
Grade is F otherwise.
The program prompts the user to enter the total number of students, and then
prompts the user to enter all of the scores, and concludes by displaying the grades.
Here is a sample run:
Enter the number of students: 4
Enter 4 scores: 40 55 70 58
Student 0 score is 40 and grade is F
Student 1 score is 55 and grade is C
Student 2 score is 70 and grade is A
Student 3 score is 58 and grade is C*/
package c07_SingleDimensionArrays;
import java.util.Scanner;

public class E0701 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        
        //Create an array to store students score in order
        int[] scores = new int[input.nextInt()];
        System.out.println("Enter students scores");
        for (int i =0; i < scores.length; i++) {
            scores[i] = input.nextInt();
        }
        // create another array that stores students' grade in order
        String[] grades = getGrade(scores);

        // print out scores and grades in order
        displayScoreGrade(scores, grades);

        input.close();
    }

    public static String[] getGrade(int[] scores) {
        String[] grades = new String[scores.length];
        int highScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
        }
        for (int i = 0; i < grades.length; i++) {
            if (scores[i] >= highScore - 5) 
                grades[i] = "A";
            else if (scores[i] >= highScore - 10) 
                grades[i] = "B";
            else if (scores[i] >= highScore - 15) 
                grades[i] = "C";
            else if (scores[i] >= highScore - 20) 
                grades[i] = "D";
            else 
                grades[i] = "F";
        }
        return grades;
    }
    
    public static void displayScoreGrade(int[] scores, String[] grades) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grades[i]);
        }
    }
}
