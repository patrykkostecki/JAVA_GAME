package object;

import main.Game;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Heart extends SuperObject{

    GamePanel gp;
    public Heart(GamePanel gp){

        this.gp = gp;

        name = "Heart";

        try{
            image = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("UI/heart0.png"));
            image2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("UI/heart3.png"));
            image3 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("UI/heart1.png"));
//            image2 = ImageIO.read(getClass().getResourceAsStream("UI/heart3.png"));
//            image3 = ImageIO.read(getClass().getResourceAsStream("UI/heart1.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
