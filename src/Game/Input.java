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

    private boolean[] keyInput = new boolean[65536];
    private boolean[] mouseButtons = new boolean[4];
    private float mouseX = 0.0f;
    private float mouseY = 0.0f;
    private int halfWidth;
    private int halfHeight;

    public Input(int displayWidth, int displayHeight)
    {
        Arrays.fill(keyInput, false);
        Arrays.fill(mouseButtons, false);

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
            keyInput[event.getKeyCode()] = true;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.exit(-1);
        }
    }

    public void keyReleased(KeyEvent event)
    {
        keyInput[event.getKeyCode()] = false;
    }

    public boolean[] getKeyInput()
    {
        return keyInput;
    }

    public boolean[] getMouseButtons() {
        return mouseButtons;
    }

    public float getMouseX() {
        return mouseX;
    }

    public float getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent){

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {
        mouseButtons[mouseEvent.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {
        mouseButtons[mouseEvent.getButton()] = false;
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
        mouseX = ((float)mouseEvent.getX() - (float)halfWidth  )/ (float) halfWidth  ;
        mouseY = ((float)mouseEvent.getY() - (float)halfHeight )/ (float)-halfHeight ;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent)
    {
        mouseX = ((float)mouseEvent.getX() - (float)halfWidth  )/ (float) halfWidth  ;
        mouseY = ((float)mouseEvent.getY() - (float)halfHeight )/ (float)-halfHeight ;
    }
}
