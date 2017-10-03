import java.awt.*;
import java.awt.event.KeyEvent;

public class MoveHero extends PositionedImage {

    public MoveHero(String filename, int posX, int posY) {
        super(filename, posX, posY);
    }

    public void moving(Graphics graphics) {
        MoveHero hero = new MoveHero("/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png", posX, posY);
        hero.draw(graphics);

        String leftImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-left.png";
        String upImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-up.png";
        String rigthImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-right.png";
    }


}
