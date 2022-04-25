import java.util.Scanner;

public class E0543 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        int count = 0;

        // input and find max value
        for (int n = 1; n <= number; n++) {
            for (int k =1; k <= number; k++) {
                count++;
                System.out.println(n + " " + k);
            } 
        }

        System.out.println("There are " + count + " combinations.");
        input.close();
    }
}
