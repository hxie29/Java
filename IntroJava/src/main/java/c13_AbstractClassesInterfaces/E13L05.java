package c13_AbstractClassesInterfaces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/*
With Number defined as the superclass for the numeric classes, we can define methods to
perform common operations for numbers. Listing 13.5 gives a program that finds the largest
number in a list of Number objects.
*/
public class E13L05 {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(45); // 45 is added as Integer (wrapper)
        list.add(3445.53); // 3445.53 is added as Double (wrapper)
        list.add(new BigInteger("34323232323432141"));
        list.add(new BigDecimal("2.0948305900121"));

        System.out.println("The largest number is " + getLargest(list));
    }  

    public static Number getLargest(ArrayList<Number> list) {
        if (list == null || list.size() == 0) 
            return null;
        Number number = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (number.doubleValue() < list.get(i).doubleValue())
                number = list.get(i);
        }
        return number;
    }
}
