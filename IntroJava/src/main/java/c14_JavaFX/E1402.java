/* (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as
shown in Figure 14.43b. A cell may be X, O, or empty. What to display
at each cell is randomly decided. The X and O are the image files x.gif and o.gif. */

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

@SuppressWarnings("CommentedOutCode")
public class E1402 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        Image pX = new Image("https://www.freeiconspng.com/uploads/black-x-png-27.png");
        Image pO = new Image("https://cdn.iconscout.com/icon/free/png-256/o-character-alphabet-letter-32857.png");

        //Cannot repeatedly adding a node into a pane, have to be different node
        /* ImageView v1 = new ImageView(pX);
        v1.setFitWidth(100);
        v1.setPreserveRatio(true);
        v1.setSmooth(true);
        v1.setCache(true);
        v1.autosize();
        
        ImageView v2 = new ImageView(pO);
        v2.setFitWidth(100);
        v2.setPreserveRatio(true);
        v2.setSmooth(true);
        v2.setCache(true); */

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int number = (int)(Math.random()* 3);
                if (number == 0) pane.add((new ImageView(pX)),i,j);
                else if (number == 1) pane.add(new ImageView(pO),i,j);
            }
        }

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Tic Tac Toe Board");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
