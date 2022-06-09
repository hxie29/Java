package c12_ExceptionTextIO;/*
(Reformat Java source code) Write a program that converts the Java source
code from the next-line brace style to the end-of-line brace style. For example,
the following Java source in (a) uses the next-line brace style. Your program
converts it to the end-of-line brace style in (b).

Your program can be invoked from the command line with the Java source-code
file as the argument. It converts the Java source code to a new format. For example,
the following command converts the Java source-code file Turtle.java to
the end-of-line brace style.
java Exercise12_12 Turtle.java

*/

import java.io.File;
import java.util.Scanner;

public class E1213 {
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

        int countLine = 0;
        int countChar = 0;
        int countWord = 0;
        try(Scanner input = new Scanner(file)){
            while (input.hasNextLine()) {
                String s0 = input.nextLine();
                countChar += s0.length();
                countLine++;
            }
        }
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String next = input.next();
                countWord++;
            }
        }
        System.out.println("File " + args[0] + "has:");
        System.out.println("Lines: " + countLine);
        System.out.println("Words: " + countWord);
        System.out.println("Characters: " + countChar);
    }
}
