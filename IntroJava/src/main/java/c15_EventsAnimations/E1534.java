/* 
(Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
path from one point to another that does not visit the same point twice. Selfavoiding
walks have applications in physics, chemistry, and mathematics. They
can be used to model chain-like entities such as solvents and polymers. Write
a program that displays a random path that starts from the center and ends at a
point on the boundary, as shown in Figure 15.39a, or ends at a dead-end point
(i.e., surrounded by four points that have already been visited), as shown in
Figure 15.39b. Assume the size of the lattice is 16 by 16.
}
*/

package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class E1534 extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);

        HBox panel = new HBox(10);
        panel.setPadding(new Insets(10,10,10,10));
        panel.setAlignment(Pos.CENTER);

        Button start = new Button("Start");
        Button resetButton = new Button("Reset");
        panel.getChildren().addAll(start, resetButton);

        RandomWalkPane randomWalk = new RandomWalkPane();

        pane.getChildren().addAll(randomWalk, panel);
        start.setOnAction(e -> randomWalk.walk());
        resetButton.setOnAction(e -> randomWalk.reset());

        //start.setOnAction(e -> machine.restart());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Rnadom walk simulate");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}
