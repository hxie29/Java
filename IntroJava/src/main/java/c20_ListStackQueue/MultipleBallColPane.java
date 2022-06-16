/*(Combine colliding bouncing balls) The example in Section 20.8 displays
multiple bouncing balls. Extend the example to detect collisions. Once two
balls collide, remove the later ball that was added to the pane and add its
radius to the other ball, as shown in Figure 20.17b. Use the Suspend button
to suspend the animation, and the Resume button to resume the animation.
Add a mouse-pressed handler that removes a ball when the mouse is
pressed on the ball.*/
package c20_ListStackQueue;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class MultipleBallColPane extends MultipleBallPane{
    @Override
    protected void moveBall() {
        super.moveBall();
        ObservableList<Node> balls = getChildren();
        if (!balls.isEmpty()) {
            double radius = ((Ball)balls.get(0)).getRadius();
            for (int i = 0; i < balls.size() - 1; i++) {
                double x1 = ((Ball)balls.get(i)).getCenterX();
                double y1 = ((Ball)balls.get(i)).getCenterY();
                for (int j = i + 1; j < balls.size(); j++) {
                    double x2 = ((Ball)balls.get(j)).getCenterX();
                    double y2 = ((Ball)balls.get(j)).getCenterY();
                    if (distance(x1, y1, x2, y2) <= radius * 2)
                        getChildren().remove(balls.get(j));
                }
            }
        }
    }

    public void removeBall(double x, double y) {
        getChildren().removeIf(ball -> ball.contains(x, y));
    }

    private double distance (double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
