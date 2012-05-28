package logic;

public class Game
{
    private Board board;
    private int n_lives = 3;
    private int score = 0;
    private BoardGenerator bgen;
    
    public Game()
    {
        
    }
    
    public void play()
    {
        
    }
    
    public boolean isLevelOver()
    {
        return true;
    }
    
    public boolean isGameOver()
    {
        return true;
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