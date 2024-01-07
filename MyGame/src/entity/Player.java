package entity;

import main.Game;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{


    private int originalWidth;
    private int originalHeight;
    private int scaledWidth;
    private int scaledHeight;

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public int skin = 1;

    public Player(GamePanel gp, KeyHandler keyH){


        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        setDefaultValues();

        solidArea = new Rectangle();
        solidArea.x = 24;
        solidArea.y = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 48;
        solidArea.height = 48;
    }

    public void setDefaultValues(){
         worldX = 1650;
         worldY = 450;
         speed = 20;
         direction = "down";
         maxLife = 6;
         life = 6;
    }

    public void getPlayerImage(){
        try {
            String skinPath = "/player/";
            switch (skin) {
                case 1: skinPath += "Leokadia/"; break;
                case 2: skinPath += "Patryk/"; break;
                case 3: skinPath += "Szymon/"; break;
                default: return;
            }
            System.out.println(skin);

            up1 = ImageIO.read(getClass().getResourceAsStream(skinPath + "tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(skinPath + "tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream(skinPath + "tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream(skinPath + "tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream(skinPath + "przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(skinPath + "przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream(skinPath + "przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream(skinPath + "przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream(skinPath + "lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(skinPath + "lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream(skinPath + "lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream(skinPath + "lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream(skinPath + "prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(skinPath + "prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream(skinPath + "prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream(skinPath + "prawo3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream(skinPath + "stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream(skinPath + "stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream(skinPath + "stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream(skinPath + "stanie3.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        if (keyH.upPressed) {
            direction = "up";

        } else if (keyH.downPressed) {
            direction = "down";

        } else if (keyH.leftPressed) {
            direction = "left";

        } else if (keyH.rightPressed) {
            direction = "right";

        } else {
            direction = "standing";
        }

        // SPRAWDZANIE KOLIZJI TILE
        colissionOn = false;
        gp.ck.checkTile(this);

        // SPRAWDZANIE KOLIZJI OBIEKTU
        int ojbIndex = gp.ck.checkObjtect(this, true);
        pickUpObject(ojbIndex);

        // SPRAWDZANIE KOLIZJI NPC
        int npcIndex = gp.ck.checkEntity(this,gp.npc);
        interactNPC(npcIndex);

        // SPRAWDZANIE EVENTU
        gp.eHandler.checkEvent();
        gp.keyH.spacePressed = false;

        // SPRAWDZANIE KOLIZJI GRACZA
        if(colissionOn == false){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;

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
    }

    public void interactNPC(int i){

        if (i != 999){

            if (gp.keyH.spacePressed == true)
            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();

        }



    }

    public void pickUpObject(int i){

        if (i != 999){
            String objectName = gp.obj[i].name;

            switch (objectName){
                case "Key":
                    hasKey ++;
                    gp.obj[i] = null;
                    gp.playSoundEffect(1);
                    System.out.println(hasKey);
                    break;
                case "Door":
                    if (hasKey > 0){
                        gp.obj[i] = null;
                        hasKey --;
                        gp.playSoundEffect(2);
                        System.out.println(hasKey);
                    } else{
                        gp.ui.showMessage("Potrzebujesz klucza!");
                    }
                    break;
                case "Desk":
                    gp.ui.showMessage("Porwano DENDZIORA!");
                    break;
                case "EatAutomat":
                    gp.player.speed = 6;
                    gp.ui.showMessage("Speed up!");
                    //gp.obj[i] = null;
                    break;
                case "Finish":
                    gp.ui.gameFinished = true;
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                } else if (spriteNumber == 2) {
                    image = up2;
                } else if (spriteNumber == 3) {
                    image = up3;
                } else if (spriteNumber == 4) {
                    image = up4;
                }
                break;

            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                } else if (spriteNumber == 2) {
                    image = down2;
                } else if (spriteNumber == 3) {
                    image = down3;
                } else if (spriteNumber == 4) {
                    image = down4;
                }
                break;

            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                } else if (spriteNumber == 2) {
                    image = left2;
                } else if (spriteNumber == 3) {
                    image = left3;
                } else if (spriteNumber == 4) {
                    image = left4;
                }
                break;

            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                } else if (spriteNumber == 2) {
                    image = right2;
                } else if (spriteNumber == 3) {
                    image = right3;
                } else if (spriteNumber == 4) {
                    image = right4;
                }
                break;

            case "standing":
                if (spriteNumber == 1) {
                    image = standing1;
                } else if (spriteNumber == 2) {
                    image = standing2;
                } else if (spriteNumber == 3) {
                    image = standing3;
                } else if (spriteNumber == 4) {
                    image = standing4;
                }
                break;

        }

        int x = screenX;
        int y = screenY;

        if(screenX > worldX){
            x = worldX;
        }

        if(screenY > worldY){
            y = worldY;
        }

        int rightStop = gp.screenWidth - screenX;
        if(rightStop > gp.worldWidth - worldX){
            x = gp.screenWidth - (gp.worldWidth - worldX);
        }

        int bottomStop = gp.screenHeight - screenY;
        if(bottomStop > gp.worldHeight - worldY){
            y = gp.screenHeight - (gp.worldHeight - worldY);
        }

        g2.drawImage(image, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
    }
    }



