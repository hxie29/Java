public class E0507 {
    public static void main(String[] args) {
        double tuition = 10000;
        int year = 0;
        double sum = 0;
        double rate = 1 + 0.06;

        while (year <10) {
            year++;
            tuition*=rate;
            System.out.println("The tuition of year " + year + " is $" + (int)(tuition * 100)/100.0);
        }
        while (year <14){
            year++;
            tuition*=rate;
            sum+=tuition;
        }
        System.out.printf("%s%.3f", "The total cost of four years tuition after the tenth year is $", sum);
    }
}
