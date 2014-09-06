package Rendering;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

/**
 * Created by Damien on 24/8/2014.
 */

public class RenderingEngine
{
    public final int CLEARCOLOUR = Bitmap.RED;

    private Display display;
    private BufferedImage screenBuffer;
    private Bitmap pixelArray;
    private int halfWidth;
    private int halfHeight;
    private float aspectRatio ;
    Random r = new Random();

    public RenderingEngine(Display display)
    {
        this.display = display;
        screenBuffer = new BufferedImage(this.display.getWidth(), this.display.getHeight(), BufferedImage.TYPE_INT_ARGB);
        pixelArray = new Bitmap(this.display.getWidth(), this.display.getHeight());

        pixelArray.setPixels(((DataBufferInt) screenBuffer.getRaster().getDataBuffer()).getData());

        halfWidth = this.display.getWidth() /2;
        halfHeight = this.display.getHeight() /2;
        aspectRatio = this.display.getWidth() / this.display.getHeight();
    }


    public void renderRect(float fx, float fy, float fsx, float fsy, int colour)
    {
        int x = (int)(fx * halfWidth) + halfWidth;
        int y = (int)(fy * -halfHeight) + halfHeight;
        int sx = (int)(fsx * halfWidth) ;
        int sy = (int)(fsy * halfHeight) ;
        pixelArray.drawRect(x, y, sx, sy, colour);
    }

    public void renderSprite(float fx,float fy, float fsx, float fsy, Sprite sprite )
    {
        int x = (int)(fx * halfWidth) + halfWidth;
        int y = (int)(fy * -halfHeight) + halfHeight;
        int sx = (int)(fsx * halfWidth) ;
        int sy = (int)(fsy * halfHeight);
        pixelArray.drawSprite(x, y, sprite);
    }


    public void render()
    {
        pixelArray.drawRect(10, 10, 10, 10, Bitmap.BLUE);
        display.swapBuffers(screenBuffer);
        pixelArray.fill(CLEARCOLOUR);
    }

    public Display getDisplay() {
        return display;
    }

}
