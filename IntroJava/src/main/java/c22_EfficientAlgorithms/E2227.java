package c22_EfficientAlgorithms;

/*(Optimal bin packing) Rewrite the preceding program so that it finds an optimal
solution that packs all objects using the smallest number of containers. Here is
a sample run of the program:
Enter the number of objects: 6
Enter the weights of the objects: 7 5 2 3 5 8
Container 1 contains objects with weight 7 3
Container 2 contains objects with weight 5 5
Container 3 contains objects with weight 2 8
The optimal number of bins is 3
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E2227 {
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
        // sort complexity is ????
        Collections.sort(goods);

        int count = 0;
        ArrayList<Integer> container = new ArrayList<>();
        while(!goods.isEmpty()) {
            count++;
            container.add(goods.get(0));
            goods.remove(0);
            int j = goods.size() -1;
            while(!goods.isEmpty() && j >= 0) {
                if (sum(container) + goods.get(j) <= limit) {
                    container.add(goods.get(j));
                    goods.remove(j);
                }
                else
                    j--;
            }
            System.out.println("Container " + count + "contains objects with weight " + container);
            container.clear();
        }
        System.out.println("The optimal number of bins is " + count);
    }
    
    public static int sum(ArrayList<Integer> list){
        int sum =0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
