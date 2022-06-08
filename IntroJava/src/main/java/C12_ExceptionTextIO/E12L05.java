//Quotient method with Exception + input mismatch exception
import java.util.InputMismatchException;
import java.util.Scanner;
public class E12L05 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;
        do{
            try{
                System.out.println("Enter 2 integers:");
                int n1 = input.nextInt();
                int n2 = input.nextInt();
                try{
                    int result = quotient(n1,n2);
                    System.out.println("Result is " + result);
                    continueInput = false;
                }
                catch (ArithmeticException ex) {
                    System.out.println(ex.getMessage());
                    input.nextLine(); // Discard input, without this line the program will terminate (exit the loop)
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Try again. Input incorrect.");
                input.nextLine(); // Discard input, without this line, it will be an infinite loop
            }
        } while (continueInput);

        input.close();
    }

    public static int quotient(int n1, int n2){
        if (n2 == 0) 
            throw new ArithmeticException("Divisor cannot be zero");
        
        return n2 / n1;
    }
}
