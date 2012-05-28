package logic;

public abstract class StaticPersona extends Persona
{
    public StaticPersona()
    {
        super();
    }
    
    public StaticPersona(int lin, int col)
    {
        super(lin,col);
    }
    
    public void eatIt()
    {
        die();
    }

    public boolean isEaten()
    {
        return isDead();
    }
}
