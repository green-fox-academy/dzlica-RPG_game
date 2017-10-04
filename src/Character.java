import java.awt.*;

public class Character extends PositionedImage {
    int currentHp;
    int maxHp;
    int Dp;
    int Sp;
    int d6;

    public Character(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    @Override
    public void draw(Graphics graphics) {
        this.posX = posX;
        this.posY = posY;
        super.draw(graphics);

    }

    public static int d6() {
        return (int) (1 + Math.random() * 6);
    }
}
