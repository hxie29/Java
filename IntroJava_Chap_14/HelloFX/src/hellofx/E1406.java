/* 
(Game: display a checkerboard) Write a program that displays a checkerboard
in which each white and black cell is a Rectangle with a fill color black or
white, as shown in Figure 14.44c.
*/

package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1406 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        Image pX = new Image("https://www.iconsdb.com/icons/preview/black/square-xxl.png");
        Image pO = new Image("https://www.iconsdb.com/icons/preview/white/square-xxl.png");

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) pane.add((new ImageView(pX)),i,j);
                    else  pane.add(new ImageView(pO),i,j);
                }
                else {
                    if (j % 2 != 0) pane.add((new ImageView(pX)),i,j);
                    else  pane.add(new ImageView(pO),i,j);
                }
            }
        }

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
