import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private boolean running = true;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        player = new Player(400, 300);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        startGameLoop();
    }

    private void startGameLoop() {
        Thread gameThread = new Thread(() -> {
            final int FPS = 60;
            final long targetTime = 1000 / FPS;

            while (running) {
                long startTime = System.nanoTime();
                update();
                repaint();
                long timeTaken = (System.nanoTime() - startTime) / 1000000;
                long timeLeft = targetTime - timeTaken;
                if (timeLeft < 0) timeLeft = 5;

                try {
                    Thread.sleep(timeLeft);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        gameThread.start();
    }

    public void update() {
        player.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.render(g);
    }

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
}
