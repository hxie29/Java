import java.util.Scanner;

public class E0601 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number (0 for exit):");
            int number = input.nextInt();
            if (number == 0) break;
            else System.out.printf("%7d\n", getPenNumber(number));
        }
        input.close();
    }

    public static int getPenNumber(int n) {
        return n * (3 * n - 1) /2;
    }
}
