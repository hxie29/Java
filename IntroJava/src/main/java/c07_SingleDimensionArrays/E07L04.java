package c07_SingleDimensionArrays;

public class E07L04 {
    public static void main(String [] args){
        // create two arrays
        char[] letters = createArray(100);
        int[] counts = countLetter(letters);
        System.out.println("The letters are:");
        displayArray(letters);
        System.out.println("The appearances of each letters are:");
        displayCounts(counts);
    }

    // Create array method: generating n random lower case letters and assign them to array letters
    public static char[] createArray(int n) {
        char[] array = new char[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (Math.random()*26 + 'a');
        }  
        return array; 
    }

    // Count letter method: count each letters' appearance, assign the value to corresponding index of counts;
    public static int[] countLetter(char[] array) {
        int[] countArray = new int[26];
        for (char c : array) {
            countArray[(c - 'a')]++;
        }
        return countArray;
    }

    // Display array method, 20 per line
    public static void displayArray(char[] letters) {
        int item = 0;
        for (char letter : letters) {
            item++;
            System.out.print((item % 20 == 0) ? letter + "\n" : letter + " ");
        } 
    }

    // Display count method, 10 per line
    public static void displayCounts(int[] counts) {
        int item = 0;
        for (int i = 0; i < counts.length; i++) {
            item++;
            System.out.printf( (item % 10 == 0) ? (char)(i + 'a') + " " + counts[i] + "\n" : (char)(i + 'a') + " "+ counts[i] + " ");
        } 
    }
}
