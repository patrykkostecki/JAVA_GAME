import java.awt.Graphics;

public class Tile {
    private int x, y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics g) {
        g.fillRect(x, y, 32, 32); // Prosta reprezentacja płytki jako kwadrat
    }
}
