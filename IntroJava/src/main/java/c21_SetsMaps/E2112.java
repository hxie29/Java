/*(Name for both genders) Write a program that prompts the user to enter one of the
filenames described in Programming Exercise 12.31 and displays the names that
are used for both genders in the file. Use sets to store names and find common
names in two sets. Here is a sample run:

Enter a file name for baby name ranking: babynamesranking2001.txt
69 names used for both genders
They are Tyler Ryan Christian ...*/
package c21_SetsMaps;

import java.io.File;
import java.util.*;

public class E2112 {
    private static final Set<String> boyList = new HashSet<>();
    private static final Set<String> girlList = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Enter a file name for baby name ranking:");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        File file = new File("/Users/halda/Documents/GitHub/Java/IntroJava/src/main/java/c12_ExceptionTextIO/test/" + fileName);
        getData(file);
        boyList.retainAll(girlList);
        System.out.println(boyList.size() + " names used for both genders\nThey are ");
        boyList.forEach(e -> System.out.print(e + " "));
    }
    private static void getData(File file) {
        if (!file.exists()) {
            System.out.println("Ranking file does not exist, please download");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {
                    String[] words = input.nextLine().split("\\s+");
                    boyList.add(words[1]);
                    girlList.add(words[3]);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
