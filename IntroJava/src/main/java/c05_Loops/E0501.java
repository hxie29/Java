package c05_Loops;

import java.util.Scanner;
public class E0501 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your score (negative to exit the program):");
            int score = input.nextInt();
            if (score < 0) {
                break;
            }
            System.out.println( (score >= 60) ? "You pass the exam." : "You did not pass the exam.");
        }
        System.out.println("No numbers are entered except 0.");
        input.close();
    }
}
