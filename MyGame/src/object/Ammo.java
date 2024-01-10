package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ammo extends SuperObject{

    public Ammo(){
        name = "Ammo";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/ammo_sp.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }


}