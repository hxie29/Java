package c06_Methods;

import java.util.Scanner;
public class E0620

 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a a string ");
        String s = input.nextLine();

        System.out.println("The number of letters in this string is " + countLetter(s));
        input.close();

    }

    public static int countLetter(String s) {
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
