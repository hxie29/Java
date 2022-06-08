package c10_ObjectOrientedThinking;

import java.math.BigInteger;

// (Divisible by 2 or 3) Find the first 10 numbers with 50 decimal digits that are divisible by 2 or 3.
public class E1016 {
    public static void main(String[] args){
        BigInteger n = new BigInteger("1000000000000000000000000000000000000000000000000");
        BigInteger[] group = new BigInteger[10];
        int count = 0;
        while (count < 10){
            if (divisible(n)) {
                group[count] = n;
                count++;
            }
            n = n.add(new BigInteger("1"));
        }
        printBigInteger(group);
    }

    public static boolean divisible(BigInteger n){
        BigInteger z  = new BigInteger("0");
        BigInteger x = new BigInteger("2");
        BigInteger y = new BigInteger("3");
        return (z.compareTo(n.remainder(x)) == 0 || z.compareTo(n.remainder(y)) == 0);
    }

    public static void printBigInteger(BigInteger[] group) {
        for (BigInteger bigInteger : group) {
            System.out.println(bigInteger);
        }
    }
}
