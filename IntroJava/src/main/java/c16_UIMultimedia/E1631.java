/* 
(Game: connect four) Programming Exercise 8.20 enables two players to play
the connect-four game on the console. Rewrite a GUI version for the program,
as shown in Figure 16.49c. The program enables two players to place red and
yellow discs in turn. To place a disk, the player needs to click an available cell.
An available cell is unoccupied and its downward neighbor is occupied. The
program flashes the four winning cells if a player wins, and reports no winners
if all cells are occupied with no winners.

 (Game: connect four) Connect four is a two-player board game in which the
players alternately drop colored disks into a seven-column, six-row vertically
suspended grid, as shown below. 
The objective of the game is to connect four same-colored disks in a row, a column,
or a diagonal before your opponent can do likewise. The program prompts
two players to drop a red or yellow disk alternately. In the preceding figure, the
red disk is shown in a dark color and the yellow in a light color. Whenever a disk
is dropped, the program redisplays the board on the console and determines the
status of the game (win, draw, or continue).
Drop a yellow disk at column (0–6): 6
| | | | | | | |
| | | | | | | |
| | | |R| | | |
| | | |Y|R|Y| |
| | |R|Y|Y|Y|Y|
|R|Y|R|Y|R|R|R|
The yellow player won 

 */
package c16_UIMultimedia;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class E1631 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ConnectFourPane pane = new ConnectFourPane();
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Connect four disks by color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    } 
}
