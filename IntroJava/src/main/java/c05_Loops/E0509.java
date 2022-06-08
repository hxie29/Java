package c05_Loops;

import java.util.Scanner;

public class E0509 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int total = input.nextInt();
        int low1 = 10000;
        int low2 = 10001;
        String lowname1 = "";
        String lowname2 = "";

        for (int n =1; n <= total; n++) {
            System.out.println("Enter the name of student:");
            String name = input.next();
            System.out.println("Enter the score of the student:");
            int score = input.nextInt();
            if (score <= low1) {
                low2 = low1;
                low1 = score;
                lowname2 = lowname1;
                lowname1 = name;
            }
            else if (score <low2) {
                low2 = score;
                lowname2 = name;
            }
        }
        System.out.println("Student " + lowname1 + " has lowest score: " + low1);
        System.out.println("Student " + lowname2 + " has second to lowest score: " + low2);
        input.close();   
    }
}
