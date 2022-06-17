/*(Perform set operations on hash sets) Given two stacks of textbooks of the following
subjects 5"Chemistry", "Mathematics", "Biology", "English"6
and 5"Biology", "English", "Geography", "Physics"6 respectively, find
the subjects that are (1) only present in the first stack; (2) only present in the
second stack; (3) present in both stacks. (You may clone the sets to preserve the
original sets from being changed by set methods.)*/
package c21_SetsMaps;

import java.util.HashSet;
import java.util.Set;

public class E2101 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("Chemistry");
        set1.add("Mathematics");
        set1.add("Biology");
        set1.add("English");
        Set<String> set2 = new HashSet<>();
        set2.add("Biology");
        set2.add("English");
        set2.add("Geography");
        set2.add("Physics");

        Set<String> tempSet = new HashSet<>(set1);
        tempSet.removeAll(set2);
        System.out.println("Subjects only in first set: " + tempSet);
        tempSet = new HashSet<>(set2);
        tempSet.removeAll(set1);
        System.out.println("Subjects only in second set: " + tempSet);
        tempSet = new HashSet<>(set2);
        tempSet.retainAll(set1);
        System.out.println("Subjects only in both sets: " + tempSet);
    }
}
