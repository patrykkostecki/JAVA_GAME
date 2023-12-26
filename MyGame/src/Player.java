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
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
        }
    }
}
