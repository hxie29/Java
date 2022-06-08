package c04_FunctionsCharString;

import java.util.Scanner;

public class E0412 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a hex digit: ");
        char number = Character.toUpperCase((input.nextLine()).charAt(0));
        
        int d;

        if (number >= 'A' && number <='F') {
             d = number - 'A' + 10;
        }
        else {
            d = number -'0';
        }

        System.out.print("The binary value is ");

        switch (d) {
            case 0 -> System.out.println("0000");
            case 1 -> System.out.println("0001");
            case 2 -> System.out.println("0010");
            case 3 -> System.out.println("0011");
            case 4 -> System.out.println("0100");
            case 5 -> System.out.println("0101");
            case 6 -> System.out.println("0110");
            case 7 -> System.out.println("0111");
            case 8 -> System.out.println("1000");
            case 9 -> System.out.println("1001");
            case 10 -> System.out.println("1010");
            case 11 -> System.out.println("1011");
            case 12 -> System.out.println("1100");
            case 13 -> System.out.println("1101");
            case 14 -> System.out.println("1110");
            case 15 -> System.out.println("1111");
        }

        input.close();
    }
}
