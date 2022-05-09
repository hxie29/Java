/*
(The MyInteger class) Design a class named MyInteger. The class contains:
■■ An int data field named value that stores the int value represented by this object.
■■ A constructor that creates a MyInteger object for the specified int value.
■■ A getter method that returns the int value.
■■ The methods isEven(), isOdd(), and isPrime() that return true if the
value in this object is even, odd, or prime, respectively.
■■ The static methods isEven(int), isOdd(int), and isPrime(int) that
return true if the specified value is even, odd, or prime, respectively.
■■ The static methods isEven(MyInteger), isOdd(MyInteger), and
isPrime(MyInteger) that return true if the specified value is even, odd, or prime, respectively.
■■ The methods equals(int) and equals(MyInteger) that return true if
the value in this object is equal to the specified value.
■■ A static method parseInt(char[]) that converts an array of numeric characters to an int value.
■■ A static method parseInt(String) that converts a string into an int value.
Draw the UML diagram for the class then implement the class. Write a client
program that tests all methods in the class
*/
public class E1003 {
    public static void main(String[] args) {
        MyInteger x1 = new MyInteger(2);
        MyInteger x2 = new MyInteger(9);
        char[] array = {'1', '2', '3', '4'};
        System.out.println(MyInteger.parseInt(array));
        System.out.println(x1.getInteger() + " is prime?" + x1.isPrime());
        System.out.println(x2.getInteger() + " is prime?" + x2.isPrime());
    }
}

class MyInteger{
    //data fields
    private int value;

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
        StringBuilder str = new StringBuilder();
        str.append(array);
        return Integer.valueOf(str.toString());

    }

    public static int parseInt(String s) {
        return Integer.valueOf(s);
    }
}
