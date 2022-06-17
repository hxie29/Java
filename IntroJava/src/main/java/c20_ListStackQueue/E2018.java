/*(Directory size) Listing 18.10, DirectorySize.java, gives a recursive method
for finding a directory size. Rewrite this method without using recursion. Your
program should use a queue to store the subdirectories under a directory. The
algorithm can be described as follows:
long getSize(File directory) {
long size = 0;
add directory to the queue;
while (queue is not empty) {
Remove an item from the queue into t;
if (t is a file)
size += t.length();
else
add all the files and subdirectories under t into the
queue;
}
return size;
}*/
package c20_ListStackQueue;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class E2018 {
    public static void main(String[] args) {
        String directory = "/Users/halda/Desktop/piano score";
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    public static long getSize(File file) {
        long size = 0;
        if (file.exists()){
            Queue<File> queue = new LinkedList<>();
            queue.offer(file);
            while (!queue.isEmpty()) {
                File t = queue.poll();
                if (t.isDirectory()) {
                    File[] files = t.listFiles();
                    if (files.length > 0) {
                        for (File e: files)
                            queue.offer(e);
                    }
                }
                else
                    size += t.length();
            }
        }
        return size;
    }
}
