package logic;

import java.awt.event.KeyEvent;

public class OptionList
{
    // board
    int board_n_lin;
    int board_n_col;
    int board_n_gums;
    int board_style;
    
    public static final int classic = 0;
    public static final int random = 1;
    
    // difficulty
    int difficulty_level;
    
    public static final int easy = 0;
    public static final int medium = 1;
    public static final int hard = 2;
    
    // sound
    int sound_level;
    
    public static final int mute = 0;
    public static final int max = 100;

    // keys
    public int left_button_key;
    public int right_button_key;
    public int up_button_key;
    public int down_button_key;
    
    public OptionList()
    {
        
    }
    
    public void setDefaultValues()
    {
        board_n_col = 10;
        board_n_lin = 10;
        board_n_gums = 6;
        board_style = random;
        
        difficulty_level = easy;
        
        sound_level = max;
        
        left_button_key = KeyEvent.VK_LEFT;
        right_button_key = KeyEvent.VK_RIGHT;
        up_button_key = KeyEvent.VK_UP;
        down_button_key = KeyEvent.VK_DOWN;
    }
}
