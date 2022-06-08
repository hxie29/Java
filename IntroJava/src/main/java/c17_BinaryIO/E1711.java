/* (Address book) Write a program that stores, retrieves, adds, and updates addresses as
shown in Figure 17.20. Use a fixed-length string for storing each attribute in the address.
Use random-access file for reading and writing an address. Assume the sizes of the
name, street, city, state, and zip are 32, 32, 20, 2, and 5 bytes, respectively.
*/

import java.io.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class E1711 extends Application{
    private String filename;
    private int numberOfPieces;
    private final TextField tfName = new TextField();
    private final TextField tfNumber = new TextField();
    private final Button btStart = new Button("Start");
    Text reminder = new Text("If the base file is named temp.txt with three pieces, \nthe three smaller files are temp_1.txt, temp_2.txt, and temp_3.txt");

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setTop(reminder);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Text("Enter a file:"), 0, 0);
        grid.add(tfName, 1, 0);
        grid.add(new Text("Specify the number of smaller files:"), 0, 1);
        grid.add(tfNumber, 1, 1);
        pane.setCenter(grid);
        pane.setBottom(btStart);

        BorderPane.setAlignment(reminder, Pos.CENTER);
        BorderPane.setAlignment(btStart, Pos.CENTER);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Split File");
        primaryStage.show();

        btStart.setOnAction(e -> {
            filename = tfName.getText();
            int dotIndex = filename.indexOf(".");
            numberOfPieces = Integer.parseInt(tfNumber.getText());
        
            try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
                long individualSize = raf.length() / numberOfPieces + 1;

                for (int i = 0; i < numberOfPieces; i++) {
                    File newFile = new File(filename.substring(0, dotIndex) + "_" + (i+1) + filename.substring(dotIndex));
                    try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(newFile))) {
                        for (int j = 0; j < individualSize; j++)
                            output.write(raf.read());
                    }
                    catch(EOFException ex) {
                        System.out.println("Done!");
                    }
                }
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        });

    }
    public static void main(String[] args) {
        Application.launch(args);
    }  
}
