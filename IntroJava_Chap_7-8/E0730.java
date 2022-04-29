/* (Pattern recognition: consecutive four equal numbers) Write the following method
that tests whether the array has four consecutive numbers with the same value */

import java.util.Scanner;
public class E0730 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int list[] = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);
        
        System.out.println(isConsecutiveFour(list) ? "The list has consecutive fours." : "The list does not have consecutive fours.");
        
        input.close();
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
    
    // Display array method, 20 per line
    public static void displayArray(int[] list) {
        int item = 0;
        for (int i = 0; i < list.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? list[i] + "\n" : list[i] + " ");
        } 
        System.out.println();
    }

    // check for consecutive fours
    public static boolean isConsecutiveFour(int[] list) {
        boolean result = true;
        for (int i = 0; i < list.length - 3; i++) {
            result = true;
            for (int j = i +1; j < i + 4; j++) {
                if (list[i] != list[j]) {
                    result = false;
                    break;
                }
            }
            if (result) break;
        }
        return result;
    }
}

    //Alternative method
/*    public static boolean isConsecutiveFour(int[] values) {
		int count = 1; // number of consecutive numbers
		
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] == values[i + 1]) 
				count++;
			
			if (count >= 4) 
				return true;
	
			if (values[i] != values[i + 1])
				count = 1;	
		}
		return false;
	}
*/
