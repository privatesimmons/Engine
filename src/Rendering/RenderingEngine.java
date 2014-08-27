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
    private int[] m_pixelArray;

    Random r = new Random();

    public RenderingEngine(Display display)
    {
        m_Display = display;
        m_objectsToBeRendered = new ArrayList<GameObject>();

        m_image = new BufferedImage(m_Display.getWidth(), m_Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        m_pixelArray = ((DataBufferInt)m_image.getRaster().getDataBuffer()).getData();
    }

    public void addToRender(GameObject go)
    {
        m_objectsToBeRendered.add(go);
    }

    public void render()
    {
        for (int i = 0 ; i < m_pixelArray.length ; i++)
        {
            m_pixelArray[i] = r.nextInt();
        }
        m_Display.swapBuffers(m_image);
        //TODO : do the rendering to the image
    }

    public Display getDisplay() {
        return m_Display;
    }

}
