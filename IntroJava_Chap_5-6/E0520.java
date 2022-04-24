import java.util.Scanner;

public class E0520 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the upper limit:");
        int upper = input.nextInt();
        int count = 1;
        
        for (int x =2; x <= upper; x++){
            boolean prime = true;
            for (int k = 2; k < x; k++){
                if (x % k == 0){
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
                System.out.print((count % 8) != 0 ? x + " " : x + "\n");
            }
        }
        input.close();
    }   
}
