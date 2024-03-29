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

    opens c23_Sorting to javafx.fxml;
    exports c23_Sorting;

    opens c24_ImpleListStackQueue to javafx.fxml;
    exports c24_ImpleListStackQueue;

    opens c25_BST_AVLTrees to javafx.fxml;
    exports c25_BST_AVLTrees;

    opens c28_Graphs to javafx.fxml;
    exports c28_Graphs;

    opens c29_WeightedGraphs to javafx.fxml;
    exports c29_WeightedGraphs;
    
    exports c30_CollectionStreams;
    opens c30_CollectionStreams to javafx.fxml;

    exports c31_AdvJavaFXFXML;
    opens c31_AdvJavaFXFXML to javafx.fxml;

    exports c32_Muiltithreading;
    opens c32_Muiltithreading to javafx.fxml;

    exports c33_Networking;
    opens c33_Networking to javafx.fxml;
}
