package c06_Methods;// estimate the square root of n
import java.util.Scanner;

public class E0622 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Plase enter a number: ");
        long n = input.nextLong();
        System.out.println("The approximate square root of n is " + sqrt(n));
        
        input.close();

    }

    public static double sqrt(long n) {
        double nextGuess = 2;
        double lastGuess = 1;

        while (Math.abs(nextGuess - lastGuess) >= 0.0001) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2.0;
        }

        return nextGuess; 
    }

}
