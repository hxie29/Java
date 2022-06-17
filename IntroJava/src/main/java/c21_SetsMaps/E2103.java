/*(Checking whether a key exists in a set) Given a problem that is identical to the previous
Programming Exercise 21.2, write a program that displays, in ascending order,
the first names of those students who have attended more than one day of the course.
If there are students with the same first name, display their first and last names.*/

package c21_SetsMaps;

import java.io.File;
import java.util.*;

public class E2103 {
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

        //Sort in ascending order
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
        //Put the only names into a set
        Set<String> names = sortedMap.keySet();
        //Map out the first name occurrences
        LinkedHashMap<String, Integer> dupFirstName = new LinkedHashMap<>();
        names.forEach(s -> {
            String[] name = s.split(" ");
            dupFirstName.put(name[0], dupFirstName.containsKey(name[0]) ? dupFirstName.get(name[0]) + 1 : 1);
        });

        //Display results
        sortedMap.forEach((k,v) -> {
            if (v > 1) {
                String[] name = k.split(" ");
                if (dupFirstName.get(name[0]) > 1)
                    System.out.println(k);
                else
                    System.out.println(k.split(" ")[0]);
            }
        });
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
