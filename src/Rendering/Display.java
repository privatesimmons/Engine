package Rendering;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by damien on 2014/08/26.
 */
public class Display extends Canvas
{
    private JFrame m_frame;
    private BufferStrategy m_bufferStrategy;
    private Graphics m_graphics;


    public Display(int width, int height, String title)
    {


        m_frame = new JFrame(title);
        this.setSize(width, height);

        m_frame.add(this);
        m_frame.setResizable(false);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setLocationRelativeTo(null);
        m_frame.pack();

        this.createBufferStrategy(1);
        m_bufferStrategy = this.getBufferStrategy();
        m_graphics = m_bufferStrategy.getDrawGraphics();

        m_frame.setVisible(true);
    }

    public void swapBuffers(BufferedImage image)
    {
        m_graphics.drawImage(image, 0,0,image.getWidth(), image.getHeight(), null);
        m_bufferStrategy.show();
    }
}
