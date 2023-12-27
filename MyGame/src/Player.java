import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private int speed = 5;
    private BufferedImage playerImage;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        // Załaduj obrazek gracza
        try {
            playerImage = ImageIO.read(getClass().getResourceAsStream("/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
            // Jeśli obrazek nie zostanie znaleziony, wyświetl komunikat i zakończ program
            System.err.println("Nie można wczytać obrazka gracza.");
            System.exit(1);
        }
    }

    public void update() {
        // Logika aktualizacji pozycji gracza
        if (upPressed) y -= speed;
        if (downPressed) y += speed;
        if (leftPressed) x -= speed;
        if (rightPressed) x += speed;
    }

    public void render(Graphics g) {
        // Rysowanie gracza jako obrazka
        g.drawImage(playerImage, x, y, null);
    }

    public void keyPressed(KeyEvent e) {
        // Obsługa wciśnięcia klawisza
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        // Obsługa zwolnienia klawisza
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_A:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
        }
    }
}
