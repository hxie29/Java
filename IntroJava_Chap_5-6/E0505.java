public class E0505 {
    public static void main(String[] args) {
        System.out.printf("%-15s %15s \t|\t %-15s %15s %n", "Celsius", "Fahrenheit", "Farhrenheit", "Celcius");
        int frah2 = 20;
        for (int cels1 =0; cels1 <= 100; cels1+=2){
            // mistake: integer divided by a float point (not an integer!)
            double frah1 = cels1 * 9 / 5.0 + 32;
            Double cels2 = (frah2 - 32) * 5 / 9.0;
            // formatting digit integers and float point numbers are different
            System.out.printf("%-15d %15.3f \t|\t %-15d %15.3f %n", cels1, frah1, frah2, cels2);
            frah2 +=5;
        }
    }
}
