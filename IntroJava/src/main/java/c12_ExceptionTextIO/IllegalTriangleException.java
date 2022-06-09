package c12_ExceptionTextIO;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
        super(" In a triangle, the sum of any two sides is greater than the other side. ");
    }
}
