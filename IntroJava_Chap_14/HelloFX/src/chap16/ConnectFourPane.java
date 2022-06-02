package chap16;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class ConnectFourPane extends BorderPane{
    private int row = 6;
    private int column = 7;
    private int radius = 30;
    private int distance = 75;
    private int currentRow = 0, currentColumn = 0;
    private int[][] scores = new int[row][column];
    private HBox controlPanel = new HBox(10);
    private Button btRestart = new Button("Restart");
    private Text reminder = new Text("Red's turn");
    private int status = 0;
    private Circle[][] disks = new Circle[row][column];
    private Pane grid = new Pane();

    public ConnectFourPane() {
        setTop(reminder);
        setBottom(controlPanel);
        setCenter(grid);
        BorderPane.setAlignment(reminder, Pos.CENTER);
        BorderPane.setAlignment(grid, Pos.CENTER);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        controlPanel.getChildren().add(btRestart);
        controlPanel.setAlignment(Pos.CENTER);
        btRestart.setOnAction(e -> restart());

        grid.setPadding(new Insets(10));

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                scores[i][j] = 0;
                disks[i][j] = new Circle((j+1) * distance, (i+1) * distance, radius);
                disks[i][j].setFill(Color.WHITE);
                disks[i][j].setStroke(Color.BLACK);
                grid.getChildren().add(disks[i][j]);
            }
        }

        reminder.setFont(Font.font(20));

        grid.setOnMouseClicked(e -> {
            //Find the circle clicked
            boolean click = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (disks[i][j].contains(e.getX(), e.getY())) {
                        currentRow = i;
                        currentColumn = j;
                        click = true;
                    }
                }
            } 

            if (click) {
                if (status != -1) {
                    if (validCell()) {
                        if (status == 0) {
                            disks[currentRow][currentColumn].setFill(Color.RED);
                            scores[currentRow][currentColumn] = 1;
                        }
                        else {
                            disks[currentRow][currentColumn].setFill(Color.YELLOW);
                            scores[currentRow][currentColumn] = 2;
                        }
                        checkStatus();
                    }
                }
                else reminder.setText("Game over. Click restart.");
            }
        });
    }

    private boolean validCell() {
        if (currentRow == row - 1) return true;
        else if (scores[currentRow + 1][currentColumn] != 0) return true;
        else return false;
    }

    private void checkStatus() {
        if (isCF()) {
            if (status == 0) reminder.setText("Red won!");
            else reminder.setText("Yellow won!");
            status = -1;
        }

        else {
            if (isFull()) {
                reminder.setText("It's a draw!");
                status = -1;
            }
            else {
                //below two lines of code dont work?
                if (status == 0) status++;
                else status--;

                reminder.setText((status == 0) ? "Red's turn." : "Yellow's turn");
            }
        }
    }

    private boolean isFull() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (scores[i][j] == 0) return false;
            }
        }
        return true;
    }

    private void restart() {
        status = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                scores[i][j] = 0;
                disks[i][j].setFill(Color.WHITE);
            }
        }
        reminder.setText("Red's turn.");
    }

    private boolean isCF() {
        // verify horizontal case
        for (int i = scores.length - 1; i >= 0; i--) {
            for (int j = 0; j < scores[i].length - 3; j++) {
                if (scores[i][j] != 0) {
                    int count = 1;
                    int n = 1;
                    //Count consecutives
                    while (n < 4) {
                        if (scores[i][j] == scores[i][j+n]) {
                            count++;
                            n++;
                        }
                        else break;
                    }
                    if (count == 4) return true;
                }
            }
        }
        
         // verify vertical case
        for (int j = 0; j < scores[0].length; j++) {
            for (int i = scores.length - 1; i >= scores.length - 4; i--) {
                if (scores[i][j] != 0) {
                    int count = 1;
                    int n = 1;
                    while (n < 4) {
                        if (scores[i][j] == scores[i - n][j]) {
                            count++; 
                            n++;
                        }
                        else break;
                    }
                    if (count == 4) return true;
                }
            }
        }

        // check for minor diagonal
        for (int i = 3; i < scores.length; i++) { 
            for (int j = 0; j < scores[i].length - 3 ; j++) {
                if (scores[i][j] != 0) {
                    int count = 1;
                    int n = 1;
                    while (n < 4) {
                        if (scores[i][j] == scores[i-n][j+n]) {
                            count++;
                            n++;
                        }
                        else break;
                    }
                    if (count == 4) return true;
                } 
            }
        }

         // check for major diagonal
         for (int i = 0; i < scores.length - 3; i++) { 
            for (int j = 0; j < scores[i].length -3; j++) {
                if (scores[i][j] != 0) {
                    int count = 1;
                    int n = 1;
                    while (n < 4) {
                        if (scores[i][j] == scores[i + n][j+n]) {
                            count++;
                            n++;
                        }
                        else break;
                    }
                    if (count == 4) return true;
                }
            }
        }


        // no consecutivefound
        return false;
    }
 
}
