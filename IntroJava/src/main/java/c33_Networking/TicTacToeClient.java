package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TicTacToeClient extends Application implements TicTacToeConstants{
    private boolean myTurn = false;
    private char myToken = ' ';
    private char otherToken = ' ';

    private int rowSelected;
    private int columnSelected;
    private final Label lbStatus = new Label();
    private final Label lbTitle = new Label();

    private boolean waiting = true;
    private boolean continuePlay = true;

    private final Cell[][] cells = new Cell[3][3];

    private DataOutputStream toServer;
    private DataInputStream fromServer;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells[i].length; j++)
                grid.add(cells[i][j] = new Cell(i, j), j, i);

        pane.setCenter(grid);
        pane.setBottom(lbStatus);
        pane.setTop(lbTitle);
        BorderPane.setAlignment(grid, Pos.CENTER);
        BorderPane.setAlignment(lbStatus, Pos.CENTER);
        BorderPane.setAlignment(lbTitle, Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("TicTacToe Client");
        stage.show();

        connectToServer();
    }

    public void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 7878);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        new Thread(() -> {
            try {
                // set player and its token
                int player = fromServer.readInt();
                if (player == PLAYER1) {
                    myToken = 'X';
                    otherToken = 'O';
                    Platform.runLater(() -> {
                        lbTitle.setText("Player 1 with token 'X'");
                        lbStatus.setText("Waiting for player 2 to join");
                    });

                    // Receive startup notification from the server
                    fromServer.readInt(); // Whatever read is ignored
                    // The other player has joined
                    Platform.runLater(() -> lbStatus.setText("Player 2 has joined. I start first"));
                    // It is my turn
                    myTurn = true;
                }
                else {
                    myToken = 'O';
                    otherToken = 'X';
                    Platform.runLater(() -> {
                        lbTitle.setText("Player 2 with token 'O'");
                        lbStatus.setText("Game begin, wait for the other player to enter move");
                    });
                }
                while (continuePlay) {
                    if (player == PLAYER1) {
                        waitForPlayerAction();
                        sendMove();
                        receiveIntoFromServer();
                    }
                    else {
                        receiveIntoFromServer();
                        waitForPlayerAction();
                        sendMove();
                    }
                }
            }
            catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private void sendMove() throws IOException{
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }
    private void waitForPlayerAction() throws InterruptedException{
        while (waiting) {
            Thread.sleep(100);
        }
        waiting = true;
    }
    private void receiveIntoFromServer() throws IOException {
        int status = fromServer.readInt();
        if (status == PLAYER1_WON) {
            continuePlay = false;
            if (myToken == 'X')
                Platform.runLater(() -> lbStatus.setText("I won! (X)"));
            else if (myToken == 'O') {
                Platform.runLater(() -> lbStatus.setText("Player 1 (X) has won."));
                receiveMove();
            }
        }
        else if (status == PLAYER2_WON) {
            continuePlay = false;
            if (myToken == 'O')
                Platform.runLater(() -> lbStatus.setText("I won! (O)"));
            else if (myToken == 'X') {
                Platform.runLater(() -> lbStatus.setText("Player 2 (O) has won."));
                receiveMove();
            }
        }
        else if (status == DRAW) {
            continuePlay = false;
            Platform.runLater(() -> lbStatus.setText("It is a draw!"));
            if (myToken == 'O') receiveMove();
        }
        else {
            receiveMove();
            Platform.runLater(() -> lbStatus.setText("My turn:"));
            myTurn = true;
        }
    }

    private void receiveMove() throws IOException{
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        Platform.runLater(() -> cells[row][column].setToken(otherToken));
    }

    public static void main(String[] args) {Application.launch(args);}
    class Cell extends Pane {
        private final int row;
        private final int column;

        private char token = ' ';

        public Cell(int row, int column) {
            setPrefHeight(100);
            setPrefWidth(100);
            setStyle("-fx-border-color: black");
            this.column = column;
            this.row = row;
            this.setOnMouseClicked(e -> handleMouseClick());
        }

        public char getToken() {
            return token;
        }

        public void setToken (char token) {
            this.token = token;
            repaint();
        }

        protected void repaint(){
            if (token == 'X') {
                Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
                line1.endXProperty().bind(this.widthProperty().subtract(10));
                line1.endYProperty().bind(this.heightProperty().subtract(10));
                Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
                line2.startYProperty().bind(this.heightProperty().subtract(10));
                line2.endXProperty().bind(this.widthProperty().subtract(10));
                // Add the lines to the pane
                this.getChildren().addAll(line1, line2);
            }
            else if (token == 'O'){
                Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                        this.getHeight() / 2, this.getWidth() / 2 - 10,
                        this.getHeight() / 2 - 10);
                ellipse.centerXProperty().bind(
                        this.widthProperty().divide(2));
                ellipse.centerYProperty().bind(
                        this.heightProperty().divide(2));
                ellipse.radiusXProperty().bind(
                        this.widthProperty().divide(2).subtract(10));
                ellipse.radiusYProperty().bind(
                        this.heightProperty().divide(2).subtract(10));
                ellipse.setStroke(Color.BLACK);
                ellipse.setFill(Color.WHITE);

                getChildren().add(ellipse); // Add the ellipse to the pane
            }
        }

        private void handleMouseClick() {
            if (token == ' ' && myTurn) {
                setToken(myToken);  // Set the player's token in the cell
                rowSelected = row;
                columnSelected = column;
                myTurn = false;
                lbStatus.setText("Waiting for the other player to move");
                waiting = false; // Just completed a successful move
            }
        }
    }
}
