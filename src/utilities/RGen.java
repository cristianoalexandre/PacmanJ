package utilities;

import java.util.Random;

public class RGen
{
    Random r_generator = new Random();
    
    public RGen()
    {
        
    }
    
    public int nextInt()
    {
        return r_generator.nextInt();
    }
    
    public int nextInt(int max)
    {
        return r_generator.nextInt(max);
    }
    
    public int nextInt(int min, int max)
    {
        return min+r_generator.nextInt(max-min);
    }
}
