import java.util.ArrayList;
import java.util.Scanner;
public class E11L09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter integers (input ends with 0): ");
        int value;

        do {
            value = input.nextInt();
            if (!list.contains(value) && value != 0) {
                list.add(value);
            }

        }while (value !=0);

        System.out.println(list.toString());

        input.close();
    }
}
