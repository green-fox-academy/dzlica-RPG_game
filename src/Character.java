import java.awt.*;

public class Character extends PositionedImage {
    int currentHp;
    int maxHp;
    int Dp;
    int Sp;
    int d6;
    boolean isAlive;
    int Sv;

    public Character(String filename, int posX, int posY, boolean isAlive) {
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
