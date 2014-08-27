package GameObjects;

import Rendering.RenderingEngine;
import Rendering.Sprite;

/**
 * Created by Damien on 24/8/2014.
 */
public abstract class GameObject
{
    private int m_x, m_y, m_sx, m_sy;
    private int[] m_colour;
    private Sprite m_sprite;

    public void render(RenderingEngine renderingEngine)
    {
        renderingEngine.addToRender(this);
    }

    public void update()
    {

    }
}
