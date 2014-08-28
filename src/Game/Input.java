package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Damien on 28/8/2014.
 */
public class Input extends KeyAdapter
{
    private int[] m_input;

    public Input()
    {
        m_input = new int[10];
        Arrays.fill(m_input, -1);
    }

    public void keyPressed(KeyEvent event)
    {
        int i = 0;


        //TODO Optimise inputs : they are a lot slower than id like but its okay for now
        while(!(m_input[i] == -1))
        {
            i++;
        }
        try
        {
            boolean isInArray= false;
            for(int j = 0; j < m_input.length; j++)
            {
                isInArray = isInArray || (m_input[j] == event.getKeyCode());
            }
            if (!isInArray)
            {
                m_input[i] = event.getKeyCode();
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.exit(-1);
        }
    }

    public void keyReleased(KeyEvent event)
    {
        int i = 0;
        while(!(m_input[i] == event.getKeyCode()))
        {
            i++;
        }
        if (i > 9)
        {
            System.out.println("Key not in array was released");
        }
        else
        {
            m_input[i] = -1;
        }
    }

    public int[] getInput()
    {
        return  m_input;
    }
}
