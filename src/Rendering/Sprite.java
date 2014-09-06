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
    BufferedImage image;

    public Sprite(String filename)
    {
        try {

            File f = new File(filename);
            if(f.exists() && !f.isDirectory())
            {
                BufferedImage temp = ImageIO.read(f);
                width = temp.getWidth();
                height = temp.getHeight();
                image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();
                g.drawImage(temp, 0, 0, null);

                this.setPixels(((DataBufferInt) image.getRaster().getDataBuffer()).getData());
            }
            else
                System.out.println("Couldnt find file");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
