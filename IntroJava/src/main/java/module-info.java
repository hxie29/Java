module java {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.media;
    requires stdlib;

    opens c14_JavaFX to javafx.fxml;
    exports c14_JavaFX;

    opens c15_EventsAnimations to javafx.fxml;
    exports c15_EventsAnimations;

    opens c18_Recursion to javafx.fxml;
    exports c18_Recursion;

    opens c20_ListStackQueue to javafx.fxml;
    exports c20_ListStackQueue;
}
