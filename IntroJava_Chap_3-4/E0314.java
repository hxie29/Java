import java.util.Scanner;

public class E0314 {
    public static void main(String [] args) {
        Scanner input =  new Scanner(System.in);
        System.out.println("Guess the result of the coin flip, enter 1 for head, enter 0 for tail: ");
        int guess = input.nextInt();
        int result = (int)(Math.random() + 0.5);

        System.out.println( (guess == result) ? "Correct!" : "Wrong.");

        input.close();
    }
}
