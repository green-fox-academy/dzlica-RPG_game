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
  int[][] theWall;


  public Board() {
    this.testBoxX = 0;
    this.testBoxY = 0;
    this.width = 720;
    this.posX = 0;
    this.posY = 0;
    this.floor = 72;
    this.currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png";
    this.theWall = new int[][]{
            { 0, 0, 0, 1, 0, 1, 0, 1, 1, 0 }, //1
            { 0, 1, 1, 1, 0, 1, 0, 1, 1, 0 }, //2
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, //3
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, //4
            { 0, 1, 0, 1, 0, 0, 0, 0, 1, 0 }, //5
            { 0, 1, 0, 1, 0, 1, 1, 0, 1, 0 }, //6
            { 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, //7
            { 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 }, //8
            { 0, 0, 0, 1, 0, 1, 1, 0, 1, 0 }, //9
            { 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 }  //10
    };

    // set the size of your draw board
    setPreferredSize(new Dimension(720, 720));
    setVisible(true);
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);


    //create the wall
    //reset pisitions to zero


    for (int i = 0; i < theWall.length; i++) {
      for (int j = 0; j < theWall.length; j++) {
        if (theWall[i][j] == 1) {
          PositionedImage wall = new PositionedImage("/Users/lica/GreenFox/dzlica-RPG_game/image/wall.png", j * this.floor, i * this.floor);
          wall.draw(graphics);
        }
        else if (theWall[i][j] == 0) {
          PositionedImage background = new PositionedImage("/Users/lica/GreenFox/dzlica-RPG_game/image/floor.png", j * this.floor, i * this.floor);
          background.draw(graphics);
        }
      }
    }


//    PositionedImage hero = new PositionedImage(currentImage, testBoxX, testBoxY);
//    hero.draw(graphics);

    MoveHero hero = new MoveHero(this.currentImage, this.testBoxX, this.testBoxY);
    hero.draw(graphics);



    //graphics.fillRect(testBoxX, testBoxY, 72, 72);

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
      testBoxY -= 72;
    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
      currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-down.png";
      testBoxY += 72;
    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
      currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-left.png";
      testBoxX -= 72;
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
      currentImage = "/Users/lica/GreenFox/dzlica-RPG_game/image/hero-right.png";
      testBoxX += 72;
    }
    // and redraw to have a new picture with the new coordinates
    repaint();
  }
}