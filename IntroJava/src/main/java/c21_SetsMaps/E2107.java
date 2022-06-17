/*(Revise Listing 21.9, CountOccurrenceOfWords.java) Rewrite Listing 21.9 to
display the words in ascending order of occurrence counts.*/
package c21_SetsMaps;

import java.util.Map;
import java.util.TreeMap;

public class E2107 {
    public static void main(String[] args) {
        String text = "Good morning, have a good class."  + "Have a good visit. Have fun!";
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        map.forEach((k,v) -> System.out.println(k + "\t" + v));
    }
}
