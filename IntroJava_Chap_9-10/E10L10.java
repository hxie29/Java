//Write a new program that ignores nonalphanumeric characters in checking whether a string is a palindrome.

import java.util.Scanner;
public class E10L10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string:");
        String s = input.nextLine();

        System.out.println(s + " is palindrome?" + isParlindrome(s));
        input.close();
    }

    public static boolean isParlindrome(String s) {
        String s1 = filter(s);

        String s2 = reverse(s1);

        return (s1 == s2);
    }

    public static String filter(String s) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                string.append(s.charAt(i));
            }
        }
        return string.toString();
    }

    public static String reverse(String s) {
        StringBuilder string = new StringBuilder(s);
        string.reverse();
        return string.toString();
    }
    
}
