package c20_ListStackQueue;

import java.util.Arrays;
import java.util.Comparator;

public class E20L07 {
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "New York", "Dallas"};
        Arrays.sort(cities, new MyComparator());
        for (String c: cities)
            System.out.print(c + ", ");
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
