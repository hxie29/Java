/*
(Geometry: the MyRectangle2D class) Define the MyRectangle2D class that contains:
■■ Two double data fields named x and y that specify the center of the rectangle
with getter and setter methods. (Assume the rectangle sides are parallel to x- or y-axis.)
■■ The data fields width and height with getter and setter methods.
■■ A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and 1 for both width and height.
■■ A constructor that creates a rectangle with the specified x, y, width, and height.
A method getArea() that returns the area of the rectangle.
■■ A method getPerimeter() that returns the perimeter of the rectangle.
■■ A method contains(double x, double y) that returns true if the specified point (x, y) is inside this rectangle (see Figure 10.24a).
■■ A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle (see Figure 10.24b).
■■ A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle (see Figure 10.24c).
Draw the UML diagram for the class then implement the class. Write a test
program that creates a MyRectangle2D object r1 (new MyRectangle2D
(2, 2, 5.5, 4.9)), displays its area and perimeter, and displays the result of
r1.contains(3, 3), r1.contains(new MyRectangle2D(4, 5, 10.5,
3.2)), and r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)).
*/


public class E1013 {
    public static void main(String[]args){
       MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
       System.out.println("Area: " + r1.getArea());
       System.out.println("Perimeter: " + r1.getPerimeter());
       System.out.println("Contains (4, 5, 10.5, 3.2)" + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
       System.out.println("Overlaps (3,5,2.3,5.4)" + r1.overlaps(new MyRectangle2D(3,5,2.3,5.4)));
    }
}

class MyRectangle2D {
    //data fields
    private double x;
    private double y;
    private double width;
    private double height;

    // constructor
    public MyRectangle2D() { 
        this(0,0,1,1); 
    }

    public MyRectangle2D(double x, double y, double width, double height) {
       this.setHeight(height);
       this.setWidth(width);
       this.setX(x);
       this.setY(y);
    }

    // method
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

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

    public boolean contains(double x, double y) {
        return (x > this.x - width/2 && x < this.x + width /2) && (y > this.y - height /2 && y < this.y + height/2);
    }

    public boolean contains(MyRectangle2D rectangle) {
        return (rectangle.getX() + rectangle.getWidth()/2 < x + width/2 && rectangle.getX() - rectangle.getWidth()/2 > x - width/2)
        && (rectangle.getY() + rectangle.getHeight()/2 < y + height/2 && rectangle.getY() - rectangle.getHeight()/2 > y - height/2);
    }

    public boolean overlaps(MyRectangle2D rectangle){
        boolean contain = this.contains(rectangle);
        boolean outside = (rectangle.getX() + rectangle.getWidth()/2 < x - width/2 || rectangle.getX() - rectangle.getWidth()/2 > x + width/2)
        || (rectangle.getY() + rectangle.getHeight()/2 < y - height/2 || rectangle.getY() - rectangle.getHeight()/2 > y + height/2);
        return !contain && !outside;
    }
}
