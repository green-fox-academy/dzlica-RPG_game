import java.awt.*;

public class Skeleton extends PositionedImage {

    String currentImage;

    public Skeleton(int posX, int posY) {
        super("image/skeleton.png", posX, posY);
        this.currentImage = "image/skeleton.png";

    }

    @Override
    public void draw(Graphics graphics) {
        this.posX = posX;
        this.posY = posY;
        super.draw(graphics);


    }
}
