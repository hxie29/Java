import java.util.Scanner;

public class E0606 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number (0 for exit):");
            int number = input.nextInt();
            if (number == 0) break;
            displayPattern(number);
        }
        input.close();
    }

    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int k = i; k > 0; k--) {
                System.out.printf("%-5d", k);
            }   
            System.out.println();
        }
    }
}
