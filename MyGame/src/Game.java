import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    // Wymiary okna gry
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // Zmienne do obsługi logiki gry
    private boolean running = true;
    private Player player;
    private World world;

    public Game() {
        // Konfiguracja okna
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);

        // Inicjalizacja świata i gracza
        player = new Player(WIDTH / 2, HEIGHT / 2);
        world = new World();

        // Pętla gry
        gameLoop();
    }

    public void gameLoop() {
        // Osiągnięcie stabilnej ilości klatek na sekundę (FPS)
        final int FPS = 60;
        final long targetTime = 1000 / FPS;

        while (running) {
            long startTime = System.nanoTime();

            update();
            repaint();

            long timeTaken = (System.nanoTime() - startTime) / 1000000;
            long timeLeft = targetTime - timeTaken;
            if (timeLeft < 0) timeLeft = 0;

            try {
                Thread.sleep(timeLeft);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        // Aktualizacja logiki gry, np. pozycji gracza
        player.update();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Rysowanie świata i gracza
        world.render(g);
        player.render(g);
    }

    // Obsługa klawiatury
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    public static void main(String[] args) {
        new Game();
    }
}
