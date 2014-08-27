package Rendering;

import java.util.Arrays;

/**
 * Created by damien on 2014/08/27.
 */
public class Bitmap
{
    private int m_width;
    private int m_height;
    private int[] m_pixels;

    public Bitmap(int width, int height)
    {
        m_width = width;
        m_height = height;
        m_pixels = new int[width * height];
    }

    public void drawPixel(int x, int y, byte a, byte r, byte g, byte b)
    {
        m_pixels[x + y * m_width] = createPixel(a, r, g, b);
    }

    public void fill(int colour)
    {
        Arrays.fill(m_pixels, colour);
    }

    public void drawPixel(int x, int y, int colour)
    {
        m_pixels[x + y * m_width] = colour;
    }

    private int createPixel(int a, int r,int  g,int  b )
    {
        int a1 = a << 24;
        int r1 = r << 16;
        int g1 = g << 8;
        int b1 = b;
        return a1 + r1 + g1 + b1;
    }
    public int[] getPixels()
    {
        return m_pixels;
    }

    public void setPixels(int[] pixels)
    {
        m_pixels = pixels;
    }
}
