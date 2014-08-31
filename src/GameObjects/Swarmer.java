package GameObjects;

/**
 * Created by damien on 2014/08/31.
 */
import Game.Game;
import Game.Input;
import Rendering.Sprite;

public class Swarmer extends GameObject
{
    private Game m_game;
    private int m_maxV;

    public Swarmer(int x, int y, int maxV, String filename, Game game )
    {
        m_x = x;
        m_y = y;
        m_maxV = maxV;
        m_sprite = new Sprite(filename);
        m_sx = m_sprite.getWidth();
        m_sy = m_sprite.getHeight();
        m_game = game;
    }

    public void update(Input input, int delta)
    {
        if(m_game.getPlayer().getX() > m_x)
        {
            m_x += m_maxV * delta;
        }
        else if (m_game.getPlayer().getX() < m_x)
        {
            m_x -= m_maxV * delta;
        }

        if(m_game.getPlayer().getY() > m_y)
        {
            m_y += m_maxV * delta;
        }
        else if (m_game.getPlayer().getY() < m_y)
        {
            m_y -= m_maxV * delta;
        }



    }
}
