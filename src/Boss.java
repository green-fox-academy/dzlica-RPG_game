import java.awt.*;

public class Boss extends PositionedImage {

    String currentImage;

    public Boss(int posX, int posY) {
        super("image/boss.png", posX, posY);
        this.currentImage = "image/boss.png";
    }

    @Override
    public void draw(Graphics graphics) {
        this.posX = posX;
        this.posY = posY;
        super.draw(graphics);
    }
}
