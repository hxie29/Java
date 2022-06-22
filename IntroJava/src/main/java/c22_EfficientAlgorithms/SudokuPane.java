package c22_EfficientAlgorithms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Objects;
import java.util.Stack;

public class SudokuPane extends GridPane {
    private final TextField[][] textFields = new TextField[9][9];
    private final int[][] inputNumbers = new int[9][9];
    private final int[][] result = new int[9][9];

    public SudokuPane() {
        setPadding(new Insets(10,10,10,10));
        setAlignment(Pos.CENTER);
        setHgap(2);
        setVgap(2);

        GridPane[][] blocks = new GridPane[3][3];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                blocks[i][j] = makeGrid(i,j);
                this.add(blocks[i][j], i, j);
            }
        }
    }

    public boolean getInput() {
        readNumbers();
        return checkInput();
    }

    private boolean checkInput() {
        for (int i = inputNumbers.length -1; i >= 0; i--) {
            for (int j = inputNumbers[i].length -1; j >= 0; j--) {
                int n = inputNumbers[i][j];
                if (n != 0 && !checkNumbers(i, j, n, inputNumbers))
                    return false;
            }
        }
        return true;
    }

    public boolean solve() {
        if (!compute())
            return false;
        else
            displayResult();
        return true;
    }

    public void clear() {
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j <textFields[i].length; j++) {
                inputNumbers[i][j] = 0;
                result[i][j] = 0;
                textFields[i][j].clear();
                textFields[i][j].setStyle("-fx-text-fill: black");
            }
        }
    }

    private void readNumbers() {
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j <textFields[i].length; j++) {
                if (Objects.equals(textFields[i][j].getText(), ""))
                    inputNumbers[i][j] = 0;
                else
                    inputNumbers[i][j] = Integer.parseInt(textFields[i][j].getText());
            }
        }
    }

    private boolean compute() {
        int row = 0;
        int column = 0;
        int start = 0;
        Stack<int[]> lastSearch = new Stack<>();
        lastSearch.push(new int[]{0, 0, 1});

        while (true) {
            //find the number
            // if it's an input, keep the number
            if (inputNumbers[row][column] != 0) {
                result[row][column] = inputNumbers[row][column];
            }
            // if it's not an input, compute number
            else{
                boolean found = false;
                for (int n = start + 1; n <= 9; n++) {
                    if (checkNumbers(row, column, n, result)) {
                        result[row][column] = n;
                        lastSearch.push(new int[]{row, column, n});
                        found = true;
                        break;
                    }
                }

                if (found) {
                    // for next cell, start searching from 1, set start to 0
                    start = 0;
                    // move forward index
                    if (column < result.length -1) {
                        column = 0;
                        row++;
                        // if last row is finished, exit compute
                        if (row == inputNumbers.length)
                            return true;
                    }
                    else
                        column++;
                }
                // if this cell's option is exhausted, iterate again from last available cell
                // if there is available cell
                else if (lastSearch.size() > 0) {
                    int[] last = lastSearch.pop();
                    row = last[0];
                    column = last[1];
                    start = last[2];
                }
                // if no available cell
                else
                    return false;
            }
        }
    }

    private boolean checkNumbers(int row, int column, int number, int[][] array) {
        for (int i = row -1; i >= 0; i--) {
            if (array[i][column] == number)
                return false;
        }
        for (int j = column -1; j >= 0; j--) {
            if (array[row][j] == number)
                return false;
        }
        return true;
    }

    private void displayResult() {
        for (int i = 0; i < inputNumbers.length; i++) {
            for (int j = 0; j < inputNumbers[i].length; j++) {
                if (inputNumbers[i][j] == 0) {
                    textFields[i][j].setText(result[i][j] + "");
                    textFields[i][j].setStyle("-fx-text-fill: red");
                }
            }
        }
    }

    private GridPane makeGrid(int row , int column){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(2);
        grid.setVgap(2);
        int rowIndex = 3 * row;
        int columnIndex = 3 * column;
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = columnIndex; j < columnIndex + 3; j++) {
                textFields[i][j] = new TextField("");
                textFields[i][j].setPrefSize(30,30);
                textFields[i][j].setAlignment(Pos.CENTER);
                grid.add(textFields[i][j], i, j);
            }
        }
        return grid;
    }

}
