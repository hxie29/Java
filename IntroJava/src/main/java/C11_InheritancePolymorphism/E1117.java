package C11_InheritancePolymorphism;/*
(Algebra: perfect square) Write a program that prompts the user to enter an integer
m and find the smallest integer n such that m * n is a perfect square. (Hint:
Store all smallest factors of m into an array list. n is the product of the factors that
appear an odd number of times in the array list. For example, consider m = 90,
store the factors 2, 3, 3, and 5 in an array list. 2 and 5 appear an odd number of
times in the array list. Thus, n is 10.) 

Here are some sample runs:

Enter an integer m: 1500
The smallest number n for m * n to be a perfect square is 15
m * n is 22500

Enter an integer m: 63
The smallest number n for m * n to be a perfect square is 7
m * n is 441
*/

import java.util.ArrayList;
import java.util.Scanner;

public class E1117 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an inter m:");
        int m = input.nextInt();
        ArrayList<Integer> list = factors(m);
        System.out.println("Factors: " + list);


        int n = 1;
        for (int i = 0; i < list.size(); i++){
            int count = 1;
            int value = list.get(i);
            //System.out.println(count);
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).equals(value)) {
                    count++;
                }
            }
            //System.out.println(count);
            if (count % 2 != 0) {
                n *= list.get(i);
            }
        }

        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + m * n);

        input.close();
    }

    public static ArrayList<Integer> factors(int m){
        ArrayList<Integer> list = new ArrayList<>();
        while (m > 1){
            for (int i = 2; i <= m ; i++) {
                if (m % i == 0) {
                    list.add(i);
                    m /= i;
                    break;
                }
            }
        }
        return list;
    }

    public static void removeDuplicate(ArrayList<Integer> list){
        for (int i =0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
               }
            }
        }
    }
}
