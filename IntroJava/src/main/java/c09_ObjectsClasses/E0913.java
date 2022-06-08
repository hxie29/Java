package c09_ObjectsClasses;
/* (The Location class) Design a class named Location for locating a maximal
value and its location in a two-dimensional array. The class contains public data
fields row, column, and maxValue that store the maximal value and its indices in
a two-dimensional array with row and column as int types and maxValue as a double type.

Write the following method that returns the location of the largest element in a
two-dimensional array:
public static Location locateLargest(double[][] a)
The return value is an instance of Location. Write a test program that prompts
the user to enter a two-dimensional array and displays the location of the largest
element in the array. Here is a sample run:

Enter the number of rows and columns in the array: 3 4
Enter the array:
23.5 35 2 10
4.5 3 45 3.5
35 44 5.5 9.6
The location of the largest element is 45 at (1, 2)

*/

import java.util.Scanner;
public class E0913 {
    public static void main(String[] args) {
        double[][] array = createArray();
        Location maxArray = locateLargest(array);
        System.out.println("The location of the largest element is " + maxArray.maxValue 
        + " at (" + maxArray.row + ", " + maxArray.column +").");

    }
    
    public static double[][] createArray(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the array: ");
        int row = input.nextInt();
        int column = input.nextInt();
        double[][] array = new double[row][column];
        System.out.println("Enter the array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        input.close();
        return array; 
    }

    public static Location locateLargest(double[][] array){
        Location x = new Location();
        x.maxValue = array[0][0];
        x.row = 0;
        x.column = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j =0; j < array[i].length; j++) {
                if (array[i][j] > x.maxValue) {
                    x.row = i;
                    x.column = j;
                    x.maxValue = array[i][j];
                }
            }
        }
        return x;
    }
}
