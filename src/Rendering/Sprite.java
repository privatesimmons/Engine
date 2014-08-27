package Rendering;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

/**
 * Created by damien on 2014/08/27.
 */
public class Sprite extends Bitmap
{
    BufferedImage m_Image;

    public Sprite(String filename)
    {
        try {

            BufferedImage temp = ImageIO.read(new File(filename));
            m_width = temp.getWidth();
            m_height = temp.getHeight();
            m_Image = new BufferedImage(m_width, m_height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = m_Image.getGraphics();
            g.drawImage(temp, 0,0, null);

            this.setPixels( ((DataBufferInt)m_Image.getRaster().getDataBuffer()).getData());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
