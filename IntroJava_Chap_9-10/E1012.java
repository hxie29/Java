/*
(Geometry: the Triangle2D class) Define the Triangle2D class that contains:
■■ Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods. MyPoint is defined in Programming Exercise 10.4.
■■ A no-arg constructor that creates a default triangle with the points (0, 0), (1, 1), and (2, 5).
■■ A constructor that creates a triangle with the specified points.
■■ A method getArea() that returns the area of the triangle.
■■ A method getPerimeter() that returns the perimeter of the triangle.
■■ A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure 10.22a).
■■ A method contains(Triangle2D t) that returns true if the s pecified triangle is inside this triangle (see Figure 10.22b).
■■ A method overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle (see Figure 10.22c).

Draw the UML diagram for the class and then implement the class. Write a
test program that creates a Triangle2D object t1 using the constructor
new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3),
new MyPoint(5, 3.5)), displays its area and perimeter, and displays the
result of t1.contains(3, 3), r1.contains(new Triangle2D(new
MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4))), and t1 .overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint (4, –3), MyPoint(2, 6.5))).
(Hint: For the formula to compute the area of a triangle, see Programming Exercise
2.19. To detect whether a point is inside a triangle, draw three dashed lines,
as shown in Figure 10.23. If the point is inside a triangle, each dashed line should
intersect a side only once. If a dashed line intersects a side twice, then the point
must be outside the triangle. For the algorithm of finding the intersecting point
of two lines, see Programming Exercise 3.25.)
*/


public class E1012 {
    public static void main(String[]args){
        Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.println("Area: " + t1.getArea());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("T1 contains (3, 3)? " + t1.contains(3, 3));
        System.out.println("C1 contains (2.9, 2) + (4, 1) + (1, 3.4)? " + t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
    }
}

class Triangle2D{
    private MyPoint p1 = new MyPoint();
    private MyPoint p2 = new MyPoint();
    private MyPoint p3 = new MyPoint();
    

    //Constructor
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle2D(){
        this.setP1(0,0);
        this.setP2(1,1);
        this.setP3(2,5);
    }

    //Methods
    public MyPoint getP1(){
        return p1;
    }
    public MyPoint getP2(){
        return p2;
    }
    public MyPoint getP3(){
        return p3;
    }
    
    public void setP1(double x, double y){
        p1 = new MyPoint(x,y);
    }
    
    public void setP2(double x, double y){
        p2 = new MyPoint(x,y);
    }
    
    public void setP3(double x, double y){
        p3 = new MyPoint(x,y);
    }

    public double getS1(){
        return Math.pow((Math.pow((p3.getX() - p2.getX()), 2) + Math.pow((p3.getY()-p2.getY()),2)) , 0.5);
    }
    public double getS2(){
        return Math.pow((Math.pow((p1.getX() - p3.getX()), 2) + Math.pow((p1.getY()-p3.getY()),2)) , 0.5);
    }
    public double getS3(){
        return Math.pow((Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY()-p2.getY()),2)) , 0.5);
    }

    public double getArea(){
        double s1 = this.getS1();
        double s2 = this.getS2();
        double s3 = this.getS3();
        double s = (s1 + s2 + s3) / 2;
        return Math.pow((s * (s-s1) * (s -s2) * (s-s3)), 0.5);
    }

    public double getPerimeter(){
        double s1 = this.getS1();
        double s2 = this.getS2();
        double s3 = this.getS3();
        return s1 + s2 + s3;
    }

    public boolean contains (double x, double y) {
       MyPoint p0 = new MyPoint(x, y);
       return (angleAtP2(p1, p0, p3) + angleAtP2(p2, p0, p3) + angleAtP2(p1, p0, p2) == 2 * Math.PI);
    }

    public boolean contains(Triangle2D t){
        return this.contains(t.getP1().getX(), t.getP1().getY()) && this.contains(t.getP2().getX(), t.getP2().getY()) && this.contains(t.getP3().getX(), t.getP3().getY());
    }

    public double angleAtP2(MyPoint p1, MyPoint p2, MyPoint p3){
        double s3 = this.getS3();
        double s1 = this.getS1();
        double s2 = this.getS2();
        double cosC = (s3 * s3 + s1 * s1 - s2 * s2) / s1 / s3 /2;
        return Math.acos(cosC);
    }

}

class MyPoint{
    //data fields
    private double x;
    private double y;

    //Constructor
    public MyPoint(){
        this(0,0);
    }
    public MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    //Methods
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double distance(double a, double b) {
        return Math.pow(((a - x)* (a - x) + (b -y) * (b -y)), 0.5);
    }

    public static double distance (MyPoint a, MyPoint b) {
        return a.distance(b.getX(), b.getY());
    }
}
