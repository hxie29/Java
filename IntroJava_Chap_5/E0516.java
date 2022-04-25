import java.util.Scanner;

public class E0516 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int number = input.nextInt();
        int factor = 2;
        
        while ((factor <= number) && number !=1) {
            if ((number % factor == 0) ){
                System.out.print(factor + " ");
                number /=factor;
                factor = 2;
            }
            else
                factor++;
        }
        input.close();
    }    
}