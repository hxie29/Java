/* 
(Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
path from one point to another that does not visit the same point twice. Selfavoiding
walks have applications in physics, chemistry, and mathematics. They
can be used to model chain-like entities such as solvents and polymers. Write
a program that displays a random path that starts from the center and ends at a
point on the boundary, as shown in Figure 15.39a, or ends at a dead-end point
(i.e., surrounded by four points that have already been visited), as shown in
Figure 15.39b. Assume the size of the lattice is 16 by 16.
 */
package chap15;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
public class RandomWalkPane extends Pane{
    private int row , column;
    private int unit = 50;
    private int width, height;
    private int margin = 25;
    private Color gridColor = Color.LIGHTGRAY;
    private int startX, startY;
    private int currentX, currentY, nextX, nextY;

    private boolean[][] walkedPoints;
    private int startRow, startColumn, currentRow, currentColumn;
    private ArrayList<Line> walkedLines = new ArrayList<>();
    private boolean[] triedPath = new boolean[4]; // {UP, DOWN, LEFT, RIGHT}

    public RandomWalkPane() {
        this(16,16);

    }

    public RandomWalkPane(int row, int column) {
        this.row = row;
        this.column = column;
        walkedPoints = new boolean[row + 1][column + 1];

        width = row * unit + 50;
        height = column * unit + 50;
        setMinHeight(height);
        setMinWidth(width);
        setMinHeight(height);
        setMinWidth(width);
        
        startX = margin + (column / 2) * unit;
        startY = margin + (row /  2) * unit;
        currentX = startX;
        currentY = startY;
        startRow = row / 2;
        startColumn = column / 2;

        walkedPoints[startRow][startColumn] = true;
        
        getGrid();
    }

    public void setUnitSize(int unit) {
        this.unit = unit;
    }

    public void setGridColor(Color gridColor) {
        this.gridColor = gridColor;
    }

    private void getGrid(){
        int x = margin, y = margin;
        for (int i = 0; i <= row; y +=unit, i++) {
            Line l = new Line(margin, y, width - margin, y);
            l.setStroke(gridColor);
            l.setStrokeWidth(1);
            getChildren().add(l);
        }
        for (int i = 0; i <= column; x +=unit, i++) {
            Line l = new Line(x, margin, x, height - margin);
            l.setStroke(gridColor );
            l.setStrokeWidth(1);
            getChildren().add(l);
        }
        Circle startPoint = new Circle(startX, startY, 10);
        startPoint.setFill(Color.RED);
        getChildren().add(startPoint);
    }
    
    public int walk() {
        while (!atBorder()) {
            int direction = (int) (Math.random() * 4); // {UP, DOWN, LEFT, RIGHT}
            if (!checkPoint(direction)) {
                drawStep(direction);
            }
            else {
                triedPath[direction] = true;
                if (exhaustedPath()) break;
            }
        } 
        if (atBorder()) return 0;
        else return 1;
    }
    
    private boolean exhaustedPath() {
        for (boolean a: triedPath) {
            if (!a) return false;
        }
        return true;
    }

    private boolean checkPoint(int direction) {
        // 0 = UP; 1 = DOWN; 2 = LEFT; 3 = RIGHT
        if (direction == 0) return walkedPoints[currentRow - 1][currentColumn];
        else if (direction == 1) return walkedPoints[currentRow + 1][currentColumn];
        else if (direction == 2) return walkedPoints[currentRow][currentColumn -1];
        else return walkedPoints[currentRow][currentColumn +1];
    }

    private boolean atBorder() {
        return (currentColumn == 0 || currentRow == 0 || currentColumn == column || currentRow == row);
    }

    private void drawStep(int direction) {
        switch (direction) {
            case 0: {
                // walk up
                currentRow--;
                nextX = currentX;
                nextY = currentY - unit;
                break;
            }
    
            case 1: {
                // walk down
                currentRow++;
                nextX = currentX;
                nextY = currentY + unit;
                break;
            }
    
            case 2: {
                // walk left
                currentColumn--;
                nextX = currentX - unit;
                nextY = currentY;
                break;
            }
    
            case 3: {
                //walk right
                currentColumn++;
                nextX = currentX + unit;
                nextY = currentY;
                break;
            }
        }

        //Draw line
        walkedPoints[currentRow][currentColumn] = true;
        Line l = new Line (currentX, currentY, nextX, nextY);
        l.setStroke(Color.BLACK);
        l.setStrokeWidth(2);
        walkedLines.add(l);
        getChildren().add(l);

        currentX = nextX;
        currentY = nextY;

        for (int i =0; i < triedPath.length; i++) {
            triedPath[i] = false;
        }
    }

    public void reset() {
        getChildren().removeAll(walkedLines);
        walkedLines.clear();

        for (int i = 0; i < walkedPoints.length; i++) {
            for (int j = 0; j < walkedPoints[i].length; j++) {
                walkedPoints[i][j] = false;
            }
        }
        for (int i =0; i < triedPath.length; i++) {
            triedPath[i] = false;
        }
        
        walkedPoints[startRow][startColumn] = true;
        currentX = startX;
        currentY = startY;
        currentRow = startRow;
        currentColumn = startColumn;
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
    }
}
