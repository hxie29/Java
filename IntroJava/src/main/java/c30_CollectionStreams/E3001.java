/*(Assign grades) Rewrite Programming Exercise 7.1 using streams.
* (Assign grades) Write a program that reads student scores, gets the best score, and
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
Student 3 score is 58 and grade is C
* */
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class E3001 {
    private static int count = 0;
    private static int best;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");

        //Create an array to store students score in order
        int[] scores = new int[input.nextInt()];
        System.out.println("Enter students scores");
        for (int i = 0; i < scores.length; i++) {
            scores[i] = input.nextInt();
        }
        input.close();
        // create another array that stores students' grade in order

        best = IntStream.of(scores).max().getAsInt();
        System.out.println(best);
        int[] grades = IntStream.of(scores).map(e -> grading(e, best)).toArray();

        // print out scores and grades in order
        IntStream.of(grades).forEach(e ->
                System.out.println("Student " + count + " score is " + scores[count] + " and grade is " + (char)grades[count++]));
    }

    private static int grading(int e, int best) {
        return (best - e <= 5) ? 'A' : (best - e <= 10) ? 'B' : (best - e <= 15) ? 'C' : (best - e <= 20) ? 'D' : 'F';
    }
}
