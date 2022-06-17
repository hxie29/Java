/*
(Addition quiz) Rewrite Programming Exercise 11.16 to store the answers in a set
rather than a list.

(Addition quiz) Rewrite Listing 5.1, RepeatAdditionQuiz.java, to alert the user
if an answer is entered again. (Hint: use an array list to store answers.) Here is a sample run:

What is 5 + 9? 12
Wrong answer. Try again. What is 5 + 9? 34
Wrong answer. Try again. What is 5 + 9? 12
You already entered 12
Wrong answer. Try again. What is 5 + 9? 14
You got it!
*/
package c21_SetsMaps;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E2115 {
    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
        
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        Set<Integer> wrongAnswers = new HashSet<>();
        
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();
    
        while (number1 + number2 != answer) {
            if (wrongAnswers.contains(answer))
                System.out.println("You already entered " + answer);
            else
                wrongAnswers.add(answer);

            System.out.print("Wrong answer. Try again. What is "  + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }
        System.out.println("You got it!");
    }
}
