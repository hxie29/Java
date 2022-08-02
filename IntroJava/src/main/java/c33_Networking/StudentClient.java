package c33_Networking;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient extends Application {
    private final TextField tfName = new TextField();
    private final TextField tfStreet = new TextField();
    private final TextField tfCity = new TextField();
    private final TextField tfState = new TextField();
    private final TextField tfZip = new TextField();

    private final Button btRegister = new Button("Register to Server");
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);
        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        pane.add(new Label("City"), 0, 2);

        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State"), tfState, new Label("Zip"), tfZip);
        pane.add(btRegister, 1, 3);
        GridPane.setHalignment(btRegister, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);

        btRegister.setOnAction(e -> {
            try {
                Socket socket = new Socket("localhost", 8000);
                ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

                String name = tfName.getText();
                String street = tfStreet.getText();
                String city = tfCity.getText();
                String state = tfState.getText();
                String zip = tfZip.getText();

                StudentAddress studentA = new StudentAddress(name, street, city, state, zip);
                toServer.writeObject(studentA);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 200);
        stage.setTitle("StudentClient"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage

    }

    public static void main(String[] args) {Application.launch(args);}
}
