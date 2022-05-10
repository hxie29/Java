import java.math.BigInteger;

/* (Large prime numbers) Write a program that finds five prime numbers larger than Long.MAX_VALUE.
*/
public class E1018 {
    public static void main(String[] args){
        BigInteger n = new BigInteger(Long.MAX_VALUE + "");
        n = n.add(new BigInteger("1"));
        BigInteger[] group = new BigInteger[5];
        int count = 0;
        while (count < group.length){
            if (isPrime(n)) {
                group[count] = n;
                count++;
                }
            }
        printBigInteger(group);
        }

    public static void printBigInteger(BigInteger[] group) {
        for (int i =0; i< group.length; i++) {
            System.out.println(group[i]);
        }
    }

    public static boolean isPrime(BigInteger n) {
        BigInteger d = new BigInteger("2");
        BigInteger z  = new BigInteger("0");
        while (d.compareTo(n) == -1){
            if (z.compareTo(n.remainder(d)) == 0 ){
                return false;
            }
            else {
                d = d.add(new BigInteger("1"));
            }
        }
        return true;
    }
}
