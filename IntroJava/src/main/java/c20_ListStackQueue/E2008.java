/*(Game: lottery) Revise Programming Exercise 3.15 to add an additional $2,000
award if two digits from the user input are in the lottery number. (Hint: Sort
the three digits in the lottery number and three digits in the user input into two
lists, and use the Collection’s containsAll method to check whether the
two digits in the user input are in the lottery number.)*/
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Scanner;

public class E2008 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter three integers: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int n3 = input.nextInt();
        input.close();

        int lottery = (int) (Math.random() * 1000);
        int s1 = lottery % 10;
        int s2 = (lottery / 10) % 10;
        int s3 = lottery / 100;
        System.out.println("The lottery number is " + s1 + s2 + s3);

        if ( (n1 == s1) && (n2 == s2) && (n3 == s3) ) {
            System.out.println("Your award is $12,000.");
        }
        else {
            ArrayList<Integer> guessList = new ArrayList<>();
            guessList.add(n1);
            guessList.add(n2);
            guessList.add(n3);
            ArrayList<Integer> rightList = new ArrayList<>();
            rightList.add(s1);
            rightList.add(s2);
            rightList.add(s3);

            guessList.removeAll(rightList);
            switch (guessList.size()) {
                case 0 -> System.out.println("Your award is $5,000.");
                case 1 -> System.out.println("Your award is $4,000.");
                case 2 -> System.out.println("Your award is $2,000.");
                case 3 -> System.out.println("You have not won any award.");
            }
        }

    }
}
