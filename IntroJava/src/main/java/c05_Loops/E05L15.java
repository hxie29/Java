package c05_Loops;

public class E05L15 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("The first 50 prime numbers are:");
        for (int x = 2; true; x++) {
            boolean prime = true;
            for (int k = 2; k < x; k++) {
                if (x % k ==0) {
                    prime = false;
                    break;
                }
            }
            if (prime && n <=49 ) {
                n++;
                System.out.print( (n % 10 !=0) ? x + " " : x + "\n"); 
            }
            else if (n> 49){
                break;
            }
        }
    }    
}
