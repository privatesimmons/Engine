package GameComponents;

import Rendering.RenderingEngine;

/**
 * Created by damien on 2014/09/06.
 */
public class RectComponent extends GameComponent {
    private int colour;

    public RectComponent(int colour) {
        this.colour = colour;
    }

    @Override
    public void render(RenderingEngine renderingEngine) {
        renderingEngine.renderRect(getGameObject().getX(), getGameObject().getY(),
                getGameObject().getSX(), getGameObject().getSY(),
                colour);
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int m_colour) {
        this.colour = m_colour;
    }
}
