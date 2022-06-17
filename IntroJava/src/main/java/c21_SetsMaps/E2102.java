/*(Display nonduplicate names in ascending order) Given one or more text files,
each representing a day’s attendance in a course and containing the names of the
students who attended the course on that particular day, write a program that displays,
in ascending order, the names of those students who have attended at least
one day of the course. The text file(s) is/are passed as command-line argument(s).*/
package c21_SetsMaps;

import edu.princeton.cs.introcs.In;

import java.io.File;
import java.util.*;

public class E2102 {
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

        //Display results
        TreeMap<String, Integer>  sortedMap = new TreeMap<>(map);
        sortedMap.forEach((k,v) -> System.out.println("Name: " + k + " times: " + v));
    }

    private static void count(File file) {
        if (!file.exists()) {
            System.out.println("File does not exist.");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String name = input.nextLine();
                    map.put(name, map.containsKey(name) ? map.get(name) + 1 : 1);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
