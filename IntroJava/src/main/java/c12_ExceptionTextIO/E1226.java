package c12_ExceptionTextIO;/*
(Create a directory) Write a program that prompts the user to enter a directory
name and creates a directory using the File’s mkdirs method. The program
displays the message “Directory created successfully” if a directory is created
or “Directory already exists” if the directory already exists.
*/

import java.io.File;
import java.util.Scanner;
public class E1226 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a directory name:");
        (new File(input.next())).mkdir();
        input.close();
    }
}
