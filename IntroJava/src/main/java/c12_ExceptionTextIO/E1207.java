package c12_ExceptionTextIO;

/*
(Checked Exception) In preparation for a class Fraction, create a class
NullDenominatorException that must be a checked exception whose
instances are thrown if the denominator of an object of class Fraction is 0.
*/
public class E1207 {
    public static void main(String[] args) {
        try {
            Fraction f = new Fraction(5, 0);
            System.out.println("Fraction is " + f.getNumerator() + "/" + f.getDenominator());
        }
        catch (NullDenominatorException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

