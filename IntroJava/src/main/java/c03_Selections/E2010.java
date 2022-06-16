/*(Perform set operations on priority queues) Given two stacks of textbooks
of the following subjects {“Chemistry”, “Mathematics”, “Biology”,
“ English”} and {“Biology”, “English”, “Geography”, “Physics”},
find the subjects that are (1) only present in the first stack; (2) only present in
the second stack; (3) present in both stacks.*/
package c03_Selections;

import java.util.PriorityQueue;

public class E2010 {
    public static void main(String[] args) {
        PriorityQueue<String> book1 = new PriorityQueue<>();
        book1.add("Chemistry");
        book1.add("Mathematics");
        book1.add("Biology");
        book1.add("English");

        PriorityQueue<String> book2 = new PriorityQueue<>();
        book2.add("Biology");
        book2.add("English");
        book2.add("Geography");
        book2.add("Physics");

        PriorityQueue<String> only1 = new PriorityQueue<>(book1);
        only1.removeAll(book2);
        System.out.println("Subjects only in stack 1: " + only1);

        only1 = new PriorityQueue<>(book2);
        only1.removeAll(book1);
        System.out.println("Subjects only in stack 2: " + only1);

        only1 = new PriorityQueue<>(book2);
        only1.retainAll(book1);
        System.out.println("Subjects in both stacks: " + only1);
    }
}
