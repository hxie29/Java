//Casting demo
import java.util.Date;
public class E11L07 {
    public static void main(String[] args){
        Object o1 = new Circle(1);
        Object r1 = new Rectangle(1, 2);
        displayObject(o1);
        displayObject(r1);

    }

    public static void displayObject(Object object){
        if (object instanceof Circle) {
            System.out.println("Radius is:" + ((Circle)object).getRadius());
            System.out.println("Area is:" + ((Circle)object).getArea());
        }
        else if (object instanceof Rectangle) {
            System.out.println("Perimeter is:" + ((Rectangle)object).getPerimeter());
            System.out.println("Area is:" + ((Rectangle)object).getArea());
        }
        System.out.println("Created on " + ((GeometricObject)object).getDate() + " Color is " + ((GeometricObject)object).getColor());
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

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        setHeight(height);
        setWidth(width);
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


