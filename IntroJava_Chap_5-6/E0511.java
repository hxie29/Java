public class E0510 {
    public static void main(String[] args) {
        int count = 0;
        for (int n =100; n <= 200; n++) {
            if ((n % 3 == 0) ^ (n % 4 ==0)){
                count+=1;
                System.out.print((count % 10 != 0) ? n + " " : n + "\n");
            }
       } 
    }
}
