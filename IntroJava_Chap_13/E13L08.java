/*
The compareTo method determines the order of this object with the specified object o and
returns a negative integer, zero, or a positive integer if this object is less than, equal to, or
greater than o.
The Comparable interface is a generic interface. The generic type E is replaced by a
concrete type when implementing this interface. Many classes in the Java library implement
Comparable to define a natural order for objects. The classes Byte, Short, Integer, Long,
Float, Double, Character, BigInteger, BigDecimal, Calendar, String, and Date
all implement the Comparable interface. For example, the Integer, BigInteger, String,
and Date classes are defined as follows in the Java API:
*/
import java.math.BigInteger;
import java.util.Arrays;
public class E13L08 {
    public static void main(String[] args) {
        String[] cities = {"London", "Atlanta", "New York"};
        Arrays.sort(cities);
        for (String city: cities) {
            System.out.println(city + " ");
        }

        BigInteger[] numbers = { new BigInteger("233420495801371"), new BigInteger("4312954019231")};
        Arrays.sort(numbers);
        for (BigInteger number: numbers) {
            System.out.println(number + " ");
        }
    }
}
