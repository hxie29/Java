package c32_Muiltithreading;

public class PrimeUtil {
    public static boolean isPrime(long number) {
        if (number <= 1 || number %2 == 0)
            return false;
        int upperDivisor = (int)Math.ceil(Math.sqrt(number));
        for (int i = 3; i <= upperDivisor; i+=2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
