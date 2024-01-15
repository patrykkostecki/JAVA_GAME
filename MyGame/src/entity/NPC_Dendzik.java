package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Dendzik extends Entity{

    private String dialogues[] = new String[8];
    public NPC_Dendzik(GamePanel gp){

        super(gp);

        direction = "standing";
        speed = 1;

        getNPCImage();
        setDialogue();

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

    public void setDialogue() {
        dialogues[0] = "";
        dialogues[1] = "Jak się cieszę, że żyjesz! Od twojego\n" +
                " ostatniego pobytu tutaj, wiele się zmieniło.\n" +
                " To miejsce z tętniącej życiem uczelni stało się\n" +
                " areną naszej walki o przetrwanie";
        dialogues[2] = "(krótki moment milczenia, w którym profesor wydaje się zbierać myśli)";
        dialogues[3] = "Wirus, który miał być naukowym przełomem,\n" +
                " wymknął się spod kontroli. Co gorsza, mutuje z \n" +
                "niezwykłą szybkością, tworząc formy, które są agresywne\n" +
                " i nieprzewidywalne. Jesteśmy pod ostrzałem nie tylko biologicznym\n" +
                ", ale i moralnym. Musimy znaleźć sposób, by to powstrzymać, zanim \n" +
                "będzie za późno dla nas wszystkich.";
        dialogues[4] ="(Profesor spogląda w kierunku drzwi obok)";
        dialogues[5] = "Obok, w gabinecie po prawej stronie,\n" +
                " jest Profesor Schmidt. Jest ona kluczową postacią\n" +
                " w naszych badaniach nad wirusem. Niezwykle utalentowana\n" +
                " i zdeterminowana osoba, ale obecnie znalazła się";
        dialogues[6] ="w sytuacji krytycznej. Potrzebuje pomocy – zarówno w zakresie\n" +
                " badań, jak i fizycznej ochrony. Zainfekowani są wszędzie, a jej \n" +
                "praca jest niezwykle cenna dla naszych szans na \n" +
                "powstrzymanie tego chaosu.";
        dialogues[7] = "Proszę, udaj się do niej natychmiast.\n" +
                " Każda sekunda jest cenna. I bądź ostrożny.\n" +
                " Nie wiemy, co jeszcze może się wydarzyć.";

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
