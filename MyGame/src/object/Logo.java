package object;

import main.Game;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Logo extends SuperObject{

    GamePanel gp;
    public Logo(GamePanel gp){

        this.gp = gp;

        name = "Logo";

        try{
            image = ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("tiles/LOGO2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
