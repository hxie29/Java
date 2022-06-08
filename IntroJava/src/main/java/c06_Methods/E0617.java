package c06_Methods;

import java.util.Scanner;

public class E0617 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter n for n-by-n matrix:");
        int n = input.nextInt();

        displayMatrix(n);
        input.close();
    }
    
    public static void displayMatrix(int n) {
        for (int i = 1; i <= n; i++){
            for (int k = 1; k <= n; k++) {
                System.out.printf("%-2d", generate());
            }
            System.out.println();
        }           
    }

    //find days of the year
    public static int generate() {
       return (int)(Math.random() + 0.5);
    }
       
}
