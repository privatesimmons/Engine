package Game;


public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
     game = new Game();
     long start, end ;
     float delta;
     delta = 0;

     while (game.getRunning())
     {
         start = System.nanoTime();
         game.update(delta);
         game.render();

         try {
             Thread.sleep(0);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         end = System.nanoTime();
         delta = ((end - start)/ 1000000.0f);
         System.out.println(((end - start)/ 1000000.0));
     }
    }
}
