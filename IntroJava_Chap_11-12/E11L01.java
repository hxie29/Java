import java.util.Date;
public class E11L01 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        System.out.println("A circle " + circle1.toString());
        System.out.println("Color: " + circle1.getColor());
        System.out.println("Filled: " + circle1.isFilled());
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Perimeter: " + circle1.getPerimeter());
        System.out.println(circle1.toString());
    }
}

//Superclass
class GeometricObject {
    //Data encapsulation
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    //Constructor
    public GeometricObject(){
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled){
        setColor(color);
        setFilled(filled);
        dateCreated = new Date();
    }

    //Methods
    public String getColor(){
        return color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public Date getDate(){
        return dateCreated;
    }

    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

//Subclass
class Circle extends GeometricObject{
    //Data fields (all data fields in superclass are inherited)
    private double radius;

    //Constructor
    public Circle(){
    }

    public Circle(double radius){
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled){
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
    }

    //Methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return Math.PI * radius * 2;
    }

    public void printCircle(){
        System.out.println("The circle is created " + getDate() + " and the radius is " + radius);
    }

    @Override
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }

}

//Subclass 
class Rectangle extends GeometricObject {
    //data fields
    private double width = 1;
    private double height = 1;

    // constructor
    public Rectangle() {  
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    // method
    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}
