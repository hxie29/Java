import java.util.Scanner;

public class E0545 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = input.nextInt();
        double sum = 0;
        double geometrySum = 0;
    
        // input and compute sum
        for (int k = 1; k <= n; k++){
            System.out.println("Enter a score: ");
            //add sum and sum of squares
            double score = input.nextDouble();
            sum += score;
            geometrySum += (score * score);
        }
    
        double mean = sum / n;
        double geoMean = geometrySum / n;
        double deviation = Math.pow(((geoMean - mean * mean / n)/ (n-1)), 0.5);

        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);

        input.close();
    }

}
