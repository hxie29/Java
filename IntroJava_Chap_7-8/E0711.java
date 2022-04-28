import java.util.Scanner;

public class E0711 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        double[] list  = new double[input.nextInt()];

        createScoreList(list);
        double mean = mean(list);
        double deviation = deviation(list);
        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);

        input.close();
    }

    public static double[] createScoreList(double[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the scores:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextDouble();
        }
        input.close();
        return list;
    }

    public static double mean(double[] list) {
        double sum = 0;
        for (int k = 0; k < list.length; k++){
            sum += list[k];
        }
        double mean = sum / list.length;
        return mean;
    }

    public static double deviation(double[] list) {
        double geometrySum = 0;
        double mean = mean(list);
        for (int k = 0; k < list.length; k++){
            geometrySum += Math.pow((list[k] - mean), 2);
        }
        double deviation = Math.pow((geometrySum / (list.length -1)), 0.5);
        return deviation;
    }
  
}
