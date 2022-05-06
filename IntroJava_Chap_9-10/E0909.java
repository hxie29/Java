
/* (Geometry: n-sided regular polygon) In an n-sided regular polygon, all sides have
the same length and all angles have the same degree (i.e., the polygon is both equilateral
and equiangular). Design a class named RegularPolygon that contains:
■■ A private int data field named n that defines the number of sides in the polygon with default value 3.
■■ A private double data field named side that stores the length of the side with default value 1.
■■ A private double data field named x that defines the x-coordinate of the polygon’s center with default value 0.
■■ A private double data field named y that defines the y-coordinate of the polygon’s center with default value 0.
■■ A no-arg constructor that creates a regular polygon with default values.
■■ A constructor that creates a regular polygon with the specified number of sides and length of side, centered at (0, 0).
■■ A constructor that creates a regular polygon with the specified number of sides, length of side, and x- and y-coordinates.
■■ The accessor and mutator methods for all data fields.
■■ The method getPerimeter() that returns the perimeter of the polygon.
■■ The method getArea() that returns the area of the polygon.
Draw the UML diagram for the class then implement the class. Write a test program
that creates three RegularPolygon objects, created using the no-arg constructor,
using RegularPolygon(6, 4), and using RegularPolygon(10, 4,
5.6, 7.8). For each object, display its perimeter and area
*/
public class E0909 {
    public static void main(String[] args) {
       RegularPolygon r1 = new RegularPolygon();
       RegularPolygon r2 = new RegularPolygon(6, 4);
       RegularPolygon r3 = new RegularPolygon(10, 4, 5.6, 7.8 );
       System.out.println("R1: Perimeter " + r1.getPerimeter() + " Area: " + r1.getArea());
       System.out.println("R2: Perimeter " + r2.getPerimeter() + " Area: " + r2.getArea());
       System.out.println("R3: Perimeter " + r3.getPerimeter() + " Area: " + r3.getArea());
    }
}

class RegularPolygon {
    //Data fields
    private int n = 3;
    private double side = 1;
    private double x;
    private double y;

    // Constructor
    public RegularPolygon() {

    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
    }

    //Methods
    public int getNumberOfSides(){
        return n;
    }
    public void setNumberOfSides(int n) {
        this.n = n;
    }

    public double getSide(){
        return side;
    }
    public void setSide(double side){
        this.side = side;
    }

    public double getCenterX (){
        return x;
    }
    public double getCenterY (){
        return y;
    }

    public void setCenter(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getPerimeter() {
        return side * n;
    }

    public double getArea() {
        return n * side * side / 4 / Math.tan(Math.PI / n);
    }
}
