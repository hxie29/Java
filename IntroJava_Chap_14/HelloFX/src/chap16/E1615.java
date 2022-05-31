/* 
(Select a font) Write a program that can dynamically change the font of a text in
a label displayed on a stack pane. The text can be displayed in bold and italic at
the same time. You can select the font name or font size from combo boxes, as
shown in Figure 16.42a. The available font names can be obtained using Font
.getFontNames(). The combo box for the font size is initialized with numbers
from 1 to 100.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;

public class E1615 extends Application {
    private ComboBox<String> cbContentDisplay = new ComboBox<>();
    private TextField tf = new TextField();
    private Label content = new Label("Flag", new ImageView("http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/rainbow-flag.png"));

    @Override
    public void start(Stage primaryStage) {
        cbContentDisplay.getItems().addAll("Left", "Right", "Top", "Bottom");
        cbContentDisplay.setValue("Left");

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER);
        Label lblDisplay = new Label("Content Display:", cbContentDisplay);
        lblDisplay.setContentDisplay(ContentDisplay.RIGHT);
        Label lblGap = new Label("GraphicText Gap:",tf);
        lblGap.setContentDisplay(ContentDisplay.RIGHT);
        topBox.getChildren().addAll(lblDisplay, lblGap);

        content.setContentDisplay(ContentDisplay.LEFT);

        pane.getChildren().addAll(topBox,content);

        cbContentDisplay.setOnAction(e -> update());
        tf.setOnAction(e -> update());

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void update() {
       String direction = cbContentDisplay.getSelectionModel().getSelectedItem();
       switch(direction) {
           case "Left": content.setContentDisplay(ContentDisplay.LEFT); break;
           case "Right": content.setContentDisplay(ContentDisplay.RIGHT); break;
           case "Top": content.setContentDisplay(ContentDisplay.TOP); break;
           case "Bottom": content.setContentDisplay(ContentDisplay.BOTTOM); break;
       }
       content.setGraphicTextGap(Double.parseDouble(tf.getText()));
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}