import java.util.Scanner;

public class E03L01 {
    public static void main(String[] args){
        int number1 = (int)(System.currentTimeMillis() % 10);
        int number2 = (int)(System.currentTimeMillis() / 10 % 10);

        Scanner input = new Scanner(System.in);
        System.out.println("What is the sum of " + number1 + " , " + number2 + "?");
        double answer = input.nextDouble();
        
        
        if (answer == number1 + number2) {
            System.out.println("Correct!");
            }
        else {
            System.out.println("Incorrect.");
    
        }
        
        input.close();
    }   
}
