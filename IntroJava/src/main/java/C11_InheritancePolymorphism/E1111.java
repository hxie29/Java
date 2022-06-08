package C11_InheritancePolymorphism;/* (Sort ArrayList) Write the following method that sorts an ArrayList of numbers:
public static void sort(ArrayList<Integer> list)
Write a test program that prompts the user to enter five numbers, stores them in
an array list, and displays them in increasing order.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class E1111{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter a list of integers, ending with 0:");
        int value;
        do{
            value = input.nextInt();
            if (value !=0) list.add(value);
        }while (value != 0);
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
        sort(list);
        System.out.println(list);
        input.close();

    }

    public static void shuffle(ArrayList<Integer> list){
        java.util.Collections.shuffle(list);
    }

    public static void sort(ArrayList<Integer> list){
        java.util.Collections.sort(list);
    }
}
