import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero extends PositionedImage {
    String currentImage;
    int testBoxX;
    int testBoxY;

    @Override
    public void draw(Graphics graphics) {
        this.posX = testBoxX;
        this.posY = testBoxY;
        super.draw(graphics);
    }

    public Hero(int posX, int posY) {
        super("image/hero-down.png", posX, posY);
        //this.currentImage = "image/hero-down.png";
        this.testBoxX = 0;
        this.testBoxY = 0;
    }

    public void moving(KeyEvent e, GameTable tempTable) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-up.png";
            if (stayIn(testBoxX, testBoxY - 1, tempTable)) {
                testBoxY -= 1;
            }

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png";
                if (stayIn(testBoxX, testBoxY + 1, tempTable)) {
                    testBoxY += 1;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-left.png";
                if (stayIn(testBoxX -1, testBoxY, tempTable)) {
                    testBoxX -= 1;
                }
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-right.png";
                if (stayIn(testBoxX + 1, testBoxY, tempTable)) {
                    testBoxX += 1;
                }
            }

        }

    public boolean stayIn(int toBeX, int toBeY, GameTable tempTable) {

        if (toBeX < 0 ||  toBeX > 9) {
            return false;
        }
        else if (toBeY < 0 || toBeY > 9) {
            return false;
        }
        else if (tempTable.table[toBeY][toBeX] == 1) {
            return false;
        }
        else return true;
    }


}
