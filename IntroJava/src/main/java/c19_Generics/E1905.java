/*(Inheritance between generic classes) Create a Triplet class that encapsulates
three objects of the same data type in a given instance of Triplet.*/
package c19_Generics;

public class E1905 {
    public static void main(String[] args) {
        Integer n1 = 10;
        Integer n2 = 15;
        Integer n3 = 20;

        Triplet<Integer> trip = new Triplet<>(n1, n2, n3);

        System.out.println("" + getSmall(trip));
    }

    public static <E extends Comparable<E>> E getSmall(Triplet<E> triplet) {
        E min = triplet.getOne();
        if (min.compareTo(triplet.getTwo()) > 0)
            min = triplet.getTwo();
        if (min.compareTo(triplet.getThree()) > 0)
            min = triplet.getThree();

        return min;
    }
}
