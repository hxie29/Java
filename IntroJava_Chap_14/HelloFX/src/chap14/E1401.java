/* (Display images) Write a program that displays four images in a grid pane, as
shown in Figure 14.43a. */

package chap14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1401 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        Image p1 = new Image("https://i.guim.co.uk/img/media/26392d05302e02f7bf4eb143bb84c8097d09144b/446_167_3683_2210/master/3683.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=49ed3252c0b2ffb49cf8b508892e452d");
        Image p2 = new Image("https://media.wired.co.uk/photos/60c8730fa81eb7f50b44037e/3:2/w_3329,h_2219,c_limit/1521-WIRED-Cat.jpeg");
        Image p3 = new Image("https://www.thetimes.co.uk/imageserver/image/%2Fmethode%2Ftimes%2Fprod%2Fweb%2Fbin%2Ffb46d228-aeb2-11ec-8b8c-0207c0fd6104.jpg?crop=2406%2C1604%2C530%2C420");
        Image p4 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKu0mwkB8aAvE2W4pLFyoaDpyKvV4Euh9kE4FJPNswEfaoItm2TVKU0mQeIA93DQU9q2A&usqp=CAU");

        ImageView v1 = new ImageView(p1);
        v1.resize(500, 500);
        v1.setFitWidth(200);
        v1.setPreserveRatio(true);
        v1.setSmooth(true);
        v1.setCache(true);
        v1.autosize();
        
        ImageView v2 = new ImageView(p2);
        v2.resize(500, 500);
        v2.setFitWidth(200);
        v2.setPreserveRatio(true);
        v2.setSmooth(true);
        v2.setCache(true);
        
        ImageView v3 = new ImageView(p3);
        v3.resize(500, 500);
        v3.setFitWidth(200);
        v3.setPreserveRatio(true);
        v3.setSmooth(true);
        v3.setCache(true);

        ImageView v4 = new ImageView(p4);
        v4.resize(500, 500);
        v4.setFitWidth(200);
        v4.setPreserveRatio(true);
        v4.setSmooth(true);
        v4.setCache(true);

        pane.add(v1,0,0);
        pane.add(v2,0,1);
        pane.add(v3,1,0);
        pane.add(v4,1,1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Cats");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
