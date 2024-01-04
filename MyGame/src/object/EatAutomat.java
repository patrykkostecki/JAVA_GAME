package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class EatAutomat extends SuperObject{
    public EatAutomat(){
        name = "EatAutomat";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/eat_automat.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
