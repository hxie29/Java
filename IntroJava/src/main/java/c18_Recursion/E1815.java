/*(Occurrences of a specified character in a string) Rewrite Programming Exercise
18.10 using a helper method to pass the substring high index to the method.
The helper method header is
public static int count(String str, char a, int high)*/
package c18_Recursion;

public class E1815 {
    public static void main(String[] args) {
        String str = "Welcome to Java";
        System.out.println(count(str.toLowerCase(),'a',str.length()));
    }
    public static int count(String str, char a, int high) {
        if (high == 0)
            return 0;
        else {
            return ((str.charAt(high - 1) == a) ? 1 : 0) + count(str, a, high - 1);
        }
    }
}
