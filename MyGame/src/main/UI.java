package main;

import entity.NPC_Dendzik;
import object.Key;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {

    NPC_Dendzik npc;
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String correntDialogue = "";
    public int commandNum = 0;
    public int titleScreenState = 0;


    public UI(GamePanel gp){
        this.gp = gp;

        arial_80 = new Font("Arial", Font.PLAIN, 80);
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        Key key = new Key();
        keyImage = key.image;
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

                g2.setFont(arial_40);
                g2.setColor(Color.darkGray);
                g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
                g2.drawString("  : " + gp.player.hasKey, 60 ,60);
                g2.drawString("Speed: "+ gp.player.speed, 550, 60);

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
        }

        // DIALOGUE STATE
        if (gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }
    }

    public void drawMenuScreen(){

        if (titleScreenState == 0){
            // BACKGROUND
            g2.setColor(Color.darkGray);
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

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

            // IMAGE
//        x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
//        y += gp.tileSize * 2;
//        g2.drawImage(npc.standing1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

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

    public int centerX(String text){
        int textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - textLenght/2;
        return x;
    }

}
