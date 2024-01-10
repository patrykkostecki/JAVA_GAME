package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Bullet extends SuperObject{

    public int lifeSpan; // Czas życia pocisku, liczba klatek zanim zniknie
    public int speed; // Prędkość pocisku
    public String direction; // Kierunek pocisku
    public boolean alive;

    GamePanel gp;

    public Bullet(GamePanel gp){

        this.gp = gp;
        name = "Bullet";
        int distanceTraveled = 0;
        final int maxDistance = 4 * gp.tileSize;
        this.lifeSpan = 22;
        this.speed = 8;



        solidArea.x = 5;
        solidArea.y = 5;
        solidArea.width = gp.tileSize / 2;
        solidArea.height = gp.tileSize / 2;

        try{
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/Bullet.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void update() {
        System.out.println("UPDATE");

        if(lifeSpan > 0) {
            switch (direction) {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
                case "standing": break;
            }
            lifeSpan--;
        } else {
            alive = false;
        }
    }
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(screenX >= 0 && screenX <= gp.screenWidth && screenY >= 0 && screenY <= gp.screenHeight) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

    public void checkCollisionWithMonsters(Entity[] monsters) {
        Rectangle bulletHitbox = new Rectangle(worldX, worldY, gp.tileSize, gp.tileSize);

        for (Entity monster : monsters) {
            if (monster != null && monster.alive) {
                Rectangle monsterHitbox = new Rectangle(monster.worldX, monster.worldY, monster.solidArea.width, monster.solidArea.height);

                if (bulletHitbox.intersects(monsterHitbox)) {

                    monster.invincible = true;
                    gp.playSoundEffect(3);
                    monster.damageReaction();
                    monster.life -= gp.player.damage;

                    alive = false; // Usuwanie pocisku

                    if (monster.life <= 0) {
                        gp.player.exp += 10;
                        if(Math.random() <= 0.5){
                            gp.player.gold += 1;
                        }
                        monster.dying = true;
                    }

                    break;
                }
            }
        }
    }

}
