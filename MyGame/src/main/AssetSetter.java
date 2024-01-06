package main;

import entity.*;
import object.*;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public void setObject(){

        gp.obj[0] = new Key();
        gp.obj[0].worldX = 48 * gp.tileSize;
        gp.obj[0].worldY = 9 * gp.tileSize;

        gp.obj[1] = new Desk();
        gp.obj[1].worldX = 13 * gp.tileSize;
        gp.obj[1].worldY = 10 * gp.tileSize;

        gp.obj[2] = new Door();
        gp.obj[2].worldX = 25 * gp.tileSize;
        gp.obj[2].worldY = 14 * gp.tileSize;

        gp.obj[3] = new Finish();
        gp.obj[3].worldX = 16 * gp.tileSize;
        gp.obj[3].worldY = 58 * gp.tileSize;

        gp.obj[4] = new EatAutomat();
        gp.obj[4].worldX = 20 * gp.tileSize;
        gp.obj[4].worldY = 46 * gp.tileSize;

        gp.obj[5] = new WaterBottle();
        gp.obj[5].worldX = 20 * gp.tileSize;
        gp.obj[5].worldY = 44 * gp.tileSize;

        gp.obj[6] = new CoffeAutomat();
        gp.obj[6].worldX = 20 * gp.tileSize;
        gp.obj[6].worldY = 47 * gp.tileSize;

    }

    public void setNPC(){

        gp.npc[0] = new NPC_Dendzik(gp);
        gp.npc[0].worldX = 28 * gp.tileSize;
        gp.npc[0].worldY = 17 * gp.tileSize;

        gp.npc[1] = new NPC_Ochrona_Man(gp);
        gp.npc[1].worldX = 47 * gp.tileSize;
        gp.npc[1].worldY = 30 * gp.tileSize;

        gp.npc[2] = new NPC_Ochrona_Woman(gp);
        gp.npc[2].worldX = 47 * gp.tileSize;
        gp.npc[2].worldY = 32 * gp.tileSize;

        gp.npc[3] = new NPC_Grzybo(gp);
        gp.npc[3].worldX = 33 * gp.tileSize;
        gp.npc[3].worldY = 47 * gp.tileSize;

        gp.npc[4] = new NPC_Krzysio(gp);
        gp.npc[4].worldX = 21 * gp.tileSize;
        gp.npc[4].worldY = 9 * gp.tileSize;

    }

}
