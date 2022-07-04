/*(Count consonants and vowels) Rewrite Programming Exercise 21.4 using
streams.*/
/*(Count consonants and vowels) Write a program that prompts the user to enter a
text file name and displays the number of vowels and consonants in the file. Use
a set to store the vowels A, E, I, O, and U.*/

package c30_CollectionStreams;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class E3017 {
    public static void main(String[] args) {
        Scanner input0 = new Scanner(System.in);
        System.out.println("Enter text files path: ");
        String fileName = input0.nextLine();
        input0.close();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        else {
            Set<Character> vowelSet = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
            StringBuilder str = new StringBuilder();
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    str.append(input.nextLine());
                }
            }

            catch (Exception ex) {
                ex.printStackTrace();
            }

            str.toString().toUpperCase().chars().mapToObj(e -> (char)e).filter(vowelSet::contains).collect(Collectors.groupingBy(e ->
                    e, HashMap:: new, Collectors.counting())).forEach((k,v) -> System.out.println(k + " appears " + v + " times"));
        }
    }
}

