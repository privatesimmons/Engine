package GameObjects;

import Game.Input;
import GameComponents.GameComponent;
import Rendering.RenderingEngine;
import Rendering.Sprite;

import java.util.ArrayList;

/**
 * Created by Damien on 24/8/2014.
 */
public abstract class GameObject
{
    protected float m_x, m_y, m_sx, m_sy;
    protected int m_colour;
    protected Sprite m_sprite;
    private ArrayList<GameComponent> m_components;

    public GameObject()
    {
        m_components = new ArrayList<GameComponent>();
    }

    public void render(RenderingEngine renderingEngine)
    {
        for(int i = 0; i < m_components.size(); i++)
        {
            m_components.get(i).render(renderingEngine);
        }
    }

    public void update(Input input,float delta)
    {
        for(int i = 0; i < m_components.size(); i++)
        {
            m_components.get(i).update(input, delta);
        }
    }

    public void addComponent(GameComponent gameComponent)
    {
        gameComponent.setGameObject(this);
        gameComponent.onAdd();
        m_components.add(gameComponent);
    }

    public float getX() {
        return m_x;
    }

    public void setX(int m_x) {
        this.m_x = m_x;
    }

    public float getY() {
        return m_y;
    }

    public void setY(int m_y) {
        this.m_y = m_y;
    }

    public float getSX() {
        return m_sx;
    }

    public void setSX(int m_sx) {
        this.m_sx = m_sx;
    }

    public float getSY() {
        return m_sy;
    }

    public void setSY(int m_sy) {
        this.m_sy = m_sy;
    }

    public int getColour() {
        return m_colour;
    }

    public void setColour(int m_colour) {
        this.m_colour = m_colour;
    }

    public Sprite getSprite() {
        return m_sprite;
    }

    public void setSprite(Sprite m_sprite) {
        this.m_sprite = m_sprite;
    }
}
