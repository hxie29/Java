package chap16;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class E16L13 extends Application {
    private char whoseTurn = 'X';
    private Cell[][] cells = new Cell[3][3];
    private Label lbStatus = new Label("X's turn to play");

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                grid.add(cells[i][j] = new Cell(), j, i);
            }
        }
        
        BorderPane pane = new BorderPane();
        pane.setBottom(lbStatus);
        pane.setCenter(grid);
        
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; i++) {
                if (cells[i][j].getToken() == ' ') return false;
            }
        }
        return true;
    }

    public boolean isWon(char token) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0].getToken() == token && cells[i][1].getToken() == token && cells[i][2].getToken() == token) return true;
        }

        for (int j = 0; j < cells[0].length; j++) {
            if (cells[0][j].getToken() == token && cells[1][j].getToken() == token && cells[2][j].getToken() == token) return true;
        }

        if (cells[0][0].getToken() == token && cells[1][1].getToken() == token  && cells[2][2].getToken() == token) return true;
        if (cells[0][2].getToken() == token && cells[1][1].getToken() == token  && cells[2][0].getToken() == token) return true;

        return false;
    }

    public class Cell extends Pane {
        private char token = ' ';

        public Cell() {
            setStyle("-fx-border-color: black");
            this.setPrefSize(2000, 2000);
            this.setOnMouseClicked(e -> handleMouseClick());
        }

        public char getToken() {
            return token;
        }

        public void setToken (char c) {
            token = c;

            if (token == 'X') {
                Line l1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
                l1.endXProperty().bind(this.widthProperty().subtract(10));
                l1.endYProperty().bind(this.heightProperty().subtract(10));
                Line l2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
                l2.startYProperty().bind(this.heightProperty().subtract(10));
                l2.endXProperty().bind(this.widthProperty().subtract(10));
                getChildren().addAll(l1,l2);
            }

            else if (token == 'O') {
                Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight()/2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.BLACK);
                ellipse.setFill(javafx.scene.paint.Color.TRANSPARENT);
                getChildren().add(ellipse);
            }
        }

        private void handleMouseClick() {
            if (token == ' ' && whoseTurn != ' ') {
                setToken(whoseTurn);

                if (isWon(whoseTurn)) {
                    lbStatus.setText(whoseTurn + " won! The game is over");
                    whoseTurn = ' ';
                }
                else if (isFull()) {
                    lbStatus.setText("Draw! The game is over.");
                }
                else {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    lbStatus.setText(whoseTurn + "'s turn");
                }
            }
        }
    }
    
}