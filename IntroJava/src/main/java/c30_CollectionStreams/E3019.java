/*(Summary information) Suppose the file test.txt contains floating-point numbers
separated by spaces. Write a program to obtain the sum, average, maximum, and
minimum of the numbers.*/
package c30_CollectionStreams;

import java.io.File;
import java.util.*;

public class E3019 {
    public static void main(String[] args) {
        Scanner input0 = new Scanner(System.in);
        System.out.println("Enter text files path: ");
        String fileName = input0.nextLine();
        input0.close();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
        }

        else {
            ArrayList<Double> list = new ArrayList<>();
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    list.add(Double.parseDouble(input.next()));
                }
            }

            catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Average is " + list.stream().mapToDouble(Double::doubleValue).average().getAsDouble());
        }
    }
}
