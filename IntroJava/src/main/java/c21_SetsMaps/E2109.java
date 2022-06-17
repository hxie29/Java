package c21_SetsMaps;

import java.util.*;

public class E2109 {
    private static final String[][] data = {
            {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
            {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
            {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},{"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
            {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"},
            {"Iowa Des", "Moines"}, {"Kansas", "Topeka"}, {"Kentucky","Frankfort"},
            {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"},
            {"Maryland", "Annapolis"}, {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"}, {"Minnesota", "Saint Paul"},
            {"Mississippi", "Jackson"}, {"Missouri", "Jefferson City"},
            {"Montana", "Helena"}, {"Nebraska", "Lincoln"},
            {"Nevada	", "Carson City"}, {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"},
            {"New York", "Albany"}, {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},{"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"}, {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"}, {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"}, {"Texas", "Austin"},
            {"Utah", "Salt Lake City"}, {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"}, {"Washington", "Olympia"},
            {"West Virginia", "Charleston"}, {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}};

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(getData());
        String key = data[(int)(Math.random() * data.length)][0];
        System.out.println("What is the capital of " + key + " ?");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        String correct = map.get(key);
        if (answer.equalsIgnoreCase(correct))
            System.out.println("You are correct!");
        else
            System.out.println("Not correct.");
        System.out.println("The answer is " + correct);
    }

    /* Method getData stores the 50 states and their capitals in a map */
    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        for (String[] datum : data) {
            map.put(datum[0], datum[1]);
        }
        return map;
    }

}
