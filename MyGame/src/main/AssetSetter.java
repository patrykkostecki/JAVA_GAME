package main;

import object.*;

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

        gp.obj[4] = new EatAutomat();
        gp.obj[4].worldX = 20 * gp.tileSize;
        gp.obj[4].worldY = 39 * gp.tileSize;

        gp.obj[5] = new WaterBottle();
        gp.obj[5].worldX = 20 * gp.tileSize;
        gp.obj[5].worldY = 37 * gp.tileSize;

        gp.obj[6] = new CoffeAutomat();
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 40 * gp.tileSize;

    }

}
