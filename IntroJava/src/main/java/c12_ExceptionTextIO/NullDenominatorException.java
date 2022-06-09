package c12_ExceptionTextIO;

class NullDenominatorException extends Exception {
    public NullDenominatorException() {
        super("Denominator can not be zero.");
    }
}
