package c16_UIMultimedia;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class E16L03 extends E16L02 {

    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);

        VBox checkedButtons = new VBox(20);
        checkedButtons.setPadding(new Insets(5,5,5,5));
        checkedButtons.setStyle("-fx-border-color: green");

        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        checkedButtons.getChildren().addAll(chkBold,chkItalic);
        
        pane.setRight(checkedButtons);

        EventHandler<ActionEvent> handler = e -> {
            if (chkBold.isSelected() && chkItalic.isSelected()) text.setFont(fontBoldItalic);
            else if (chkBold.isSelected()) text.setFont(fontBold);
            else if (chkItalic.isSelected()) text.setFont(fontItalic);
            else text.setFont(fontNormal);
        };

        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        return pane;
    }
    //Start method is inherited

    public static void main(String[] args ){
        launch(args);
    }
    
}