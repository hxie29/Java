package c02_Elementary;

import java.util.Scanner; //Scanner is in the java.util package

public class E02L02 {
    public static void main(String[] args) {
        // create a scanner object
        Scanner inp = new Scanner(System.in);

        final double PI = 3.1415926; // declare a constant
        System.out.println("Enter three numbers:");
        double n1 = inp.nextDouble(); // next.Double() is a method in Scanner class
        double n2 = inp.nextDouble();
        double n3 = inp.nextDouble();
        
        double area = n1 * n1 * PI;
        System.out.println("The average of " + n1 + " ," + n2 + " ," + " and " + n3 + " is " + (n1 + n2 + n3)/3 );
        System.out.println("The area for the circle of radius " + n1 + " is " + area + ".");
        inp.close();
    }
    
}

/* basic 8 variable types called PRIMITIVES:
    byte (number, 1 byte)           -2^7  to 2^7-1
    short (number, 2 bytes)         -2^15 to 2^15-1
    int (number, 4 bytes)           -2^31 to 2^31-1
    long (number, 8 bytes)          -2^63 to 2^63-1
    float (float, 4 bytes)
    double (float, 8 bytes)
    char (a character, 2 bytes)
    boolean (T or F, 1 byte) 
*/