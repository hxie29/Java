/*(Count the occurrences of words in a text file) Rewrite Listing 21.9 to read the
text from a text file. The text file is passed as a command-line argument. Words
are delimited by whitespace characters, punctuation marks (,;.:?), quotation
marks ('"), and parentheses. Count words in case-insensitive fashion (e.g.,
consider Good and good to be the same word). The words must start with a letter.
Display the output in alphabetical order of words, with each word preceded
by its occurrence count.*/
package c21_SetsMaps;

import java.util.*;

public class E21L09 {
    public static void main(String[] args) {
        String text = "Good morning, have a good class."  + "Have a good visit. Have fun!";
        Map<String, Integer> map = new HashMap<>();

        String[] words = text.split("[\n\t\r\"'.,;:!?()]");
        for (String word : words) {
            String key = word.toLowerCase();
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new OccurrenceComparator());
        list.forEach(System.out::println);
    }
}

