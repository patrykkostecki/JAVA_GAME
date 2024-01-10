package main;

import entity.*;
import monster.ZombieMan;
import object.*;

import java.util.zip.ZipOutputStream;

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

        gp.obj[7] = new Ammo();
        gp.obj[7].worldX = 26 * gp.tileSize;
        gp.obj[7].worldY = 11 * gp.tileSize;

        gp.obj[8] = new Ammo();
        gp.obj[8].worldX = 39 * gp.tileSize;
        gp.obj[8].worldY = 11 * gp.tileSize;

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

        gp.npc[5] = new NPC_Wozna(gp);
        gp.npc[5].worldX = 29 * gp.tileSize;
        gp.npc[5].worldY = 9 * gp.tileSize;

        gp.npc[6] = new NPC_Kasia(gp);
        gp.npc[6].worldX = 43 * gp.tileSize;
        gp.npc[6].worldY = 17 * gp.tileSize;

        gp.npc[7] = new NPC_Bubi(gp);
        gp.npc[7].worldX = 14 * gp.tileSize;
        gp.npc[7].worldY = 17 * gp.tileSize;

        gp.npc[8] = new NPC_Rafal(gp);
        gp.npc[8].worldX = 15 * gp.tileSize;
        gp.npc[8].worldY = 53 * gp.tileSize;

        gp.npc[9] = new NPC_Ochrona_Gun(gp);
        gp.npc[9].worldX = 55 * gp.tileSize;
        gp.npc[9].worldY = 37 * gp.tileSize;

        gp.npc[10] = new NPC_Ochrona_AK47(gp);
        gp.npc[10].worldX = 32 * gp.tileSize;
        gp.npc[10].worldY = 7 * gp.tileSize;

        gp.npc[11] = new NPC_Ochrona_P90(gp);
        gp.npc[11].worldX = 36 * gp.tileSize;
        gp.npc[11].worldY = 7 * gp.tileSize;

        gp.npc[12] = new NPC_Ochrona_AK47(gp);
        gp.npc[12].worldX = 54 * gp.tileSize;
        gp.npc[12].worldY = 38 * gp.tileSize;

        gp.npc[13] = new NPC_Ochrona_P90(gp);
        gp.npc[13].worldX = 21 * gp.tileSize;
        gp.npc[13].worldY = 53 * gp.tileSize;

        gp.npc[14] = new NPC_Ochrona_AK47(gp);
        gp.npc[14].worldX = 29 * gp.tileSize;
        gp.npc[14].worldY = 52 * gp.tileSize;

        gp.npc[15] = new NPC_Ochrona_AK47(gp);
        gp.npc[15].worldX = -2 * gp.tileSize;
        gp.npc[15].worldY = 52 * gp.tileSize;

        gp.npc[16] = new NPC_Dziekan(gp);
        gp.npc[16].worldX = 15 * gp.tileSize;
        gp.npc[16].worldY = 47 * gp.tileSize;

        gp.npc[17] = new NPC_Minecraft_Fan(gp);
        gp.npc[17].worldX = 25 * gp.tileSize;
        gp.npc[17].worldY = 43 * gp.tileSize;

        gp.npc[18] = new NPC_Oskar(gp);
        gp.npc[18].worldX = 43 * gp.tileSize;
        gp.npc[18].worldY = 37 * gp.tileSize;

        gp.npc[19] = new NPC_Karol(gp);
        gp.npc[19].worldX = 32 * gp.tileSize;
        gp.npc[19].worldY = 15 * gp.tileSize;

        gp.npc[20] = new NPC_Martwy_Man(gp);
        gp.npc[20].worldX = 37 * gp.tileSize;
        gp.npc[20].worldY = 36 * gp.tileSize;

        gp.npc[21] = new NPC_Medyk(gp);
        gp.npc[21].worldX = 37 * gp.tileSize;
        gp.npc[21].worldY = 34 * gp.tileSize;

        gp.npc[22] = new NPC_Wozna_Phone(gp);
        gp.npc[22].worldX = 34 * gp.tileSize;
        gp.npc[22].worldY = 25 * gp.tileSize;

    }


    public void setMonster(){

        gp.monster[0] = new ZombieMan(gp);
        gp.monster[0].worldX = 45 * gp.tileSize;
        gp.monster[0].worldY = 17 * gp.tileSize;

        gp.monster[1] = new ZombieMan(gp);
        gp.monster[1].worldX = 30 * gp.tileSize;
        gp.monster[1].worldY = 60 * gp.tileSize;

        gp.monster[2] = new ZombieMan(gp);
        gp.monster[2].worldX = 33 * gp.tileSize;
        gp.monster[2].worldY = 60 * gp.tileSize;

        gp.monster[3] = new ZombieMan(gp);
        gp.monster[3].worldX = 36 * gp.tileSize;
        gp.monster[3].worldY = 60 * gp.tileSize;

        gp.monster[4] = new ZombieMan(gp);
        gp.monster[4].worldX = 39 * gp.tileSize;
        gp.monster[4].worldY = 60 * gp.tileSize;

        gp.monster[5] = new ZombieMan(gp);
        gp.monster[5].worldX = 42 * gp.tileSize;
        gp.monster[5].worldY = 60 * gp.tileSize;

        gp.monster[6] = new ZombieMan(gp);
        gp.monster[6].worldX = 33 * gp.tileSize;
        gp.monster[6].worldY = 63 * gp.tileSize;

        gp.monster[7] = new ZombieMan(gp);
        gp.monster[7].worldX = 36 * gp.tileSize;
        gp.monster[7].worldY = 63 * gp.tileSize;

        gp.monster[8] = new ZombieMan(gp);
        gp.monster[8].worldX = 39 * gp.tileSize;
        gp.monster[8].worldY = 66 * gp.tileSize;

        gp.monster[9] = new ZombieMan(gp);
        gp.monster[9].worldX = 42 * gp.tileSize;
        gp.monster[9].worldY = 66 * gp.tileSize;

        gp.monster[10] = new ZombieMan(gp);
        gp.monster[10].worldX = 33 * gp.tileSize;
        gp.monster[10].worldY = 69 * gp.tileSize;

        gp.monster[11] = new ZombieMan(gp);
        gp.monster[11].worldX = 36 * gp.tileSize;
        gp.monster[11].worldY = 69 * gp.tileSize;

        gp.monster[12] = new ZombieMan(gp);
        gp.monster[12].worldX = 39 * gp.tileSize;
        gp.monster[12].worldY = 69 * gp.tileSize;

    }

}
