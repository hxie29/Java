package c10_ObjectOrientedThinking;

/* (New string split method) The split method in the String class returns an
array of strings consisting of the substrings split by the delimiters. However, the
delimiters are not returned. Implement the following new method that returns
an array of strings consisting of the substrings split by the matching delimiters,
including the matching delimiters.
public static String[] split(String s, String regex)
For example, split("ab#12#453", "#") returns ab, #, 12, #, and 453 in
an array of String and split("a?b?gf#e", "[?#]") returns a, ?, b, ?, gf,
#, and e in an array of String.
*/
public class E1025 {
    public static void main(String[] args){
        String s = "ab#12#453";
        String regex  = "#";
        String[] split0 = split(s, regex);
        for (String value : split0) {
            System.out.println(value);
        }
    }

    public static String[] split(String s, String regex){
        String[] split1 = s.split(regex);
        String[] split2 = new String[split1.length * 2 - 1];
        for (int i = 0; i < split1.length; i++) {
            split2[2 * i] = split1[i];
            if (i < split1.length -1) split2[2 * i + 1] = regex;
        }
        return split2;
    }
}
