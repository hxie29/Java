/*(Implement hashCode for string) Write a method that returns a hash code for string
using the approach described in Section 27.3.2 with b value 31. The function
header is as follows:
public static int hashCodeForString(String s)*/
package c27_Hashing;

public class E2709 {
    public static void main(String[] args) {
        System.out.println("Hashcode for welcome is " + hashCodeForString("welcome"));
    }

    /*A better approach is to generate a hash code that takes the position of characters into consideration.
Specifically, let the hash code be s0 * b^(n-1) + s1 * b^(n-2) + g + sn-1
where si is s.charAt(i). This expression is a polynomial for some positive b, so this is called
a polynomial hash code. Using Horner’s rule for polynomial evaluation (see Section 6.7), the
hash code can be calculated efficiently as follows:
(...((s0 * b + s1) * b + s2) * b + g + sn-2) * b + sn-1
This computation can cause an overflow for long strings, but arithmetic overflow is ignored in
Java. You should choose an appropriate value b to minimize collisions. Experiments show that
good choices for b are 31, 33, 37, 39, and 41. In the String class, the hashCode is overridden
using the polynomial hash code with b being 31. */
    public static int hashCodeForString(String s) {
        int code = 0;
        final int B = 31;
        for (int i = 0; i < s.length(); i++) {
            code = code * B + s.charAt(i);
        }
        return code;
    }
}
