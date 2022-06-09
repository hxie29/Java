package c16_UIMultimedia;

import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;

public class E16L09 extends Application {
    private final String[] flagTtitles = {"Canada", "China", "Denmark", "France"};
    private final ImageView[] flagImage = {new ImageView("https://icons.iconarchive.com/icons/wikipedia/flags/256/CA-Canada-Flag-icon.png"),
                                     new ImageView("https://cdn.iconscout.com/icon/premium/png-256-thumb/china-51-571573.png"),
                                     new ImageView("https://cdn.britannica.com/07/8007-004-8CF0B1A9/Flag-Denmark.jpg"),
                                     new ImageView ("https://icons.iconarchive.com/icons/wikipedia/flags/256/FR-France-Flag-icon.png")};

    private final String[] flagDescription = new String[4];

    @Override
    public void start(Stage primaryStage) {
        ListView<String> lv = new ListView<>(FXCollections.observableArrayList(flagTtitles));
        lv.setPrefSize(400, 100);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane imagePane = new FlowPane(10,10);

        flagDescription[0] = "The Canadian national flag....";
        flagDescription[1] = "The Chinese national flag....";
        flagDescription[2] = "The Denish national flag....";
        flagDescription[3] = "The French national flag....";

        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);
        
        lv.getSelectionModel().selectedItemProperty().addListener( ov -> {
            imagePane.getChildren().clear();
            for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
                imagePane.getChildren().add(flagImage[i]);
            }
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("ListView Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}