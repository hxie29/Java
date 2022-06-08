package c10_ObjectOrientedThinking;

import java.math.BigInteger;

/*(Square numbers) Find the first 10 square numbers that are greater than Long.
MAX_VALUE. A square number is a number in the form of n2. For example, 4, 9,
and 16 are square numbers. Find an efficient approach to run your program fast.
*/
public class E1017 {
    public static void main(String[] args){
        long n = Long.MAX_VALUE;
        BigInteger root = new BigInteger(((long)Math.pow(n, 0.5) + 1 ) + "");
        BigInteger[] group = new BigInteger[10];
        int count = 0;
        for (int i = 0; i < 10; i++){
            group[count] = root.multiply(root);
            count++;
            root = root.add(new BigInteger("1"));
            }
        printBigInteger(group);
        }

    public static void printBigInteger(BigInteger[] group) {
        for (BigInteger bigInteger : group) {
            System.out.println(bigInteger);
        }
    }
}
