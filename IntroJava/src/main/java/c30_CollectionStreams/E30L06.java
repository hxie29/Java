// Collect grouping demo
package c30_CollectionStreams;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E30L06 {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen","George", "Alan", "Stacy", "Michelle", "john"};

        Map<String, Long> map1 = Stream.of(names).map(String:: toUpperCase).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map1);

        Map<Character, Long> map2 = Stream.of(names).map(String:: toUpperCase).collect(Collectors.groupingBy(e -> e.charAt(0), TreeMap:: new, Collectors.counting()));
        System.out.println(map2);

        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};
        IntStream.of(values).boxed().collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting())).forEach((k,v) ->
                System.out.println(k + " occurs " + v + " times"));

        MyStudent[] students = {new MyStudent("John", "Lu", "CS", 32, 78),
                new MyStudent("Susan", "Yao", "Math", 31, 85.4),
                new MyStudent("Kim", "Johnson", "CS", 30, 78.1)};

        System.out.printf("%10s%10s\n", "Department", "Average");
        Stream.of(students).collect(Collectors.groupingBy(MyStudent::getMajor, TreeMap::new, Collectors.averagingDouble(MyStudent:: getScore))).forEach((k,v) ->
                System.out.printf("%10s%10.2f\n", k, v));

    }
}

class MyStudent{
    private final String firstName;
    private final String lastName;
    private final String major;
    private final int age;
    private final double score;

    public MyStudent(String firstName, String lastName, String major, int age, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.age = age;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }
}
