package c32_Muiltithreading;

import c15_EventsAnimations.CarPane;
import javafx.concurrent.Task;

public class RacingCarTask extends Task<Void> {
    private final CarPane carPane;

    public RacingCarTask(CarPane carPane){
        this.carPane = carPane;
    }

    @Override
    protected Void call() throws Exception {
        carPane.play();
        return null;
    }

    public CarPane getCar() {
        return carPane;
    }
}
