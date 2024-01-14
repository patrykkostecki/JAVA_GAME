package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Karol extends Entity{

    private String dialogues[] = new String[4];

    public NPC_Karol(GamePanel gp){

        super(gp);

        direction = "standing";
        speed = 1;

        getNPCImage();
        setDialogue();

    }

    public void getNPCImage(){

        try{

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Karol/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Karol/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Karol/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Karol/stanie3.png")));


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

    }

    public void setAction(){

        actionLockCounter ++;

        if (actionLockCounter == 120){
            Random random = new Random();
            //int i = random.nextInt(100) + 1;
            int i = 101;

            if (i <= 25){
                direction = "up";
            } else if (i > 25 && i <= 50){
                direction = "down";
            } else if (i > 50 && i <= 75){
                direction = "left";
            } else if (i > 75 && i <= 100){
                direction = "right";
            } else if (i == 101){
                direction = "standing";
            }
        }
        actionLockCounter = 0;
    }

    public void setDialogue() {
        dialogues[0] = "";
        dialogues[1] = "ESSA wiadomość";
        dialogues[2] = "WSSA wiadomość";
        dialogues[3] = "WSSA w2iadomość";
    }



    public void speak() {
        System.out.println("Dialog [" + currentDialogueIndex + "]: " + dialogues[currentDialogueIndex]);
        currentDialogueIndex++;
        System.out.println(dialogues.length);

        if (currentDialogueIndex < dialogues.length){
            gp.ui.correntDialogue = dialogues[currentDialogueIndex];
        } else{
            gp.gameState = gp.playState;
            currentDialogueIndex = 0;
        }
    }

}

