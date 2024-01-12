package main;

import entity.Entity;
import entity.Player;
import object.Bullet;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //USTWAIENIA ERKANU
    final int originalTitleSize = 16; // 16 x 16 tile
    final int scale = 3;
    public final int tileSize = originalTitleSize * scale; // 48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768
    public final int screenHeight = tileSize * maxScreenRow; //576

    //USTAWIENIA MAPY
    public final int maxWorldCol = 71;
    public final int maxWorldRow = 97;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    // SYSTEM
    public KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public ColissionChecker ck = new ColissionChecker(this);
    public Sound sound = new Sound();
    public Sound2 sound2 = new Sound2();
    public UI ui = new UI(this);
    public AssetSetter ac = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    TileManager tileM = new TileManager(this);

    // PLAYER AND OBJECTS NAD MONSTERS
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[50];
    public Entity npc[] = new Entity[30];
    public Entity monster[] = new Entity[100];

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
        ac.setMonster();
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
        ui.musicMenu();

        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].update();
                if (gameState == dialogueState) {
                    npc[i].updateDialogue();
                }
            }
        }

        if(gameState == playState){
            // PLAYER
            player.update();

            // BULLETS
            for (int i = 0; i < player.maxBullets; i++) {
                Bullet bullet = player.bullets[i];
                if (bullet != null) {
                    bullet.update();
                    bullet.checkCollisionWithMonsters(monster);
                }
            }

            // NPC
            for (int i=0; i<npc.length;i++){
                if (npc[i] != null){
                    npc[i].update();
                }
            }
            for (int i=0; i<monster.length; i++){
                if (monster[i] != null){
                    if (monster[i].alive == true && monster[i].dying == false){
                        monster[i].update();
                    }
                    if (monster[i].alive == false){
                        monster[i] = null;
                    }
                }
            }

        }
        else if(gameState == stopState){

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

            // MONSTERS
            for (int i=0; i < monster.length; i++){
                if (monster[i] != null){
                    monster[i].draw(g2);
                }
            }

            // PLAYER
            player.draw(g2);

            // BULLETS
            for (int i = 0; i < player.maxBullets; i++) {
                if (player.bullets[i] != null) {
                    player.bullets[i].draw(g2);
                }
            }

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
        sound.play();
        sound.loop();
    }
    public void playMusic2(int i){
        sound2.setFile(i);
        sound2.play();
        sound2.loop();
    }
    public void stopMusic()
    {
        sound.stop();
    }
    public void stopMusic2()
    {
        sound2.stop();
    }

    public void playSoundEffect(int i){
        sound.setFile(i);
        sound.play();
    }

    public void playSoundEffect2(int i){
        sound2.setFile(i);
        sound2.play();
    }
}

