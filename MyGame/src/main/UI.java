package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";

    public UI(GamePanel gp){
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        Key key = new Key();
        keyImage = key.image;
    }

    public void showMessage(String text){

        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2){

        g2.setFont(arial_40);
        g2.setColor(Color.darkGray);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("  : " + gp.player.hasKey, 60 ,60);
        g2.drawString("Speed: "+ gp.player.speed, 550, 60);

        //TEXT MSG
        if (messageOn == true){

            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize * 3, gp.tileSize * 4);
        }

    }

}
