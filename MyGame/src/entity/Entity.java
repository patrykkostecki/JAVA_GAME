package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    GamePanel gp;
    public int worldX = 0;
    public int worldY = 0;
    public int speed = 0;
    public BufferedImage up1, up2, up3, up4, down1, down2, down3, down4, left1, left2, left3, left4, right1, right2, right3, right4, standing1, standing2, standing3, standing4;
    public BufferedImage attackl, attackp, attackpr, attackt;
    public boolean attacking = false;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0,0,0,0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean colissionOn = false;
    public int actionLockCounter = 0;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public String dialogues[] = new String[20];
    int dialogueIndex = 0;
    public int type; // 0 - player, 1 - npc, 2 - monster

    // STATUS BOHATERA
    public int maxLife;
    public int life;
    public String name;


    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction(){

    }

    public void speak(){

    }

    public void update(){

        setAction();

        colissionOn = false;
        gp.ck.checkTile(this);
        gp.ck.checkObjtect(this, false);
        gp.ck.checkEntity(this, gp.npc);
        gp.ck.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.ck.checkPlayer(this);

        if (this.type == 2 && contactPlayer == true){
            if (gp.player.invincible == false){
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }

        if(colissionOn == false){
            switch(direction){
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;

            }
        }

        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNumber++;
            if (spriteNumber > 4) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }

        if (invincible == true){
            invincibleCounter ++;
            if (invincibleCounter > 40){
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }



    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNumber == 1) { image = up1;
                    } else if (spriteNumber == 2) { image = up2;
                    } else if (spriteNumber == 3) { image = up3;
                    } else if (spriteNumber == 4) { image = up4;} break;

                case "down":
                    if (spriteNumber == 1) { image = down1;
                    } else if (spriteNumber == 2) { image = down2;
                    } else if (spriteNumber == 3) { image = down3;
                    } else if (spriteNumber == 4) { image = down4;} break;

                case "left":
                    if (spriteNumber == 1) { image = left1;
                    } else if (spriteNumber == 2) { image = left2;
                    } else if (spriteNumber == 3) { image = left3;
                    } else if (spriteNumber == 4) { image = left4;} break;

                case "right":
                    if (spriteNumber == 1) { image = right1;
                    } else if (spriteNumber == 2) { image = right2;
                    } else if (spriteNumber == 3) { image = right3;
                    } else if (spriteNumber == 4) { image = right4; } break;

                case "standing":
                    if (spriteNumber == 1) { image = standing1;
                    } else if (spriteNumber == 2) { image = standing2;
                    } else if (spriteNumber == 3) { image = standing3;
                    } else if (spriteNumber == 4) { image = standing4; } break;
            }

            if (invincible == true){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }

            g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        }

    }
}
