import java.awt.*;

public class GameTable {
    int[][] table;
    int width;
    Skeleton tempSkeleton1;
    Skeleton tempSkeleton2;
    Skeleton tempSkeleton3;

    public GameTable(int[][]table, int width) {
        this.width = width;
        this.table = table;
    }

    public void makeTable(Graphics graphics) {
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table.length; j++) {
                if (this.table[i][j] == 1) {
                    PositionedImage wall = new PositionedImage("image/wall.png", j, i);
                    wall.draw(graphics);
                } else if (this.table[i][j] == 0) {
                    PositionedImage background = new PositionedImage("image/floor.png", j, i);
                    background.draw(graphics);
                }
            }
        }
    }



}
