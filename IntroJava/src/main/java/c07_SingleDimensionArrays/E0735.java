package c07_SingleDimensionArrays;/* (Game: hangman) Write a hangman game that randomly generates a word and
prompts the user to guess one letter at a time, as presented in the sample run.
Each letter in the word is displayed as an asterisk. When the user makes a correct
guess, the actual letter is then displayed. When the user finishes a word, display
the number of misses and ask the user whether to continue to play with another
word. Declare an array to store words, as follows:
// Add any words you wish in this array String[] words = {"write", "that",...}; */

import java.util.Arrays;
import java.util.Scanner;

public class E0735 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] words = {"write", "that", "perfect", "project", "would", "exception", "evolve", "generic"};
        
        int play = 1;
        
        while (play == 1) {
            String answer = pickWordFrom(words);
            char[] answerArray = createArray(answer);
            char[] reply = new char[answerArray.length];
            java.util.Arrays.fill(reply,'*');  
            int[] miss = {0};
            int[] count = {0};

            while(count[0] < answerArray.length) {
                char letter = getLetter(reply);
                checkLetter(letter, answerArray, reply, miss, count);
            }
            System.out.println("The word is " + answer + ". You missed " + miss[0] + " times.");
            System.out.println("Play another round? Enter 1 for yes, 0 for no.");
            play = input.nextInt();
        }
        System.out.println("Thanks for playing!");
        input.close();

    }

    // ask asnwer
    public static char getLetter(char[] list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Guess, enter a letter in word ");
        printChar(list);
        System.out.print(" > ");
        //input.close();
        return input.next().charAt(0);
    }
    // print char array
    public static void printChar(char[] list) {
        for (char c : list) {
            System.out.print(c);
        }
    }

    // pick a word from an array of strings
    public static String pickWordFrom(String[] list) {
        return list[(int)(Math.random() * list.length)];
    }

    // parse the string into an array
    public static char[] createArray(String sentence) {
        char[] list = new char[sentence.length()];
        for (int i = 0; i < list.length; i++ ) {
            list[i] = sentence.charAt(i);
        }
        return list;
    }

    // check if letter is in the answer
    public static void checkLetter(char key, char[] answerArray, char[] reply, int[] miss, int[] count) {
        int[] nonMatch = new int[answerArray.length];
        java.util.Arrays.fill(nonMatch,0);
        int[] finding = linearSearch(answerArray, key);
        //printInt(finding);
        int[] included = linearSearch(reply, key);
        //printInt(included);
        if (java.util.Arrays.equals(finding, nonMatch)) {
            System.out.println(key + " is not in the word.");
            miss[0]++;
        }
        if (!java.util.Arrays.equals(finding, nonMatch) && Arrays.equals(finding, included)) System.out.println(key + " is already in the word.");
        if (!java.util.Arrays.equals(finding, nonMatch) && !Arrays.equals(finding, included)) {
            for (int i = 0; i < answerArray.length; i++) {
                if (finding[i] == 1) {
                    reply[i] = answerArray[i];
                    count[0]++;
                }
            }
        }
    }

    // linear search function returning matching key's index number in the array
    public static int[] linearSearch(char[] list, char key){
        int[] index = new int[list.length];
        java.util.Arrays.fill(index, 0);
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) index[i] = 1;
        }
        return index;
    }
}
