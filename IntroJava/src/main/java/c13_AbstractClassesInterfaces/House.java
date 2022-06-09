package c13_AbstractClassesInterfaces;

import java.util.Date;

class House implements Cloneable, Comparable<House> {
    private final int id;
    private final double area;
    private final Date whenBuilt;

    //Constructor
    public House() {
        this(0, 0);
    }

    public House(int id, double area) {
        this.id = id;
        this.area = area;
        whenBuilt = new Date();
    }

    //Methods
    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public Date getWhenBuilt() {
        return whenBuilt;
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); //This is shallow copy, because the Date object is not copied, only its reference is.
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }


    /* Deep copy, also clone all the objects in the data field
    @Override
    public Object clone() {
        House h2 = new House(id, area);
        h2.whenbuilt = new Date();
        h2.getWhenBuilt.setTime(whenBuilt.getTime());
        return h2;
    }
    */

    @Override
    public String toString() {
        return super.toString() + "Id: " + id + " Area: " + area + " Built in: " + whenBuilt;
    }

    @Override
    public int compareTo(House o) {
        return Double.compare(getArea(), o.getArea());
    }
}
