import java.util.Scanner;

public class E03L01 {
    public static void main(String[] args){
        int number1 = (int)(System.currentTimeMillis() % 10);
        int number2 = (int)(System.currentTimeMillis() / 10 % 10);

        Scanner input = new Scanner(System.in);
        System.out.println("What is the sum of " + number1 + " , " + number2 + "?");
        double answer = input.nextDouble();
 /*       int answerInt = (int) answer;
// this section is to detect non-integers, though a input double would also be processed as incorrect answer.
        if (answerInt == answer){
*/
            if (answer == number1 + number2) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect.");
            }
        }
        else {
            System.out.println("Invalid input.");
        }

        input.close();
//    }
}
