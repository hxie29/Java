/*
(Baby name popularity ranking) The popularity ranking of baby names from
years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored
in files named babynameranking2001.txt, babynameranking2002.txt, . . . ,
babynameranking2010.txt. You can download these files using the URL such
as http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt. Each file
contains 1,000 lines. Each line contains a ranking, a boy’s name, number for the
boy’s name, a girl’s name, and number for the girl’s name. For example, the first
two lines in the file babynameranking2010.txt are as follows:
1 Jacob 21,875 Isabella 22,731
2 Ethan 17,866 Sophia 20,477
Therefore, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the
boy’s name Ethan and girl’s name Sophia are ranked #2; 21,875 boys are named
Jacob, and 22,731 girls are named Isabella. Write a program that prompts the
user to enter the year, gender, followed by a name, and displays the ranking of
the name for the year. Here is a sample run:

Enter the year: 2010
Enter the gender: M
Enter the name: Javier
Javier is ranked #190 in year 2010
*/

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class E1231 {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a year:");
        int year = userInput.nextInt();
        File file = new File("/Users/halda/Documents/GitHub/Java/IntroJava_Chap_11-12/test/babynamesranking" + year + ".txt");
        if (!file.exists()) {
            System.out.println("Ranking file does not exist, please download");
            System.exit(1);
        }
        
        System.out.println("Enter a gender: M or F");
        char gender = userInput.next().charAt(0);
        int genderNumber = (gender == 'M') ? 1 : 3;
        System.out.println("Enter a name:");
        String name = userInput.next();
        userInput.close();


        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split("\\s+");
                if (name.equals(line[genderNumber])) {
                    int rank = Integer.parseInt(line[0]);
                    System.out.println(name + " is ranked #" + rank + " in year " + year);
                    break;
                }
            }
        }

    }    
}
