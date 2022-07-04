/*(Count the occurrences of words in a text file) Rewrite Programming Exercise
21.8 using streams.*/

package c30_CollectionStreams;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E3018 {
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
            StringBuilder str = new StringBuilder();
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    str.append(input.nextLine());
                }
            }

            catch (Exception ex) {
                ex.printStackTrace();
            }
            String[] words = str.toString().split(" ");
            Stream.of(words).filter(e -> Character.isLetter(e.charAt(0))).collect(Collectors.groupingBy(e ->
                    e, TreeMap:: new, Collectors.counting())).forEach((k,v) -> System.out.println(k + " appears " + v + " times"));
        }
    }
}

