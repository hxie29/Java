import java.util.Scanner;

public class E0539 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your target salary:");
        double minBonus = input.nextInt() - 5000;
        double sales = 25000;
        double bonus = 2200;

        while (bonus < minBonus) {
            sales++;
            bonus = 5000 * 0.06 + 5000 * 0.08 + (sales - 10000) * 0.1;
        }

        System.out.println("Required sales to reach target salary is " + sales);
        input.close();
    }
}
