/*(Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
it using an array rather than an ArrayList. You should check the array size
before adding a new element to the stack. If the array is full, create a new array that
doubles the current array size and copy the elements from the current array to the
new array.*/

package c19_Generics;

public class E1901 {

    public static void main(String[]args) {
        GenericStack2<Integer> list = new GenericStack2<>();

        for (int i = 0; i < 10000; i++) {
            list.push(i);
        }

        System.out.println("Current Size " + list.getSize());
        System.out.println("Is stack empty? " + list.isEmpty());
        System.out.println("Pop: " + list.pop());
        System.out.println("Pop: " + list.pop());
        System.out.println("Current Size " + list.getSize());
    }
}
