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

        m_pixelArray.setPixels(((DataBufferInt)m_image.getRaster().getDataBuffer()).getData());
    }

    public void addToRender(GameObject go)
    {
        m_objectsToBeRendered.add(go);
    }

    public void render()
    {
        for (int j = 0 ; j < m_Display.getHeight(); j++)
        {
            for (int i = 0 ; i < m_Display.getWidth() ; i++)
            {
                m_pixelArray.drawPixel(i, j, r.nextInt());
            }
        }
        m_Display.swapBuffers(m_image);
        //TODO : do the rendering to the image
    }

    public Display getDisplay() {
        return m_Display;
    }

}
