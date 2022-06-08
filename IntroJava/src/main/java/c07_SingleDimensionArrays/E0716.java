package c07_SingleDimensionArrays;// check excution time for linear search and binary search
import java.util.Scanner;

public class E0716 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];
        createArray(list);
        System.out.println("Enter the key for search");
        int key = input.nextInt();
        
        // linear search
        long startTime = System.nanoTime();
        linearSearch(list, key);
        long endTime = System.nanoTime();
        long excutionTime = endTime - startTime;
        System.out.println("Execution time linear search: " + excutionTime);

        // binary search
        startTime = System.nanoTime();
        binarySearch(list, key);
        endTime = System.nanoTime();
        excutionTime = endTime - startTime;
        System.out.println("Execution time binary search: " + excutionTime);

        input.close();
    }


    // create array with numbers in ascending order
    public static void createArray(int[] list) {
        for (int i = 0; i < list.length; i++ ) {
            list[i] = i;
        }
    }

    // linear search method
    public static void linearSearch(int[] list, int key) {
        for (int j : list) {
            if (key == j) return;
        }
    }

    // linear search method
    public static void binarySearch(int[] list, int key) {
        int lowIndex = 0;
        int highIndex = list.length - 1;
        while(highIndex >= lowIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (key == list[midIndex]) return;
            else if (key > list[midIndex]) {
                lowIndex = midIndex + 1;
            }
            else highIndex = midIndex -1;
        }
    }
    
}
