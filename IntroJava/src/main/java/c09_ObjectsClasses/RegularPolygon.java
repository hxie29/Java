package c09_ObjectsClasses;

public class RegularPolygon {
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
