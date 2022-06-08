package c08_MultidimensionArrays;/* (Guess the capitals) Write a program that repeatedly prompts the user to enter
a capital for a state. Upon receiving the user input, the program reports whether
the answer is correct. Assume that 50 states and their capitals are stored in a
two-dimensional array, as shown in Figure 8.10. The program prompts the user to
answer all states’ capitals and displays the total correct count. The user’s answer
is not case-sensitive.

Alabama Montgomery
Alaska Juneau
Arizona Phoenix

*/
import java.util.Scanner;
public class E0837 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] list = {{"Alabama", "Montgomery"},
                            {"Alaska", "Juneau"},
                            {"Arizona", "Phoenix"}};
        int count = 0;
        int index = 0;
        while (index < list.length) {
            System.out.println("What is the capital of " + list[index][0] + "?");
            String answer = input.nextLine().toLowerCase();
            if (answer.equalsIgnoreCase(list[index][1])) {
                System.out.println("Your answer is correct.");
                count++;
            }
            else System.out.println("The correct answer should be " + list[index][1]);
            index++;
        }
        System.out.println("The correct count is " + count);
        input.close();
    } 
    
}
