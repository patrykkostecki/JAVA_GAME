package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Tube extends SuperObject{
    public Tube(){
        name = "Tube";

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/tube.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}