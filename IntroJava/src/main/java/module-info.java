module exercise.introjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens C14_JavaFX to javafx.fxml;
    exports C14_JavaFX;
}