package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmExitDialog
{
    JFrame dialog_frame = new JFrame();
    public ConfirmExitDialog() {};
    
    public boolean ask()
    {
        String title = "Quit game?";
        String message = "Are you sure you want to quit?";
        Object options[] = {"Yes", "No"};
        
        return (JOptionPane.showOptionDialog(dialog_frame, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION);
    }
}
