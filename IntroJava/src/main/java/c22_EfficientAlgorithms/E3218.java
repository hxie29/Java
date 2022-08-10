/*(Parallel Eight Queens) Revise Listing 22.11, EightQueens.java, to develop a
parallel algorithm that finds all solutions for the Eight Queens problem. (Hint:
Launch eight subtasks, each of which places the queen in a different column in the
first row.)*/
package c22_EfficientAlgorithms;

import c32_Muiltithreading.EightQueenParallel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class E3218 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ScrollPane scPane = new ScrollPane();
        HBox solutionPane = new HBox(10);
        scPane.setContent(solutionPane);

        ArrayList<ArrayList<int[]>> solutions = EightQueenParallel.findAllSolutions();
        for (int i = 0; i < solutions.size(); i++) {
            for (int j = 0; j < solutions.get(i).size(); j++) {
                EightQueenPane queenPane = new EightQueenPane();
                queenPane.display(solutions.get(i).get(j));
                Label lbSolution = new Label("Solution " + (i+1) + "-" + j, queenPane);
                lbSolution.setContentDisplay(ContentDisplay.BOTTOM);
                lbSolution.setAlignment(Pos.CENTER);
                solutionPane.getChildren().add(lbSolution);
            }
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
