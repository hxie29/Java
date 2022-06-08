import java.util.Date;

/*
To define a custom class that implements the Cloneable interface, the class must override
the clone() method in the Object class. Listing 13.11 defines a class named House that
implements Cloneable and Comparable.
*/
public class E13L11 {
    public static void main(String[] args) {
        House h1 = new House(5, 1000);
        House h2 = (House) h1.clone();
        System.out.println(h2 == h1); // False, they are not refering to the same object. 
        System.out.println(h1.compareTo(h1)); // 0 , because the area data value are copied, i.e. the same
        System.out.println(h1.equals(h2)); // False, they are not the same objects
    }
}

class House implements Cloneable, Comparable<House> {
    private int id;
    private double area;
    private Date whenBuilt;

    //Constructor
    public House(){
        this(0, 0);
    }

    public House (int id, double area) {
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

    public Date getWhenBuilt(){
        return whenBuilt;
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); //This is shallow copy, because the Date object is not copied, only its reference is.
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }

    // Deep copy, also clone all the obejcts in the data field
    /*
    @Override
    public Object clone() {
        House h2 = new House(id, area);
        h2.whenbuilt = new Date();
        h2.getWhenBuilt.setTime(whenBuilt.getTime());
        return h2;
    }
    */

    @Override
    public String toString(){
        return super.toString() + "Id: " + id + " Area: " + area + " Built in: " + whenBuilt;
    }

    @Override 
    public int compareTo(House o){
        return (getArea() > o.getArea()) ? 1 : ((getArea() < o.getArea()) ? -1 : 0);
    }
}