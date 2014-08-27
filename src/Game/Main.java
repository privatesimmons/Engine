package Game;

/**
 * Created by Damien on 24/8/2014.
 */
public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
     game = new Game();
     while (true)
     {
         game.render();
     }
    }
}
