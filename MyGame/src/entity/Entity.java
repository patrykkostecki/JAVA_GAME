package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX = 0;
    public int worldY = 0;
    public int speed = 0;
    public BufferedImage up1, up2,up3,up4, down1, down2, down3, down4, left1, left2,left3, left4, right1, right2,right3, right4, standing1, standing2, standing3, standing4;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean colissionOn = false;
}
