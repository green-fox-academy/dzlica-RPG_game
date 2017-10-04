import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JComponent implements KeyListener {

    int testBoxX;
    int testBoxY;
    int width;
    int posX;
    int posY;
    int floor;
    String currentImage;
    GameTable tempTable;


    public Board() {
        this.testBoxX = 0;
        this.testBoxY = 0;
        this.width = 720;
        this.posX = 0;
        this.posY = 0;
        this.floor = 72;
        this.currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png";


        // set the size of your draw board
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);


        //create the wall
        //reset pisitions to zero
        int[][] tableX = {
                {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0}
        };

        GameTable theWall = new GameTable (tableX, 720);
        theWall.makeTable(graphics);
        this.tempTable = theWall;


//        PositionedImage hero = new PositionedImage(currentImage, testBoxX, testBoxY);
//        hero.draw(graphics);

        Hero hero = new Hero(currentImage, testBoxX, testBoxY);
        hero.draw(graphics);

        //graphics.fillRect(testBoxX, testBoxY, 72, 72);

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


    public static void main(String[] args) {
        // Here is how you set up a new window and adding our board to it
        JFrame frame = new JFrame("RPG Game");
        Board board = new Board();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        // Here is how you can add a key event listener
        // The board object will be notified when hitting any key
        // with the system calling one of the below 3 methods
        frame.addKeyListener(board);
        // Notice (at the top) that we can only do this
        // because this Board class (the type of the board object) is also a KeyListener
    }

    // To be a KeyListener the class needs to have these 3 methods in it
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    // But actually we can use just this one for our goals here
    @Override
    public void keyReleased(KeyEvent e) {
        // When the up or down keys hit, we change the position of our box
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-up.png";
            if (stayIn(testBoxX, testBoxY - 1, this.tempTable)) {
                testBoxY -= 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png";
            if (stayIn(testBoxX, testBoxY + 1, this.tempTable)) {
                testBoxY += 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-left.png";
            if (stayIn(testBoxX -1, testBoxY, this.tempTable)) {
                testBoxX -= 1;
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-right.png";
            if (stayIn(testBoxX + 1, testBoxY, this.tempTable)) {
                testBoxX += 1;
            }
        }
        // and redraw to have a new picture with the new coordinates
        repaint();
    }
}