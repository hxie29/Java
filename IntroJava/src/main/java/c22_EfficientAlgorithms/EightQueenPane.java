package c22_EfficientAlgorithms;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class EightQueenPane extends GridPane {
    private final static Image image = new Image("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/32x32/plain/chess_piece_queen.png");
    public static final int SIZE = 8;
    private final int[] queens = {-1,-1,-1,-1,-1,-1,-1,-1};
    private final Label[][] labels = new Label[SIZE][SIZE];

    public EightQueenPane() {
        setAlignment(Pos.CENTER);
        setVgap(2);
        setHgap(2);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.add(labels[i][j] = new Label(), j, i);
                labels[i][j].setStyle("-fx-border-color: black");
                labels[i][j].setPrefSize(40,40);
            }
        }
    }

    public void display() {
        searchSolution();
        for (int i = 0; i < SIZE; i++) {
            labels[i][queens[i]].setGraphic(new ImageView(image));
            labels[i][queens[i]].setAlignment(Pos.CENTER);
        }
    }

    public void display(int[] solution) {
        for (int i = 0; i < SIZE; i++) {
            labels[i][solution[i]].setGraphic(new ImageView(image));
        }
    }

    public void searchSolution() {
        // all column values in queens[] are -1 so far
        int row = 0;
        while (row >= 0 && row < SIZE) {
            int column = findPosition(row);
            if (column < 0) {
                queens[row] = -1;
                row--;
            }
            else {
                queens[row] = column;
                row++;
            }
        }
    }

    private int findPosition(int row) {
        // queens[k] start is now -1
        int start = queens[row] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(row,j))
                return j;
        }
        return -1;
    }

    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column || queens[row - i] == column - i || queens[row - i] == column + i)
                return false;
        }
        return true;
    }
}
