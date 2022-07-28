/*(Weighted 4 * 4 16 tails) Revise Listing 29.9, WeightedNineTail.java, for the
weighted 4 * 4 16 tails problem. Your program should read the model object
created from the preceding exercise.*/
package c29_WeightedGraphs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class E2907 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(""));
            SixteenTailModelWeighted model = (SixteenTailModelWeighted)input.readObject();
        }
        finally {
            System.out.println("Done.");
        }
   }
}
