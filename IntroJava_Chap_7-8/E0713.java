// get a random number from an array
import java.util.Scanner;
public class E0713 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int list[] = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);

        System.out.println("A random element from array:" + getRandom(list));
        
        input.close();
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

    // create integer array
    public static int[] createArray(int[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextInt();
        }
        input.close();
        return list;
    }

    // get random number from an integer array

    public static int getRandom(int[] list) {
        int index = (int)(Math.random()* list.length);
        return list[index];
    } 

}
