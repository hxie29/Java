package c10_ObjectOrientedThinking;

public class MyRectangle2D {
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
