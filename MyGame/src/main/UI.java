package main;

import entity.NPC_Dendzik;
import object.Heart;
import object.Key;
import object.Logo;
import object.SuperObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {

    public boolean musicPlayed = false;


    NPC_Dendzik npc;
    GamePanel gp;
    Graphics2D g2;
    Font arial_20, arial_40, arial_80;
    BufferedImage keyImage;
    BufferedImage heart_full, heart_half, heart_blank;
    BufferedImage mainLogo;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String correntDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0;
    public int howLong = 120;



    public UI(GamePanel gp){
        loadBackgrounds();
        this.gp = gp;

        arial_80 = new Font("Arial", Font.PLAIN, 80);
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        Key key = new Key();
        keyImage = key.image;

        // HUD
        SuperObject heart = new Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;

        // LOGO
        SuperObject logo = new Logo(gp);
        mainLogo = logo.image;

    }

    public void showShortMessage(String text){

        message = text;
        if (howLong > 0){
            messageOn = true;
            howLong--;
//            System.out.println(howLong);
        } else{
            messageOn = false;
        }
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2){

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        // MENU STATE
        if (gp.gameState == gp.menuState){

            drawMenuScreen();

        }

        // PLAY STATE
        if (gp.gameState == gp.playState){

            drawPlayerLife();

            if (gameFinished == true){

                g2.setFont(arial_40);
                g2.setColor(Color.darkGray);

                String text;
                int textLenght;
                int x;
                int y;

                text = "Udało Ci się uzyskać 5 z projektu!";
                x = centerX(text);
                y = gp.screenHeight/2 - (gp.tileSize * 3);
                g2.drawString(text, x, y);

                g2.setFont(arial_80);
                g2.setColor(Color.green);
                text = "KONIEC";
                x = centerX(text);
                y = gp.screenHeight/2 + (gp.tileSize * 2);
                g2.drawString(text, x, y);

                gp.gameThread = null;




            } else{

                g2.setFont(arial_20);
                g2.setColor(Color.black);
                g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2 + 470, gp.tileSize, gp.tileSize, null);
                drawStatWindow();
                g2.drawString("  : " + gp.player.hasKey, 60 ,530);
                g2.setColor(Color.green);
                g2.drawString("Level: "+ gp.player.level, 600, 70);
                g2.setColor(Color.white);
                g2.drawString("Attack: "+ gp.player.damage, 600, 100);
                g2.drawString("Speed: "+ gp.player.speed, 600, 130);
                g2.drawString("Ammo: "+ gp.player.ammo, 600, 160);
                g2.drawString("Gold: "+ gp.player.gold, 600, 190);
                g2.setColor(Color.yellow);
                g2.drawString("EXP: "+ gp.player.exp + "/" + gp.player.needExp, 600, 250);
                g2.drawString("X: "+ gp.player.worldX, 50, 150);
                g2.drawString("Y: "+ gp.player.worldY, 50, 170);
                g2.drawString("Col: "+ (int)(gp.player.worldX / gp.tileSize + 1), 50, 200);
                g2.drawString("Row: "+ (int)(gp.player.worldY / gp.tileSize + 2), 50, 230);


                // TEXT MSG
                if (messageOn == true){

                    g2.setFont(g2.getFont().deriveFont(30F));
                    g2.drawString(message, centerX(message), gp.tileSize * 5);

                    messageCounter ++;

                    if(messageCounter > 120){
                        messageCounter = 0;
                        messageOn = false;
                    }
                }
            }
        }

        // PAUSE STAtE
        if (gp.gameState == gp.stopState){
            drawPauseScreen();
            drawPlayerLife();
        }

        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState){
            drawDialogueScreen();
            drawPlayerLife();
        }
    }

    public void drawPlayerLife(){

        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;

        // MAX HP
        while (i < gp.player.maxLife/2){
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        // RESET
        x = gp.tileSize / 2;
        y = gp.tileSize / 2;
        i = 0;

        // AKTUALNE HP
        while (i < gp.player.life){

            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life){
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x+=gp.tileSize;

        }



    }


    //TŁA
    BufferedImage backgroundImg;
    BufferedImage characterSelectBackgroundImg;

    public void loadBackgrounds() {
        try {
            backgroundImg = ImageIO.read(getClass().getResourceAsStream("/tiles/tlo.png"));
            characterSelectBackgroundImg = ImageIO.read(getClass().getResourceAsStream("/tiles/tlo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMenuScreen(){

        if (titleScreenState == 0){

//            // BACKGROUND
//            g2.setColor(Color.darkGray);
//            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            if (backgroundImg != null) {
                g2.drawImage(backgroundImg, 0, 0, gp.screenWidth, gp.screenHeight, null);
            }

            // TEXT
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
            String text = "SMCEBI GAME";
            int x = centerX(text);
            int y = gp.tileSize * 3;
            // SHADOW
            g2.setColor(Color.black);
            g2.drawString(text, x + 5, y + 5);
            // COLOR
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
            y = gp.tileSize * 2;
            g2.drawImage(mainLogo, x - 30, y + 60, gp.tileSize * 3, gp.tileSize * 3, null);

            // MENU
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "NOWA GRA";
            x = centerX(text);
            y += gp.tileSize * 6;
            g2.drawString(text, x, y);
            if (commandNum == 0){
                g2.drawString(">",x-gp.tileSize,y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "WCZYTAJ GRĘ";
            x = centerX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1){
                g2.drawString(">",x-gp.tileSize,y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "WYJDZ Z GRY";
            x = centerX(text);
            y += gp.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2){
                g2.drawString(">",x-gp.tileSize,y);
            }
        } else if (titleScreenState == 1){

            if (characterSelectBackgroundImg != null) {
                g2.drawImage(backgroundImg, 0, 0, gp.screenWidth, gp.screenHeight, null);
            }

            // WYBOR POSTACI
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));

            String text = "WYBIERZ CHOPKA";
            int x = centerX(text);
            int y = gp.tileSize * 3;
            g2.drawString(text,x,y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "LEOKADIA";
            x = centerX(text);
            y += gp.tileSize * 3;
            g2.drawString(text,x,y);
            if (commandNum  == 0){
                g2.drawString(">",x - gp.tileSize,y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "PATRYK";
            x = centerX(text);
            y += gp.tileSize;
            g2.drawString(text,x,y);
            if (commandNum  == 1){
                g2.drawString(">",x - gp.tileSize,y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "SZYMON";
            x = centerX(text);
            y += gp.tileSize;
            g2.drawString(text,x,y);
            if (commandNum  == 2){
                g2.drawString(">",x - gp.tileSize,y);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));
            text = "WROC";
            x = centerX(text);
            y += gp.tileSize * 3;
            g2.drawString(text,x,y);
            if (commandNum  == 3){
                g2.drawString(">",x - gp.tileSize,y);
            }
        } else if (titleScreenState == 3) {
            // INTRODUCION
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 38F));

            String text = "TU SE DAJ TEKST ESSA";
            int x = centerX(text);
            int y = gp.tileSize * 3;
            g2.drawString(text,x,y);
        }
    }

    public void drawPauseScreen(){

        String text = "PAUZA";
        int x = centerX(text);
        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);

    }

    public void drawDialogueScreen(){

        // WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 5;

        drawSubWindow(x,y,width,height);

        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : correntDialogue.split("\n")){
            g2.drawString(line,x,y);
            y += 40;
        }


    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color color = new Color(0,0,0,200);
        g2.setColor(color);
        g2.fillRoundRect(x,y,width,height,35,35);

        color = new Color(255,255,255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y+5, width-10, height-10,25,25);

    }

    public void drawStatWindow(){
        int x = 580;
        int y = 30;
        int width = 140;
        int height = 260;
        Color color = new Color(0,0,0,200);
        g2.setColor(color);
        g2.fillRoundRect(x,y,width,height,35,35);

        color = new Color(255,255,255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 3, y+3, width-10, height-10,25,25);
    }

    public int centerX(String text){
        int textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - textLenght/2;
        return x;
    }

    public void musicMenu() {
        //System.out.println("Aktualny stan gry: " + gp.gameState);

        if (gp.gameState == gp.menuState) {
            if (!musicPlayed) {
                System.out.println("Odtwarzanie muzyki menu");
                gp.playMusic(0);
                musicPlayed = true;
            }
        } else if (gp.gameState == gp.playState) {
            if (musicPlayed) {
                System.out.println("Zatrzymanie muzyki menu i odtwarzanie muzyki gry");
                gp.stopMusic();
                musicPlayed = false;
                gp.playMusic(7);
            }
        } else {
            if (musicPlayed) {
                System.out.println("Zatrzymywanie muzyki");
                gp.stopMusic();
                musicPlayed = false;
            }
        }
    }

}
