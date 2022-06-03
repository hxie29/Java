/* (Combine files GUI) Rewrite Exercise 17.12 with a GUI, as shown in Figure 17.21b.*/

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

public class E1713 extends Application{
    private String filename;
    private int numberOfPieces;
    private TextField tfName = new TextField();
    private TextField tfNumber = new TextField();
    private Button btStart = new Button("Start");
    Text reminder = new Text("If the base file is named temp.txt with three pieces, \ntemp_1.txt, temp_2.txt, and temp_3.txt are combined into temp.txt");


    @Override
    public void start(Stage primaryStage) throws IOException  {
        BorderPane pane = new BorderPane();
        pane.setTop(reminder);
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.add(new Text("Enter a file:"), 0, 0);
        grid.add(tfName, 1, 0);
        grid.add(new Text("Specify the number of smaller files:"), 0, 1);
        grid.add(tfNumber, 1, 1);
        pane.setCenter(grid);
        pane.setBottom(btStart);

        BorderPane.setAlignment(reminder, Pos.CENTER);
        BorderPane.setAlignment(btStart, Pos.CENTER);

        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Combine File");
        primaryStage.show();

        btStart.setOnAction(e -> {
            filename = tfName.getText();
            int dotIndex = filename.indexOf(".");
            numberOfPieces = Integer.parseInt(tfNumber.getText());
        
            try {
                for (int i = 0; i < numberOfPieces; i++) {
                File newFile = new File(filename.substring(0, dotIndex) + "_" + (i+1) + filename.substring(dotIndex, filename.length()));
                try (
                        BufferedInputStream input = new BufferedInputStream(new FileInputStream(newFile));
                        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(filename, true))) 
                    {
                        int r;
                        while ((r = input.read()) != -1)
                            output.write(r);
                    }
                }
            }
            catch(IOException ex) {}
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }  
}
