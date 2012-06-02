package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;
import logic.Board;
import logic.Food;
import logic.Gum;

public class BoardPanel extends JPanel
{
    char[][] board;
    int n_lin;
    int n_col;
    
    protected static final Image pacman_left_open = Toolkit.getDefaultToolkit().createImage("./textures/pacman_left_o.png");
    protected static final Image pacman_left_closed = Toolkit.getDefaultToolkit().createImage("./textures/pacman_left_h.png");
    protected static final Image pacman_right_open = Toolkit.getDefaultToolkit().createImage("./textures/pacman_right_o.png");
    protected static final Image pacman_right_closed = Toolkit.getDefaultToolkit().createImage("./textures/pacman_right_h.png");
    protected static final Image pacman_up_open = Toolkit.getDefaultToolkit().createImage("./textures/pacman_up_o.png");
    protected static final Image pacman_up_closed = Toolkit.getDefaultToolkit().createImage("./textures/pacman_up_h.png");
    protected static final Image pacman_down_open = Toolkit.getDefaultToolkit().createImage("./textures/pacman_down_o.png");
    protected static final Image pacman_down_closed = Toolkit.getDefaultToolkit().createImage("./textures/pacman_down_h.png");
    protected static final Image pacman_die = Toolkit.getDefaultToolkit().createImage("./textures/pop.png");
    
    protected static final Image inky_down = Toolkit.getDefaultToolkit().createImage("./textures/inky_down.png");
    protected static final Image inky_left = Toolkit.getDefaultToolkit().createImage("./textures/inky_left.png");
    protected static final Image inky_up = Toolkit.getDefaultToolkit().createImage("./textures/inky_up.png");
    protected static final Image inky_right = Toolkit.getDefaultToolkit().createImage("./textures/inky_right.png");
    protected static final Image blinky_down = Toolkit.getDefaultToolkit().createImage("./textures/blinky_down.png");
    protected static final Image blinky_left = Toolkit.getDefaultToolkit().createImage("./textures/blinky_left.png");
    protected static final Image blinky_up = Toolkit.getDefaultToolkit().createImage("./textures/blinky_up.png");
    protected static final Image blinky_right = Toolkit.getDefaultToolkit().createImage("./textures/blinky_right.png");
    protected static final Image clyde_down = Toolkit.getDefaultToolkit().createImage("./textures/clyde_down.png");
    protected static final Image clyde_left = Toolkit.getDefaultToolkit().createImage("./textures/clyde_left.png");
    protected static final Image clyde_up = Toolkit.getDefaultToolkit().createImage("./textures/clyde_up.png");
    protected static final Image clyde_right = Toolkit.getDefaultToolkit().createImage("./textures/clyde_right.png");
    protected static final Image pinky_down = Toolkit.getDefaultToolkit().createImage("./textures/pinky_down.png");
    protected static final Image pinky_left = Toolkit.getDefaultToolkit().createImage("./textures/pinky_left.png");
    protected static final Image pinky_up = Toolkit.getDefaultToolkit().createImage("./textures/pinky_up.png");
    protected static final Image pinky_right = Toolkit.getDefaultToolkit().createImage("./textures/pinky_right.png");
    protected static final Image vulnerable_ghost = Toolkit.getDefaultToolkit().createImage("./textures/vulnerable_blue.png");
    
    protected static final Image gum = Toolkit.getDefaultToolkit().createImage("./textures/power_pill.gif");
    protected static final Image food = Toolkit.getDefaultToolkit().createImage("./textures/dot.gif");
    
    protected static final Image wall = Toolkit.getDefaultToolkit().createImage("./textures/wall.png");
    protected static final Image empty = Toolkit.getDefaultToolkit().createImage("./textures/empty.png");
    
    
    public BoardPanel(char[][] board)
    {
        this.board = board;
        n_lin = board.length;
        n_col = board[0].length;
        
        new Board(board.length, board[0].length,board).show();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        //setLayout(new GridLayout(n_lin, n_col));
        super.paintComponent(g);
        for (int lin = 0; lin < n_lin; lin++)
        {
            for (int col = 0; col < n_col; col++)
            {
                if (board[lin][col] == Food.symbol)
                {
                    g.drawImage(empty, 28*col, 28*lin, 28, 28, this);
                    g.drawImage(food, 28*col+10, 28*lin+9, this);
                }
                else if (board[lin][col] == Gum.symbol)
                {
                    g.drawImage(empty, 28*col, 28*lin, 28, 28, this);
                    g.drawImage(gum, 28*col+10, 28*lin+9, this);
                }
                else if (board[lin][col] == Board.wall)
                {
                    g.drawImage(wall, 28*col, 28*lin, 28, 28, this);
                }
                else
                {
                    g.drawImage(empty, 28*col, 28*lin, 28, 28, this);
                }
            }
        }
    }
}
