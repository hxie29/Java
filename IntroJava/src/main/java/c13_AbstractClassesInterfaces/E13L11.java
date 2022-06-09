package c13_AbstractClassesInterfaces;

/*
To define a custom class that implements the Cloneable interface, the class must override
the clone() method in the Object class. Listing 13.11 defines a class named House that
implements Cloneable and Comparable.
*/
public class E13L11 {
    public static void main(String[] args) {
        House h1 = new House(5, 1000);
        House h2 = (House) h1.clone();
        System.out.println(h2 == h1); // False, they are not referring to the same object.
        System.out.println(h1.compareTo(h2)); // 0 , because the area data value are copied, i.e. the same
        System.out.println(h1.equals(h2)); // False, they are not the same objects
    }
}

