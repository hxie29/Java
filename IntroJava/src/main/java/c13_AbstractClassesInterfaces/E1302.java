import java.util.ArrayList;

/*
(Average ArrayList) Write the following method that averages an ArrayList of
integers:
public static void average(ArrayList<Integer> list)
*/
public class E1302 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(-5);
        list.add(3);
        average(list);
    }

    public static void average(ArrayList<Integer> list) {
        if (list.size() == 0 || list == null) {
            System.out.println("The list is empty.");
        }
        else {
            int sum = 0;
            for (Integer e: list) {
                sum += e;
            }
            System.out.println(sum * 1.0 / list.size());
        }
    }
}
