package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Dendzik extends Entity{

    public NPC_Dendzik(GamePanel gp){

        super(gp);

        direction = "down";
        speed = 1;

        getNPCImage();
        speak();
        setDialogue();
        setAction();

    }

    public void getNPCImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Dendzik/prawo3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Dendzik/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Dendzik/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Dendzik/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Dendzik/stanie3.png")));

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

        dialogues[0] = "";
        dialogues[1] = "";
        dialogues[2] = "";
        dialogues[3] = "";

    }

    public void speak(){

        if (dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }
        gp.ui.correntDialogue = dialogues[dialogueIndex];
        dialogueIndex ++;

    }

}
