/*(Occurrences of a specified character in a string) Write a recursive method that
finds the number of occurrences of a specified letter in a string using the following
method header:
public static int count(String str, char a)
For example, count("Welcome", 'e') returns 2. Write a test program that
prompts the user to enter a string and a character, and displays the number of
occurrences for the character in the string.*/
package c18_Recursion;

public class E1810 {
    public static void main(String[] args) {
        String str = "Welcome to Java";
        System.out.println(count(str.toLowerCase(),'w'));
    }
    public static int count(String str, char a) {
        if (!str.contains(a + ""))
            return 0;
        else {
            StringBuilder s = new StringBuilder(str);
            int index = s.indexOf("" + a);
            s.deleteCharAt(index);
            return 1 + count(s.toString(), a);
        }
    }
}
