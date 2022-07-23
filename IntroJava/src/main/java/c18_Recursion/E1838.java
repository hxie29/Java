/*(Recursive tree) Write a program to display a recursive tree as shown in
Figure 18.20.*/
package c18_Recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class E1838 extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        TreePane treePane = new TreePane();
        TextField tfOrder = new TextField();
        tfOrder.setPrefColumnCount(3);
        tfOrder.setAlignment(Pos.BASELINE_RIGHT);
        Label lbOrder = new Label("Enter an order: ", tfOrder);
        lbOrder.setContentDisplay(ContentDisplay.RIGHT);
        pane.setCenter(treePane);
        pane.setBottom(lbOrder);
        BorderPane.setAlignment(treePane, Pos.CENTER);
        BorderPane.setAlignment(lbOrder, Pos.CENTER);

        tfOrder.setOnAction(e -> treePane.setOrder(Integer.parseInt(tfOrder.getText())));

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("H tree");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);}
}
