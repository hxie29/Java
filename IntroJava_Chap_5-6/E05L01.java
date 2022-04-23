public class E05L01 {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x++); // print out x, then x++, print out 10
        System.out.println(x); // x = 11
        System.out.println(++x); // ++x, then print out new x = 12

        if (x++ == 12) { // x = 12, then x++, 
            System.out.println(x); // x = 13
        }
    }
}
