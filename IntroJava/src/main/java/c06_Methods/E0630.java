package c06_Methods;// Game: craps
import java.util.Scanner;
public class E0630 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to play, 0 to exit:");
            int play = input.nextInt();
            if (play == 1) {
                int n1 = (int)(Math.random()*6) + 1;
                int n2 = (int)(Math.random()*6) + 1;
                displayResult(n1, n2);
            }
            else break;
        }
        input.close();
    }

    public static void displayResult(int n1, int n2) {
        int sum = n1 + n2;
        System.out.printf("You rolled %1d + %1d = %2d.\n", n1, n2, sum);
        if ((sum == 2) || (sum == 3) || (sum == 12)){
            System.out.println("You lose");
        }
        else if ((sum == 7) || (sum == 11)) {
            System.out.println("You win");
        }
        else System.out.println("Point is " + sum);
    }
}
