package c16_UIMultimedia;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class DescriptionPane extends BorderPane {
    private final Label lbTitle = new Label();
    private final TextArea taDescription = new TextArea();

    public DescriptionPane() {
        lbTitle.setContentDisplay(ContentDisplay.TOP);
        lbTitle.setPrefSize(200, 100);
        lbTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        ScrollPane scrollPane = new ScrollPane(taDescription);

        setLeft(lbTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5,5,5,5));
    }

    public void setTitle(String title) {
        lbTitle.setText(title);
    }

    public void setImageView (ImageView icon) {
        lbTitle.setGraphic(icon);
    }

    public void setDescription (String text) {
        taDescription.setText(text);
    }
    
}
