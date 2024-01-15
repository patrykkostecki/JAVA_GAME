package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;


public class NPC_Wozna extends Entity{

    private String dialogues[] = new String[5];
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
        dialogues[1] = "Jesteś! Przysięgam, każdy dzień wydaje się tu wiecznością\n" +
                "Ta sytuacja jest nie do wytrzymania ludzie,\n" +
                "którzy znamy, teraz. teraz. nie mogę nawet\n" +
                "wypowiedzieć tego słowa. Niebezpieczeństwo czyha\n" +
                "na każdym kroku, a nasze zasoby są na wyczerpaniu.\n";
        dialogues[2] = "Amunicja się kończy, podobnie jak jedzenie.\n" +
                "Te stwory... one były kiedyś naszymi przyjaciółmi,\n" +
                "Ale teraz są bezwzględne, nie do poznania.\n" +
                "Musimy działać, zanim będzie za późno.\n";
        dialogues[3] = "(Woźna wyciąga klucz z kieszeni i podaje go z drżącą ręką.)\n";
        dialogues[4] ="Wejdź przez boczne drzwi które są przed tobą i jak najszybciej\n" +
                " znajdz profesora Dendzika.\n" +
                "To on tutaj wszystkim zarządza i na pewno przyda \n" +
                " mu się kolejna para rąk do pracy.“";

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
