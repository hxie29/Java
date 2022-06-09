/* 
(Count-up stopwatch) Write a program that simulates a stopwatch, as shown
in Figure 16.45a. When the user clicks the Start button, the button’s label is
changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause
button, the button’s label is changed to Resume, as shown in Figure 16.45c. The
Clear button resets the count to 0 and resets the button’s label to Start.
 */
package c16_UIMultimedia;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class E1620 extends Application {
    private final StopWatch watch = new StopWatch();
    private final Button btStart = new Button("Start");
    private final Button btClear = new Button("Clear");
    private final Text text = new Text();

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(btStart, btClear);

        text.setText("00:00:00");
        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> text.setText(watch.toString())));
        animation.setCycleCount(Timeline.INDEFINITE);

        btStart.setOnAction(e -> {
            btStart.setText((btStart.getText().equals("Pause") ? "Resume" : "Pause"));
            if (!watch.isOn()) {
                watch.start();
                animation.play();
            }
            else if (watch.isPaused()) {
                watch.resume();
                animation.play();
            }
            else {
                watch.pause();
                animation.pause();
            }
        });

        btClear.setOnAction(e -> {
            watch.stop();
            animation.stop();
            btStart.setText("Start");
            text.setText("00:00:00");
        });

        pane.getChildren().addAll(text, controlPanel);

        Scene scene = new Scene(pane, 1000,800);
        primaryStage.setTitle("Stop Watch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}

class StopWatch {
    private long mStartTime;
    private long mEndTime;
    private long mElapsedPause;

    private boolean mIsOn;
    private boolean mIsPaused;

    private int mSeconds;
    private int mMinutes;
    private int mHours;

    public StopWatch() {
        mStartTime = System.currentTimeMillis();
    }
    
    public void start() {
        mStartTime = System.currentTimeMillis();
        mIsOn = true;
    }

    public void stop() {
        mIsOn = false;
        mEndTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return mEndTime - mStartTime;
    }

    public void pause() {
        mIsPaused = true;
        mElapsedPause = System.currentTimeMillis() - mStartTime;
    }

    public void resume() {
        mIsPaused = false;
        mStartTime =  System.currentTimeMillis() - mElapsedPause;
    }

    public boolean isOn() {
        return mIsOn;
    }

    public boolean isPaused() {
        return mIsPaused;
    }

    public long peek() {
        return System.currentTimeMillis() - mStartTime;
    }

    public void reset(){
        stop();
        mHours = 0;
        mMinutes = 0;
        mSeconds = 0;
        mStartTime = 0;
        mEndTime = 0;
    }

    private void updateTime() {
        long currentTime = peek() / 1000;
        mSeconds = (int) (currentTime % 60);

        currentTime = currentTime / 60;

        mMinutes = (int) (currentTime % 60);
        currentTime = currentTime / 60;

        mHours = (int)(currentTime % 24);
    }

    private String getTimeFormat(int n) {
        if (n < 10) return "0" + n;
        else return "" + n;
    }

    @Override
    public String toString() {
        updateTime();
        String hours = getTimeFormat(mHours);
        String minutes = getTimeFormat(mMinutes);
        String seconds = getTimeFormat(mSeconds);

        return hours + ":" + minutes + ":" + seconds;
    }

}