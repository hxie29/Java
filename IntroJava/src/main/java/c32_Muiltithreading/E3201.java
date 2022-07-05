// (Revise Listing 32.1) Rewrite Listing 32.1 to display the output in a text area.
package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class E3201 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextPane pane = new TextPane();
        pane.print();
        new Thread(() -> {
            while (true) {
                try {
                    Platform.runLater(pane::display);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Scene scene = new Scene(pane, 200,100);
        stage.setTitle("Display print in text area");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static class TextPane extends ScrollPane{
        private static final TextArea ta = new TextArea();
        private static final StringBuilder str = new StringBuilder();

        public TextPane() {
            this.setContent(ta);
            ta.setText(str.toString());
        }

        public void print() {
            new Thread(() -> {
                int count = 0;
                while (count < 1000) {
                    str.append('a');
                    count++;
                }
            }).start();

            new Thread(() -> {
                int count = 0;
                while (count < 1000) {
                    str.append('b');
                    count++;
                }
            }).start();

            new Thread(() -> {
                int count = 1;
                while (count <= 1000) {
                    str.append(" ").append(count);
                    count++;
                }
            }).start();
        }

        public void display() {
            ta.setText(str.toString());
        }
    }
}

