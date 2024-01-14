package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Kasia extends Entity{

    private String dialogues[] = new String[2];

    public NPC_Kasia(GamePanel gp){

        super(gp);

        direction = "standing";
        speed = 1;
        foundTube = false;

        getNPCImage();
        setDialogue();

    }

    public void getNPCImage(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/tyl0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/tyl1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/tyl2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/tyl3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/przod0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/przod1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/przod2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/przod3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/lewo0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/lewo1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/lewo2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/lewo3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/prawo0.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/prawo1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/prawo2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/Kasia/prawo3.png"));

            standing1 = ImageIO.read((getClass().getResourceAsStream("/player/Kasia/stanie0.png")));
            standing2 = ImageIO.read((getClass().getResourceAsStream("/player/Kasia/stanie1.png")));
            standing3 = ImageIO.read((getClass().getResourceAsStream("/player/Kasia/stanie2.png")));
            standing4 = ImageIO.read((getClass().getResourceAsStream("/player/Kasia/stanie3.png")));

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
        dialogues[1] = "We no ogarnij mi 3 probowki";
        if (gp.player.tube == 3){
            dialogues = new String[2];
            dialogues[0] = "";
            dialogues[1] = "Dziękuję za te 3 probówki, bez ciebie by sie to nie udalo!";
            if (currentDialogueIndex > 0){
                foundTube = true;
                gp.player.tube = 0;
                System.out.println(gp.player.tube);
                currentDialogueIndex = 0;
            }
        }
        if (foundTube == true){
            dialogues = new String[2];
            dialogues[0] = "";
            dialogues[1] = "Teraz mozesz zrobic to i tamto";
        }
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
