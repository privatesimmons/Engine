package Rendering;

import Game.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by damien on 2014/08/26.
 */
public class Display extends Canvas
{
    private JFrame frame;
    private BufferStrategy bufferStrat;
    private Graphics graphics;

    public Display(Input input ,int width, int height, String title)
    {


        frame = new JFrame(title);
        this.setSize(width, height);

        frame.add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100, 100);
        frame.pack();

        this.createBufferStrategy(1);
        bufferStrat = this.getBufferStrategy();
        graphics = bufferStrat.getDrawGraphics();
        addKeyListener(input);
        addMouseListener(input);
        addMouseMotionListener(input);
        requestFocus();
        frame.setVisible(true);
    }

    public void swapBuffers(BufferedImage image)
    {
        graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        bufferStrat.show();
    }


    public JFrame getFrame() {
        return frame;
    }
}
