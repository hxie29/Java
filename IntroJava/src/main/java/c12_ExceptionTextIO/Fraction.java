package c12_ExceptionTextIO;

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

    public int getNumerator() {
        return numberator;
    }

    public int getDenominator() {
        return denominator;
    }
}
