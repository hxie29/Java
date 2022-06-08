package C11_InheritancePolymorphism;

import java.util.ArrayList;
import java.util.Scanner;

public class E1107{
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
        System.out.println("Max value is: " + max(list));
        shuffle(list);
        System.out.println(list);
        input.close();

    }

    public static Integer max(ArrayList<Integer> list){
        Integer max = list.get(0);
        for (Integer integer : list) {
            if (max - integer < 0) {
                max = integer;
            }
        }
        return max;
    }

    public static void shuffle(ArrayList<Integer> list){
        java.util.Collections.shuffle(list);
    }
}
