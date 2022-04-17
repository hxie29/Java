public class Main {
    public static void main(String[] args) {
        System.out.println("This will be printed.");
    }

/* basic 8 variable types called PRIMITIVES:
    byte (number, 1 byte)
    short (number, 2 bytes)
    int (number, 4 bytes)
    long (number, 8 bytes)
    float (float, 4 bytes)
    double (float, 8 bytes)
    char (a character, 2 bytes)
    boolean (T or F, 1 byte) 
*/

int mynumber = 5;
double d = 4.5;
float f = 4.5f; 
char c ='g';

// String is not a primitive, but a real type
String s1 = new String ("what's your name?"); //String object stored in heap memory
String s2 = "i don't know."; // String literal stored in String pool
String s3 = s1 + s2; // operator + on strings to concatenate,  The operator + is only defined for strings, you will never see it with other objects, only primitives.
String s4 = "I have" + d + " liters of oil'";

}
/* Create all of the primitives (except long and double) with different values. 
    Concatenate them into a string and print it to the screen so it will print: H3110 w0r1d 2.0 true */