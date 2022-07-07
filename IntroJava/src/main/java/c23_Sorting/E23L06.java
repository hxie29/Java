package c23_Sorting;

public class E23L06 {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        MergeSort.mergeSort(list);
        for (int j : list) System.out.print(j + " ");
    }
}
