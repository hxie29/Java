// defining a method
public class E06L01 {
    
    public static void main(String [] args){
        int j = 5;
        int i = 2;
        int k = max(i, j);
        System.out.println(k);
    }
    //max method
    public static int max (int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

}
