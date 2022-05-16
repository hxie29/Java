// Test File class
import java.io.File;
public class test {
    public static void main(String[] args) throws Exception {
        File file = new File ("test");
        if (!file.exists()) file.createNewFile();
        File[] list = file.getCanonicalFile().listFiles();
        System.out.println(list[0].toString());
    }
}
