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

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        setDefaultValues();
        getPlayerImage();

        solidArea = new Rectangle(8, 16, 48, 48);
    }

    public void setDefaultValues(){
         worldX = 1125;
         worldY = -10;
         speed = 4;
         direction = "down";
    }

    public void getPlayerImage(){

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/TYŁ_0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/TYŁ_1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/TYŁ_2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/TYŁ_3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/PRZÓD_0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/PRZÓD_1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/PRZÓD_2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/PRZÓD_3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/LEWO_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/LEWO_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/LEWO_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/LEWO_4.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/PRAWO_0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/PRAWO_1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/PRAWO_2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/PRAWO_3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/STANIE_0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/STANIE_1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/STANIE_2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/STANIE_3.png")));



        } catch(IOException e){
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

        //SPRAWDZANIE KOLIZJI
        colissionOn = false;
        gp.ck.checkTile(this);

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

        g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);
    }
    }



