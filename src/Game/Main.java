package Game;


public class Main
{
    private static Game game;
    private static int frames = 0;


    public static void main(String[] args)
    {
     game = new Game();
     long start, end, endupdate, endrender ;

     int delta;
     delta = 0;

     while (game.getRunning())
     {
         start = System.nanoTime();

         game.update(delta);

         endupdate = System.nanoTime();

         game.render();

         endrender = System.nanoTime();

         end = System.nanoTime();
         delta = (int)((end - start)/ 1000000.0);
         frames++;
         if (frames % 50 == 0)
         {
             System.out.println("update time : " + ((endupdate - start) / 1000000.0));
             System.out.println("render time : " + ((endrender - endupdate) / 1000000.0));
             System.out.println("total time : " + ((end - start) / 1000000.0));
             System.out.println("Frames : " + frames);
             System.out.println("");
         }
     }
    }

    public static int getFrames() {return frames;}
}
