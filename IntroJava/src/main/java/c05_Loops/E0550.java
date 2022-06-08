package c05_Loops;

import java.util.Scanner;

public class E0550 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        input.nextLine();

        for (int n = 1; n <= 9; n++) {
            for (int k =1; k <= 9; k++) {
                System.out.print(k + "*" + n + "= " + (k * n) + "\t");
            } 
            System.out.println();
        }
        input.close();
    }
}
