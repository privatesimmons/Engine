package Game;

import GameObjects.GameObject;
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

    public Game()
    {
        m_renderingEngine = new RenderingEngine(new Display(WIDTH, HEIGHT, "Hello World"));
        m_objectList = new ArrayList<GameObject>();
        this.init();
        running = true;
    }

    private void init()
    {
        m_objectList.add(new SpriteTest( 30, 30, 20, 20, "res/blackSquare.bmp"));
    }

    public void update()
    {

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

}
