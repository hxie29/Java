import java.util.Scanner;
import java.lang.Integer;

public class test {

    public static void main(String[] agrs) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a byte integer:");
    
        int number = input.nextInt();
        System.out.println(Integer.toBinaryString(number));

        input.close();
    }

    
}
