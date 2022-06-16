/*(Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a three-digit
number. The program prompts the user to enter a three-digit number and determines
whether the user wins according to the following rules:
1. If the user input matches the lottery number in the exact order, the award is
$12,000.
2. If all digits in the user input match all digits in the lottery number, the award
is $5,000.
3. If one digit in the user input matches a digit in the lottery number, the award
is $2,000.*/
package c03_Selections;

import java.util.Scanner;

public class E0315 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter three integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();

        int lottery = (int) (Math.random() * 1000);
        int s1 = lottery % 10;
        int s2 = (lottery / 10) % 10;
        int s3 = lottery / 100;
        System.out.println("The lottery number is " + s1 + s2 + s3);
    
    if ( (n1 == s1) && (n2 == s2) && (n3 == s3) ) {
        System.out.println("Your award is $12,000.");
    }
    else {
        if (n1 > n2) {
            int swap = n1;
            n1 = n2;
            n2 = swap;
        }
        if ((n3 < n2 ) && (n3 > n1)) {
            int swap = n3;
            n3 = n2;
            n2 = swap;
        }
        if (n3 < n1) {
            int swap = n3;
            n3 = n2;
            n2 = swap;
    
            swap = n1;
            n1 = n2;
            n2 = swap;
        }      

        if (s1 > s2) {
            int swap = s1;
            s1 = s2;
            s2 = swap;
        }
        if ((s3 < s2 ) && (s3 > s1)) {
            int swap = s3;
            s3 = s2;
            s2 = swap;
        }
        if (s3 < 1) {
            int swap = s3;
            s3 = s2;
            s2 = swap;
    
            swap = s1;
            s1 = s2;
            s2 = swap;
        }      
    }

    if ( (n1 == s1) && (n2 == s2) && (n3 == s3) ) {
        System.out.println("Your award is $5,000.");
    }
    else if (n1 == s1 || n1 == s2 || n1 == s3 || n2 == s1 || n2 == s2 || n3 == s3 || n3 == s1 || n3 == s2) {
        System.out.println("Your award is $2,000.");
    }
    else 
        System.out.println("You have not won any award.");

    input.close();
    }
}
