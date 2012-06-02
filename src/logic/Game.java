package logic;

public class Game
{
    private Board board;
    private int n_lives = 3;
    private int score = 0;
    private BoardGenerator bgen;
    
    public Game()
    {
        bgen = new BoardGenerator();
    }
    
    public Game(int n_lin, int n_col, int n_gum)
    {
        bgen = new BoardGenerator(n_lin, n_col, n_gum);
        board = bgen.nextBoard();
    }
    
    public Game(Board new_board)
    {
        board = new_board;
    }
    
    public void play()
    {
        
    }
    
    public void moveGhosts()
    {
        
    }
    
    public boolean isLevelOver()
    {
        
        
        return false;
    }
    
    public boolean isGameOver()
    {
        return false;
    }
    
    public void loseLife()
    {
        n_lives--;
    }
    
    public void winPoints(int points)
    {
       score += points;
    }
    
    public void winLife()
    {
        n_lives++;
    } 
}