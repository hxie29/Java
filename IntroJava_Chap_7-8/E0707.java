// Generate 200 single digits, count appearance of each
public class E0707 {
    public static void main(String[] args) {
        int[] list = new int[200];
        for (int i = 0; i < list.length; i++) {
            list[i]= (int)(Math.random() * 10);
        }
        displayArray(list);
        int[] count = countNumbers(list);
        displayCount(count);
    }
    
    // Display array method, 20 per line
    public static void displayArray(int[] list) {
        int item = 0;
        for (int i = 0; i < list.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? list[i] + "\n" : list[i] + " ");
        } 
    }

    // Count method
    public static int[] countNumbers(int[] list) {
        int[] count = new int[10];
        for (int i = 0; i < list.length; i++) {
            count[list[i]]++;
        }
        return count;
    }
    // Display count
    public static void displayCount(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                System.out.println(i + " occurs " + count[i] + " time.");
            }
            if (count[i] > 1) {
                System.out.println(i + " occurs " + count[i] + " times.");
            }
        }
    }
}