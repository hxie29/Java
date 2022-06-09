package c16_UIMultimedia;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class E16L08 extends Application {
    private final String[] flagTtitles = {"Canada", "China", "Denmark", "France"};
    private final ImageView[] flagImage = {new ImageView("https://icons.iconarchive.com/icons/wikipedia/flags/256/CA-Canada-Flag-icon.png"),
                                     new ImageView("https://cdn.iconscout.com/icon/premium/png-256-thumb/china-51-571573.png"),
                                     new ImageView("https://cdn.britannica.com/07/8007-004-8CF0B1A9/Flag-Denmark.jpg"),
                                     new ImageView ("https://icons.iconarchive.com/icons/wikipedia/flags/256/FR-France-Flag-icon.png")};

    private final String[] flagDescription = new String[4];
    private final DescriptionPane descriptionPane = new DescriptionPane();
    private final ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        flagDescription[0] = "The Canadian national flag....";
        flagDescription[1] = "The Chinese national flag....";
        flagDescription[2] = "The Denish national flag....";
        flagDescription[3] = "The French national flag....";

        setDisplay(0);

        BorderPane paneCombo = new BorderPane();
        paneCombo.setLeft(new Label("Select a country:  "));
        paneCombo.setCenter(cbo);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");
        
        ObservableList<String> items = FXCollections.observableArrayList(flagTtitles);
        cbo.getItems().addAll(items);
        
        BorderPane pane = new BorderPane();
        pane.setTop(paneCombo);
        pane.setCenter(descriptionPane);

        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("ComboBox Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setDisplay(int index) {
        descriptionPane.setTitle(flagTtitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}