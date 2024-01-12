package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;


public class NPC_Wozna extends Entity{

    private String dialogues[] = new String[3];
    private boolean giveKey;

    public NPC_Wozna(GamePanel gp){

        super(gp);

        direction = "standing";
        speed = 1;
        giveKey = true;

        getNPCImage();
        setDialogue();
    }

    public void getNPCImage(){

        try{
            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Wozna/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Wozna/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Wozna/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Wozna/stanie3.png")));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

    }

    public void setAction(){

        actionLockCounter ++;

        if (actionLockCounter == 90){
            Random random = new Random();
//            int i = random.nextInt(100) + 1;
            int i = 101;

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

    public void setDialogue() {
        dialogues[0] = "";
        dialogues[1] = "Pierwsza wiadomość";
        dialogues[2] = "Druga wiadomość";
    }



    public void speak() {
        System.out.println("Dialog [" + currentDialogueIndex + "]: " + dialogues[currentDialogueIndex]);
        currentDialogueIndex++;
        System.out.println(dialogues.length);

        if (currentDialogueIndex < dialogues.length){
            gp.ui.correntDialogue = dialogues[currentDialogueIndex];
        } else{
            gp.gameState = gp.playState;
            if (giveKey == true){
                gp.player.hasKey += 1;
                giveKey = false;
            }
            currentDialogueIndex = 0;
        }
    }


}
