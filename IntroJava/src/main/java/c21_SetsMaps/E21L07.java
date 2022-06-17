// Counting keywords
package c21_SetsMaps;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class E21L07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file: ");
        String fileName = input.nextLine();
        input.close();

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("The number of Java keywords in " + fileName + " is " + countKey(file));
        }
        else
            System.out.println("File does not exist.");
    }

    private static int countKey(File file) {
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
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String word = input.next();
                if (keySet.contains(word))
                    count++;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }
}
