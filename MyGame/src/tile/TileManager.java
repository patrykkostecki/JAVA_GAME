package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;

    public int[][] mapTileNum;

    public TileManager(GamePanel gp){

        this.gp = gp;
        tile = new Tile[100];
        getTileImage();
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        loadMap();

    }

    public void getTileImage() {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassv2.png"));

            tile[60] = new Tile();
            tile[60].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassv2.png"));
            tile[60].colission = true;

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(getClass().getResourceAsStream("/tiles/smoking_plate.png"));
            tile[61].colission = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sciana_Uczelnia.png"));
            tile[1].colission = true;

            tile[70] = new Tile();
            tile[70].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Sciana_Uczelnia.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Glass_wall.png"));
            tile[2].colission = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/P_Jasna_Cala.png"));

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Glass_wall.png"));
//
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Schody_lewo.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_lewo.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_prawo.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/P_Ciemna_Cala.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/smoking_plate.png"));

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wood2.png"));

            // SECURITY DESK
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/security_desk_0.png"));
            tile[12].colission = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/security_desk_1.png"));
            tile[13].colission = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/security_desk_2.png"));
            tile[14].colission = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/security_desk_3.png"));
            tile[15].colission = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_srodek.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/klasa.png"));

            //DOOR'S
            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door_1.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/glass_door_1.png"));

            //Flowers
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flowers_3.png"));
            tile[20].colission = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flowers_1.png"));
            tile[21].colission = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flowers_2.png"));
            tile[22].colission = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flowers_0.png"));
            tile[23].colission = true;

            //Barrier
            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/tiles/barrier_0.png"));
            tile[25].colission = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/tiles/barrier_1.png"));
            tile[26].colission = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/tiles/barrier_2.png"));
            tile[27].colission = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/tiles/barrier_3.png"));
            tile[28].colission = true;

            //Bench
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench_0.png"));
            tile[30].colission = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench_1.png"));
            tile[31].colission = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/tiles/bench_2.png"));
            tile[32].colission = true;

            //Banners
            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/tiles/banner_0.png"));
            tile[35].colission = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/tiles/banner_1.png"));
            tile[36].colission = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/tiles/banner_2.png"));
            tile[37].colission = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/tiles/banner_3.png"));
            tile[38].colission = true;

            //Schody Barrier
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_barrier_0.png"));
            tile[40].colission = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_barrier_1.png"));
            tile[41].colission = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/tiles/schody_barrier_2.png"));
            tile[42].colission = true;

            //ARENA
            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena.png"));

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena_barrier_0.png"));

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena_barrier_1.png"));

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena_barrier_2.png"));

            tile[54] = new Tile();
            tile[54].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena_barrier_3.png"));

            // EVENTY
            tile[81] = new Tile();
            tile[81].image = ImageIO.read(getClass().getResourceAsStream("/tiles/arena.png"));

            tile[80] = new Tile();
            tile[80].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Czern.png"));


            tile[90] = new Tile();
            tile[90].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tablica.png"));

            tile[91] = new Tile();
            tile[91].image = ImageIO.read(getClass().getResourceAsStream("/tiles/komputerl.png"));
            tile[91].colission = true;

            tile[92] = new Tile();
            tile[92].image = ImageIO.read(getClass().getResourceAsStream("/tiles/komputerp.png"));
            tile[92].colission = true;

            tile[95] = new Tile();
            tile[95].image = ImageIO.read(getClass().getResourceAsStream("/tiles/umywalka.png"));
            tile[95].colission = true;

            tile[96] = new Tile();
            tile[96].image = ImageIO.read(getClass().getResourceAsStream("/tiles/kibel.png"));
            tile[96].colission = true;

            tile[97] = new Tile();
            tile[97].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lawka.png"));
            tile[97].colission = true;

            tile[98] = new Tile();
            tile[98].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tablica2.png"));
            tile[98].colission = true;

            tile[99] = new Tile();
            tile[99].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lawka2.png"));
            tile[99].colission = true;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){

        try{

            InputStream is = getClass().getResourceAsStream("/maps/map.rtf");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                 String line = br.readLine();

                 while (col < gp.maxWorldCol){
                     String numbers[] = line.split(" ");
                     int num = Integer.parseInt(numbers[col]);

                     mapTileNum[col][row] = num;
                     col++;
                 }

                 if(col == gp.maxWorldCol){
                     col = 0;
                     row++;
                 }

            }
            br.close();


        } catch(Exception e){
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // Zatrzymanie kamery
            if(gp.player.screenX > gp.player.worldX){
                screenX = worldX;
            }
            if(gp.player.screenY > gp.player.worldY){
                screenY = worldY;
            }

            int rightStop = gp.screenWidth - gp.player.screenX;
            if(rightStop > gp.worldWidth - gp.player.worldX){
                screenX = gp.screenWidth - (gp.worldWidth - worldX);
            }

            int bottomStop = gp.screenHeight - gp.player.screenY;
            if(bottomStop > gp.worldHeight - gp.player.worldY){
                screenY = gp.screenHeight - (gp.worldHeight - worldY);
            }

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){

                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }else if(gp.player.screenX > gp.player.worldX ||
                     gp.player.screenY > gp.player.worldY ||
                     rightStop > gp.worldWidth - gp.player.worldX ||
                     bottomStop > gp.worldHeight - gp.player.worldY){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }



            worldCol++;

            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;

            }

        }

//            g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
//            g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//            g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
        }

}
