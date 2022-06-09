package c13_AbstractClassesInterfaces;

//Subclass
class Square extends GeometricObject implements Colorable {
    //data fields
    private double side = 1;

    // constructor
    public Square() {
    }

    public Square(double side) {
        setside(side);
    }

    // method
    public double getside() {
        return side;
    }

    public void setside(double side) {
        this.side = side;
    }


    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public String toString() {
        return "Square, side is " + side + super.toString();
    }

    @Override
    public void toColor(String color) {
        super.setColor(color);
    }

}
