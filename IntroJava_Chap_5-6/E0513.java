public class E0510 {
    public static void main(String[] args) {
        int n = 100;
        while (true) {
            //  mistake below
            if ((n+1)*(n+1) >= 12000)
                break;
            n++;
        }
        System.out.print(n);
       } 
    }
