/*(Largest block) The problem for finding a largest block is described in
Programming Exercise 8.35. Design a dynamic programming algorithm for
solving this problem in O(n2) time. Write a test program that displays a 10- by-
10 square matrix, as shown in Figure 22.14a. Each element in the matrix is 0 or
1, randomly generated with a click of the Refresh button. Display each number
centered in a text field. Use a text field for each entry. Allow the user to change
the entry value. Click the Find Largest Block button to find a largest square
submatrix that consists of 1s. Highlight the numbers in the block, as shown
in Figure 22.14b. See liveexample.pearsoncmg.com/dsanimation/LargestBlock
.html for an interactive test.

*/
package c22_EfficientAlgorithms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LargestBlockPane extends BorderPane {
    private final TextField[][] textFields = new TextField[10][10];
    private final int[][] block = new int[10][10];
    private final int[][] sizes = new int[10][10];
    private int maxBlockSize = 1, row = 0, column = 0;
    public LargestBlockPane() {
        Button btRefresh = new Button("Refresh");
        Button btFind = new Button("Find the largest block");
        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(btRefresh, btFind);
        controlPanel.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        setCenter(grid);
        setBottom(controlPanel);
        BorderPane.setAlignment(grid,Pos.CENTER);
        BorderPane.setAlignment(controlPanel,Pos.CENTER);

        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                block[i][j] = (int)(Math.random() + 0.5);
                textFields[i][j] = new TextField("" + block[i][j]);
                textFields[i][j].setPrefSize(30,30);
                textFields[i][j].setStyle("-fx-border-color: black;");
                textFields[i][j].setAlignment(Pos.CENTER);
                grid.add(textFields[i][j], i, j);
                textFields[i][j].setOnAction(e -> getNumbers());
            }
        }

        btRefresh.setOnAction(e -> refresh());
        btFind.setOnAction(e -> find());
    }

    public void refresh() {
        setRandom();
        removeResult();
    }

    private void getNumbers() {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                block[i][j] = Integer.parseInt(textFields[i][j].getText());
            }
        }
        removeResult();
        find();
    }

    private void removeResult() {
        // clear colors
        for (int i = row; i < row + maxBlockSize; i++) {
            for (int j = column; j < column + maxBlockSize; j++) {
                textFields[i][j].setStyle("-fx-background-color: white;");
                textFields[i][j].setStyle("-fx-border-color: black;");
            }
        }
        row = 0;
        column = 0;
        maxBlockSize = 1;
    }

    private void setRandom() {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                block[i][j] = (int)(Math.random() + 0.5);
                textFields[i][j].setText(block[i][j] + "");
            }
        }
    }

    public void find() {
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                int size = minSize(i,j) -1;
                while (i + size < block.length && j + size < block.length) {
                    if (sameBlock(i, j, size + 1)) {
                        size++;
                    }
                    else
                        break;
                }
                sizes[i][j] = size;
                if (size > maxBlockSize) {
                    maxBlockSize = size;
                    row = i;
                    column = j;
                }
            }
        }
    // set colors
        for (int i = row; i < row + maxBlockSize; i++) {
            for (int j = column; j < column + maxBlockSize; j++) {
                textFields[i][j].setStyle("-fx-background-color: red;");
            }
        }
    }
    private boolean sameBlock(int i, int j, int size) {
        int n = block[i][j];
        if (i + size >= block.length || j + size >= block.length)
            return false;

        for (int a = i; a < i + size -1; a++) {
            if (block[a][j + size -1] != n)
                return false;
        }
        for (int b = j; b < j + size; b++) {
            if (block[ i+ size -1][b] != n)
                return false;
        }
        return true;
    }

    private int minSize(int i , int j) {
        if (i == 0 && j == 0)
            return 1;
        else if (i == 0) {
            return sizes[0][j-1];
        }
        else if (j == 0) {
            return sizes[i-1][0];
        }
        else {
            int n = Math.min(sizes[i-1][j-1], sizes[i-1][j]);
            return Math.min(n, sizes[i][j-1]);
        }
    }
}
