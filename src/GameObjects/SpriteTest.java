package GameObjects;

import Rendering.Sprite;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject
{
    private Sprite[] m_sprites;
    private int m_spriteCounter;
    public SpriteTest(int x, int y, int sx, int sy, String filename, String filename2)
    {
        m_x = x;
        m_y = y;
        m_sx = sx;
        m_sy = sy;
        m_sprites = new Sprite[2];
        m_sprites[0] = new Sprite(filename);
        m_sprites[1] = new Sprite(filename2);
        m_sprite = m_sprites[0];
    }

    public void update()
    {
        m_spriteCounter++;
        m_sprite = m_sprites[m_spriteCounter % 2];
    }
}
