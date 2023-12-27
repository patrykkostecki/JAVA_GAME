import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {
        GamePanel panel = new GamePanel();
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Game();
        System.out.println("Gra uruchomiona");
    }
}
