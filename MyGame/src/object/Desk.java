package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Desk extends SuperObject{

    public Desk(){
            name = "Desk";

            try{
                image = ImageIO.read(getClass().getResourceAsStream("/objects/desk.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
            collision = true;
    }


}
