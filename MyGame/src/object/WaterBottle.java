package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class WaterBottle extends SuperObject{
    public WaterBottle(){
        name = "EatAutomat";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_bootle.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
