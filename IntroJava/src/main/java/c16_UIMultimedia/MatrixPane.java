/* E1630
(Pattern recognition: consecutive four equal numbers) Write a GUI program
for Programming Exercise 8.19, as shown in Figures 16.49a–b. Let the user
enter the numbers in the text fields in a grid of 6 rows and 7 columns. The user
can click the Solve button to highlight a sequence of four equal numbers, if it
exists. Initially, the values in the text fields are randomly filled with numbers
from 0 to 9.
 */

package c16_UIMultimedia;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MatrixPane extends BorderPane{
    private int row = 6;
    private int column = 7;
    private int[][] matrix;
    private final ArrayList<Integer> cfIndex = new ArrayList<>();
    private TextField[][] tfNumbers;
    private final Text result = new Text(" ");

    public MatrixPane() {
        setTop(result);
        HBox controlPanel = new HBox(10);
        setBottom(controlPanel);
        GridPane grid = new GridPane();
        setCenter(grid);
        BorderPane.setAlignment(result, Pos.CENTER);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(grid, Pos.CENTER);

        Button btReset = new Button("Reset Numbers");
        Button btSolve = new Button("Solve");
        controlPanel.getChildren().addAll(btSolve, btReset);
        controlPanel.setAlignment(Pos.CENTER);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));

        matrix = new int[row][column];
        tfNumbers = new TextField[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tfNumbers[i][j] = new TextField((int)(Math.random() * 10) + "");
                tfNumbers[i][j].setPrefColumnCount(1);
                grid.add(tfNumbers[i][j], j, i);
            }
        }

        btSolve.setOnAction(e -> solve());
        btReset.setOnAction(e -> resetNumbers());
    }

    public void setRow(int row) {
        this.row = row;
        matrix = new int[row][column];
        tfNumbers = new TextField[row][column];
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
        matrix = new int[row][column];
        tfNumbers = new TextField[row][column];
    }

    public int getColumn() {
        return column;
    }

    private void solve() {
        removeHighlight(cfIndex);
        getMatrix();
        findConsecutive(matrix);
    }

    private void resetNumbers() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tfNumbers[i][j].setText((int)(Math.random() * 10) + "");
            }
        }
        removeHighlight(cfIndex);
    }

    private void getMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = Integer.parseInt(tfNumbers[i][j].getText());
            }
        }
    }

    private void findConsecutive(int[][] matrix) {
        if (isCF(matrix)) {
            result.setText("A consecutive four found");
            highlightCell(cfIndex);
        }
        else result.setText("No consecutive four found");
    }

    private boolean isCF(int[][] matrix) {
        // verify horizontal case
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 3; j++) {
                cfIndex.add(i);
                cfIndex.add(j);
                int count = 1;
                int n = 1;
                //Count consecutives
                while (n < 4) {
                    if (matrix[i][j] == matrix[i][j+n]) {
                        count++;
                        cfIndex.add(i);
                        cfIndex.add(j + n);
                        n++;
                    }
                    else break;
                }
                if (count == 4) return true;
                else cfIndex.clear();
            }
        }
        
         // verify vertical case
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length - 3; i++) {
                int count = 1;
                int n = 1;
                cfIndex.add(i);
                cfIndex.add(j);
                while (n < 4) {
                    if (matrix[i][j] == matrix[i + n][j]) {
                        count++; 
                        cfIndex.add(i + n);
                        cfIndex.add(j);
                        n++;
                    }
                    else break;
                }
                if (count == 4) return true;
                else cfIndex.clear();
            }
        }

        // check for major diagonal
        for (int i = 0; i < matrix.length - 3; i++) { 
            for (int j = 0; j < matrix[i].length -3; j++) {
                int count = 1;
                int n = 1;
                cfIndex.add(i);
                cfIndex.add(j);
                while (n < 4) {
                    if (matrix[i][j] == matrix[i+n][j+n]) {
                        count++;
                        cfIndex.add(i + n);
                        cfIndex.add(j + n);
                        n++;
                    }
                    else break;
                }
                if (count == 4) return true;
                else cfIndex.clear();
            }
        }
 
        // check for minor diagonal
        for (int i = 0; i < matrix.length - 3; i++) { 
            for (int j = 3; j < matrix[i].length ; j++) {
                int count = 1;
                int n = 1;
                cfIndex.add(i);
                cfIndex.add(j);
                while (n < 4) {
                    if (matrix[i][j] == matrix[i+n][j-n]) {
                        count++;
                        cfIndex.add(i + n);
                        cfIndex.add(j - n);
                        n++;
                    }
                    else break;
                }
                if (count == 4) return true;
                else cfIndex.clear();
            }
        }

        // no consecutivefound
        return false;
    }

    private void highlightCell(ArrayList<Integer> list) {
        int rowIndex, columnIndex;
        for (int i = 0; i < list.size(); i +=2) {
            rowIndex = list.get(i);
            columnIndex = list.get(i+1);
            tfNumbers[rowIndex][columnIndex].setStyle("-fx-border-color: red");
        }
    }

    private void removeHighlight(ArrayList<Integer> list) {
        int rowIndex, columnIndex;
        for (int i = 0; i < list.size(); i +=2) {
            rowIndex = list.get(i);
            columnIndex = list.get(i+1);
            tfNumbers[rowIndex][columnIndex].setStyle("-fx-border-color: transparent");
        }
    }
}
