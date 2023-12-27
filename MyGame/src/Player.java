import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private int speed = 5;
    private boolean upPressed, downPressed, leftPressed, rightPressed;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (upPressed) y -= speed;
        if (downPressed) y += speed;
        if (leftPressed) x -= speed;
        if (rightPressed) x += speed;
    }

    public void render(Graphics g) {
        g.fillRect(x, y, 32, 32); // Prosta reprezentacja gracza jako kwadrat
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // lub VK_UP dla strzałki w górę
                upPressed = true;
                break;
            case KeyEvent.VK_S: // lub VK_DOWN dla strzałki w dół
                downPressed = true;
                break;
            case KeyEvent.VK_A: // lub VK_LEFT dla strzałki w lewo
                leftPressed = true;
                break;
            case KeyEvent.VK_D: // lub VK_RIGHT dla strzałki w prawo
                rightPressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // lub VK_UP dla strzałki w górę
                upPressed = false;
                break;
            case KeyEvent.VK_S: // lub VK_DOWN dla strzałki w dół
                downPressed = false;
                break;
            case KeyEvent.VK_A: // lub VK_LEFT dla strzałki w lewo
                leftPressed = false;
                break;
            case KeyEvent.VK_D: // lub VK_RIGHT dla strzałki w prawo
                rightPressed = false;
                break;
        }
    }
}
