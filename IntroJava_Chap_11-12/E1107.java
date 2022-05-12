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
        System.out.println(list.toString());
        System.out.println("Max value is: " + max(list));
        shuffle(list);
        System.out.println(list.toString());
        input.close();

    }

    public static Integer max(ArrayList<Integer> list){
        Integer max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (max - list.get(i) < 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void shuffle(ArrayList<Integer> list){
        java.util.Collections.shuffle(list);
    }
}
