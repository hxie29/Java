
public class E0515 {
    public static void main(String [] args) {
        int n1 = '!';
        int n2 = '~';
        int count = 0;
        for (int x =0; x <= n2-n1; x++) {
            count++;
            System.out.print((count % 10 !=0) ? (char)(n1 + x) + " " : (char) (n1+x) + "\n");  
            
        }
    }
}
