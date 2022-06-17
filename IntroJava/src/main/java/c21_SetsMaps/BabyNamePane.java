package c21_SetsMaps;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BabyNamePane extends Pane {
    private static final Map<String, Integer> boyMap = new HashMap<>();
    private static final Map<String, Integer> girlMap = new HashMap<>();
    private static final ComboBox<String> cbGender = new ComboBox<>();
    private static final ComboBox<Integer> cbYear = new ComboBox<>();
    private static final TextField tfName = new TextField();

    public BabyNamePane() {
        setUp();
        VBox selectionPanel = new VBox(10);
        selectionPanel.setAlignment(Pos.CENTER);
        Label lbYear = new Label("Select a year: ", cbYear);
        Label lbGender = new Label("Boy or Girl? ", cbGender);
        Label lbName = new Label("Enter a name: ", tfName);
        lbYear.setContentDisplay(ContentDisplay.RIGHT);
        lbGender.setContentDisplay(ContentDisplay.RIGHT);
        lbName.setContentDisplay(ContentDisplay.RIGHT);
        selectionPanel.getChildren().addAll(lbYear, lbGender, lbName);
        getChildren().add(selectionPanel);
    }

    public String findRank() {
        int year = cbYear.getValue();
        File file = new File("/Users/halda/Documents/GitHub/Java/IntroJava/src/main/java/c12_ExceptionTextIO/test/babynamesranking" + year + ".txt");
        getData(file);
        String gender = cbGender.getValue();
        String name = tfName.getText();
        Integer rank = getRank(gender, name);
        if (rank == null)
            return gender + " name " + name + " is not in the ranking in year " + year;
        else
            return gender + " name " + name + " is ranked #" + rank + " in year " + year;
    }

    private Integer getRank(String gender, String name) {
        if (gender.equals("Boy"))
            return boyMap.get(name);
        else
            return girlMap.get(name);
    }

    private void getData(File file) {
        if (!file.exists()) {
            System.out.println("Ranking file does not exist, please download");
        }
        else {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNextLine()) {
                    String[] words = input.nextLine().split("\\s+");
                    int rank = Integer.parseInt(words[0]);
                    boyMap.put(words[1], rank);
                    girlMap.put(words[3], rank);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void setUp() {
        cbGender.getItems().add("Boy");
        cbGender.getItems().add("Girl");
        cbYear.getItems().add(2001);
    }
}
