package c33_Networking;

import c17_BinaryIO.AddressBook;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class E3306_Client extends Application implements E3306_Constants{
    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;
    private AddressBook currentAddress;
    private final TextField tfName = new TextField();
    private final TextField tfStreet = new TextField();
    private final TextField tfState = new TextField();
    private final TextField tfCity = new TextField();
    private final TextField tfZip = new TextField();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        HBox row1 = new HBox(10);
        HBox row2 = new HBox(10);
        HBox row3 = new HBox(10);
        VBox contentPanel = new VBox(10);
        contentPanel.setAlignment(Pos.CENTER_LEFT);
        contentPanel.getChildren().addAll(row1, row2, row3);
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);

        tfName.setPrefColumnCount(32);
        tfStreet.setPrefColumnCount(32);
        tfCity.setPrefColumnCount(20);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(5);

        row1.getChildren().addAll(new Text("Name"), tfName);
        row2.getChildren().addAll(new Text("Street"), tfStreet);
        row3.getChildren().addAll(new Text("City"), tfCity, new Text("State"), tfState, new Text("Zip"), tfZip);

        Button btAdd = new Button("Add");
        Button btFirst = new Button("First");
        Button btNext = new Button("Next");
        Button btPrevious = new Button("Previous");
        Button btLast = new Button("Last");
        controlPanel.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast);
        pane.setBottom(controlPanel);
        pane.setCenter(contentPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(contentPanel, Pos.CENTER);

        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Address book client");
        stage.setScene(scene);
        stage.show();

        try {
            Socket socket = new Socket(HOSTNAME, PORT);
            fromServer = new ObjectInputStream(socket.getInputStream());
            toServer = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        btAdd.setOnAction(e -> addAddress());

        btFirst.setOnAction(e -> first());

        btNext.setOnAction(e -> next());

        btPrevious.setOnAction(e -> previous());

        btLast.setOnAction(e -> last());
    }

    private void addAddress() {
        try {
            toServer.writeInt(ADD);
            toServer.writeObject(readTextFields());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private AddressBook readTextFields() throws IOException{
        return new AddressBook(tfName.getText(), tfStreet.getText(), tfCity.getText(), tfState.getText(), tfZip.getText());
    }

    private void first() {
        try {
            toServer.writeInt(FIRST);
            retrieveAddress();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void retrieveAddress() {
        try {
            Object received = fromServer.readObject();
            if (received != null) {
                currentAddress = (AddressBook) received;
                Platform.runLater(() -> {
                    tfName.setText(currentAddress.getName());
                    tfStreet.setText(currentAddress.getStreet());
                    tfCity.setText(currentAddress.getCity());
                    tfState.setText(currentAddress.getState());
                    tfZip.setText(currentAddress.getZip());
                });
            }
        }
        catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void next() {
        try {
            toServer.writeInt(NEXT);
            retrieveAddress();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void previous() {
        try {
            toServer.writeInt(PREVIOUS);
            retrieveAddress();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void last() {
        try {
            toServer.writeInt(LAST);
            retrieveAddress();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
