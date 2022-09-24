/*(Display numbers in a pyramid pattern) Write a nested for loop that prints the
following output: (symmetric!)
  1
1 3 1
1 3 9 3 1
1 3 9 27 9 3 1
1 3 9 27 81 27 9 3 1
1 3 9 27 81 243 81 27 9 3 1
1 3 9 27 81 243 729 243 81 27 9 3 1
1 3 9 27 81 243 729 2187 729 243 81 27 9 3 1 */
package c05_Loops;

import java.util.Scanner;

public class E0519 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        
    
        System.out.println("Enter number of rows:");
        int numberOfRows = input.nextInt();

        System.out.println("Enter the integer base");
        int base = input.nextInt();

        // counting from row 1, looping for number of rows
        for (int row = 1; row <= numberOfRows; row++){
            
            // starting by printing all the empty spaces, (row 1 has numberOfRows - 1) of empty spaces on both ends
            int numberOfSpaces = numberOfRows - row;
            // counting printed spaces on the left
            for (int printedSpaces = 1; printedSpaces <= numberOfSpaces; printedSpaces++) {
                System.out.print("      ");
            }
            // after this loop, all spaces on the left are printed

                // print middle part of numbers
                for (int numberOfFigures = 1; numberOfFigures <= row; numberOfFigures++) {
                    int figure = (int) Math.pow(base, (numberOfFigures - 1));
                    System.out.printf("%6d", figure); // digits are aligned to the right of reserved spaces.
                }
                // after this loop, numberOfFigures == row +1, needs to be reassigned
                for (int numberOfFigures = row - 1; numberOfFigures > 0; numberOfFigures--) {
                    int figure = (int) Math.pow(base, (numberOfFigures - 1));
                    System.out.printf("%6d", figure);
                }
                //final value of numberOfFigures when print is execued is 1, i.e. 3^0 is printed. after this loop all numbers are printed
            
                // counting printed spaces on the right
            for (int printedSpaces = 1; printedSpaces <= numberOfSpaces; printedSpaces++) {
                System.out.print("      ");
            }
            // after this loop, all spaces on the right are printed
            System.out.println();
        }
        input.close();
    }    
}