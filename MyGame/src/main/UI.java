package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

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
