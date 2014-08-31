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
    private BufferedImage m_screenBuffer;
    private Bitmap m_pixelArray;

    Random r = new Random();

    public RenderingEngine(Display display)
    {
        m_Display = display;
        m_objectsToBeRendered = new ArrayList<GameObject>();
        m_screenBuffer = new BufferedImage(m_Display.getWidth(), m_Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        m_pixelArray = new Bitmap(m_Display.getWidth(), m_Display.getHeight());

        m_pixelArray.setPixels(((DataBufferInt) m_screenBuffer.getRaster().getDataBuffer()).getData());
    }

    public void addToRender(GameObject go)
    {
        m_objectsToBeRendered.add(go);
    }



    public void render()
    {
        m_pixelArray.fill(Bitmap.BLACK);
//        m_pixelArray.drawRect(10 , 10, 10, 10, Bitmap.BLACK);

        for(int i = 0 ; i < m_objectsToBeRendered.size(); i++)
        {
            if (!(m_objectsToBeRendered.get(i).getSprite() == null))
            {
                m_pixelArray.drawSprite(m_objectsToBeRendered.get(i).getX(),
                                        m_objectsToBeRendered.get(i).getY(),
                                        m_objectsToBeRendered.get(i).getSprite());
            }
            else
            {
                m_pixelArray.drawRect(m_objectsToBeRendered.get(i).getX(),
                                      m_objectsToBeRendered.get(i).getY(),
                                      m_objectsToBeRendered.get(i).getSX(),
                                      m_objectsToBeRendered.get(i).getSY(),
                                      m_objectsToBeRendered.get(i).getColour());
            }
        }

        m_Display.swapBuffers(m_screenBuffer);
    }

    public Display getDisplay() {
        return m_Display;
    }

}
