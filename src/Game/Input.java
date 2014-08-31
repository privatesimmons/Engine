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
    private boolean[] m_keyInput = new boolean[65536];

    public Input()
    {
        Arrays.fill(m_keyInput, false);
    }

    public void keyPressed(KeyEvent event)
    {
        try
        {
            m_keyInput[event.getKeyCode()] = true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.exit(-1);
        }
    }

    public void keyReleased(KeyEvent event)
    {
        m_keyInput[event.getKeyCode()] = false;
    }

    public boolean[] getKeyInput()
    {
        return  m_keyInput;
    }
}
