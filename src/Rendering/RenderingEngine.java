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
    public final int CLEARCOLOUR = Bitmap.RED;

    private Display m_Display;
    private BufferedImage m_screenBuffer;
    private Bitmap m_pixelArray;
    private int halfWidth;
    private int halfHeight;
    private float aspectRatio ;
    Random r = new Random();

    public RenderingEngine(Display display)
    {
        m_Display = display;
        m_screenBuffer = new BufferedImage(m_Display.getWidth(), m_Display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        m_pixelArray = new Bitmap(m_Display.getWidth(), m_Display.getHeight());

        m_pixelArray.setPixels(((DataBufferInt) m_screenBuffer.getRaster().getDataBuffer()).getData());

        halfWidth = m_Display.getWidth() /2;
        halfHeight = m_Display.getHeight() /2;
        aspectRatio = m_Display.getWidth() / m_Display.getHeight();
    }


    public void renderRect(float fx, float fy, float fsx, float fsy, int colour)
    {
        int x = (int)(fx * halfWidth) + halfWidth / (int)aspectRatio;
        int y = (int)(fy * -halfHeight) + halfHeight;
        int sx = (int)(fsx * halfWidth) / (int)aspectRatio;
        int sy = (int)(fsy * halfHeight) ;
        m_pixelArray.drawRect(x, y, sx, sy, colour);
    }

    public void renderSprite(float fx,float fy, float fsx, float fsy, Sprite sprite )
    {
        int x = (int)(fx * halfWidth) + halfWidth;
        int y = (int)(fy * -halfHeight) + halfHeight;
        int sx = (int)(fsx * halfWidth) ;
        int sy = (int)(fsy * halfHeight);
        m_pixelArray.drawSprite(x,y,sprite);
    }


    public void render()
    {
        m_pixelArray.drawRect(10 , 10, 10, 10, Bitmap.BLUE);
        m_Display.swapBuffers(m_screenBuffer);
        m_pixelArray.fill(CLEARCOLOUR);
    }

    public Display getDisplay() {
        return m_Display;
    }

}
