import java.awt.Graphics;

public class World {
    private Tile[][] tiles;

    public World() {
        // Inicjalizacja świata z przykładowymi płytkami
        tiles = new Tile[10][10];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(i * 32, j * 32);
            }
        }
    }

    public void render(Graphics g) {
        // Rysowanie płytek
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.render(g);
            }
        }
    }
}
