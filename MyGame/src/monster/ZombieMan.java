package monster;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ZombieMan extends Entity {

    public ZombieMan(GamePanel gp){
        super(gp);

        name = "ZombieMan";
        speed = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 5;
        solidArea.y = 1;
        solidArea.width = 32;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Zombie_Man/tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Bubi/prawo3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Bubi/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Bubi/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Bubi/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Bubi/stanie3.png")));

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
