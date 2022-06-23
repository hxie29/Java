/*(Game: multiple Eight Queens solution) Write a program to display all possible
solutions for the Eight Queens puzzle in a scroll pane, as shown in Figure 22.16.
For each solution, put a label to denote the solution number. (Hint: Place all
solution panes into an HBox and place this one pane into a ScrollPane. If
you run into a StackOverflowError, run the program using java –Xss200m
Exercise22_23 from the command window.)*/

package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class E2223 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ScrollPane scPane = new ScrollPane();
        HBox solutionPane = new HBox(10);
        scPane.setContent(solutionPane);

        ArrayList<int[]> solutions = EightQueen.main();
        for (int i = 0; i < solutions.size(); i++) {
            EightQueenPane queenPane = new EightQueenPane();
            queenPane.display(solutions.get(i));
            Label lbSolution = new Label("Solution " + (i + 1), queenPane);
            lbSolution.setContentDisplay(ContentDisplay.BOTTOM);
            lbSolution.setAlignment(Pos.CENTER);
            solutionPane.getChildren().add(lbSolution);
        }

        Scene scene = new Scene(scPane);
        stage.setTitle("Eight queen");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
