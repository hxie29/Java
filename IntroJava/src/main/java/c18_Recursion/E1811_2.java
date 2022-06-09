/*  Write a recursive method that displays all permutations of a given array of
integers. Here is a sample run:
Enter the array size : 3
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
*/
package c18_Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class E1811_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size:");
        listPermutation(input.nextInt());
    }

    private static void listPermutation(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        System.out.println(permute(list));
    }

    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list) {
        // If only one element left in the list, then permutation is the list itself, return that list
        if (list.size() == 1) {
            ArrayList<ArrayList<Integer>> subList = new ArrayList<>();
            subList.add(list);
            return subList;
        }
        /* If more than one element left, create a list of sublist, each sublist is a permutation of original list */
        else {
            /* create a list of sublist */
            ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
            /* FOR loop to permutation the sublist */
            for (Integer i: list) {
                /* For each sublist, an element is isolated from the list, to create a permutation of sublist */
                ArrayList<Integer> subList = new ArrayList<>(list);
                /* isolate an element by removal */
                subList.remove(i);
                ArrayList<ArrayList<Integer>> subListNew = permute(subList);
                for (ArrayList<Integer> sub2List: subListNew) {
                    ArrayList<Integer> local = new ArrayList<>();
                    /* Add back the removed element at the beginning of the sublist */
                    local.add(i);
                    /* Add the permutation of the remaining elements */
                    local.addAll(sub2List);
                    /* Push this combination to parent list */
                    newList.add(local);
                }
            }
            /* Return the list to its parent list */
            return newList;
        }
    }

}
