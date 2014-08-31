package Game;

import GameObjects.GameObject;
import GameObjects.Player;
import GameObjects.SpriteTest;
import Rendering.Display;
import Rendering.RenderingEngine;

import java.util.ArrayList;


/**
 * Created by Damien on 24/8/2014.
 */
public class Game
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private RenderingEngine m_renderingEngine;
    private ArrayList<GameObject> m_objectList;
    private Boolean running;
    private Input m_input;

    public Game()
    {
        this.init();
        running = true;
    }

    private void init()
    {
        m_input = new Input();
        m_renderingEngine = new RenderingEngine(new Display(m_input ,WIDTH, HEIGHT,"Hello World"));
        m_objectList = new ArrayList<GameObject>();
        m_objectList.add(new Player(30, 30, "res/man.bmp",this));
    }

    public void update(int delta)
    {
        for(int i = 0; i < m_objectList.size(); i++ )
        {
            m_objectList.get(i).update(m_input ,delta);
        }
    }

    public void render()
    {
        for(int i = 0; i < m_objectList.size(); i++ )
        {
            m_objectList.get(i).render(m_renderingEngine);
        }
        m_renderingEngine.render();
    }

    public Boolean getRunning()
    {
        return running;
    }

    public int getDisplayWidth()
    {
        return this.m_renderingEngine.getDisplay().getWidth();
    }

    public int getDisplayHeight()
    {
        return this.m_renderingEngine.getDisplay().getHeight();
    }
}
