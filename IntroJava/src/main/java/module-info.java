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

    opens c21_SetsMaps to javafx.fxml;
    exports c21_SetsMaps;

    opens c22_EfficientAlgorithms to javafx.fxml;
    exports c22_EfficientAlgorithms;

    exports c30_CollectionStreams;
    opens c30_CollectionStreams to javafx.fxml;

    exports c32_Muiltithreading;
    opens c32_Muiltithreading to javafx.fxml;
}
