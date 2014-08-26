package Rendering;

import GameObjects.GameObject;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;

/**
 * Created by Damien on 24/8/2014.
 */
public class RenderingEngine
{

    private Display m_Display;
    private ArrayList<GameObject> m_objectsToBeRendered;
    private BufferedImage m_image;
    private byte[] m_pixelArray;

    public RenderingEngine(Display display)
    {
        m_Display = display;
        m_objectsToBeRendered = new ArrayList<GameObject>();

        m_image = new BufferedImage(m_Display.getWidth(), m_Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        m_pixelArray = ((DataBufferByte)m_image.getRaster().getDataBuffer()).getData();
    }

    public void addToRender(GameObject go)
    {
        m_objectsToBeRendered.add(go);
    }

    public void render()
    {

    }

}
