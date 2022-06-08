/*
(Create a directory) Write a program that prompts the user to enter a directory
name and creates a directory using the File’s mkdirs method. The program
displays the message “Directory created successfully” if a directory is created
or “Directory already exists” if the directory already exists.
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class E1229 {
    public static void main(String[] args) throws Exception{
        ArrayList<File> list = new ArrayList<>();
        addFiles(list, args);
        //System.out.println(list.size());

        pad(list);
    }

    public static void addFiles(ArrayList<File> list, String[] args) {
		for (int i = 0; i < args.length; i ++) {
			if (!args[i].equals("Exercise12_27.java") && !args[i].equals("Exercise12_27.class")) {
				list.add(new File(args[i]));
			}
		}
	}

    public static void pad(ArrayList<File> list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder name = new StringBuilder (list.get(i).getName());
            int dashIndex = name.indexOf("_");
            if (dashIndex == -1) continue;
            if (dashIndex + 2 > name.length() - 1) {
                name.insert(dashIndex + 1, "0");
            }
            if (!Character.isDigit(name.charAt(dashIndex + 2))) {
                name.insert(dashIndex + 1, "0");
            }
            list.get(i).renameTo(new File (name.toString()));
        }
    }
}
