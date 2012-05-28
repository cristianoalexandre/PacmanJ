package logic;

public class Pacman extends MovingPersona
{
    private boolean super_power; 
    
    public Pacman()
    {
        super();
        symbol = 'P';
        super_power = false;
    }
    
    public Pacman(int lin, int col)
    {
        super(lin, col);
        symbol = 'P';
        super_power = false;
    }
    
    public boolean isSuperPowerful()
    {
        return super_power;
    }   
    
    public void becomeSuperPowerful()
    {
        super_power = true;
    }
    
    public void becomeNormal()
    {
        super_power = false;
    }
}