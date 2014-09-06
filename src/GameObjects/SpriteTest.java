package GameObjects;

import GameComponents.RectComponent;
import Rendering.Bitmap;
import Game.Input;

import java.awt.event.KeyEvent;

/**
 * Created by damien on 2014/08/27.
 */
public class SpriteTest extends GameObject {
    public SpriteTest(float x, float y, float sx, float sy, String filename, String filename2) {
        posX = x;
        posY = y;
        sizeX = sx;
        sizeY = sy;
        addComponent(new RectComponent(Bitmap.CYAN));

//        sprites = new Sprite[2];
//        sprites[0] = new Sprite(filename);
//        sprites[1] = new Sprite(filename2);
//        sprite = sprites[0];
    }

    public void update(Input input, float delta) {
        super.update(input, delta);

        if (input.getMouseButtons()[1]) {
            posX = input.getMouseX() - (sizeX / 2);
            posY = input.getMouseY();
        }
        if (input.getKeyInput()[KeyEvent.VK_UP]) {
            posY += (delta / 700.0f);
        }
        if (input.getKeyInput()[KeyEvent.VK_DOWN]) {
            posY -= (delta / 700.0f);
        }
        if (input.getKeyInput()[KeyEvent.VK_RIGHT]) {
            posX += (delta / 700.0f);
        }
        if (input.getKeyInput()[KeyEvent.VK_LEFT]) {
            posX -= (delta / 700.0f);
        }


//        spriteCounter++;
//        sprite = sprites[m_spriteCounter % 2];
    }

}
