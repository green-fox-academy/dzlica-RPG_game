import java.awt.*;

public class Boss extends Character {

    String currentImage;

    public Boss(int posX, int posY) {
        super("image/boss.png", posX, posY);
        this.currentImage = "image/boss.png";
        int x = 1; //level
        this.maxHp = 2 * x * d6 + d6;
        this.currentHp = this.maxHp;
        this.Dp = x/2 * d6 + d6/2;
        this.Sp = x * d6 + x;
    }

}
