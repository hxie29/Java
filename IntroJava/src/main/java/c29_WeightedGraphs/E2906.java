/*(Weighted 4 * 4 16 tails model) The weighted nine tails problem in the text
uses a 3 * 3 matrix. Assume that you have 16 coins placed in a 4 * 4 matrix.
Create a new model class named WeightedTailModel16. Create an instance
of the model and save the object into a file named WeightedTailModel16.dat.*/
package c29_WeightedGraphs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E2906 {
    public static void main(String[] args) throws IOException {
        SixteenTailModelWeighted model = new SixteenTailModelWeighted();
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("SixteenTailModelWeighted.dat"))) {
            output.writeObject(model);
            System.out.println("Done.");
        }
    }
}
