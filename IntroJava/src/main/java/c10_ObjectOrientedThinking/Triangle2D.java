package c10_ObjectOrientedThinking;

class Triangle2D {
    private MyPoint p1 = new MyPoint();
    private MyPoint p2 = new MyPoint();
    private MyPoint p3 = new MyPoint();


    //Constructor
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle2D() {
        this.setP1(0, 0);
        this.setP2(1, 1);
        this.setP3(2, 5);
    }

    //Methods
    public MyPoint getP1() {
        return p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP1(double x, double y) {
        p1 = new MyPoint(x, y);
    }

    public void setP2(double x, double y) {
        p2 = new MyPoint(x, y);
    }

    public void setP3(double x, double y) {
        p3 = new MyPoint(x, y);
    }

    public double getS1() {
        return Math.pow((Math.pow((p3.getX() - p2.getX()), 2) + Math.pow((p3.getY() - p2.getY()), 2)), 0.5);
    }

    public double getS2() {
        return Math.pow((Math.pow((p1.getX() - p3.getX()), 2) + Math.pow((p1.getY() - p3.getY()), 2)), 0.5);
    }

    public double getS3() {
        return Math.pow((Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2)), 0.5);
    }

    public double getArea() {
        double s1 = this.getS1();
        double s2 = this.getS2();
        double s3 = this.getS3();
        double s = (s1 + s2 + s3) / 2;
        return Math.pow((s * (s - s1) * (s - s2) * (s - s3)), 0.5);
    }

    public double getPerimeter() {
        double s1 = this.getS1();
        double s2 = this.getS2();
        double s3 = this.getS3();
        return s1 + s2 + s3;
    }

    public boolean contains(double x, double y) {
        MyPoint p0 = new MyPoint(x, y);
        return (angleAtP2(p1, p0, p3) + angleAtP2(p2, p0, p3) + angleAtP2(p1, p0, p2) == 2 * Math.PI);
    }

    public boolean contains(Triangle2D t) {
        return this.contains(t.getP1().getX(), t.getP1().getY()) && this.contains(t.getP2().getX(), t.getP2().getY()) && this.contains(t.getP3().getX(), t.getP3().getY());
    }

    public double angleAtP2(MyPoint p1, MyPoint p2, MyPoint p3) {
        double s3 = this.getS3();
        double s1 = this.getS1();
        double s2 = this.getS2();
        double cosC = (s3 * s3 + s1 * s1 - s2 * s2) / s1 / s3 / 2;
        return Math.acos(cosC);
    }

}
