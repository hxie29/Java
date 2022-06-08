package c07_SingleDimensionArrays;// Selection sorting algorhythm
import java.util.Scanner;

public class E07L08 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 6 integers:");
        
        // create an array with 6 integers input
        int[] list = new int[6];
        for (int i = 0; i < list.length; i++) {
            list[i] =  input.nextInt();
        }
        System.out.println("Array before sorting: ");
        arrayPrint(list);
        
        sortArray(list);
        System.out.println("Array after sorting:");
        arrayPrint(list);

        input.close();
    }

    // Print array method
    public static void  arrayPrint(int[] list) {
        for (int j : list) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // Selection sort array method
    public static void sortArray(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;
            // find minimum from index i to the end of the array
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < currentMin) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    
}
