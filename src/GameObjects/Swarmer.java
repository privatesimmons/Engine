package GameObjects;

/**
 * Created by damien on 2014/08/31.
 */
import Game.Game;
import Game.Input;
import Rendering.Sprite;
import Game.Util;

import java.util.Random;

public class Swarmer extends GameObject
{
    private Game m_game;
    private int m_maxV;
    private Random r;

    public Swarmer(int x, int y, int maxV, String filename, Game game )
    {
        m_x = x;
        m_y = y;
        m_maxV = maxV;
        m_sprite = new Sprite(filename);
        m_sx = m_sprite.getWidth();
        m_sy = m_sprite.getHeight();
        m_game = game;
        r = new Random();
    }

    public void update(Input input, int delta)
    {
        boolean canMove = true;

        for(int i = 0; i < m_game.getObjectList().size(); i++)
        {
            if(m_game.getObjectList().get(i) != this)
            {
                canMove = canMove && (!Util.Intersects(this, m_game.getObjectList().get(i)));
            }
        }

        if (canMove)
        {
            if(m_game.getPlayer().getX() > m_x)
            {
                m_x += ((m_maxV * delta)/ 3);
            }
            else if (m_game.getPlayer().getX() < m_x)
            {
                m_x -= ((m_maxV * delta)/ 3);
            }

            if(m_game.getPlayer().getY() > m_y)
            {
                m_y += ((m_maxV * delta)/ 3);
            }
            else if (m_game.getPlayer().getY() < m_y)
            {
                m_y -= ((m_maxV * delta)/ 3);
            }
        }
        else
        {
            if(r.nextBoolean())
            {
                m_x += ((Math.random() * m_maxV) * delta / 4);
                m_y += ((Math.random() * m_maxV) * delta / 4);
            }
            else
            {
                m_x -= ((Math.random() * m_maxV) * delta / 4);
                m_y -= ((Math.random() * m_maxV) * delta / 4);
            }

        }



    }
}
