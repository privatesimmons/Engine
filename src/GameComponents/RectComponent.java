package GameComponents;

import Rendering.RenderingEngine;

/**
 * Created by damien on 2014/09/06.
 */
public class RectComponent extends GameComponent
{
    private int m_colour;

    public RectComponent(int colour)
    {
        m_colour = colour;
    }

    @Override
    public void render(RenderingEngine renderingEngine)
    {
        renderingEngine.renderRect(getGameObject().getX(), getGameObject().getY(),
                                   getGameObject().getSX(), getGameObject().getSY(),
                                   m_colour);
    }

    public int getColour() {
        return m_colour;
    }

    public void setColour(int m_colour) {
        this.m_colour = m_colour;
    }
}
