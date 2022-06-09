package c13_AbstractClassesInterfaces;

//Subclass
class Octagon extends GeometricObject implements Cloneable {
    //Data fields (all data fields in superclass are inherited)
    private double side;

    //Constructor
    public Octagon() {
        this(0);
    }

    public Octagon(double side) {
        setSide(side);
    }

    public Octagon(double side, String color, boolean filled) {
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setSide(side);
    }

    //Methods
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // Implement
    public double getArea() {
        return (2 + 4 / Math.pow(2, 0.5)) * side * side;
    }

    public double getPerimeter() {
        return side * 8;
    }

    public void printOctagon() {
        System.out.println("The Octagon is created " + getDate() + " and the side is " + side);
    }

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(getArea(), o.getArea());
    }


    public boolean equals(GeometricObject a) {
        return ((Octagon)a).getSide() == side;
    }

    @Override
    public String toString() {
        return super.toString() + "\nside is " + side;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        return new Octagon(side);
    }

}
