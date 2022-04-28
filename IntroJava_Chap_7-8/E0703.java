// Reads a serie of integers and count each's appearance
import java.util.Scanner;

public class E0703 {
    public static void main(String[] args) {
        int[] count = new int[50];
        
        System.out.println("Enter numbers between 1 and 50:");
        
        //Count method for inputs and counting
        countNumbers(count);
        
        //Display methods;
        displayCount(count);
        
    }
    
    // Count method
    public static int[] countNumbers(int[] count) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int number = input.nextInt();
            if (number == 0) break;
            if (number > 0 && number <= 50) count[(number -1)]++;
        }
        input.close();
        return count;
    }

    //Display count;
    public static void displayCount(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                System.out.println((i+1) + " occurs " + count[i] + " time.");
            }
            if (count[i] > 1) {
                System.out.println((i+1) + " occurs " + count[i] + " times.");
            }
        }
    }
}
