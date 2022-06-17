/*(Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
pairs of each state and its capital in a map. Your program should prompt the user
to enter a state, and should display the capital for the state.*/
package c20_ListStackQueue;

import java.util.*;

public class E2109 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        LinkedList<String> keys = new LinkedList<>();
        for (String[] pair: stateCapitals) {
            map.put(pair[0], pair[1]);
            keys.push(pair[1]);
        }
        int count = 0;
        while (map.size() > 0) {
            Collections.shuffle(keys);
            String key = keys.pollFirst();
            String correctAnswer = map.remove(key);
            System.out.println("What is the capital of " + key + "?");
            String answer = input.nextLine().toLowerCase();

            if (answer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Your answer is correct.");
                count++;
            }
            else System.out.println("The correct answer should be " + correctAnswer);
        }
        System.out.println("The correct count is " + count);
        input.close();
    }
    private static final String[][] stateCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Maryland", "Annapolis"},
            {"Minnesota", "Saint Paul"},
            {"Iowa", "Des Moines"},
            {"Maine", "Augusta"},
            {"Kentucky", "Frankfort"},
            {"Indiana", "Indianapolis"},
            {"Kansas", "Topeka"},
            {"Louisiana", "Baton Rouge"},
            {"Oregon", "Salem"},
            {"Oklahoma", "Oklahoma City"},
            {"Ohio", "Columbus"},
            {"North Dakota", "Bismark"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"New Jersey", "Trenton"},
            {"New Hampshire", "Concord"},
            {"Nevada", "Carson City"},
            {"Nebraska", "Lincoln"},
            {"Montana", "Helena"},
            {"North Carolina", "Raleigh"},
            {"Missouri", "Jefferson City"},
            {"Mississippi", "Jackson"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
    };
}
