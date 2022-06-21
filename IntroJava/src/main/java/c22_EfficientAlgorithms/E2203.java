/*(Pattern matching) Write an O(n) time program that prompts the user to enter
two strings and tests whether the second string is a substring of the first string.
Suppose the neighboring characters in the string are distinct. (Don’t use the
indexOf method in the String class.) Here is a sample run of the program:
Enter a string s1: Welcome to Java
Enter a string s2: come
matched at index 3 */
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E2203 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string s1:");
        String s1 = input.nextLine();
        System.out.println("Enter a string s2:");
        String s2 = input.nextLine();

        int index = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            // check letter
            if (s2.charAt(0) == s1.charAt(i) && count == 0) {
                index = i;
                count = 1;
            }
            else if (s2.charAt(count) == s1.charAt(i)) {
                count++;
            }
            else {
                count = 0;
                index = -1;
            }

            // s2 is exhausted
            if (count == s2.length())
                break;
        }

        System.out.println((index == -1) ? "Not a sub string" : "matched at index " + index);
    }
}
