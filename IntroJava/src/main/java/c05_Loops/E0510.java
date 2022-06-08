package c05_Loops;

public class E0510 {
    public static void main(String[] args) {
        int count = 0;
        for (int n =100; n <= 1000; n++) {
            if (n % 12 == 0) {
                count+=1;
                System.out.print((count % 10 != 0) ? n + " " : n + "\n");
            }
       } 
    }
}
