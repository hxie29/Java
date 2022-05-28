/* 
(Game: bean-machine animation) Write a program that animates the bean
machine introduced in Programming Exercise 7.37. The animation terminates
after 10 balls are dropped, as shown in Figures 15.38b and c.
}
*/

package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class E1533 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Label instruction = new Label("(Enter the number of beans:)");
        TextField round = new TextField();
        Button playRound = new Button("Play");
        Button reStart = new Button("Restart");
        
        controlPanel.getChildren().addAll(instruction, round, playRound,reStart);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        
        BeanMachineV2 machine = new BeanMachineV2();
        pane.setCenter(machine);

        playRound.setOnAction(e -> {
            int n = Integer.parseInt(round.getText());
            machine.play(n);
        });
        reStart.setOnAction(e -> machine.restart());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Bean machine simulate");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}
