// Raw types and backward compatibility, this is not safe to use
package c19_Generics;

public class Max {
    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
}
