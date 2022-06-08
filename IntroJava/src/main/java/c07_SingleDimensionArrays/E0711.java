package c07_SingleDimensionArrays;

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

    public static void createScoreList(double[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the scores:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextDouble();
        }
        input.close();
    }

    public static double mean(double[] list) {
        double sum = 0;
        for (double v : list) {
            sum += v;
        }
        return sum / list.length;
    }

    public static double deviation(double[] list) {
        double geometrySum = 0;
        double mean = mean(list);
        for (double v : list) {
            geometrySum += Math.pow((v - mean), 2);
        }
        return Math.pow((geometrySum / (list.length -1)), 0.5);
    }
  
}
