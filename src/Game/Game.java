package Game;

import Rendering.Display;
import Rendering.RenderingEngine;


/**
 * Created by Damien on 24/8/2014.
 */
public class Game
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private RenderingEngine m_renderingEngine;

    private Boolean running;

    public Game()
    {
        m_renderingEngine = new RenderingEngine(new Display(WIDTH, HEIGHT, "Hello World"));
        running = true;
    }

    public void update()
    {

    }

    public void render()
    {
        m_renderingEngine.render();
    }

    public Boolean getRunning()
    {
        return running;
    }

}
