/* 
(Random time) Modify the ClockPane class with three new Boolean properties—
hourHandVisible, minuteHandVisible, and secondHandVisible—and
their associated accessor and mutator methods. You can use the set methods
to make a hand visible or invisible. Write a test program that displays only the
hour and minute hands. The hour and minute values are randomly generated.
The hour is between 0 and 11, and the minute is either 0 or 30, as shown in
Figure 14.52b.
 */
package hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;


public class E1428 extends Application {
    @Override
    public void start(Stage primaryStage) {
        RandomClockPane clock = new RandomClockPane();
        clock.setSecondVisible(false);
        String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSeconds();
        Label timeLabel = new Label(time);

        BorderPane pane = new BorderPane();
        pane.setBottom(timeLabel);
        pane.setCenter(clock);
        BorderPane.setAlignment(timeLabel, Pos.TOP_CENTER);
        

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(pane, 300,200);
        primaryStage.setTitle("Show Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

class RandomClockPane extends ClockPane {
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;
   
    public RandomClockPane() {
       super();
       hour = super.getHour();
       second = super.getSeconds();
       minute = super.getMinute();
    }

    public RandomClockPane(int hour, int minute, int second) {
        super(hour, minute, second);
        hour = super.getHour();
        second = super.getSeconds();
        minute = super.getMinute();
    }

    public RandomClockPane(int hour, int minute, int second, boolean hourHandVisible, boolean minuteHandVisible, boolean secondHandVisible) {
        super(hour, minute, second);
        this.hourHandVisible = hourHandVisible;
        this.minuteHandVisible = minuteHandVisible;
        this.secondHandVisible = secondHandVisible;
        hour = super.getHour();
        second = super.getSeconds();
        minute = super.getMinute();
    }

    public boolean isHourVisible(){
        return hourHandVisible;
    }
    public boolean isMinuteVisible(){
        return minuteHandVisible;
    }
    public boolean isSecondVisible(){
        return secondHandVisible;
    }

    public void setHourVisible(boolean x){
        hourHandVisible = x;
    }
    public void setMinuteVisible(boolean x){
        minuteHandVisible = x;
    }
    public void setSecondVisible(boolean x){
        secondHandVisible = x;
    }

    private void paint() {
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        double centerX = getWidth() / 2, centerY = getHeight() / 2;

        Circle c = new Circle(centerX, centerY, radius);
        c.setFill(Color.BLUE);
        c.setStroke(Color.YELLOWGREEN);
        
        Text t1 = new Text(centerX - 5, centerY - radius + 12, "12");
        t1.setStroke(Color.YELLOW);
        Text t2 = new Text(centerX + radius - 10, centerY + 3, "3");
        t2.setStroke(Color.YELLOW);
        Text t3 = new Text(centerX - 3, centerY + radius -3, "6");
        t3.setStroke(Color.YELLOW);
        Text t4 = new Text(centerX - radius + 3, centerY +5, "9");
        t4.setStroke(Color.YELLOW);

        double sLength = radius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * 2 * Math.PI / 60);
        double secondY = centerY - sLength * Math.cos(second * 2 * Math.PI / 60);
        Line secondLine = new Line(centerX, centerY, secondX, secondY);
        secondLine.setStroke(Color.RED);

        double mLength = radius * 0.6;
        double minuteX = centerX + mLength * Math.sin(minute * 2 * Math.PI / 60);
        double minuteY = centerY - mLength * Math.cos(minute * 2 * Math.PI / 60);
        Line minuteLine = new Line(centerX, centerY, minuteX, minuteY);
        minuteLine.setStroke(Color.WHITE);
        minuteLine.setStrokeWidth(2);

        double hLength = radius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * 2 * Math.PI / 12);
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0)* 2 * Math.PI / 12);
        Line hourLine = new Line(centerX, centerY, hourX, hourY);
        hourLine.setStroke(Color.YELLOW);
        hourLine.setStrokeWidth(4);

        Group group = new Group();
        group.getChildren().addAll(c, t1, t2, t3, t4);
        if (hourHandVisible) group.getChildren().add(hourLine);
        if (minuteHandVisible) group.getChildren().add(minuteLine);
        if (secondHandVisible) group.getChildren().add(secondLine);

        getChildren().clear();
        getChildren().add(group);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}