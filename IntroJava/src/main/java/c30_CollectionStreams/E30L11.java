package c30_CollectionStreams;

import java.io.File;
import java.nio.file.Files;

public class E30L11 {
    public static void main(String[] args) {
        String directory = "/Users/halda/Desktop/piano score";
        System.out.println(getSize(new File(directory)) + " bytes");
    }

    private static long getSize(File file) {
        if (file.isDirectory()) {
            try {
                return Files.list(file.toPath()).parallel().mapToLong(e -> getSize(e.toFile())).sum();
            }
            catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        else
            return file.length();
    }
}
