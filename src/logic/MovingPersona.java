package logic;

public abstract class MovingPersona extends Persona
{
    public MovingPersona()
    {
        super();
    }

    public MovingPersona(int lin, int col)
    {
        super(lin, col);
    }

    /**
     * Moves the persona left
     */
    public void goLeft()
    {
        saveLastPosition();
        current_position[1]--;
    }

    /**
     * Moves the persona right
     */
    public void goRight()
    {
        saveLastPosition();
        current_position[1]++;
    }

    /**
     * Moves the persona up
     */
    public void goUp()
    {
        saveLastPosition();
        current_position[0]--;
    }

    /**
     * Moves the persona down
     */
    public void goDown()
    {
        saveLastPosition();
        current_position[0]++;
    }

    /**
     * Moves the persona back to it's old position
     */
    public void returnToLastPostion()
    {
        current_position[0] = old_position[0];
        current_position[1] = old_position[1];
    }
}
