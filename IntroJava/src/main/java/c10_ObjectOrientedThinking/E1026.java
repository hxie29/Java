package c10_ObjectOrientedThinking;/* (New string split method) The split method in the String class returns an
array of strings consisting of the substrings split by the delimiters. However, the
delimiters are not returned. Implement the following new method that returns
an array of strings consisting of the substrings split by the matching delimiters,
including the matching delimiters.
public static String[] split(String s, String regex)
For example, split("ab#12#453", "#") returns ab, #, 12, #, and 453 in
an array of String and split("a?b?gf#e", "[?#]") returns a, ?, b, ?, gf,
#, and e in an array of String.
*/
import java.util.Scanner;
public class E1026 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        StringBuilder s = new StringBuilder(input.nextLine());

        //Delete all spaces and ""
        int n = 0;
        while(n < s.length()) {
            if (s.charAt(n) == ' ' || s.charAt(n) == '"') s.deleteCharAt(n);
            else n++;
        }
        //Convert to string
        String str0 = s.toString();
        String[] str = new String[str0.length()];

        //Conver to String[];
        for (int i = 0; i< str0.length(); i++) {
            str[i] = "" + str0.charAt(i);
        }


        if (str.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }
        
        
        int result = switch (str[1].charAt(0)) {
            case '+' -> Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
            case '-' -> Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
            case '.' -> Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
            case '/' -> Integer.parseInt(str[0]) / Integer.parseInt(str[2]);
            default -> 0;
        };

        // Display result
        System.out.println(str[0] + ' ' + str[1] + ' ' + str[2] + " = " + result);
    }
}
