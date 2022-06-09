package c12_ExceptionTextIO;

class HexFormatException extends Exception {
    public HexFormatException() {
        super("The string is not a hex string.");
    }
}
