/* E1629
(Display a calendar) Write a program that displays the calendar for the current
month. You can use the Prior and Next buttons to show the calendar of the
previous or next month. Display the dates in the current month in black and
display the dates in the previous month and next month in gray, as shown in
Figure 16.48. 
 */
package chap16;

import java.util.GregorianCalendar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;


import java.util.Calendar;

public class CalendarPane extends BorderPane {
    private int year;
    private int month;
    private Calendar calendar = new GregorianCalendar();
    private Calendar calenderLastMonth = new GregorianCalendar();
    private final String[] monthName = {"January", "Feburary", "March", "April", "May", "June", "July", 
                                    "August", "September", "October", "November", "December"};
    private final String[] weekdayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private Text title = new Text();
    private GridPane grid = new GridPane();
    private final int daysOfWeek = 7;

    public CalendarPane() {
        setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        setCenter(grid);
        BorderPane.setAlignment(grid, Pos.CENTER);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        setLastMonth(calendar);

        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(20,20,20,20));
        grid.setAlignment(Pos.CENTER);
        update();
    }

    private void update() {
        title.setText(monthName[month] + ", " + year);
        updateMonthBody(calendar);
    }
    
    public void priorMonth() {
        if (month > 0) month--;
        else {
            month = 11;
            year--;
        }
        calendar.set(year, month, 1);
        setLastMonth(calendar);
        update();
    }
    
    public void nextMonth() {
        if (month < 11) month++;
        else {
            month = 0;
            year++;
        }
        calendar.set(year, month, 1);
        setLastMonth(calendar);
        update();
    }

    private static int getStartDay(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
    
    private void updateMonthBody(Calendar calendar) {
        grid.getChildren().clear();

        //Add days
        for (int i = 0; i < daysOfWeek; i++) {
            grid.add(new Text(weekdayName[i]), i, 0);
        }

        int currentRow = 1;
        int currentColumn = getStartDay(calendar);

        //Find total days of this month
        int totalNumberOfDaysThisMonth = calendar.getActualMaximum(Calendar.DATE);
        //Find total days of last month
        int totalNumberOfDaysLastMonth = calenderLastMonth.getActualMaximum(Calendar.DATE);

        //Print previous month days in grey
        int currentDay = totalNumberOfDaysLastMonth;
        for (int i = currentColumn - 1; i >= 0; i--) {
            Text tCurrentDay = new Text(currentDay + "");
            tCurrentDay.setFill(Color.LIGHTGRAY);
            grid.add(tCurrentDay, i, currentRow);
            currentDay--;
        }
        //Print current month days in black
        currentDay = 1;
        for (int i = 1; i <= totalNumberOfDaysThisMonth; i++) {
            Text tCurrentDay = new Text(currentDay + "");
            if (currentColumn >= daysOfWeek) {
                currentRow++;
                currentColumn -= 7;
            }
            grid.add(tCurrentDay, currentColumn, currentRow);
            currentColumn++;
            currentDay++;
        }
        
        //Print next month days in grey
        currentDay = 1;
        for (int i = currentColumn; i < daysOfWeek; i++) {
            Text tCurrentDay = new Text(currentDay + "");
            tCurrentDay.setFill(Color.LIGHTGRAY);
            grid.add(tCurrentDay, currentColumn, currentRow);
            currentColumn++;
            currentDay++;
        }
    }  

    private void setLastMonth(Calendar calendar) {
        if (month > 0) {
            calenderLastMonth.set(year, month -1, 1);
        }
        else {
            calenderLastMonth.set(year-1, 11, 1);
        }
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
    }
}
