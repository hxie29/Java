package c17_BinaryIO;/* The Serializable interface is a marker interface. Since it has no methods, you don’t need
to add additional code in your class that implements Serializable. Implementing this interface
enables the Java serialization mechanism to automate the process of storing objects and arrays.
To appreciate this automation feature, consider what you otherwise need to do in order to
store an object. Suppose that you wish to store an ArrayList object. To do this, you need to
store all the elements in the list. Each element is an object that may contain other objects. As
you can see, this would be a very tedious process. Fortunately, you don’t have to go through
it manually. Java provides a built-in mechanism to automate the process of writing objects.
This process is referred as object serialization, which is implemented in ObjectOutputStream.
In contrast, the process of reading objects is referred as object deserialization, which is implemented
in ObjectInputStream.

An array is serializable if all its elements are serializable. An entire array can be saved into a file using
writeObject and later can be restored using readObject. Listing 17.7 stores an array of five int
values and an array of three strings, and reads them back to display on the console.
*/

import java.io.*;

public class E17L07 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] names = {"John", "Susan", "Kim"};

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true))) {
            output.writeObject(numbers);
            output.writeObject(names);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"))) {
            //need to cast object into specific class
            int[] newNumbers = (int[]) (input.readObject());
            String[] newNames = (String[]) (input.readObject());

            for (int number: newNumbers) System.out.print(number + " ");
            System.out.println();
            for (String name: newNames) System.out.print(name + " ");
            System.out.println();
        }
    }  
}
