package c07_SingleDimensionArrays;/* (Game: Eight Queens) The classic Eight Queens puzzle is to place eight queens
on a chessboard such that no two queens can attack each other (i.e., no two queens
are on the same row, same column, or same diagonal). There are many possible
solutions. Write a program that displays one such solution. A sample output is
shown below:

|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |

*/

public class E0736 {
    public static void main(String[] args) {
        int[] column = new int[8];
        java.util.Arrays.fill(column, 1);

        for (int i = 0; i < column.length; i++){
            int columnNumber = pickColumn(column);
            printRow(columnNumber, column);
            column[columnNumber] = 0;
        }
    }
        
    public static int pickColumn(int[] list) {
        int pick = 0;
        int index = 0;
        while (pick == 0) {
            index = (int) (Math.random() * list.length);
            pick = list[index];
        }
        return index;
    }

    public static void printRow(int n, int[] list) {
        for (int i = 0; i < n; i++) System.out.print("| ");
        System.out.print("|Q");
        for (int i = n; i < list.length; i++) System.out.print("| ");
        System.out.print("|\n");
    }
}
        