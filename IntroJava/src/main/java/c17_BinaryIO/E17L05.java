/* Since ObjectInputStream/ObjectOutputStream contains all the functions of DataInputStream/DataOutputStream,
you can replace DataInputStream/DataOutputStream completely with ObjectInput Stream/ObjectOutputStream.

You can wrap an ObjectInputStream/ObjectOutputStream on any InputStream/
OutputStream using the following constructors:
// Create an ObjectInputStream
public ObjectInputStream(InputStream in)
// Create an ObjectOutputStream
public ObjectOutputStream(OutputStream out)
*/

import java.io.*;
import java.util.Date;

public class E17L05 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeObject(new Date());
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"))) {
            String name = input.readUTF();
            double score = input.readDouble();
            Date date = (Date)input.readObject();
            System.out.println(name + " " + score + " " + date);
        }
    }  
}
