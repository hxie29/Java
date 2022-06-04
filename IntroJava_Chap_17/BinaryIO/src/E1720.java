/* (Binary editor) Write a GUI application that lets the user to enter file name in
the text field and press the Enter key to display its binary representation in a text
area. The user can also modify the binary code and save it back to the file, as
shown in Figure 17.23a.
*/

import java.io.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class E1720 extends Application{
    private String filename;
    private final TextField tfName = new TextField();
    private final TextArea ta = new TextArea();
    private final Button btSave = new Button("Save");
    private final StringBuilder content = new StringBuilder();

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(new Text("Enter a file:"), tfName);
        inputBox.setAlignment(Pos.CENTER);

        pane.setTop(inputBox);
        pane.setCenter(ta);
        pane.setBottom(btSave);
        BorderPane.setAlignment(inputBox, Pos.CENTER);
        BorderPane.setAlignment(ta, Pos.CENTER);
        BorderPane.setAlignment(btSave, Pos.CENTER);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Binary editor");
        primaryStage.show();

        tfName.setOnAction(e -> read());

        btSave.setOnAction(e -> save());
    }

    private void read(){
        filename = tfName.getText();
        content.delete(0, content.length());
        try (BufferedInputStream input = new BufferedInputStream (new FileInputStream(filename))) {
            int r;
            while ((r = input.read()) != -1) {
                content.append(getBits(r));
            }
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }

        ta.setText(content.toString());
    }

    private void save(){
        String content = ta.getText();
        int value;
        try (BufferedOutputStream out = new BufferedOutputStream (new FileOutputStream(filename))) {
            for (int index = 0; index < content.length(); index +=8) {
                String subString = content.substring(index, index+8);
                value = Integer.parseInt(subString, 2);
                out.write(value);
            }
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBits(int value) {
        StringBuilder byteString = new StringBuilder();

        for (int i = 7; i >= 0; i--)
            byteString.append((value >> i) & 1);

        return byteString.toString();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }  
}
