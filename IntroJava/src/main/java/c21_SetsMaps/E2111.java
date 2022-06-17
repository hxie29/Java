package c21_SetsMaps;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2111 extends Application {


    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        BabyNamePane babyPane = new BabyNamePane();
        Button btFind = new Button("Find Ranking");
        Text tResult = new Text();
        pane.getChildren().addAll(babyPane, btFind, tResult);

        btFind.setOnAction(e -> tResult.setText(babyPane.findRank()));

        Scene scene = new Scene(pane, 300,400);
        primaryStage.setTitle("Baby name rankings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
