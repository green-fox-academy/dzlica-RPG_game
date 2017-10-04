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
    GameTable tempTable;
    Hero tempHero;
    Skeleton tempSkeleton1;
    Skeleton tempSkeleton2;
    Skeleton tempSkeleton3;
    Boss tempBoss;

    public Board() {
        this.testBoxX = 0;
        this.testBoxY = 0;
        this.width = 720;
//        this.posX = 0;
//        this.posY = 0;


        // set the size of your draw board
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.tempTable.makeTable(graphics);
        this.tempHero.draw(graphics);
        this.tempSkeleton1.draw(graphics);
        this.tempSkeleton2.draw(graphics);
        this.tempSkeleton3.draw(graphics);
        this.tempBoss.draw(graphics);

        graphics.drawString("Hero (Level 1) HP: " + tempHero.currentHp + "/" + tempHero.maxHp + " | DP: " + tempHero.Dp + " | SP: " + tempHero.Dp, 740, 50);
        graphics.drawString("Boss (Level 1) HP: " + tempBoss.currentHp + "/" + tempBoss.maxHp + " | DP: " + tempBoss.Dp + " | SP: " + tempBoss.Dp, 740, 80);
        graphics.drawString("Skeleton One (Level 1) HP: " + tempSkeleton1.currentHp + "/" + tempSkeleton1.maxHp + " | DP: " + tempSkeleton1.Dp + " | SP: " + tempSkeleton1.Dp, 740, 110);
        graphics.drawString("Skeleton Two (Level 1) HP: " + tempSkeleton2.currentHp + "/" + tempSkeleton2.maxHp + " | DP: " + tempSkeleton2.Dp + " | SP: " + tempSkeleton2.Dp, 740, 140);
        graphics.drawString("Skeleton Three (Level 1) HP: " + tempSkeleton3.currentHp + "/" + tempSkeleton3.maxHp + " | DP: " + tempSkeleton3.Dp + " | SP: " + tempSkeleton3.Dp, 740, 170);

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
        board.tempTable = theWall;

        Hero hero = new Hero(0, 0);
        board.tempHero = hero;

        Skeleton monsterOne = new Skeleton(board.posX, board.posY, board.tempTable);
        board.tempSkeleton1 = monsterOne;

        Skeleton monsterTwo = new Skeleton(board.posX, board.posY, board.tempTable);
        board.tempSkeleton2 = monsterTwo;

        Skeleton monsterThree = new Skeleton(board.posX, board.posY, board.tempTable);
        board.tempSkeleton3 = monsterThree;

        Boss boss = new Boss(7, 6);
        board.tempBoss = boss;






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
        tempHero.moving(e, tempTable);
        // When the up or down keys hit, we change the position of our box
        // and redraw to have a new picture with the new coordinates
        repaint();
    }
}