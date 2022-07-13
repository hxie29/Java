/*(Animation: stack) Write a program to animate push and pop in a stack, as shown
in Figure 24.20a.*/
package c24_ImpleListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2410 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        StackAnimatePane stackPane = new StackAnimatePane();
        stackPane.setStyle("-fx-border-color: black");
        Text text = new Text("This is animation for stack.");

        TextField tfValue = new TextField();
        tfValue.setPrefColumnCount(5);
        Label lbValue = new Label("Enter a value: ", tfValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);

        Button btPush = new Button("Push");
        Button btPop = new Button("Pop");
        Button btPeek = new Button("Peek");

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(lbValue, btPush, btPop, btPeek);

        pane.getChildren().addAll(text, stackPane, controlPanel);
        btPush.setOnAction(e -> {
            if (isDigit(tfValue.getText()))
                stackPane.push(Integer.parseInt(tfValue.getText()));
        });
        btPop.setOnAction(e -> tfValue.setText("" + stackPane.pop()));
        btPeek.setOnAction(e -> tfValue.setText("" + stackPane.peek()));

        Scene scene = new Scene(pane);
        stage.setTitle("Stack visualization");
        stage.setScene(scene);
        stage.show();
    }

    private static boolean isDigit(String s) {
        if (s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){Application.launch(args);}
}
