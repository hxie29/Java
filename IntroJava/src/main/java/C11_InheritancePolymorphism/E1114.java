package C11_InheritancePolymorphism;/* (Combine two lists) Write a method that returns the union of two array lists of
integers using the following header:
public static ArrayList<Integer> union( ArrayList<Integer> list1, ArrayList<Integer> list2)

For example, the addition of two array lists {2, 3, 1, 5} and {3, 4, 6} is
{2, 3, 1, 5, 3, 4, 6}. Write a test program that prompts the user to enter two lists,
each with five integers, and displays their union. The numbers are separated by
exactly one space. Here is a sample run:
Enter five integers for list1: 3 5 45 4 3
Enter five integers for list2: 33 51 5 4 13
The combined list is 3 5 45 4 3 33 51 5 4 13
*/
import java.util.ArrayList;
import java.util.Arrays;

public class E1114{
    public static void main(String[] args){
        Integer[] array1 = {2, 3, 1, 5};
        Integer[] array2 = {4, 5, 7, 90};
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
        ArrayList<Integer> list = union(list1, list2);
        System.out.println(list);
    }

    public static ArrayList<Integer> union( ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }
}
