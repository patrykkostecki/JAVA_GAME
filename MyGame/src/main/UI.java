package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
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

        if (gameFinished == true){

            g2.setFont(arial_40);
            g2.setColor(Color.darkGray);

            String text;
            int textLenght;
            int x;
            int y;

            text = "Udało Ci się uzyskać 5 z projektu!";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - 200;
            y = gp.screenHeight/2 - (gp.tileSize * 3);
            g2.drawString(text, x, y);

            g2.setFont(arial_80);
            g2.setColor(Color.green);
            text = "KONIEC";
            textLenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - 10;
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
                g2.drawString(message, gp.tileSize * 4, gp.tileSize * 5);

                messageCounter ++;

                if(messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }


    }

}
