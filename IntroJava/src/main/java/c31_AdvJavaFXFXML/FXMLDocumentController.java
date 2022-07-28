package c31_AdvJavaFXFXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tfNumber1, tfNumber2, tfResult;

    @FXML
    private void addButtonAction(ActionEvent event) {
        tfResult.setText(getResult('+') + "");
    }
    @FXML
    private void subtractButtonAction(ActionEvent event) {
        tfResult.setText(getResult('-')  + "");
    }

    @FXML
    private void multiplyButtonAction(ActionEvent event) {
        tfResult.setText(getResult('*')  + "");
    }

    @FXML
    private void divideButtonAction(ActionEvent event) {
        tfResult.setText(getResult('/')  + "");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private double getResult(char operator) {
        double number1 = Double.parseDouble(tfNumber1.getText());
        double number2 = Double.parseDouble(tfNumber2.getText());
        return switch (operator) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> Double.NaN;
        };
    }
}
