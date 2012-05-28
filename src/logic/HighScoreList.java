package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class HighScoreList implements Serializable
{
    private static final int max_high_scores = 10;
    
    ArrayList<Integer> high_scores;

    public HighScoreList()
    {
        for (int i = 0; i < max_high_scores; i++)
        {
            high_scores.add(0);
        }
    }

    public void addHighScore(int new_highscore)
    {
        for (int i = 0; i < high_scores.size(); i++)
        {
            if (high_scores.get(i) <= new_highscore)
            {
                high_scores.add(i,new_highscore);
                high_scores.remove(high_scores.size()-1);
                break;
            }
        }

        Collections.sort(high_scores);
    }
}
