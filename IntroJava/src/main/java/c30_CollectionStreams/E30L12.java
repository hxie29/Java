package c30_CollectionStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class E30L12 {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java source file:");
        String fileName = input.nextLine();

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(1);
        }
        else {
            System.out.println("The number of keywords in " + fileName + " is " + countKW(file));
        }

    }
    private static long countKW(File file) throws IOException {
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int", "interface",
                "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Set<String> keySet = new HashSet<>(Arrays.asList(keywordString));

        return Files.lines(file.toPath()).parallel().mapToLong(line ->
                Stream.of(line.split("[\\s+]")).filter(keySet::contains).count()).sum();
    }
}
