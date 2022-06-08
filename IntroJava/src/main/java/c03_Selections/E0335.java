package c03_Selections;

import java.util.Scanner;

public class E0335 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int number = input.nextInt();
        System.out.print(number + " is an ");
        System.out.println((number%2 ==0) ? "even number." : "odd number.");

        input.close();
    }
}
