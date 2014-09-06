package GameComponents;

import Game.Input;
import GameObjects.GameObject;
import Rendering.RenderingEngine;

/**
 * Created by damien on 2014/09/06.
 */
public abstract class GameComponent
{
    private GameObject m_gameObject;

    public void update(Input input, float delta){}
    public void render(RenderingEngine renderingEngine){}
    public void onAdd(){}
    public void setGameObject(GameObject gameObject){m_gameObject = gameObject;}
    public GameObject getGameObject(){return m_gameObject;}

}
