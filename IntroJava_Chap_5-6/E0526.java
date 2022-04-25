import java.util.Scanner;

public class E0526 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the limit of i:");
        int i = input.nextInt();
        double sum1 = 0;

        //calculate from small value to big
        for (int k = i; k>0; k--) {
            sum1 += 4 * Math.pow((-1), (k+1)) * 1.0 / (2 * k - 1);
        }
        System.out.println("The approximate value of pi is " + sum1);

        input.close();
    }    
}
