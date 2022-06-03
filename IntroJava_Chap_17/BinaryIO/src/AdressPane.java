import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.*;

public class AdressPane extends BorderPane {
    private RandomAccessFile raf;

    private final int NAME_L = 32;
    private final int STREET_L = 32;
    private final int CITY_L = 20;
    private final int STATE_L = 2;
    private final int ZIP_L = 5;

    private byte[] name = new byte[NAME_L];
    private byte[] street = new byte[STREET_L];
    private byte[] city = new byte[CITY_L];
    private byte[] state = new byte[STATE_L];
    private byte[] zip = new byte[ZIP_L];

    private int unit = NAME_L + STREET_L + CITY_L + STATE_L + ZIP_L;
    private long index = 0;

    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfState = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfZip = new TextField();

    private Button btAdd = new Button("Add");
    private Button btFirst = new Button("First");
    private Button btNext = new Button("Next");
    private Button btPrevious = new Button("Previous");
    private Button btLast = new Button("Last");
    private Button btUpdate = new Button("Update");


    public AdressPane(File file) throws FileNotFoundException {
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

        controlPanel.getChildren().addAll(btAdd, btFirst, btNext, btPrevious, btLast, btUpdate);
        setBottom(controlPanel);
        setCenter(contentPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(contentPanel, Pos.CENTER);

        display();

        btAdd.setOnAction(e -> addAdress());

        btFirst.setOnAction(e -> first());

        btNext.setOnAction(e -> next());

        btPrevious.setOnAction(e -> previous());

        btLast.setOnAction(e -> last());

        btUpdate.setOnAction(e -> updateAdress());
    }

    private void display(){
        try {
            raf.seek(index * unit);

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

        catch(IOException ex) {}
    }

    private void addAdress() {
        try {
            raf.seek(raf.length());
            readTextFields();
        }
        catch (IOException ex) {}
    }

    private void updateAdress() {
        try {
            raf.seek(index * unit);
            readTextFields();
        }
        catch (IOException ex) {}
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
            if (index * unit < raf.length()) index++;
        }
        catch(IOException ex) {}
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
            raf.seek((long)(raf.length()) - unit);
            display();
        }
        catch (IOException ex) {}
    }

    private byte[] convertLength(byte[] origin, int n) {
        byte[] newData = new byte[n];
        for (int i = 0; i < origin.length; i++) {
            newData[i] = origin[i];
        }
        return newData;
    }

}
