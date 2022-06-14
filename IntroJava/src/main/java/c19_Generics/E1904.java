/*(Using wildcards) Write a generic static method that returns the smallest value in an
instance of Pair from Programming Exercise 19.3.*/
package c19_Generics;

public class E1904 {
    public static void main(String[] args) {
        Integer n1 = 10;
        Integer n2 = 15;

        Pair<Integer> pair = new Pair<>(n1, n2);

        System.out.println("" + getSmall(pair));
    }

    public static <E extends Comparable<E>> E getSmall(Pair<E> pair) {
        if (pair.getOne().compareTo(pair.getTwo()) > 0)
            return pair.getTwo();
        else
            return pair.getOne();
    }
}
