/*(Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to
display the words in ascending order of occurrence counts.*/
package c21_SetsMaps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E2107 {
    private static final String regex = "[\\s+\\p{P}]";
    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter text files' paths per line, enter 0 to exist: ");
            String fileName = input.nextLine();
            if (fileName.length() == 1 && fileName.charAt(0) == '0')
                break;
            else
                count(new File(fileName));
        }
        input.close();
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        treeMap.forEach((k,v) -> System.out.println(k + "\t" + v));
    }

    private static void count(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String line = input.nextLine().toLowerCase();
                    String[] words = line.split(regex);
                    for (String key : words) {
                        if (!Character.isDigit(key.charAt(0)))
                            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
