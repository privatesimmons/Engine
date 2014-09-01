package Game;

import GameObjects.GameObject;
import GameObjects.Player;
import GameObjects.SpriteTest;
import GameObjects.Swarmer;
import Rendering.Bitmap;
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
    private Player m_player;

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
        m_player = new Player(30, 30, "res/man.bmp",this);
        m_objectList.add(m_player);
        m_objectList.add(new Swarmer(90, 90,1, "res/ninja.bmp" , this));
        m_objectList.add(new Swarmer(70, 90,1, "res/ninja.bmp" , this));
        m_objectList.add(new Swarmer(60, 90,1, "res/ninja.bmp" , this));
        m_objectList.add(new Swarmer(30, 90,1, "res/ninja.bmp" , this));
        m_objectList.add(new Swarmer(500, 90,1, "res/ninja.bmp" , this));
        m_objectList.add(new Swarmer(700, 90,1, "res/ninja.bmp" , this));
        m_renderingEngine.setBackground(Bitmap.GREY);
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

    public Player getPlayer()
    {
        return m_player;
    }

    public ArrayList<GameObject> getObjectList() {
        return m_objectList;
    }
}
