package c07_SingleDimensionArrays;// find least common multiples of five numbers
import java.util.Scanner;

public class E0714 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);

        System.out.println("The least common multiple of these numbers is " + getLcm(list));
        
        input.close();
    }

     // Display array method, 20 per line
     public static void displayArray(int[] list) {
        int item = 0;
         for (int j : list) {
             item++;
             System.out.print((item % 20 == 0) ? j + "\n" : j + " ");
         }
        System.out.println();
    }

    // create integer array
    public static void createArray(int[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextInt();
        }
        input.close();
    }

    // get lcm
    public static int getLcm(int[] list) {
        int lcm = 1;
        do {
            lcm++;
        } while (!multipleOfArray(lcm, list));
        return lcm;
    } 

    // verify multiples
    public static boolean multipleOfArray(int lcm, int[] list) {
        boolean multiple = true;
        for (int j : list) {
            if (lcm % j != 0) {
                multiple = false;
                break;
            }
        }
        return multiple;
    }
    
}
