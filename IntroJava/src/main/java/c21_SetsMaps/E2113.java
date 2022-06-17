/*(Baby name popularity ranking) Revise Programming Exercise 21.11 to
prompt the user to enter year, gender, and name and display the ranking for the
name. Prompt the user to enter another inquiry or exit the program. Here is a
sample run:

Enter the year: 2010
Enter the gender: M
Enter the name: Javier
Boy name Javier is ranked #190 in year 2010
Enter another inquiry? Y
Enter the year: 2001
Enter the gender: F
Enter the name: Emily
Girl name Emily is ranked #1 in year 2001
Enter another inquiry? N*/
package c21_SetsMaps;

import java.io.File;
import java.util.Scanner;

public class E2113 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the year: ");
            int year = input.nextInt();
            System.out.println("Enter the gender:");
            char gender = Character.toUpperCase(input.next().charAt(0));
            System.out.println("Enter the name:");
            String name = input.next();
            findRanking(year, gender, name);
            System.out.println("Enter another inquiry? ");
            char status = input.next().charAt(0);
            if (status == 'N')
                break;
        }
    }

    private static void findRanking(int year, char gender, String name) {
        File file = new File("/Users/halda/Documents/GitHub/Java/IntroJava/src/main/java/c12_ExceptionTextIO/test/babynamesranking" + year + ".txt");
        if (!file.exists()) {
            System.out.println("Ranking file does not exist, please download");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                int rank = 0;
                while (input.hasNextLine()) {
                    String[] words = input.nextLine().split("\\s+");
                    if (gender == 'M') {
                        if (words[1].equals(name))
                            rank = Integer.parseInt(words[0]);
                    }
                    else if (gender == 'F') {
                        if (words[3].equals(name))
                            rank = Integer.parseInt(words[0]);
                    }
                }
                if (rank != 0)
                    System.out.println(gender + " name " + name + " is ranked #" + rank + " in year " + year);
                else
                    System.out.println(gender + " name " + name + " is not in the ranking in year " + year);

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
