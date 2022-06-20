/*Solving the Eight Queens Problem Using Backtracking:
* The search starts from the first row with k = 0, where k is the index of the current row being
considered. The algorithm checks whether a queen can be possibly placed in the jth column in
the row for j = 0, 1, c, 7, in this order. The search is implemented as follows:
■■ If successful, it continues to search for a placement for a queen in the next row. If the
current row is the last row, a solution is found.
■■ If not successful, it backtracks to the previous row and continues to search for a new
placement in the next column in the previous row.
■■ If the algorithm backtracks to the first row and cannot find a new placement for a
queen in this row, no solution can be found. */

package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E22L11 extends Application {
    public static final int SIZE = 8;
    private final static int[] queens = {-1,-1,-1,-1,-1,-1,-1,-1};

    @Override
    public void start(Stage stage) throws Exception {
        // find the position of queens
        search();

        // create chess board
        GridPane chessboard = new GridPane();
        chessboard.setAlignment(Pos.CENTER);
        Label[][] labels = new Label[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                chessboard.add(labels[i][j] = new Label(), j, i);
                labels[i][j].setStyle("-fx-border-color: black");
                labels[i][j].setPrefSize(55,55);
            }
        }

        // set correct spots with queens in chessboard
        Image image = new Image("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/64x64/plain/chess_piece_queen.png");
        for (int i = 0; i < SIZE; i++) {
            labels[i][queens[i]].setGraphic(new ImageView(image));
        }

        Scene scene = new Scene(chessboard, 55 * SIZE, 55* SIZE);
        stage.setTitle("Eight queen");
        stage.setScene(scene);
        stage.show();
    }

    private static boolean search() {
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
        return row != -1;
    }

    private static int findPosition(int row) {
        // queens[k] start is now -1
        int start = queens[row] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(row,j))
                return j;
        }
        return -1;
    }

    private static boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column || queens[row - i] == column - i || queens[row - i] == column + i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
