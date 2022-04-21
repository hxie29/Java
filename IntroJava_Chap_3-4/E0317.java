import java.util.Scanner;

public class E0317 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number for scissor (0), rock (1), paper (2): ");
        int you = input.nextInt();

        if ((you <= 2) && (you >= 0)){

                int computer = (int) (Math.random() * 2 + 1);

        //computer choice
                if (computer == 0) {
                    System.out.print("The computer is scissor. ");
                }
                else if (computer == 1) {
                    System.out.print("The computer is rock. ");
                }
                else
                System.out.print("The computer is paper. ");
                
        // your choice
                if (you == 0) {
                    System.out.print("You are scissor. ");
                }
                else if (you == 1) {
                    System.out.print("You are rock. ");
                }
                else
                System.out.print("You are paper. ");

        // result
                if (you == computer) {
                    System.out.println(" It is a draw.");
                }
                else if ( (you - computer == -1) || (you - computer == 2) ){
                    System.out.println(" You lost.");
                }
                else 
                    System.out.println(" You won.");
            input.close();
            }
        else 
        System.out.println("Invalid input.");
    }
}
