package c12_ExceptionTextIO;/* (Writing in a sorted file) Write a method public static int
writeInFile(String name, File file) that writes name at its correct
position in file so that it fulfills the assumptions given in Programming Exercise
12.14. The method returns the line position of the name.
*/
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
public class E1215 {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("Usage: java E1215.java line filename");
            System.exit(1);
        }
        String line = args[0];

        File file = new File(args[1]);
        if (!file.exists()) {
            System.out.println(args[1] + " does not exist.");
            System.exit(2);
        }

        System.out.println(line + " is inserted in file " + args[1] + " at line : " + writeInFile(line, file));
        
    }
    
    public static int writeInFile(String line, File file) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String name = input.nextLine();
                list.add(name);
            }
        }

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (line.compareTo(list.get(i)) <= 0) {
                index = i;
                list.add(index, line);
                break;
            }
            
            if (line.compareTo(list.get(i)) > 0 && i == list.size() - 1) {
                list.add(line);
            }
        }

        try (PrintWriter output = new PrintWriter(file)) {
            for (String s : list) {
                output.println(s);
            }
        }

        return index;
    }

}
