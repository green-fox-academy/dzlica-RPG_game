import java.awt.*;

public class Boss extends Character {

    String currentImage;

    public Boss(int posX, int posY) {
        super("image/boss.png", posX, posY);
        this.currentImage = "image/boss.png";
        this.currentHp = currentHp;
        this.maxHp = maxHp;
        this.Dp = Dp;
        this.Sp = Sp;
    }

}
