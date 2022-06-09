package c15_EventsAnimations;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class OkHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("OK button clicked");
    }
}
