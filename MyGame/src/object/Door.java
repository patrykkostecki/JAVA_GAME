package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends SuperObject{

    public Door(){
        name = "Door";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/doors/Drzwi_Dol_Dol.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }


}
