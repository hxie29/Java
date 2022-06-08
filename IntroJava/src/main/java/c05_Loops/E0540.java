package c05_Loops;

import java.util.Scanner;

public class E0540 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of throws:");
        int time = input.nextInt();
        int countHead = 0;
        int countTail = 0;

        for (int n = 1; n <= time ; n++) {
            int result = (int)(Math.random()+0.5);
            if (result == 1) {
                countHead++;
            }
            else
                countTail++;
        }

        System.out.println("The number of heads is " + countHead);
        System.out.println("The number of tails is " + countTail);

        input.close();
    }
}
