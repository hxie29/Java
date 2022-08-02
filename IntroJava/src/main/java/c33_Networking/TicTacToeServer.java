package c33_Networking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TicTacToeServer extends Application implements TicTacToeConstants {
    private int sessionNo = 1;

    @Override
    public void start(Stage stage) throws Exception {
        TextArea ta = new TextArea();

        Scene scene = new Scene(new ScrollPane(ta));
        stage.setScene(scene);
        stage.setTitle("TicTacToe Server");
        stage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(7878);
                Platform.runLater(() -> ta.appendText("Server started at socket 7878\n"));

                while (true){
                    // Accept player 1 for current session
                    Socket socket1 = serverSocket.accept();
                    Platform.runLater(() -> ta.appendText("Player 1 joined session" + sessionNo +
                            ", from IP: " + socket1.getInetAddress().getHostAddress() + "\n"));
                    new DataOutputStream(socket1.getOutputStream()).writeInt(PLAYER1);

                    //Accept player 2 for current session
                    Socket socket2 = serverSocket.accept();
                    Platform.runLater(() -> ta.appendText("Player 2 joined session" + sessionNo +
                            ", from IP: " + socket2.getInetAddress().getHostAddress() + "\n"));
                    new DataOutputStream(socket2.getOutputStream()).writeInt(PLAYER2);

                    // new session
                    Platform.runLater(() -> ta.appendText("Start a thread for session " + sessionNo + '\n'));
                    sessionNo++;

                    new Thread(new HandleGame(socket1, socket2)).start();
                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args){Application.launch(args);}

    static class HandleGame implements Runnable{
        private final Socket player1;
        private final Socket player2;

        private final char[][] cell = new char[3][3];
        
        private DataInputStream fromPlayer1;
        private DataInputStream fromPlayer2;
        private DataOutputStream toPlayer1;
        private DataOutputStream toPlayer2;

        public HandleGame(Socket player1, Socket player2) {
            this.player1 = player1;
            this.player2 = player2;
            
            for (char[] chars : cell) {
                Arrays.fill(chars, ' ');
            }
        }

        @Override
        public void run() {
            try {
                fromPlayer1 = new DataInputStream(player1.getInputStream());
                fromPlayer2 = new DataInputStream(player2.getInputStream());
                toPlayer1 = new DataOutputStream(player1.getOutputStream());
                toPlayer2 = new DataOutputStream(player2.getOutputStream());
                //game starts with player 1
                toPlayer1.writeInt(1);

                while (true) {
                    // register player 1's move
                    int row = fromPlayer1.readInt();
                    int column= fromPlayer1.readInt();
                    cell[row][column] = 'X';

                    // check status and communicate it to player 2
                    if (isWon('X')) {
                        toPlayer1.writeInt(PLAYER1_WON);
                        toPlayer2.writeInt(PLAYER1_WON);
                        sendMove(toPlayer2, row, column);
                        break;
                    }
                    else if (isFull()){
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer2, row, column);
                        break;
                    }
                    else {
                        toPlayer2.writeInt(CONTINUE);
                        sendMove(toPlayer2, row, column);
                    }

                    // register player2 move
                    row = fromPlayer2.readInt();
                    column= fromPlayer2.readInt();
                    cell[row][column] = 'O';

                    // check status and communicate it to player 1
                    if (isWon('O')) {
                        toPlayer1.writeInt(PLAYER2_WON);
                        toPlayer2.writeInt(PLAYER2_WON);
                        sendMove(toPlayer2, row, column);
                        break;
                    }
                    else if (isFull()){
                        toPlayer1.writeInt(DRAW);
                        toPlayer2.writeInt(DRAW);
                        sendMove(toPlayer1, row, column);
                        break;
                    }
                    else {
                        toPlayer1.writeInt(CONTINUE);
                        sendMove(toPlayer1, row, column);
                    }
                }
                
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        private boolean isFull() {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (cell[i][j] == ' ')
                        return false; // At least one cell is not filled
            // All cells are filled
            return true;
        }

        private boolean isWon(char token) {
            // Check all rows
            for (int i = 0; i < 3; i++)
                if ((cell[i][0] == token)
                        && (cell[i][1] == token)
                        && (cell[i][2] == token)) {
                    return true;
                }

            /** Check all columns */
            for (int j = 0; j < 3; j++)
                if ((cell[0][j] == token)
                        && (cell[1][j] == token)
                        && (cell[2][j] == token)) {
                    return true;
                }

            /** Check major diagonal */
            if ((cell[0][0] == token)
                    && (cell[1][1] == token)
                    && (cell[2][2] == token)) {
                return true;
            }

            /** Check subdiagonal */
            if ((cell[0][2] == token)
                    && (cell[1][1] == token)
                    && (cell[2][0] == token)) {
                return true;
            }

            /** All checked, but no winner */
            return false;
        }
        private void sendMove(DataOutputStream toPlayer, int row, int column) throws IOException{
            toPlayer.writeInt(row);
            toPlayer.writeInt(column);
        }
    }
}
