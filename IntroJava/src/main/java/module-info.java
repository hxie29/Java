module exercise.introjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens c14_JavaFX to javafx.fxml;
    exports c14_JavaFX;
}