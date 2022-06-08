package c12_ExceptionTextIO;/*
(Ranking summary) Write a program that uses the files described in Programming
Exercise 12.31 and displays a ranking summary table for the first five
girl’s and boy’s names as follows:
Year Rank 1 Rank 2 Rank 3 Rank 4 Rank 5 Rank 1 Rank 2 Rank 3 Rank 4 Rank 5
2010 Isabella Sophia Emma Olivia Ava Jacob Ethan Michael Jayden William
2009 Isabella Emma Olivia Sophia Ava Jacob Ethan Michael Alexander William
...
2001 Emily Madison Hannah Ashley Alexis Jacob Michael Matthew Joshua Christopher
*/

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class E1231 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-8s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s\n", "Year",
        "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        System.out.println("-----------------------------------------------------------------------------------");

        int year = 2001;
        int end = 2001;
        for (int n = year; n <= end; n++) {
            
            File file = new File("/Users/halda/Documents/GitHub/Java/IntroJava_Chap_11-12/test/babynamesranking" + year + ".txt");
            if (!file.exists()) {
                System.out.println("Ranking file of " + year + " does not exist, please download");
                System.exit(1);
            }
    
            ArrayList<String[]> list = new ArrayList<>();
            try (Scanner input = new Scanner(file)) {
                for (int i = 0 ; i < 5; i++) {
                    String[] line = input.nextLine().split("\\s+");
                    list.add(line);
                }
            }
            
            System.out.printf("%-8d", year);
    
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-12s", list.get(i)[3]);
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%-12s", list.get(i)[1]);
            }
            System.out.println();
        }
    }   
    
}
