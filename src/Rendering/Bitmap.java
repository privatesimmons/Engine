package Rendering;

import java.util.Arrays;

/**
 * Created by damien on 2014/08/27.
 */
public class Bitmap {
    @SuppressWarnings(value = "colours")
    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int BLACK = 0xFF000000;
    public static final int GREY = 0xFF808080;
    public static final int YELLOW = 0xFFFFFF00;
    public static final int CYAN = 0xFF00FFFF;
    public static final int PINK = 0xFFFF00FF;
    public static final int TRANS = 0xFFFEFEFE;
    public static final int PURPLE = 0xFF800080;

    protected int width;
    protected int height;
    protected int[] pixels;

    public Bitmap() {

    }

    public Bitmap(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void drawPixel(int x, int y, byte a, byte r, byte g, byte b) {

        drawPixel(x, y, createPixel(a, r, g, b));
    }

    public void fill(int colour) {
        Arrays.fill(pixels, colour);
    }

    public void fill(byte a, byte r, byte g, byte b) {
        Arrays.fill(pixels, createPixel(a, r, g, b));
    }

    public void drawPixel(int x, int y, int colour) {
        if (x > width || y >= height || x < 0 || y < 0) {
            return;
        }
        pixels[x + y * width] = colour;

    }

    public int createPixel(int a, int r, int g, int b) {
        int a1 = a << 24;
        int r1 = r << 16;
        int g1 = g << 8;
        int b1 = b;
        return a1 + r1 + g1 + b1;
    }

    public int getPixel(int x, int y) {
        return pixels[x + y * width];
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public void drawRect(int x, int y, int sx, int sy, int colour) {

        for (int j = y; j <= (y + sy); j++) {
            for (int i = x; i <= (x + sx); i++) {
                drawPixel(i, j, colour);
            }
        }
    }

    //TODO : add variable sprite draw size thing
    public void drawSprite(int x, int y, Sprite sprite) {
        for (int j = y; j < (y + sprite.getHeight()); j++) {
            for (int i = x; i < (x + sprite.getWidth()); i++) {
                if (!(sprite.getPixel(i - x, j - y) == Bitmap.TRANS)) {
                    drawPixel(i, j, sprite.getPixel(i - x, j - y));
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
