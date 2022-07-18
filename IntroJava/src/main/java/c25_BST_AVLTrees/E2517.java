/*(Data compression: Huffman coding animation) Write a program that enables
the user to enter text and displays the Huffman coding tree based on the text, as
shown in Figure 25.21a. Display the weight of the subtree inside the subtree’s
root circle. Display each leaf node’s character. Display the encoded bits for
the text in a label. When the user clicks the Decode Text button, a bit string is
decoded into text displayed in the label, as shown in Figure 25.21b.*/
package c25_BST_AVLTrees;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2517 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        HuffmanTreeView view = new HuffmanTreeView();

        TextField tfText = new TextField();
        TextField tfCodes = new TextField();
        tfText.setPrefColumnCount(10);
        tfCodes.setPrefColumnCount(10);
        tfText.setAlignment(Pos.BASELINE_RIGHT);
        tfCodes.setAlignment(Pos.BASELINE_RIGHT);
        Label lbText = new Label("Enter a text: ", tfText);
        Label lbCodes = new Label("Enter a bit string: ", tfCodes);
        lbText.setContentDisplay(ContentDisplay.RIGHT);
        lbCodes.setContentDisplay(ContentDisplay.RIGHT);
        Button btEncode = new Button("Show Huffman tree");
        Button btDecode = new Button("Decode to text");
        HBox hbText = new HBox(10);
        HBox hbCodes = new HBox(10);
        hbText.getChildren().addAll(lbText, btEncode);
        hbCodes.getChildren().addAll(lbCodes, btDecode);
        hbText.setAlignment(Pos.CENTER);
        hbCodes.setAlignment(Pos.CENTER);
        Text status = new Text(" ");

        pane.getChildren().addAll(hbText, hbCodes, view, status);

        btEncode.setOnAction(e -> {
            view.displayTree(tfText.getText());
            status.setText(tfText.getText() + " is encoded to " + view.getCodes());
        });

        btDecode.setOnAction(e -> status.setText(tfCodes.getText() +
                " is decoded to " + view.decode(tfCodes.getText())));

        Scene scene = new Scene(pane, 500,500);
        stage.setTitle("Huffman coding scheme visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){Application.launch(args);}
}
