package c13_AbstractClassesInterfaces;

/*
(Create a rational-number calculator) Write a program similar to Listing 7.9,
Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10.
You will need to use the split method in the String class, introduced in
Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string
and denominator string, and convert strings into integers using the Integer
. parseInt method.
Figure 13.10 (a) The program takes a string argument that consists of operand1, operator, and
operand2 from the command line and displays the expression and the result of the arithmetic
operation. (b) A complex number can be interpreted as a point in a plane
*/
public class E1316 {
    public static void main(String[] args) {
        // Check number of strings passed
            if (args.length != 3) {
            System.out.println("Usage: java Calculator RationalNumber a/b operator RationalNumber c/d");
            System.exit(1);
            }
            
            String s1= args[0].split("/")[0];
            checkDigit(s1);
            String s2= args[0].split("/")[1];
            checkDigit(s2); 
            String s3= args[2].split("/")[0];
            checkDigit(s3);
            String s4= args[2].split("/")[1];
            checkDigit(s4);

            Rational2 r1 = new Rational2(Integer.parseInt(s1), Integer.parseInt(s2));
            Rational2 r2 = new Rational2(Integer.parseInt(s3), Integer.parseInt(s4));

        new Rational2();
        Rational2 result = switch (args[1].charAt(0)) {
            case '+' -> r1.add(r2);
            case '-' -> r1.subtract(r2);
            case '.' -> r1.multiply(r2);
            case '/' -> r1.divide(r2);
            default -> new Rational2();
        };

        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result.toString());
    }
    
    public static void checkDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                System.out.println("Wrong input: " + s);
                System.exit(1);
            }
        }
    }
}

