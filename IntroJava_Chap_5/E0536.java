import java.util.Scanner;

public class E0536 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        String isbn = "";

        for (int n = 1; n <= 9; n++) {
            System.out.println("Please enter a single digit: ");
            int d = input.nextInt();
            sum += (d * n);
            isbn += (d + "");
        }
        int finalNumber = sum % 11;
        
    if (finalNumber == 10) {
        System.out.println("The ISBN-10 number is " + isbn + "X");
    }  
    else
        System.out.println("The ISBN-10 number is " + isbn + finalNumber);
        input.close();
    }
}
