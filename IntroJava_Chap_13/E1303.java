import java.util.ArrayList;

/*
(Average ArrayList) Write the following method that averages an ArrayList of
integers:
public static void average(ArrayList<Integer> list)
*/
import java.util.Arrays;
public class E1303 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(-5);
        list.add(3);
        System.out.println(list.toString());

        sort2(list);
        System.out.println(list.toString());
    }

    //Sort with int[] using Arrays.sort()
    public static void sort(ArrayList<Integer> list) {
        if (list.size() == 0 || list == null) {
            System.out.println("The list is empty.");
        }
        else {
            int[] list2 = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                list2[i] = list.get(i);
            }
            Arrays.sort(list2);
            list.clear();;
            for (int i = 0; i < list2.length; i++) {
                list.add(list2[i]);
            }
        }
    }

    //Selection sort
    public static void sort2(ArrayList<Integer> list) {
        int min;
        int minIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            min = list.get(i).intValue();
            minIndex = i;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).intValue() < min) {
                    min = list.get(j).intValue();
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }
    }
}
