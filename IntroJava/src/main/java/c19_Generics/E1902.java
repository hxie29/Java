/*((Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
implemented using composition. Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes then implement GenericStack. Write a test
program that prompts the user to enter five strings and displays them in reverse order.*/

package c19_Generics;

public class E1902 {

    public static void main(String[]args) {
        GenericStack3<String> list = new GenericStack3<>();

        for (int i = 0; i < 5; i++) {
            list.push("This is number " + i);
        }

        System.out.println("Current Size " + list.getSize());
        System.out.println("Is stack empty? " + list.isEmpty());
        System.out.println("Pop: " + list.pop());
        System.out.println("Pop: " + list.pop());
        System.out.println("Current Size " + list.getSize());
    }
}
