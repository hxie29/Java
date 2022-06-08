package c12_ExceptionTextIO;/*
(Reformat Java source code) Write a program that converts the Java source
code from the next-line brace style to the end-of-line brace style. For example,
the following Java source in (a) uses the next-line brace style. Your program
converts it to the end-of-line brace style in (b).

Your program can be invoked from the command line with the Java source-code
file as the argument. It converts the Java source code to a new format. For example,
the following command converts the Java source-code file Test.java to
the end-of-line brace style.
java Exercise12_12 Test.java

*/

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class E1212 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1 || !args[0].endsWith(".java")) {
            System.out.println("Usage: ***.java");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File does not exists.");
            System.exit(2);
        }

        ArrayList<String> text = new ArrayList<>();
        Scanner input = new Scanner(file);
        String s0 = input.nextLine();
        while (input.hasNextLine()) {
            String s1 = input.nextLine();
            if (s1.endsWith("{")) {
                s0 += "{";
                text.add(s0);
                s0 = input.nextLine();
            }
            else {
                text.add(s0);
                s0 = s1;
            }
        }
        text.add(s0);

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < text.size(); i++) {
                output.println(text.get(i));
            }
        }

        input.close();
    }
}
