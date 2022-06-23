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
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E22L11 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EightQueenPane pane = new EightQueenPane();
        pane.display();

        Scene scene = new Scene(pane, 55 * 8, 55* 8);
        stage.setTitle("Eight queen");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
