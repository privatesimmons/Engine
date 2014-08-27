package Game;


public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
     game = new Game();
     while (game.getRunning())
     {
         long start = System.nanoTime();
         game.render();
         long end = System.nanoTime();
         System.out.println(((end - start)/ 1000000.0));
     }
    }
}
