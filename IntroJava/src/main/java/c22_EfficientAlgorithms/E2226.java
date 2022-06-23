package c22_EfficientAlgorithms;/*
(Bin packing with smallest object first) The bin packing problem is to pack the
objects of various weights into containers. Assume each container can hold a
maximum of 10 pounds. The program uses an algorithm that places an object
with the smallest weight into the first bin in which it would fit. Your program
should prompt the user to enter the total number of objects and the weight of each
object. The program displays the total number of containers needed to pack the
objects, and the contents of each container. Here is a sample run of the program:

Enter the number of objects: 6
Enter the weights of the objects: 7 5 2 3 5 8
Container 1 contains objects with weight 2 3 5
Container 2 contains objects with weight 5
Container 3 contains objects with weight 7
Container 4 contains objects with weight 8

Does this program produce an optimal solution, that is, finding the minimum
number of containers to pack the objects?
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E2226 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int limit = 10;

        //input of weights, stored in integer list
        System.out.println("Enter the number of objects:");
        int n = input.nextInt();
        System.out.println("Enter the weights of the objects:");
        ArrayList<Integer> goods = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int weight = input.nextInt();
            goods.add(weight);
        }
        Collections.sort(goods);

        ArrayList<Integer> container = new ArrayList<>();
        for (int i = 0; !goods.isEmpty(); i++) {
            for (int j = 0; j < goods.size(); j++) {
                if (sum(container) + goods.get(j) <= limit) {
                    container.add(goods.get(j));
                    //System.out.println(container.toString());
                    goods.remove(j);
                    j--;
                    //System.out.println(goods.toString());
                }
                if (sum(container) >= limit) break;
            }
            System.out.println("Container " + i + "contains objects with weight " + container);
            container.clear();
        }
        
    }
    
    public static int sum(ArrayList<Integer> list){
        int sum =0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
