package GameObjects;

import Rendering.Sprite;
import  Game.Game;
import Game.Input;

import java.awt.event.KeyEvent;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject
{
    private Sprite[] m_sprites;
    private int m_spriteCounter;
    public SpriteTest(float x, float y, float sx, float sy ,String filename, String filename2)
    {
        m_x = x;
        m_y = y;
        m_sx = sx;
        m_sy = sy;;
        m_sprites = new Sprite[2];
        m_sprites[0] = new Sprite(filename);
        m_sprites[1] = new Sprite(filename2);
        m_sprite = m_sprites[0];
    }

    public void update(Input input,float delta)
    {
        for(int i = 0; i < input.getInput().length ; i++)
        {
            switch (input.getInput()[i])
            {
                case KeyEvent.VK_UP:
                    debuggystuff();
                    m_y += ( delta / 700.0f);
                    break;
                case KeyEvent.VK_DOWN:
                    m_y -= ( delta / 700.0f);
                    break;
                case KeyEvent.VK_RIGHT:
                    m_x+= ( delta / 700.0f);
                    break;
                case KeyEvent.VK_LEFT:
                    m_x-= ( delta / 700.0f);
                    break;
            }
        }


        m_spriteCounter++;
        m_sprite = m_sprites[m_spriteCounter % 2];
    }

    public void debuggystuff()
    {
        int i = 1+ 1;
    }
}
