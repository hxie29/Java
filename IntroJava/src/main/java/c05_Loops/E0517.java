/*(Display pyramid) Write a program that prompts the user to enter an integer from
1 to 15 and displays a pyramid, as shown in the following sample run: */
package c05_Loops;

import java.util.Scanner;

public class E0517 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int number = input.nextInt();
        int figure = number;
        
        while (figure > 0){
            while (figure > 0) {
                System.out.print(figure + " ");
                figure--;
            }
            figure+=2;
            while (figure <= number){
                System.out.print(figure + " ");
                figure ++;
            }
            number--;
            figure = number;
            System.out.println();
        }
        input.close();
    }    
}