package c09_ObjectsClasses;

public class Location {
    //Data fields
    public int row = 1;
    public int column = 1;
    public double maxValue = 0;

    //Constructor
    public Location(){

    }

    // Methods
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
    public double getMax(){
        return maxValue;
    }
}
