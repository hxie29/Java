package c11_InheritancePolymorphism;/* (Remove duplicates) Write a method that removes the duplicate elements from
an array list of integers using the following header:
public static void removeDuplicate(ArrayList<Integer> list)
Write a test program that prompts the user to enter 10 integers to a list and displays
the distinct integers in their input order and separated by exactly one space.
Here is a sample run:
Enter 10 integers: 34 5 3 5 6 4 33 2 2 4
The distinct integers are 34 5 3 6 4 33 2
*/
import java.util.ArrayList;
import java.util.Scanner;

public class E1113{
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
        System.out.println("The distinct integers are:");
        removeDuplicate(list);
        System.out.println(list);
        input.close();

    }

    public static void shuffle(ArrayList<Integer> list){
        java.util.Collections.shuffle(list);
    }

    public static void sort(ArrayList<Integer> list){
        java.util.Collections.sort(list);
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
