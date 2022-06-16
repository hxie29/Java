/*(Guessing the capitals) Rewrite Programming Exercise 8.37 to store the pairs
of states and capitals so that the questions are displayed randomly.*/
package c20_ListStackQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class E2003 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String[]> list = new LinkedList<>();
        Collections.addAll(list, stateCapitals);

        int count = 0;
        while (list.size() > 0) {
            Collections.shuffle(list);
            System.out.println("What is the capital of " + list.get(0)[0] + "?");
            String answer = input.nextLine().toLowerCase();

            if (answer.equalsIgnoreCase(list.get(0)[1])) {
                System.out.println("Your answer is correct.");
                count++;
            }
            else System.out.println("The correct answer should be " + list.get(0)[1]);

            list.pollFirst();
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
