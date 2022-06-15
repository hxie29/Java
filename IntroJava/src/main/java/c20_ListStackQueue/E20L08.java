// Sorting String ignore cases
//Comparator.comparing(ClassName:: data value);
package c20_ListStackQueue;

import c17_BinaryIO.Loan;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E20L08 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Atlanta", "New York", "Dallas");
        cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        //Alternative: method reference
        cities.sort(String::compareToIgnoreCase);

        Loan[] list = {new Loan(5.5, 10,2323), new Loan (5, 10, 1000)};
        Arrays.sort(list, Comparator.comparing(Loan::getLoanAmount));
        for (Loan l: list)
            System.out.println(l);
        Arrays.sort(list, Comparator.comparing(Loan::getAnnualInterestRate).reversed());
        for (Loan l: list)
            System.out.println(l);
    }
}
