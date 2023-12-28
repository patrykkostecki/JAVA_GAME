package main;

import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {
        GamePanel panel = new GamePanel();
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("GOTY 2025");
        panel.startGameThread();



    }

    public static void main(String[] args) {
        new Game();
        System.out.println("Gra uruchomiona");
    }
}
