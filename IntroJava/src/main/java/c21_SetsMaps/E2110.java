/*(Count the occurrences of each keyword) Rewrite Listing 21.7, CountKeywords.
java to read in a Java source-code file and count the occurrence of each keyword
in the file, but don’t count the keyword if it is in a comment or in a string literal.*/
package c21_SetsMaps;

import java.io.File;
import java.util.*;

public class E2110 {
    private static final String regex = "[\\s+\\p{P}]";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text file path: ");
        String fileName = input.nextLine();
        input.close();

        File file = new File(fileName);
        System.out.println("Key words count: " + count(file));
    }

    private static int count (File file) {
        int count = 0;
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int", "interface",
                "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};
        Set<String> keySet = new HashSet<>(Arrays.asList(keywordString));

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String line = input.nextLine().toLowerCase();
                    String[] words = line.split(regex);
                    // Delete words that are in comment or in string literals
                    boolean ignore = false;
                    //String literals
                    for (String key : words) {
                    // Reverse ignore boolean value if // or /* or " appears
                        if (key.contains("//") || key.contains("/*") || key.contains("*/") || key.contains("\""))
                            ignore = !ignore;
                        if (keySet.contains(key))
                            count++;
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }
}
