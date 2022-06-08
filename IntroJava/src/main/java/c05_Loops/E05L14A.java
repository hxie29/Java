package c05_Loops;

import java.util.Scanner;

public class E05L14A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String word = input.nextLine();

        int high = word.length() - 1;
        int low = 0;

        boolean isPandrome = true;
        while (low < high) {
            if (word.charAt(low) != word.charAt(high)) {
                isPandrome = false;
                break;
            }
            high--;
            low++;
        }
        if (isPandrome) {
            System.out.println(word + " is palindrom.");
        }
        else {
            System.out.println(word + " is not a palindrom.");
        }
        input.close();
    }    
}
