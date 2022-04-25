import java.util.Scanner;

public class E0534{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int youWin = 0;
        int computerWin = 0;

        // condition to continue the game
        while (youWin < 3 && computerWin <3) {

            // start one round of game
            System.out.println("Please enter a number for scissor (0), rock (1), paper (2): ");
            int you = input.nextInt();

                // check input validity
                if ((you <= 2) && (you >= 0)){
                    int computer = (int) (Math.random() * 2 + 1);

                //print computer choice
                    if (computer == 0) {
                        System.out.print("The computer is scissor. ");
                    }
                    else if (computer == 1) {
                        System.out.print("The computer is rock. ");
                    }
                    else
                    System.out.print("The computer is paper. ");
                        
                //print your choice
                    if (you == 0) {
                        System.out.print("You are scissor. ");
                    }
                    else if (you == 1) {
                        System.out.print("You are rock. ");
                    }
                    else
                    System.out.print("You are paper. ");

                //print result
                    if (you == computer) {
                        System.out.println(" It is a draw."); 
                    }
                    else if ( (you - computer == -1) || (you - computer == 2) ){
                        System.out.println(" You lost.");
                        computerWin++;
                    }
                    else {
                        System.out.println(" You won.");
                        youWin++;
                    }
                    // show current scores
                        System.out.println("Current scores:\n You: " + youWin + "    Computer: " + computerWin);
                }
                else {
                    System.out.println("Invalid input.");
                }
            }

            System.out.println((youWin > computerWin)? "You win the game!" : "You lost the game");
            input.close();
        }
    }
