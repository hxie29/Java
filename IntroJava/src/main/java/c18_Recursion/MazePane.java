package c18_Recursion;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
public class MazePane extends GridPane {
    private final int[][] matrix = new int[9][9];
    private ArrayList<int[]> result = new ArrayList<>();
    private final StackPane[][] cellPanes = new StackPane[9][9];
    private final Rectangle[][] cells = new Rectangle[9][9];
    public MazePane() {
        setHgap(5);
        setVgap(5);
        setAlignment(Pos.CENTER);
        generateCells();
        //fill matrix with initial value 0
        for (int[] ints : matrix) {
            Arrays.fill(ints, 0);
        }
        generateBlock();
    }
    public boolean findPath() {
        ArrayList<int[]> path = new ArrayList<>();
        return findPath(0,0, path);
    }

    private boolean findPath(int i, int j, ArrayList<int[]> path) {
        if (isValid(i,j)) {
            // add location to path
            path.add(new int[]{i, j});
            //Check if destination is reached
            if (i == 8 && j == 8) {
                result = path;
                colorCells(Color.RED);
                return true;
            }
            else {
                // Back up a pth in case going down doesn't work
                ArrayList<int[]> newPath = new ArrayList<>(path);
                // going down
                boolean returnValue = findPath(i+1, j, path);
                // going right
                if (!returnValue) {
                    returnValue = findPath(i,j+1, newPath);
                }
                return returnValue;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        if (i >= 0 && i < 9 && j >= 0 && j < 9) {
                return matrix[i][j] == 0;
            }
        return false;
    }

    private void colorCells(Color color) {
        for (int[] i: result) {
            cells[i[0]][i[1]].setFill(color);
        }
    }

    public void reset() {
        //Clear all cells
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    cellPanes[i][j].getChildren().removeIf(l -> l instanceof Line);
                }
                matrix[i][j] = 0;
            }
        }
        colorCells(Color.TRANSPARENT);
        result.clear();
        generateBlock();
    }
    private void generateBlock() {
        for (int n = 0; n < 20; n++){
            int i = (int)(Math.random() * 9);
            int j = (int)(Math.random() * 9);
            if (isValid(i, j) && (i + j < 16) && (i + j > 0)) {
                matrix[i][j] = 1;
                cellPanes[i][j].getChildren().addAll(new Line(0,0,50,50), new Line(0,50,50,0));
            }
        }
    }

    private void generateCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Rectangle(50,50);
                cells[i][j].setFill(Color.TRANSPARENT);
                cells[i][j].setStroke(Color.BLACK);
                cellPanes[i][j] = new StackPane();
                cellPanes[i][j].getChildren().add(cells[i][j]);
                this.add(cellPanes[i][j], j, i);
            }
        }
    }
}
