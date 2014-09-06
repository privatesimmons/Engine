package GameObjects;

import Game.Input;
import GameComponents.GameComponent;
import Rendering.RenderingEngine;
import Rendering.Sprite;

import java.util.ArrayList;

/**
 * Created by Damien on 24/8/2014.
 */
public abstract class GameObject {
    protected float posX, posY, sizeX, sizeY;
    protected int colour;
    protected Sprite sprite;
    private ArrayList<GameComponent> components;

    public GameObject() {
        components = new ArrayList<GameComponent>();
    }

    public void render(RenderingEngine renderingEngine) {
        for (GameComponent component : components) {
            component.render(renderingEngine);
        }
    }

    public void update(Input input, float delta) {
        for (GameComponent component : components) {
            component.update(input, delta);
        }
    }

    public void addComponent(GameComponent gameComponent) {
        gameComponent.setGameObject(this);
        gameComponent.onAdd();
        components.add(gameComponent);
    }

    public float getX() {
        return posX;
    }

    public void setX(int posX) {
        this.posX = posX;
    }

    public float getY() {
        return posY;
    }

    public void setY(int posY) {
        this.posY = posY;
    }

    public float getSX() {
        return sizeX;
    }

    public void setSX(int sizeX) {
        this.sizeX = sizeX;
    }

    public float getSY() {
        return sizeY;
    }

    public void setSY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
