package c03_Selections;

import java.util.Scanner;

public class E03L03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
    
    if (number1 < number2) {
        int swap = number1;
        number1 = number2;
        number2 = swap;
    }

    System.out.println("What is " + number1 + " - " + number2 + "?");
    double answer = input.nextDouble();

    if (answer == (number1 - number2)){
        System.out.println("Correct!");
    }
    else {
        System.out.println("Incorrect.");
    }
    input.close();
    }
}
