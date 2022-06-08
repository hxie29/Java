package c10_ObjectOrientedThinking;

public class MyInteger {
    //data fields
    private final int value;

    //Constructor
    public MyInteger(int value){
        this.value = value;
    }

    //Methods
    public int getInteger(){
        return value;
    }

    public boolean isEven(){
        return isEven(value);
    }

    public boolean isOdd(){
        return isOdd(value);
    }

    public boolean isPrime(){
        return isPrime(value);
    }

    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    public static boolean isOdd(int n) {
        return !isEven(n);
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return prime;
    }

    public boolean equals(int n){
        return (n == value);
    }

    public static int parseInt(char[] array) {
        return Integer.parseInt(String.valueOf(array));

    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
