package c15_EventsAnimations;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class CancelHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("Cancel button clicked");
    }
}
