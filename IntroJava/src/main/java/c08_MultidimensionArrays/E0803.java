package c08_MultidimensionArrays;/* (Sort students on grades) Rewrite Listing 8.2, GradeExam.java, to display students
in decreasing order of the number of correct answers */

public class E0803 {
    public static void main(String[] args) {
        // STUDENTS' ANSWERS
        char[][] answers = {
            {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
            {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
            {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
            {'A', 'B', 'C', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
            {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        
        // KEY TO QUESTIONS
        char[] key ={'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

        // Correct answer each students
        int[][] correctAnswer;
        correctAnswer = calcScores(answers, key);

        //Print students and scores in descending order
        printScores(correctAnswer);
    }
    
    public static int[][] calcScores(char[][] answers, char[] key) {
        int[][] scores = new int[8][answers.length];
        for (int i = 0; i < answers.length; i++) {
            int count = 0;
            for (int j = 0; j < key.length; j++) {
                if (answers[i][j] == key[j]) count++;
            }
            scores[i][0] = i;
            scores[i][1] = count;
        }
        return scores;
    }

    // Sort and print students number and scores in pair
    public static void printScores(int[][] correctAnswer) {
        // Sorting students number and scores in pair
        for (int i = 0; i < correctAnswer.length; i++) {
            int max = correctAnswer[i][1];
            int maxIndex = i;
            for (int j = i+1; j < correctAnswer.length; j++) {
                if (correctAnswer[j][1] > max) {
                    max = correctAnswer[j][1];
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int[] temp = correctAnswer[maxIndex];
                correctAnswer[maxIndex] = correctAnswer[i];
                correctAnswer[i] = temp;
            }
        }
        // print in pair
        for (int[] ints : correctAnswer) {
            System.out.println("Student " + ints[0] + "'s correct answer count is " + ints[1]);
        }
    }
}
