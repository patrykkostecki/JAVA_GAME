package main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp){

        this.gp = gp;
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent(){

//        if (hit(30,17,"down") == true ){
//
//            damagePit(gp.dialogueState);
//
//        }
        if (hit(26,10,"left") == true ){
            headlingPool(gp.dialogueState);
        }
        if (hit(39,10,"right") == true ){
            headlingPool(gp.dialogueState);
        }



    }

    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if (gp.player.solidArea.intersects(eventRect)){
            if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;



        return hit;
    }
    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.ui.correntDialogue = "Ała!";
        gp.player.life -= 1;
    }

    public void headlingPool (int gameState){

        //if (gp.keyH.spacePressed == true){
            gp.gameState = gameState;
            gp.ui.correntDialogue = "Uleczono";
            if (gp.player.life == gp.player.maxLife){
                gp.ui.correntDialogue = "Masz pełne życie!";
            } else if(gp.player.life < gp.player.maxLife){
                gp.player.life ++;
            }

       // }

    }
}
