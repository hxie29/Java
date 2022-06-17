// occurences of words
package c21_SetsMaps;

import java.util.*;

public class E21L09 {
    public static void main(String[] args) {
        String text = "Good morning, have a good class."  + "Have a good visit. Have fun!";
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\\s+\\p{P}]");
        for (String word : words) {
            String key = word.toLowerCase();
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new OccurrenceComparator());
        list.forEach(System.out::println);
    }
}

