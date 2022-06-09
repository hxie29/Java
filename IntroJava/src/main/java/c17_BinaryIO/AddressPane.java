package c17_BinaryIO;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.*;

public class AddressPane extends BorderPane {
    private final RandomAccessFile raf;

    private final int NAME_L = 32;
    private final int STREET_L = 32;
    private final int CITY_L = 20;
    private final int STATE_L = 2;
    private final int ZIP_L = 5;

    private final byte[] name = new byte[NAME_L];
    private final byte[] street = new byte[STREET_L];
    private final byte[] city = new byte[CITY_L];
    private final byte[] state = new byte[STATE_L];
    private final byte[] zip = new byte[ZIP_L];

    private final int UNIT = NAME_L + STREET_L + CITY_L + STATE_L + ZIP_L;
    private long index = 0;

    private final TextField tfName = new TextField();
    private final TextField tfStreet = new TextField();
    private final TextField tfState = new TextField();
    private final TextField tfCity = new TextField();
    private final TextField tfZip = new TextField();



    public AddressPane(File file) throws FileNotFoundException {
        raf = new RandomAccessFile(file, "rw");

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
        Button btUpdate = new Button("Update");
        controlPanel.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);
        setBottom(controlPanel);
        setCenter(contentPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(contentPanel, Pos.CENTER);

        display();

        btAdd.setOnAction(e -> addAddress());

        btFirst.setOnAction(e -> first());

        btNext.setOnAction(e -> next());

        btPrevious.setOnAction(e -> previous());

        btLast.setOnAction(e -> last());

        btUpdate.setOnAction(e -> updateAddress());
    }

    private void display(){
        try {
            raf.seek(index * UNIT);

            raf.read(name);
            tfName.setText(new String(name));
    
            raf.read(street);
            tfStreet.setText(new String(street));
    
            raf.read(city);
            tfCity.setText(new String(city));
    
            raf.read(state);
            tfState.setText(new String(state));
    
            raf.read(zip);
            tfZip.setText(new String(zip));
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addAddress() {
        try {
            raf.seek(raf.length());
            readTextFields();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateAddress() {
        try {
            raf.seek(index * UNIT);
            readTextFields();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void readTextFields() throws IOException{
        raf.write(convertLength(tfName.getText().getBytes(), NAME_L));
        raf.write(convertLength(tfStreet.getText().getBytes(), STREET_L));
        raf.write(convertLength(tfCity.getText().getBytes(), CITY_L));
        raf.write(convertLength(tfState.getText().getBytes(), STATE_L));
        raf.write(convertLength(tfZip.getText().getBytes(), ZIP_L));
    }

    private void first() {
        index = 0;
        display();
    }

    private void next() {
        try {
            if (index * UNIT < raf.length()) index++;
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        display();
    }

    private void previous() {
        if (index > 0) {
            index--;
            display();
        }
    }

    private void last() {
        try{
            raf.seek(raf.length() - UNIT);
            display();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private byte[] convertLength(byte[] origin, int n) {
        byte[] newData = new byte[n];
        System.arraycopy(origin, 0, newData, 0, origin.length);
        return newData;
    }

}
