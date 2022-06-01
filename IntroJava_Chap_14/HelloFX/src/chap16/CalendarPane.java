package chap16;

import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Calendar;

public class CalendarPane extends Pane {
    private int year;
    private int month;
    private Calendar calendar = new GregorianCalendar();
    private final String[] monthName = {"January", "Feburary", "March", "April", "May", "June", "July", 
                                    "August", "September", "October", "November", "December"};
    private final String[] weekdayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Fridat", "Saturday"};
    private Text title = new Text();

    public CalendarPane() {
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        paint();
    }

    private void paint() {
        title.setText(monthName[month] + ", " + year);
    }

    public void prior() {
        if (month > 0) month--;
        else {
            month = 11;
            year--;
        }
        paint();
    }

    public void next() {
        if (month < 11) month++;
        else {
            month = 0;
            year++;
        }

    }

   

    
}
