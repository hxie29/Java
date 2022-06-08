package c07_SingleDimensionArrays;// Reads student scores, and assign grades
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
