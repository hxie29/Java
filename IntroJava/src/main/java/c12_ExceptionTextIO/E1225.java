package c12_ExceptionTextIO;/*
(Process large dataset) A university posts its employees’ salaries at http://
liveexample.pearsoncmg.com/data/Salary.txt. Each line in the file consists of
a faculty member’s first name, last name, rank, and salary (see Programming
Exercise 12.24). Write a program to display the total salary for assistant professors,
associate professors, full professors, and faculty, respectively, and display
the average salary for assistant professors, associate professors, full professors,
and faculty, respectively.
*/
import java.net.URL;
import java.util.Scanner;
public class E1225 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
        String[] rank = {"assistant", "associate", "full"};
        double sumAssistant = 0;
        double sumAssociate = 0;
        double sumFull = 0;

        int countAssistant = 0;
        int countAssociate = 0;
        int countFull = 0;
        

        int count = 0;
        int sum = 0;

        try (Scanner input = new Scanner(url.openStream())) {
            //ArrayList<Integer> list = new ArrayList<>();
            while (input.hasNext()) {
                String[] line = input.nextLine().split("\\s+");
                String type = line[2];
                double salary = Double.parseDouble(line[line.length - 1]);
                if (type.equals(rank[0])) {
                    sumAssistant += salary;
                    countAssistant++;
                }

                if (type.equals(rank[1])) {
                    sumAssociate += salary;
                    countAssociate++;
                }

                if (type.equals(rank[2])) {
                    sumFull += salary;
                    countFull++;
                }
            }
        }

        System.out.println("The sum of assistant salary is " + sumAssistant + " Average: " + sumAssistant / countAssistant);
        System.out.println("The sum of associate salary is " + sumAssociate + " Average: " + sumAssociate / countAssociate);
        System.out.println("The sum of full professor salary is " + sumFull+ " Average: " + sumFull / countFull);
    }
}
