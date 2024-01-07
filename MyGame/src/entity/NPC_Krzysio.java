package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Krzysio extends Entity{

    public NPC_Krzysio(GamePanel gp){

        super(gp);

        direction = "standing";
        speed = 1;

        getNPCImage();
        setDialogue();

    }

    public void getNPCImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Krzysio/prawo3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Krzysio/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Krzysio/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Krzysio/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Krzysio/stanie3.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setAction(){

        actionLockCounter ++;

        if (actionLockCounter == 90){
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

    public void setDialogue(){

        dialogues[0] = "Daj 5 Dendzior pls";

    }

    public void speak(){

        gp.ui.correntDialogue = dialogues[0];

    }

}
