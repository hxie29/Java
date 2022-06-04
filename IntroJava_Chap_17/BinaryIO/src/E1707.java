/* (Store Loan objects) The Loan class in Listing 10.2 does not implement
Serializable. Rewrite the Loan class to implement Serializable. Write
a pro gram that creates five Loan objects and stores them in a file named
Exercise17_06.dat.
*/

import java.io.*;

public class E1707 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Loan[] loans = new Loan[5];
        for (int i = 0; i < loans.length; i++) {
            loans[i] = new Loan(5.2, 2 + i, 1000 * (i +1));
        }        

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("E17_07.dat", false))) {
            for (Loan loan: loans) {
                output.writeObject(loan);
            }
        }

       try {

           try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("E17_07.dat"))) {
               //need to cast object into specific class
               while (true) {
                   Loan newLoans = (Loan)(input.readObject());
                   System.out.println("Total loan amount is " + newLoans.getLoanAmount());
               }
           }
       }

       catch (EOFException ex) {
           System.out.println("Done");
       }
    }  
}
