import java.util.ArrayList;

import java.util.Scanner;
public class E1104 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter a list of integers, ending with 0:");
        int value;
        do{
            value = input.nextInt();
            if (value !=0) list.add(value);
        }while (value != 0);
        System.out.println("Max value is: " + max(list));
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
}
