/* (Compute the weekly hours for each employee) Suppose the weekly hours
for all employees are stored in a two-dimensional array. Each row records an
employee’s seven-day work hours with seven columns. For example, the following
array stores the work hours for eight employees. Write a program that
displays employees and their total hours in increasing order of the total hours. */

public class E0804 {
    public static void main(String[] args) {
        // Employees hours for each day of the week
        int[][] hours = {
            {2, 4, 3, 4, 5, 8, 8},
            {7, 3, 4, 3, 3, 4, 4},
            {3, 3, 4, 3, 3, 2, 2},
            {9, 3, 4, 7, 3, 4, 1},
            {3, 5, 4, 3, 6, 3, 8},
            {3, 4, 4, 6, 3, 4, 4},
            {3, 7, 4, 8, 3, 8, 4},
            {6, 3, 5, 9, 2, 7, 9}};
        
        int[][]weeklyHours = weekly(hours);
        
        printHours(weeklyHours);
    }
    
    public static int[][] weekly(int[][]hours) {
        int[][]weekly = new int[hours.length][2];
        for (int i = 0; i < hours.length; i++) {
            weekly[i][0] = i;
            for (int j = 0; j < hours[i].length; j++) {
                weekly[i][1] += hours[i][j];
            }
        }
        return weekly;
    }

    // Sort and print hours in increasing order in pair
    public static void printHours(int[][] weeklyHours) {

        for (int i = 0; i < weeklyHours.length; i++) {
            int min = weeklyHours[i][1];
            int minIndex = i;
            for (int j = i+1; j < weeklyHours.length; j++) {
                if (weeklyHours[j][1] < min) {
                    min = weeklyHours[j][1];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int[] temp = weeklyHours[minIndex];
                weeklyHours[minIndex] = weeklyHours[i];
                weeklyHours[i] = temp;
            }
        }
        // print in pair
        for (int i = 0; i < weeklyHours.length; i++ ) {
            System.out.println("Employee " + weeklyHours[i][0] + "'s weekly working hours is " + weeklyHours[i][1]);
        }
    }
}
