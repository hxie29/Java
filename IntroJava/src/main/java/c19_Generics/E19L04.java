// Generic sort
package c19_Generics;

public class E19L04 {
    public static void main(String[] args) {
        Integer[] intArray = {2, 4, 3};
        Double[] doubleArray = {3.4, 1.3, -22.1};

        Character[] charArray = {'a', 'J', 'r'};
        String[] strArray = {"Tom", "Susan", "Kim"};

        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(strArray);

        printList(intArray);
        printList(doubleArray);
        printList(charArray);
        printList(strArray);
    }

    public static <E extends Comparable<E>> void sort(E[] list) {
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length -1; i++) {
            currentMin = list[i];
            currentMinIndex = i;

            for (int j = i +1; j < list.length-1; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void printList(Object[] list) {
        for (Object o: list) {
            System.out.print(o.toString() + " ");
        }
        System.out.println();
    }
}
