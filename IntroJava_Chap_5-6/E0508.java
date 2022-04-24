import java.util.Scanner;

public class E0508 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int total = input.nextInt();
        int highest = 0;
        String highname = "";

        for (int n =1; n <= total; n++) {
            System.out.println("Enter the name of student:");
            String name = input.next();
            System.out.println("Enter the score of the student:");
            int score = input.nextInt();
            if (score > highest) {
                highname = name;
                highest = score;
            }
        }
        System.out.println("Student " + highname + " has highest score: " + highest);
        input.close();   
    }
}
