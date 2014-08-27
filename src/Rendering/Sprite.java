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
    BufferedImage m_image;

    public Sprite(String filename)
    {
        try {

            File f = new File(filename);
            if(f.exists() && !f.isDirectory())
            {
                BufferedImage temp = ImageIO.read(f);
                m_width = temp.getWidth();
                m_height = temp.getHeight();
                m_image = new BufferedImage(m_width, m_height, BufferedImage.TYPE_INT_ARGB);
                Graphics g = m_image.getGraphics();
                g.drawImage(temp, 0, 0, null);

                this.setPixels(((DataBufferInt) m_image.getRaster().getDataBuffer()).getData());
            }
            else
                System.out.println("Couldnt find file");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
