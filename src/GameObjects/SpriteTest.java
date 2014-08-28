package GameObjects;

import Rendering.Sprite;
import  Game.Game;

import java.awt.event.KeyEvent;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject
{
    private Sprite[] m_sprites;
    private int m_spriteCounter;
    private Game m_game;
    public SpriteTest(int x, int y, int sx, int sy, Game game ,String filename, String filename2)
    {
        m_x = x;
        m_y = y;
        m_sx = sx;
        m_sy = sy;
        m_game = game;
        m_sprites = new Sprite[2];
        m_sprites[0] = new Sprite(filename);
        m_sprites[1] = new Sprite(filename2);
        m_sprite = m_sprites[0];
    }

    public void update()
    {
        for(int i = 0; i < m_game.getInput().length ; i++)
        {
            switch (m_game.getInput()[i])
            {
                case KeyEvent.VK_UP:
                    m_y-=2;
                    break;
                case KeyEvent.VK_DOWN:
                    m_y+=2;
                    break;
                case KeyEvent.VK_RIGHT:
                    m_x+=2;
                    break;
                case KeyEvent.VK_LEFT:
                    m_x-=2;
                    break;
            }
        }


        m_spriteCounter++;
        m_sprite = m_sprites[m_spriteCounter % 2];
    }
}
