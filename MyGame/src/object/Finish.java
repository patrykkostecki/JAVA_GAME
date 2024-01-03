package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Finish extends SuperObject{
    public Finish(){
        name = "Finish";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/C.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
