/* (Sorted?) Write the following method that returns true if the list is already sortedin decreasing order. */
import java.util.Scanner;

public class E0719 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int list[] = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);

        System.out.println(isSorted(list) ? "The list is sorted." : "The list is not sorted");
        input.close();
    }

    public static int[] createArray(int[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextInt();
        }
        input.close();
        return list;
    }
    
    // Display array method, 20 per line
    public static void displayArray(int[] list) {
        int item = 0;
        for (int i = 0; i < list.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? list[i] + "\n" : list[i] + " ");
        } 
        System.out.println();
    }

    // sort verification
    public static boolean isSorted(int[] list) {
        boolean sorted = true;
        for (int i = 0; i < list.length -1; i++) {
            if (list[i] < list[i+1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    
}
