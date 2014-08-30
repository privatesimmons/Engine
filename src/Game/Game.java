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
    private int[] m_input;

    public Game()
    {
        this.init();
        running = true;
    }

    private void init()
    {
        m_renderingEngine = new RenderingEngine(new Display(WIDTH, HEIGHT, "Hello World"));
        m_objectList = new ArrayList<GameObject>();
        m_objectList.add(new SpriteTest( 30, 30, 20, 20, this,"res/blackSquare.bmp","res/redSquare.bmp" ));
    }

    public void update()
    {
        for(int i = 0; i < m_objectList.size(); i++ )
        {
            m_objectList.get(i).update();
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

    public int[] getInput()
    {
        return m_input;
    }

    public void setInput()
    {
        m_input = m_renderingEngine.getDisplay().getInputClass().getInput();
    }


    public Boolean getRunning()
    {
        return running;
    }

}
