/* (Sum ArrayList) Write the following method that returns the sum of all numbers
in an ArrayList:
public static double sum(ArrayList<Double> list)
Write a test program that prompts the user to enter five numbers, stores them in
an array list, and displays their sum.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class E1112{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        System.out.println("Enter a list of Doubles, ending with 0:");
        double value;
        do{
            value = input.nextDouble();
            if (value !=0) list.add(value);
        }while (value != 0);
        System.out.println(list.toString());
        shuffle(list);
        System.out.println(list.toString());
        sort(list);
        System.out.println(list.toString());
        System.out.println(sum(list));
        input.close();

    }

    public static void shuffle(ArrayList<Double> list){
        java.util.Collections.shuffle(list);
    }

    public static void sort(ArrayList<Double> list){
        java.util.Collections.sort(list);
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i <list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
