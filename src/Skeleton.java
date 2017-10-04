import java.awt.*;

public class Skeleton extends Character {
    String currentImage;


    public Skeleton(int posX, int posY, GameTable tempTable) {
        super("image/skeleton.png", posX, posY);
        if (placeSkeleton(this.posX, this.posY, tempTable)) {
            this.posX = (int) (1 + Math.random() * 9);
        }
        if (placeSkeleton(this.posX, this.posY, tempTable)) {
            this.posY = (int) (1 + Math.random() * 9);
        }
        this.currentImage = "image/skeleton.png";
        int x = 1; //level
        this.maxHp = 2 * x * d6;
        this.currentHp = this.maxHp;
        this.Dp = x / 2 * d6;
        this.Sp = x * d6;
    }
    public boolean placeSkeleton(int posX, int posY, GameTable tempTable) {
        if (tempTable.table[posX][posY] == 0) {
            return true;
        } else return false;
    }
}
