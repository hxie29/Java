/* (Store Loan objects) The Loan class in Listing 10.2 does not implement
Serializable. Rewrite the Loan class to implement Serializable. Write
a pro gram that creates five Loan objects and stores them in a file named
Exercise17_06.dat.
*/

import java.io.*;

public class E1706 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Loan[] loans = new Loan[5];
        double annualInterestRate = 5.2;

        for (int i = 0; i < loans.length; i++) {
            loans[i] = new Loan(annualInterestRate, 2 + i, 1000 * (i +1));
        }
        
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("E17_06.dat"))) {
            output.writeObject(loans);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("E17_06.dat"))) {
            //need to cast object into specific class
            Loan[] newLoans = (Loan[])(input.readObject());
            for (Loan loan: newLoans)
                System.out.println(loan.toString());
        }
    }  
}
