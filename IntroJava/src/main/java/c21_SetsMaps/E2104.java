/*(Count consonants and vowels) Write a program that prompts the user to enter a
text file name and displays the number of vowels and consonants in the file. Use
a set to store the vowels A, E, I, O, and U.*/

package c21_SetsMaps;

import java.io.File;
import java.util.*;

public class E2104 {
    private static final Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text files path: ");
        String fileName = input.nextLine();
        input.close();
        count(new File(fileName));
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap);
    }

    private static void count(File file) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    for (int i = 0; i < line.length(); i++) {
                        char letter = Character.toUpperCase(line.charAt(i));
                        if (vowelSet.contains(letter))
                            map.put(letter, map.containsKey(letter) ? map.get(letter) + 1 : 1);
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
