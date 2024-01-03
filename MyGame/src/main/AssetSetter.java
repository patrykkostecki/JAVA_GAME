package main;

import object.Desk;
import object.Finish;
import object.Key;
import object.Door;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[0] = new Key();
        gp.obj[0].worldX = 48 * gp.tileSize;
        gp.obj[0].worldY = 2 * gp.tileSize;

        gp.obj[1] = new Desk();
        gp.obj[1].worldX = 13 * gp.tileSize;
        gp.obj[1].worldY = 3 * gp.tileSize;

        gp.obj[2] = new Door();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 7 * gp.tileSize;

        gp.obj[3] = new Finish();
        gp.obj[3].worldX = 16 * gp.tileSize;
        gp.obj[3].worldY = 51 * gp.tileSize;

    }

}
