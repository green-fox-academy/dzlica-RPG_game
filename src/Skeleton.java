import java.awt.*;

public class Skeleton extends Character {

    String currentImage;

    public Skeleton(int posX, int posY) {
        super("image/skeleton.png", posX, posY);
        this.currentImage = "image/skeleton.png";
        int x = 1; //level
        this.maxHp = 2 * x * d6;
        this.currentHp = this.maxHp;
        this.Dp = x/2 * d6;
        this.Sp = x * d6;

    }

}
