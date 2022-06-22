/*(Game: Sudoku) The complete solution for the Sudoku problem is given in
Supplement VI.C. Write a program that lets the user enter the input from the
text fields, as shown in Figure 22.15a. Clicking the Solve button displays the
result, as shown in Figures 22.15b and c.*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class E2221 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        SudokuPane sudokuPane = new SudokuPane();
        HBox controlPanel = new HBox(10);
        Button btSolve = new Button("Solve");
        Button btClear = new Button("Clear");
        controlPanel.getChildren().addAll(btSolve, btClear);
        controlPanel.setAlignment(Pos.CENTER);
        Text tResult = new Text("Enter input");

        pane.setCenter(sudokuPane);
        pane.setTop(tResult);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(sudokuPane, Pos.CENTER);
        BorderPane.setAlignment(tResult, Pos.CENTER);

        btSolve.setOnAction(e -> {
            if (sudokuPane.getInput()) {
                if (sudokuPane.solve())
                    tResult.setText("Solution found");
                else
                    tResult.setText("Solution not found");
            }
            else
                tResult.setText("Invalid input");
        });
        btClear.setOnAction(e -> {
            sudokuPane.clear();
            tResult.setText("Enter inputs");
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Sudoku solver");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
