/* 
(Demonstrate TextArea properties) Write a program that demonstrates the
properties of a text area. The program uses a check box to indicate whether the
text is wrapped onto next line, as shown in Figure 16.41a.
counts.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.Scene;

public class E1612 extends Application {
    private TextArea ta = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        ScrollPane view = new ScrollPane(ta);

        CheckBox chkEditable = new CheckBox("Editable");
        CheckBox chkWrap = new CheckBox("Wrap");

        HBox inputBox = new HBox();
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().addAll(chkEditable, chkWrap);

        pane.getChildren().addAll(view, inputBox);

        chkEditable.setOnAction(e -> {
            if (chkEditable.isSelected()) ta.setEditable(true);
            else ta.setEditable(false);
        });

        chkWrap.setOnAction(e -> {
            if (chkWrap.isSelected()) ta.setWrapText(true);
            else ta.setWrapText(false);
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}