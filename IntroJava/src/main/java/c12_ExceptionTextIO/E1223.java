package c12_ExceptionTextIO;/*
(Process scores in a text file on the Web) Suppose the text file on the Web
http://liveexample.pearsoncmg.com/data/Scores.txt contains an unspecified
number of scores separated by spaces. Write a program that reads the scores
from the file and displays their total and average.
*/
import java.net.URL;
import java.util.Scanner;
public class E1223 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");

        int count = 0;
        int sum = 0;

        try (Scanner input = new Scanner(url.openStream())) {
            //ArrayList<Integer> list = new ArrayList<>();
            while (input.hasNext()) {
                int score = Integer.parseInt(input.next());
                count++;
                sum += score;
            }
        }

        System.out.println("The sum of scores is " + sum);
        System.out.println("The average score is " + sum * 1.0 / count);
    }
}
