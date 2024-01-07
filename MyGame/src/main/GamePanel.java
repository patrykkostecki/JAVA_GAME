package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.Tile;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //USTWAIENIA ERKANU
    final int originalTitleSize = 16; // 16 x 16 tile
    final int scale = 3;
    public final int tileSize = originalTitleSize * scale; // 48 x 48 tile
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol; //768
    public final int screenHeight = tileSize * maxScreenRow; //576

    //USTAWIENIA MAPY
    public final int maxWorldCol = 73;
    public final int maxWorldRow = 97;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // SYSTEM
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public ColissionChecker ck = new ColissionChecker(this);
    public Sound sound = new Sound();
    public UI ui = new UI(this);
    public AssetSetter ac = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    TileManager tileM = new TileManager(this);

    // PLAYER AND OBJECTS
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];

    // GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int stopState = 2;
    public final int dialogueState = 3;
    public final int menuState = 4;


    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        ac.setObject();
        ac.setNPC();
        gameState = menuState;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {

        while (gameThread != null){

            int FPS = 60;
            double drawInterval = 1000000000/FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int drawCount = 0;

            while(gameThread != null) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if(delta >= 1) {
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }

            if (timer >= 1000000000){
                // System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
            }
        }
    }

    public void update(){

        if(gameState == playState){
            // PLAYER
            player.update();

            // NPC
            for (int i=0; i<npc.length;i++){
                if(npc[i] != null){
                        npc[i].update();
                }
            }

        }
        if(gameState == stopState){

        }



    }

    public void paintComponent(Graphics g){
         super.paintComponent(g);

         Graphics2D g2 = (Graphics2D)g;
//         //Włączenie antyaliasingu
//        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // MENU
        if (gameState == menuState){

            ui.draw(g2);

        } else{
            // TILE
            tileM.draw(g2);

            // OBJECTS
            for(int i=0; i<obj.length; i++){
                if(obj[i] != null){
                    obj[i].draw(g2, this);
                }
            }

            // EVENTS


            // PLAYER
            player.draw(g2);

            // NPC
            for (int i=0; i < npc.length; i++){
                if (npc[i] != null){
                    npc[i].draw(g2);
                }
            }

            // INTERFACE
            ui.draw(g2);
        }



        g2.dispose();
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.stop();
        sound.loop();
    }
    public void stopMusic(){
        sound.stop();
    }

    public void playSoundEffect(int i){
        sound.setFile(i);
        sound.play();
    }
}

