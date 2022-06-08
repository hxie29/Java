package c12_ExceptionTextIO;//Quotient method with Exception
import java.util.Scanner;
public class E12L04 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 2 integers:");
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        try{
            int result = quotient(n1,n2);
            System.out.println("Result is " + result);
        }
        catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        input.close();
    }

    public static int quotient(int n1, int n2){
        if (n2 == 0) 
            throw new ArithmeticException("Divisor cannot be zero");
        
        return n2 / n1;
    }
}
