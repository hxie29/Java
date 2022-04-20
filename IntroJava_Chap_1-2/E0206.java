import java.util.Scanner;
public class E0206 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer between 0 and 1000: ");
        int number = input.nextInt();
        int n1 = number / 100;
        int n2 = (number - n1 * 100) / 10;
        int n3 = (number - n1 * 100 - n2 * 10);
        int multiply = n1 * n2 * n3;
        System.out.println("The multipilication of all digits in " + number + " is " + multiply);
        input.close();
    }
}
