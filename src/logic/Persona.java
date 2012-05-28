package logic;

public abstract class Persona
{
    protected static char symbol;
    protected int[] old_position =
    {
        -1, -1
    };
    protected int[] current_position = new int[2];
    protected boolean dead;

    public Persona()
    {
        dead = false;
    }

    public Persona(int lin, int col)
    {
        current_position[0] = lin;
        current_position[1] = col;
        dead = false;
    }

    /**
     * Saves the position where the persona was, before the current move
     */
    protected void saveLastPosition()
    {
        if (current_position[0] >= 0)
        {
            old_position[0] = current_position[0];
            old_position[1] = current_position[1];
        }
    }


    /**
     *
     * @param persona dragon, sword or hero
     * @return Returns true if two personas are in adjacent positions, and false otherwise
     */
    public boolean isAdjacentTo(Persona persona)
    {
        return (((getLine() == persona.getLine()) && (getColumn() == persona.getColumn() + 1))
                || ((getLine() == persona.getLine()) && (getColumn() == persona.getColumn() - 1))
                || ((getColumn() == persona.getColumn()) && (getLine() == persona.getLine() + 1))
                || ((getColumn() == persona.getColumn()) && (getLine() == persona.getLine() - 1)));
    }

    /**
     *
     * @return Returns the symbol that represents a persona (dragon, sword or hero)
     */
    public char getSymbol()
    {
        return symbol;
    }

    /**
     *
     * @return Returns the line of persona's current position
     */
    public int getLine()
    {
        return current_position[0];
    }

    /**
     *
     * @return Returns the column of persona's current position
     */
    public int getColumn()
    {
        return current_position[1];
    }

    /**
     *
     * @return Returns the line of persona's old position
     */
    public int getLastLine()
    {
        return old_position[0];
    }

    /**
     *
     * @return Returns the column of persona's old position
     */
    public int getLastColumn()
    {
        return old_position[1];
    }

    /**
     * Sets the coordinates of persona's current position
     *
     * @param lin maze's line
     * @param col maze's column
     */
    public void setCoord(int lin, int col)
    {
        saveLastPosition();
        current_position[0] = lin;
        current_position[1] = col;
    }

    /**
     * Sets the persona's status to dead
     */
    public void die()
    {
        dead = true;
    }

    /**
     *
     * @return Returns true is the persona is dead, and false otherwise
     */
    public boolean isDead()
    {
        return dead;
    }

    /**
     * Sets persona's symbol as new_symbol
     *
     * @param new_symbol
     */
    public void setSymbol(char new_symbol)
    {
        symbol = new_symbol;
    }
}
