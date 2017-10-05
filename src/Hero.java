import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero extends Character {
    int testBoxX;
    int testBoxY;


    @Override
    public void draw(Graphics graphics) {
        this.posX = testBoxX;
        this.posY = testBoxY;
        super.draw(graphics);
    }

    public Hero(int posX, int posY) {
        super("image/hero-down.png", posX, posY, true);
        this.testBoxX = 0;
        this.testBoxY = 0;
        this.maxHp = 20 + 3 * d6();
        this.currentHp = this.maxHp;
        this.Dp = 2 * d6();
        this.Sp = 5 + d6();
        this.Sv = this.Sp + 2 * d6();
    }


    public void moving(KeyEvent e, GameTable tempTable) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.setImage("/Users/lica/GreenFox/dzlica-RPG_game/image/hero-up.png");
            if (stayIn(testBoxX, testBoxY - 1, tempTable)) {
                testBoxY -= 1;
            }

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.setImage("/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png");
            if (stayIn(testBoxX, testBoxY + 1, tempTable)) {
                testBoxY += 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.setImage("/Users/lica/GreenFox/dzlica-RPG_game/image/hero-left.png");
            if (stayIn(testBoxX -1, testBoxY, tempTable)) {
                testBoxX -= 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.setImage("/Users/lica/GreenFox/dzlica-RPG_game/image/hero-right.png");
            if (stayIn(testBoxX + 1, testBoxY, tempTable)) {
                testBoxX += 1;
            }
        }
        }


    public boolean stayIn(int toBeX, int toBeY, GameTable tempTable) {
        if (toBeX < 0 || toBeX > 9) {
            return false;
        } else if (toBeY < 0 || toBeY > 9) {
            return false;
        } else if (tempTable.table[toBeY][toBeX] >= 1) {
            return false;
        }
        else return true;
    }

    public boolean battle(int toBeX, int toBeY, GameTable tempTable, Skeleton tempSkeleton) {
        if (tempTable.table[toBeX][toBeY] > 1) {
            while (this.currentHp > 0 || tempSkeleton.currentHp > 0) {
                this.strike(tempSkeleton);
            }
        }
        return isAlive = false;
    }

    public void strike(Skeleton tempSkeleton) {
        if (this.Sv > tempSkeleton.Dp) {
            tempSkeleton.currentHp = tempSkeleton.currentHp - ((this.Sv) - tempSkeleton.Dp);
        }
        else if ((tempSkeleton.Sv) > this.Dp) {
            this.currentHp = this.currentHp - ((tempSkeleton.Sv) - this.Dp);
        }
    }
}
