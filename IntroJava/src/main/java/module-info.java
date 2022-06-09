module exercise.introjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.media;
    requires stdlib;

    opens c14_JavaFX to javafx.fxml;
    exports c14_JavaFX;

    opens c18_Recursion to javafx.fxml;
    exports c18_Recursion;
}