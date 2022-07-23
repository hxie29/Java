/*(H-tree fractal) An H-tree (introduced at the beginning of this chapter in
Fig ure 18.1) is a fractal defined as follows:
1. Begin with a letter H. The three lines of H are of the same length, as shown
in Figure 18.1a.
2. The letter H (in its sans-serif form, H) has four endpoints. Draw an H centered
at each of the four endpoints to an H-tree of order 1, as shown in Figure 18.1b.
These Hs are half the size of the H that contains the four endpoints.
3. Repeat Step 2 to create an H-tree of order 2, 3, . . . , and so on, as shown in
Figures 18.1c and d.
Write a program that draws an H-tree, as shown in Figure 18.1.*/
package c18_Recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class E1835 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        HTreePane hTreePane = new HTreePane();
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(3);
        tfOrder.setAlignment(Pos.BASELINE_RIGHT);
        Label lbOrder = new Label("Enter an order: ", tfOrder);
        lbOrder.setContentDisplay(ContentDisplay.RIGHT);
        pane.setCenter(hTreePane);
        pane.setBottom(lbOrder);
        BorderPane.setAlignment(hTreePane, Pos.CENTER);
        BorderPane.setAlignment(lbOrder, Pos.CENTER);

        tfOrder.setOnAction(e -> hTreePane.setOrder(Integer.parseInt(tfOrder.getText())));

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("H tree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {Application.launch(args);}
}
