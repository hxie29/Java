package c05_Loops;

public class E0503 {
    public static void main(String[] args) {
        System.out.printf("%-15s %15s %n", "Celsius", "Fahrenheit");
        for (int celsius =0; celsius <= 100; celsius+=2){
            // mistake: integer divided by a float point (not an integer!)
            double frah = celsius * 9 / 5.0 + 32;

            // formatting digit integers and float point numbers are different
            System.out.printf("%-15d %15.1f %n", celsius, frah);
        }
    }
}
