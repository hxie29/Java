/*
(Geometry: the bounding rectangle) A bounding rectangle is the minimum rectangle
that encloses a set of points in a two-dimensional plane, as shown in
Figure 10.24d. Write a method that returns a bounding rectangle for a set of
points in a two-dimensional plane, as follows:
public static MyRectangle2D getRectangle(double[][] points)
The Rectangle2D class is defined in Programming Exercise 10.13. Write a test
program that prompts the user to enter five points and displays the bounding
rectangle’s center, width, and height. Here is a sample run:
*/

import java.util.Scanner;
public class E1015 {
    public static void main(String[]args){
        double[][] points = new double[5][2];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five points:");
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        MyRectangle2D r = getRectangle(points);
        
        System.out.println("The bounding rectangle's center is (" + r.getX() + ", " + r.getY() + "), width " 
                            + r.getWidth() + ", height " + r.getHeight());
        input.close();
    }

    public static MyRectangle2D getRectangle(double[][] points){
        double maxX = max(points, 0);
        double minX = min(points, 0);
        double maxY = max(points, 1);
        double minY = min(points, 1);

        double height = maxY - minY;
        double width = maxX - minX;
        double x = maxX - width/2;
        double y = maxY - height/2;
        return new MyRectangle2D(x, y, width, height);
    }

    public static double max(double[][] points, int index){
        double max = points[0][index];
        for (int i = 0; i < points.length; i++) {
            if (max < points[i][index]){
                max = points[i][index];
            }
        }
        return max;
    }
    public static double min(double[][] points, int index){
        double min = points[0][index];
        for (int i = 0; i < points.length; i++) {
            if (min > points[i][index]){
                min = points[i][index];
            }
        }
        return min;
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
