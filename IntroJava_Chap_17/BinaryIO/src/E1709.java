/* (Address book) Write a program that stores, retrieves, adds, and updates addresses as
shown in Figure 17.20. Use a fixed-length string for storing each attribute in the address.
Use random-access file for reading and writing an address. Assume the sizes of the
name, street, city, state, and zip are 32, 32, 20, 2, and 5 bytes, respectively.
*/

import java.io.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E1709 extends Application{

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        File file = new File("E17_09.dat");

        AddressPane pane = new AddressPane(file);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Address Book");
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }  
}
