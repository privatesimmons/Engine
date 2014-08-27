package GameObjects;

import Rendering.Sprite;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject
{
    public SpriteTest(int x, int y, int sx, int sy, String filename)
    {
        m_x = x;
        m_y = y;
        m_sx = sx;
        m_sy = sy;
        m_sprite = new Sprite(filename);

    }
}
