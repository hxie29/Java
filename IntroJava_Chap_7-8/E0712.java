// Reverse an array and return itself
import java.util.Scanner;

public class E0712 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        double list[] = new double[input.nextInt()];

        createArray(list);
        System.out.println("The array before reversing is:");
        displayArray(list);

        reverse(list);
        System.out.println("The array after reversing is:");
        displayArray(list);

        input.close();
    }

    public static double[] createArray(double[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextDouble();
        }
        input.close();
        return list;
    }

    // Display array method, 20 per line
    public static void displayArray(double[] list) {
        int item = 0;
        for (int i = 0; i < list.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? list[i] + "\n" : list[i] + " ");
            System.out.println();
        } 
    }

    public static double[] reverse(double[] list) {
        for (int i = 0; i < list.length / 2; i++ ) {
            double temp = list[i];
            list[i] = list[list.length-1-i];
            list[list.length-1-i] = temp;
        }
        return list;
    }
}
