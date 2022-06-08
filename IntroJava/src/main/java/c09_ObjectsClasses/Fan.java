package c09_ObjectsClasses;

public class Fan {
    //Data fields
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on;
    private double radius = 5;
    String color = "blue";

    // Constructor
    public Fan(){

    }

    // Methods
    public int getSpeed(){
        return speed;
    }

    public boolean getStatus(){
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(boolean on){
        this.on = on;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String toString() {
        if (on)
            return "Speed: " + speed + " Color " + color + "; radius: " + radius;
        else
            return "fan is off" +  " Color " + color + "; radius: " + radius;
    }
}
