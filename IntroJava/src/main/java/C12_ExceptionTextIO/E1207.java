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

class Fraction {
    private int numberator = 1;
    private int denominator = 1;

    public Fraction() {

    }

    public Fraction(int numberator, int denominator) throws NullDenominatorException {
        setNumberator(numberator);
        setDenominator(denominator);
    }

    public void setNumberator(int numberator) {
        this.numberator = numberator;
    }
    public void setDenominator(int denominator) throws NullDenominatorException {
        if (denominator == 0) 
            throw new NullDenominatorException();
        else 
            this.denominator = denominator;
    }

    public int getNumerator(){
        return numberator;
    }

    public int getDenominator(){
        return denominator;
    }
}

class NullDenominatorException extends Exception{
    public NullDenominatorException() {
        super("Denominator can not be zero.");
    }
}

