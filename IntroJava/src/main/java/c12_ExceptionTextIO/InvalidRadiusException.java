package c12_ExceptionTextIO;

class InvalidRadiusException extends Exception {
    private final double radius;

    public InvalidRadiusException(double radius) {
        super("Invalid radius " + radius); // Call for Exception class method to construct an Exception object, argument is included as a message
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
