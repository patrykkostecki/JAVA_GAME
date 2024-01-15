package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Kasia extends Entity{

    private String dialogues[] = new String[4];

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
        dialogues[1] = "(nie odrywając wzroku od swojego biurka,\n" +
                " otoczonego przez migające ekrany i skomplikowane\n" +
                " urządzenia) Ah, weszłeś.\n" +
                " Profesor Dendzik przysłał cię, tak";
        dialogues[2] = "(odwracając się, jej twarz odzwierciedla mieszankę\n" +
                " zmęczenia i determinacji) Doskonale.\n" +
                " Pracuję nad rozwiązaniem problemu z wirusem,\n" +
                " wykorzystując do tego sztuczną inteligencję i sieci neuronowe.\n" +
                " Udało nam się osiągnąć znaczny postęp, ale potrzebujemy\n" +
                " więcej danych, aby w pełni zrozumieć mechanizmy działania wirusa\n" +
                " i opracować skuteczne lekarstwo.\n";
        dialogues[3] = "(pauza, w której profesor przegląda swoje notatki)";
//        dialogues[4] = "Niestety, nasze zasoby są ograniczone,\n" +
//                " a sytuacja na zewnątrz... jest daleka od stabilnej.\n" +
//                " Potrzebuję, abyś odzyskał trzy kapsuły z próbkami,\n" +
//                " które zgubiłam na południowej części kampusu. \n" +
//                "Ta strefa jest silnie zainfekowana, więc będzie to ryzykowne.\n" +
//                " Ale te próbki są niezbędne dla naszych badań.";
//        dialogues[5] ="Są dokładnie takie jak ten na moim biurku.\n" +
//                " Znajdziesz je prawdopodobnie w miejscach o największym\n" +
//                " stężeniu zakażenia czyli w południowym skrzydle uczelni.\n" +
//                " Bądź bardzo ostrożny. Obszar ten jest pełen zagrożeń\n " +
//                "i trudno przewidzieć, co możesz tam napotkać.\n" +
//                "Wystarczą 3 próbki.";
//        dialogues[6] = "Wracaj z nimi jak najszybciej cały i zdrowy!.";
        if (gp.player.tube == 3){
            dialogues = new String[4];
            dialogues[0] = "";
            dialogues[1] = "(odwracając się z zaskoczeniem i radością)";
            dialogues[2] = "To niesamowite! Nie spodziewałam się,\n" +
                    " że tak szybko sobie poradzisz. Te próbki są \n" +
                    "kluczowe dla naszych badań. Dzięki nim możemy \n" +
                    "znacząco posunąć się naprzód w zrozumieniu wirusa\n" +
                    " i opracowaniu skutecznego lekarstwa.\n";
            dialogues[3] = "(bierze kapsuły i umieszcza je w specjalnym urządzeniu)";
            if (currentDialogueIndex > 0){
                foundTube = true;
                gp.player.tube = 0;
                System.out.println(gp.player.tube);
                currentDialogueIndex = 0;
            }
        }
        if (foundTube == true){
            dialogues = new String[4];
            dialogues[0] = "Teraz muszę skupić się na pracy.\n" +
                    " Te dane mogą nam wiele wyjaśnić.\n";
            dialogues[1] = " Dziękuję za twoją pomoc i odwagę";
            dialogues[2] = "A. Profesor Bubak szukał cię,\n" +
                    " kiedy byłeś po próbki. Powiedział,\n" +
                    " że to pilne. Powinieneś go znaleźć \n" +
                    "jak najszybciej. Jest w swojej sali na\n" +
                    " lewo od wejścia bocznego uczelni.";
            dialogues[3] = "Do zobaczenia!";
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
