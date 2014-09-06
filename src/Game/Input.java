package Game;

import java.awt.event.*;
import java.util.Arrays;

/**
 * Created by Damien on 28/8/2014.
 */
public class Input implements KeyListener, MouseListener, MouseMotionListener
{

    private final int MOUSE_LEFT = 1;
    private final int MOUSE_RIGHT = 2;

    private boolean[] m_keyInput = new boolean[65536];
    private boolean[] m_mouseButtons = new boolean[4];
    private float m_mouseX = 0.0f;
    private float m_mouseY = 0.0f;
    private int halfWidth;
    private int halfHeight;

    public Input(int displayWidth, int displayHeight)
    {
        Arrays.fill(m_keyInput, false);
        Arrays.fill(m_mouseButtons, false);

        halfWidth = displayWidth / 2;
        halfHeight = displayHeight / 2;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent event)
    {
        try
        {
            m_keyInput[event.getKeyCode()] = true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.exit(-1);
        }
    }

    public void keyReleased(KeyEvent event)
    {
        m_keyInput[event.getKeyCode()] = false;
    }

    public boolean[] getKeyInput()
    {
        return  m_keyInput;
    }

    public boolean[] getMouseButtons() {
        return m_mouseButtons;
    }

    public float getMouseX() {
        return m_mouseX;
    }

    public float getMouseY() {
        return m_mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent){

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        m_mouseButtons[mouseEvent.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        m_mouseButtons[mouseEvent.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent){

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {
        m_mouseX = ((float)mouseEvent.getX() - (float)halfWidth  )/ (float) halfWidth  ;
        m_mouseY = ((float)mouseEvent.getY() - (float)halfHeight )/ (float)-halfHeight ;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        m_mouseX = ((float)mouseEvent.getX() - (float)halfWidth  )/ (float) halfWidth  ;
        m_mouseY = ((float)mouseEvent.getY() - (float)halfHeight )/ (float)-halfHeight ;
    }
}
