import java.awt.*;

public class Character extends PositionedImage {
    int currentHp;
    int maxHp;
    int Dp;
    int Sp;

    public Character(String filename, int posX, int posY) {
        super(filename, posX, posY);
        this.currentHp = currentHp;
        this.maxHp = maxHp;
        this.Dp = Dp;
        this.Sp = Sp;
    }

    @Override
    public void draw(Graphics graphics) {
        this.posX = posX;
        this.posY = posY;
        super.draw(graphics);
    }
}
