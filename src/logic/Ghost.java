package logic;

public class Ghost extends MovingPersona
{
    private boolean vulnerable;
    
    public Ghost()    
    {
        super();
        symbol = 'G';
        vulnerable = false;
    }
    
    public Ghost(int lin, int col)
    {
        super(lin,col);
        symbol = 'G';
        vulnerable = false;
    }
    
    public boolean isVulnerable()
    {
        return vulnerable;
    }
    
    public void becomeVulnerable()
    {
        vulnerable = true;
    }
    
    public void respawn()
    {
        
    }
}