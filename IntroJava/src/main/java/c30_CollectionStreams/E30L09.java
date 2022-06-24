/*The preceding example randomly generates lowercase letters and counts the occurrence of
each letter. This example counts the occurrence of each letter in a string. The program given in
Listing 30.9 prompts the user to enter the string, converts all letters to uppercase, and displays
the count of each letter in the string.*/
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E30L09 {
    private static int count;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        input.close();

        System.out.println("The occurrences of each letter are:");
        Stream.of(toCharacterArray(s.toCharArray())).filter(Character::isLetter).map(Character:: toUpperCase).collect(Collectors.groupingBy(e -> e,
                TreeMap::new, Collectors.counting())).forEach((k,v) -> System.out.print(v + " " + k + (++count % 10 == 0 ? "\n" : " ")));
    }

    private static Character[] toCharacterArray(char[] s) {
        Character[] result = new Character[s.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = s[i];
        }
        return result;
    }
}
