/*Write a program that prompts the user for a path and displays the directory structure
on the command tool as follows:
 testdir
+--f1
+--d2
    +--d22
        +--f221
    +--f21
    +--d21
        +--f212
        +--f211
+--f2
+--d1
    +--f12

An example of a testdir directory with
two directories d1 and d2 and two files
f1 and f2. The directory d1 has one file
f12, and so on.
Hint: To do this, you will have to use
java.io.File.
*/
package c18_Recursion;

import java.io.File;
import java.io.IOException;

public class E1829 {
    public static void main(String[] args) {
        String directory = "/Users/halda/Desktop/piano score";
        printDir(new File(directory), 0);
    }

    public static void printDir(File file, int layer){
        for (int i = 1; i < layer; i++) {
            System.out.print("\t");
        }
        System.out.println("+--" + file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                printDir(files[i], layer + 1);
            }
        }
    }
}
