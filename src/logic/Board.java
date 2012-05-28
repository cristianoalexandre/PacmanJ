package logic;

public class Board
{
    public static char wall = 'X';
    public static char empty = ' ';
    public static final int n_ghosts = 4;
    
    private char[][] board;
    private int n_lin;
    private int n_col;
    
    public Board()
    {
        
    }
    
    public Board(int lin, int col)
    {
        n_lin = lin; n_col = col;
        board = new char[lin][col];
    }
    
    public Board(int lin, int col, char[][] board)
    {
        n_col = col; n_lin = lin; this.board = board;
    }
}