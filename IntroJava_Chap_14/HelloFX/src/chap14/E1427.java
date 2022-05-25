/* (Draw a detailed clock) Modify the ClockPane class in Section 14.12 to draw
the clock with more details on the hours and minutes, as shown in Figure 14.52a.
 */
package chap14;


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
import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;


public class E1427 extends Application {
    @Override
    public void start(Stage primaryStage) {
        DetailedClockPane clock = new DetailedClockPane();
        String time ="Time: " + clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSeconds();
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

class DetailedClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
   
    public DetailedClockPane() {
        setCurrentTiime();
    }

    public DetailedClockPane(int hour, int minute, int second) {
       setHour(hour);
       setMinute(minute);
       setSeconds(second);
    }

    public void setCurrentTiime() {
        Calendar calendar = new GregorianCalendar();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
    }

    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSeconds() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paint();
    }
    
    public void setMinute(int minute) {
        this.minute = minute;
        paint();
    }
    public void setSeconds(int second) {
        this.second = second;
        paint();
    }


    private void paint() {
        double radius = Math.min(getWidth(), getHeight()) * 0.4;
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        Group group = new Group();

        Circle c = new Circle(centerX, centerY, radius);
        c.setFill(Color.BLUE);
        c.setStroke(Color.YELLOWGREEN);
        group.getChildren().add(c);
        
        
        // Text of hours      
        for (int i = 0; i < 12; i++) {
            double x = centerX + radius * 0.8 * Math.cos((0.5 - i / 6.0) * Math.PI);
            double y = centerY - radius * 0.8 * Math.sin((0.5 - i / 6.0) * Math.PI);
            Text t0 = new Text(x, y, "" + ((i == 0) ? 12 : i));
            t0.setStroke(Color.YELLOW);
            group.getChildren().add(t0);
        }

        //Small lines
        double r1 = radius * 0.95;
        double r2 = radius * 0.9;
        for (int i = 0; i < 60; i++) {
            double startX, startY;
            if (i % 5 == 0) {
                startX = centerX + r2 * Math.cos((0.5 - i / 30.0) * Math.PI);
                startY = centerY - r2 * Math.sin((0.5 - i / 30.0) * Math.PI);
            }
            else {
                startX = centerX + r1 * Math.cos((0.5 - i / 30.0) * Math.PI);
                startY = centerY - r1 * Math.sin((0.5 - i / 30.0) * Math.PI);
            }
            double endX = centerX + radius *  Math.cos((0.5 - i / 30.0) * Math.PI);
            double endY = centerY - radius * Math.sin((0.5 - i / 30.0) * Math.PI);

            Line l = new Line(startX, startY, endX, endY);
            l.setStroke(Color.YELLOW);
            group.getChildren().add(l);
        }
        
        //Lines of time
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
        
        group.getChildren().addAll(secondLine, minuteLine, hourLine);
        

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