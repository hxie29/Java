// Directory size
package com.example.recursion;

import java.io.File;

public class E18L07 {
    public static void main(String[] args) {
        String directory = "/Users/halda/Desktop/piano score";
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public  static long getSize(File file) {
        long size = 0;
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]);
            }
        }
        else
            size += file.length();

        return size;
    }

}
