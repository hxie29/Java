package c06_Methods;// Game: craps
import java.util.Scanner;
public class E0632 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of times: ");
        int play = input.nextInt();
        int count = 0;

        for (int i =1; i <= play; i++) {
                int n1 = (int)(Math.random()*6) + 1;
                int n2 = (int)(Math.random()*6) + 1;
                if (win(n1, n2)) count++;
        }
        System.out.println("Your chance of winning game is " + count);

        input.close();
    }

    public static boolean win(int n1, int n2) {
        int sum = n1 + n2;
        return (sum == 7) || (sum == 11);
    }
}
