package GameObjects;

import GameComponents.RectComponent;
import Rendering.Bitmap;
import Rendering.Sprite;
import  Game.Game;
import Game.Input;

import java.awt.event.KeyEvent;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject
{
    public SpriteTest(float x, float y, float sx, float sy ,String filename, String filename2)
    {
        m_x = x;
        m_y = y;
        m_sx = sx;
        m_sy = sy;
        addComponent(new RectComponent(Bitmap.CYAN));

//        m_sprites = new Sprite[2];
//        m_sprites[0] = new Sprite(filename);
//        m_sprites[1] = new Sprite(filename2);
//        m_sprite = m_sprites[0];
    }

    public void update(Input input,float delta)
    {
        super.update(input, delta);

        if(input.getMouseButtons()[1])
        {
            m_x = input.getMouseX() - (m_sx/2);
            m_y = input.getMouseY();
        }
        if(input.getKeyInput()[KeyEvent.VK_UP])
        {
            m_y += (delta / 700.0f);
        }
        if(input.getKeyInput()[KeyEvent.VK_DOWN])
        {
            m_y -= (delta / 700.0f);
        }
        if(input.getKeyInput()[KeyEvent.VK_RIGHT])
        {
            m_x += (delta / 700.0f);
        }
        if(input.getKeyInput()[KeyEvent.VK_LEFT])
        {
            m_x -= (delta / 700.0f);
        }


//        m_spriteCounter++;
//        m_sprite = m_sprites[m_spriteCounter % 2];
    }

}
