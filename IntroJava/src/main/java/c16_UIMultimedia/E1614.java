/* 
(Select a font) Write a program that can dynamically change the font of a text in
a label displayed on a stack pane. The text can be displayed in bold and italic at
the same time. You can select the font name or font size from combo boxes, as
shown in Figure 16.42a. The available font names can be obtained using Font
.getFontNames(). The combo box for the font size is initialized with numbers
from 1 to 100.
 */
package c16_UIMultimedia;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;

public class E1614 extends Application {
    private final Text text = new Text("This is a text.");
    private final ComboBox<String> cbFont = new ComboBox<>();
    private final ComboBox<Integer> cbFontSize = new ComboBox<>();
    private final CheckBox chkBold = new CheckBox("Bold");
    private final CheckBox chkItalic = new CheckBox("Italic");

    @Override
    public void start(Stage primaryStage) {
        cbFont.getItems().addAll(Font.getFamilies());

        Integer[] sizes = new Integer[100];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = i + 10;
        }
        cbFontSize.getItems().addAll(sizes);

        VBox pane = new VBox();
        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER);
        Label lblFont = new Label("Font name:", cbFont);
        lblFont.setContentDisplay(ContentDisplay.RIGHT);
        Label lblFontSizes = new Label("Font Size",cbFontSize);
        lblFontSizes.setContentDisplay(ContentDisplay.RIGHT);
        topBox.getChildren().addAll(lblFont, lblFontSizes);
       
        HBox bottomBox = new HBox(10);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().addAll(chkBold, chkItalic);

        pane.getChildren().addAll(topBox,text, bottomBox);

        chkBold.setOnAction(e -> update());
        chkItalic.setOnAction(e -> update());
        cbFont.setOnAction(e -> update());
        cbFontSize.setOnAction(e -> update());

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Font demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void update() {
        FontWeight weight = (chkBold.isSelected()) ? FontWeight.BOLD : FontWeight.NORMAL;
        FontPosture posture = (chkItalic.isSelected()) ? FontPosture.ITALIC : FontPosture.REGULAR;
        text.setFont(Font.font(cbFont.getSelectionModel().getSelectedItem(), weight, posture, cbFontSize.getSelectionModel().getSelectedItem()));
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}