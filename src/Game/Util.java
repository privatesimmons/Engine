package Game;

import GameObjects.GameObject;

/**
 * Created by damien on 2014/08/31.
 */
public class Util
{
    public static boolean Intersects(GameObject go1, GameObject go2)
    {
        return go1.getX() < (go2.getX() + go2.getSX()) && (go1.getX() + go1.getSX()) > go2.getX() &&
                go1.getY() < (go2.getY() + go2.getSY()) && (go1.getY() + go1.getSY()) > go2.getY();
    }
}
