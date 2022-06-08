package c05_Loops;

public class E0513 {

    public static void main(String[] args) {
        int n = 100;
        while ((n + 1) * (n + 1) < 12000) {
            //  mistake below
            n++;
        }
        System.out.print(n);
       } 
    }
