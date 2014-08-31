package GameObjects;

import Game.Input;
import Rendering.Sprite;

import java.awt.event.KeyEvent;
import Game.Game;

/**
 * Created by damien on 2014/08/31.
 */
public class Player extends GameObject
{
    private Game m_game;

    public Player(int x, int y, String filename, Game game)
    {
        m_x = x;
        m_y = y;
        m_sprite = new Sprite(filename);
        m_sx = m_sprite.getWidth();
        m_sy = m_sprite.getHeight();
        m_game = game;
    }

    public void update(Input input , int delta)
    {
        if(input.getKeyInput()[KeyEvent.VK_LEFT])
        {
            m_x = m_x - (delta/2);
        }
        if(input.getKeyInput()[KeyEvent.VK_RIGHT])
        {
            m_x = m_x + (delta/2);
        }
        if(input.getKeyInput()[KeyEvent.VK_DOWN])
        {
            m_y = m_y + (delta/2);
        }
        if(input.getKeyInput()[KeyEvent.VK_UP])
        {
            m_y = m_y - (delta/2);
        }
        if(m_x < 0 )
        {
            m_x = 0;
        }
        if(m_x + m_sx > m_game.getDisplayWidth() )
        {
            m_x = m_game.getDisplayWidth() - m_sx;
        }
        if(m_y < 0 )
        {
            m_y = 0;
        }
        if(m_y + m_sy > m_game.getDisplayHeight() )
        {
            m_y = m_game.getDisplayHeight() - m_sy;
        }


    }
}
