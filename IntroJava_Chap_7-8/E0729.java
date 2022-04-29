/* (Game: dice) Suppose three dice are thrown at random. Write a program that
shows all possible permutations or configurations of the three dice that yield the sum of nine. */
import java.util.Scanner;
public class E0729 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of dices");
        int[] diceResult = new int[input.nextInt()];
        System.out.println("Enter the total sum");
        int sum = input.nextInt();

        //create an array showing all the results
        String[] combination = new String[(int)Math.pow(6, diceResult.length)];
        int index = 0;

        // throw the first dice from 1 to 6
        for (int i = 0; i < 6; i++) {
            diceResult[0] = i + 1; 
            int total = diceResult[0];
            for (int j = 1; j <= 6 ; j++) {
                diceResult[1] =j;
                total += diceResult[1];
                if ((sum - total > 0) && (sum - total <= 6)) {
                    diceResult[diceResult.length -1] = sum - total;
                    combination[index] = turnString(diceResult);
                    index++;
                    }
                } 
            }
        // Display permutations
        System.out.println("All possible combinations are:");
        displayStringArray(combination);

        input.close();
    }
 
    //Throw a dice
    public static int throwDice(){
        return (int)(Math.random() * 6) + 1;
    }

    // turn sequence into a string
    public static String turnString(int[] list) {
        String str = "";
        for (int i = 0; i < list.length; i++) {
            str += (list[i] + " ");
        }
        return str;
    }

    // Display array method, 20 per line
    public static void displayStringArray(String[] list) {
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) System.out.println(list[i]);
        } 
    }

    // linear search function
    public static int linearSearch(String[] permutation, String key){
        for (int i = 0; i < permutation.length; i++) {
            if (key == permutation[i]) return i;
        }
        return -1;
    }
}
