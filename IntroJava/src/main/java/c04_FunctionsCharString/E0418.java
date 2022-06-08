package c04_FunctionsCharString;

import java.util.Scanner;

public class E0418 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two characters: ");
        String chara = input.nextLine();
        char major = chara.charAt(0);
        char year = chara.charAt(1);

        if (("ICA".contains(major + "")) && (year >= '1') && (year <= '4')) {
            switch (major) {
                case 'I' -> System.out.print("Information Management ");
                case 'C' -> System.out.print("Computer Science ");
                case 'A' -> System.out.print("Accounting ");
            }
            switch (year) {
                case '1' -> System.out.println("Freshman");
                case '2' -> System.out.println("Sophomore");
                case '3' -> System.out.println("Junior");
                case '4' -> System.out.println("Senior");
            }
        }
        else {
            System.out.println("Invalid input.");
        }

        input.close();
    }
}
