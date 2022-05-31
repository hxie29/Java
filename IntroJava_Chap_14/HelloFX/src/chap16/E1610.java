/* 
(Text viewer) Write a program that displays a text file in a text area, as shown
in Figure 16.40a. The user enters a file name in a text field and clicks the View
button; the file is then displayed in a text area.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class E1610 extends Application {
    private TextArea ta = new TextArea();
    private TextField tfInput = new TextField();
    private StringBuilder text = new StringBuilder("Enter a file path...");

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        ScrollPane view = new ScrollPane(ta);
        ta.setEditable(false);
        ta.setText(text.toString());
        tfInput.setPrefColumnCount(30);

        Button btView = new Button("View");

        HBox inputBox = new HBox();
        inputBox.getChildren().addAll(new Label("Filename"), tfInput, btView);

        pane.getChildren().addAll(view, inputBox);

        btView.setOnAction(e -> {
            File file = new File(tfInput.getText());
            text.delete(0, text.length());

            if (file.exists()) {
                try (Scanner input = new Scanner(file)) {
                    while (input.hasNext()) {
                        text.append(input.nextLine() + "\n");
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else text.append("The file does not exist.");

            ta.setText(text.toString());
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