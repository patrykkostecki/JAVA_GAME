package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CoffeAutomat extends SuperObject{
    public CoffeAutomat(){
        name = "EatAutomat";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/coffe_automat.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
