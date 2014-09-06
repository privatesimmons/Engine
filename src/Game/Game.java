package Game;

import GameObjects.GameObject;
import GameObjects.SpriteTest;
import Rendering.Display;
import Rendering.RenderingEngine;

import java.util.ArrayList;


/**
 * Created by Damien on 24/8/2014.
 */
public class Game {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private RenderingEngine renderingEngine;
    private ArrayList<GameObject> objectList;
    private Boolean running;
    private Input input;

    public Game() {
        this.init();
        running = true;
    }

    private void init() {
        input = new Input(WIDTH, HEIGHT);
        renderingEngine = new RenderingEngine(new Display(input, WIDTH, HEIGHT, "Hello World"));
        objectList = new ArrayList<GameObject>();
        objectList.add(new SpriteTest(-0.5f, -0.5f, 0.05f, 0.05f, "res/blackSquare.bmp", "res/redSquare.bmp"));
    }

    public void update(float delta) {
        for (GameObject object : objectList) {
            object.update(input, delta);
        }

    }

    public void render() {
        for (GameObject object : objectList) {
            object.render(renderingEngine);
        }
        renderingEngine.render();
    }


    public Boolean getRunning() {
        return running;
    }

    public int getDisplayWidth() {
        return renderingEngine.getDisplay().getWidth();
    }

    public int getDisplayHeight() {
        return renderingEngine.getDisplay().getHeight();
    }
}
