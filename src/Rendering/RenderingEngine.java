package Rendering;

import GameObjects.GameObject;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Damien on 24/8/2014.
 */
public class RenderingEngine
{


    private Display m_Display;
    private ArrayList<GameObject> m_objectsToBeRendered;
    private BufferedImage m_image;
    private Bitmap m_pixelArray;

    Random r = new Random();

    public RenderingEngine(Display display)
    {
        m_Display = display;
        m_objectsToBeRendered = new ArrayList<GameObject>();
        m_image = new BufferedImage(m_Display.getWidth(), m_Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        m_pixelArray = new Bitmap(m_Display.getWidth(), m_Display.getHeight());

        m_pixelArray.setPixels(((DataBufferInt) m_image.getRaster().getDataBuffer()).getData());
    }

    public void addToRender(GameObject go)
    {
        m_objectsToBeRendered.add(go);
    }

    private int count;
    private int x;

    public void render()
    {
        m_pixelArray.fill(Bitmap.GREY);
        m_pixelArray.drawRect(x , x, 10, 10, Bitmap.CYAN);
       if (count % 1 == 0)
       {
           x++;
           count = 0;
       }
       count++;
        m_Display.swapBuffers(m_image);
        //TODO : do the rendering to the image
    }

    public Display getDisplay() {
        return m_Display;
    }

}
