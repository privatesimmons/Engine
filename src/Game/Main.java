package Game;


public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
     game = new Game();
     long start, end ;
     int delta;
     delta = 0;

     while (game.getRunning())
     {
         start = System.nanoTime();
         game.update(delta);
         game.render();
         end = System.nanoTime();
         delta = (int)((end - start)/ 1000000.0);
         System.out.println(((end - start)/ 1000000.0));
     }
    }
}
