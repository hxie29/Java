import java.util.Scanner;

public class E0602 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number (0 for exit):");
            int number = input.nextInt();
            if (number == 0) break;
            else System.out.printf("%7d\n", getSum(number));
        }
        input.close();
    }

    public static int getSum(int number) {
        int sum = 0;
        while (number >= 1) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
