package c08_MultidimensionArrays;/* (Game: nine heads and tails) Nine coins are placed in a 3-by-3 matrix with some
face up and some face down. You can represent the state of the coins using a
3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
0 0 0 | 1 0 1 | 1 1 0 | 1 0 1 | 1 0 0
0 1 0 | 0 0 1 | 1 0 0 | 1 1 0 | 1 1 1
0 0 0 | 1 0 0 | 0 0 1 | 1 0 0 | 1 1 0 

*/
import java.util.Scanner;
public class E0811 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Enter a decimal number
        System.out.println("Enter a decimal number between 0 and 511: ");
        int number = input.nextInt();
        if (number < 0 || number > 511) System.out.println("Invalid input.");
        else {
            String binary = getBinary(number);
            System.out.println(binary);
            char[][] m = getMatrix(binary);
            printMatrix(m);
        }
        input.close();
    }

    //translate it into binary number
    public static String getBinary(int number) {
        StringBuilder binary = new StringBuilder();
        int divisor = 2;
        while (number > 0) {
            int remainder = number % divisor;
            number /= divisor;
            binary.insert(0, remainder);
        }
        // IMPORTANT! output needs to be length of 9 to fill the matrix
        while (binary.length() < 9) {
            binary.insert(0, "0");
        }
        return binary.toString();
    }

    //put binary number into a matrix of H & T
    public static char[][] getMatrix(String binary) {
        char[][]x = new char[3][3];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                int number = binary.charAt(3*i + j) - '0';
                x[i][j] = (number == 0) ? 'H' : 'T';
            }
        }
        return x;
    }

    // print char matrix
    public static void printMatrix(char[][] list) {
        for (char[] chars : list) {
            System.out.printf("%1S %1S %1S \n", chars[0], chars[1], chars[2]);
        }
    }
}
