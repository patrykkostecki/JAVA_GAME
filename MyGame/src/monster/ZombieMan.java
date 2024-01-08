package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class ZombieMan extends Entity {

    public ZombieMan(GamePanel gp){
        super(gp);

        direction = "down";
        name = "ZombieMan";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        type = 2;

        solidArea.x = 10;
        solidArea.y = 1;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Zoombie_Man/prawo3.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setAction(){

        actionLockCounter ++;

        if (actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25){
                direction = "up";
            } else if (i > 25 && i <= 50){
                direction = "down";
            } else if (i > 50 && i <= 75){
                direction = "left";
            } else if (i > 75 && i <= 100){
                direction = "right";
//            } else if (i == 101){
//                direction = "standing";
            }
            actionLockCounter = 0;
        }

    }

}
