package chap16;

import java.util.Scanner;
import javafx.scene.shape.Rectangle;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.File;

public class Histogram extends Pane {
    private int[] count = new int[26];
    private double width = 1500;
    private double height = 1500;
    private double barWidth = 50;
    private Rectangle[] bars = new Rectangle[26];
    private File file;
    private GridPane pane = new GridPane();
    private String filename = "";
    
    public Histogram() {
        pane.setHgap(10);
        setHeight(height);
        setWidth(width);
        for (int i = 0; i < 26; i++) {
            bars[i] = new Rectangle(1, barWidth);
            bars[i].setStroke(Color.BLACK);
        }
    }

    public void draw() {
        count(filename);
        getChildren().clear();
        pane.getChildren().clear();
        int sum = getTotal();
        for (int i = 0; i < bars.length; i++) {
            bars[i].setHeight(height * count[i] * 1.0 / sum);
            Label lb = new Label("" + (char)('A' + count[i]) , bars[i]);
            lb.setContentDisplay(ContentDisplay.TOP);
            pane.add(lb, i, 0);
            GridPane.setValignment(lb, VPos.BASELINE);
        }
        getChildren().add(pane);
    }

    private void count(String filename) {
        file = new File(filename);

        if (file.exists()) {
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    String line = input.nextLine();
                    for (int i = 0; i < line.length(); i++) {
                        char ch = Character.toUpperCase(line.charAt(i));
                        if (Character.isLetter(ch)) count[ch - 'A']++;
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else System.out.println("File does not exit.");
    }

    public int[] getCounts() {
        return count;
    }

    public void setFile(String s) {
        filename = s;
    }

    public void setCounts(int[] count ) {
        this.count = count;
        draw();
    }

    private int getTotal() {
        int sum =0;
        for (int a: count) {
            sum +=a;
        } 
        return sum;
    }

}
