/* (Replace text) Listing 12.16, ReplaceText.java, gives a program that replaces
text in a source file and saves the change into a new file. Revise the program to
save the change into the original file. For example, invoking
java Exercise12_16 file oldString newString
*/
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
public class E1214 {
    public static void main(String[] args) throws Exception{
        if (args.length != 3) {
            System.out.println("Usage: java E121.java filename oldString newString");
            System.exit(1);
        }

        File file = new File(args[0]);
        String oldString = args[1];
        String newString = args[2];

        if (!file.exists()) {
            System.out.println(args[1] + " does not exist.");
            System.exit(2);
        }

        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine();
                list.add(line.replaceAll(oldString, newString));
            }
        }

        System.out.println(list.toString());

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < list.size(); i++) {
                output.println(list.get(i));
            }
        }
    }

}
