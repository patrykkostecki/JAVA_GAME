package main;

import entity.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    Player pl;
    GamePanel gp;

    public boolean footstep = false;
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed,
            shootingPressedUp,shootingPressedDown, shootingPressedLeft, shootingPressedRight;

    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (gp.ui.titleScreenState == 0) {
            if (gp.gameState == gp.menuState) {

                if (code == KeyEvent.VK_W) {
                    gp.ui.commandNum--;
                    gp.playSoundEffect2(0);
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }

                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    gp.playSoundEffect2(0);
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.playSoundEffect2(3);
                        gp.ui.titleScreenState = 1;

                    }
                    if (code == KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 2) {
                            gp.playSoundEffect2(3);
                            System.exit(0);
                        }
                    }
                }
            }
            } else if (gp.ui.titleScreenState == 1) {

                if (gp.gameState == gp.menuState) {

                    if (code == KeyEvent.VK_W) {
                        gp.playSoundEffect2(0);
                        gp.ui.commandNum--;
                        if (gp.ui.commandNum < 0) {
                            gp.ui.commandNum = 3;
                        }
                        gp.repaint();
                    }
                    if (code == KeyEvent.VK_S) {
                        gp.playSoundEffect2(0);
                        gp.ui.commandNum++;
                        if (gp.ui.commandNum > 3) {
                            gp.ui.commandNum = 0;
                        }
                        gp.repaint();
                    }
                    if (code == KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 0) {
                            gp.playSoundEffect2(3);
//                            gp.gameState = gp.playState;
                            gp.player.skin = 1;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();
                            gp.ui.titleScreenState = 3;
                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 1) {
//                            gp.gameState = gp.playState;
                            gp.player.skin = 2;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();
                            gp.ui.titleScreenState = 3;


                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 2) {
//                            gp.gameState = gp.playState;
                            gp.player.skin = 3;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();
                            gp.ui.titleScreenState = 3;


                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 3) {
                        }
                        gp.repaint();
                    }
                }
            } else if(gp.ui.titleScreenState == 3){
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        } if (gp.gameState == gp.playState) {


                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                    if (footstep == false)
                    {
                        gp.playMusic2(1);
                        footstep = true;
                    }
                }
                if (code == KeyEvent.VK_S) {
                    downPressed = true;
                    if (footstep == false)
                    {
                        gp.playMusic2(1);
                        footstep = true;
                    }
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                    if (footstep == false)
                    {
                        gp.playMusic2(1);
                        footstep = true;
                    }
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = true;
                    if (footstep == false)
                    {
                        gp.playMusic2(1);
                        footstep = true;
                    }
                }
                if (code == KeyEvent.VK_SPACE) {
                    spacePressed = true;
                }
                if (code == KeyEvent.VK_UP){
                    shootingPressedUp = true;

                }
                if (code == KeyEvent.VK_DOWN){
                    shootingPressedDown = true;
                }
                if (code == KeyEvent.VK_LEFT){
                    shootingPressedLeft = true;
                }
                if (code == KeyEvent.VK_UP){
                    shootingPressedRight = true;
            }
                if (code == KeyEvent.VK_UP) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("up");
                        shot_sound_effect();
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("down");
                        shot_sound_effect();
                    }
                }
                if (code == KeyEvent.VK_LEFT) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("left");
                        shot_sound_effect();
                    }
                }
                if (code == KeyEvent.VK_RIGHT) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("right");
                        shot_sound_effect();
                    }
                }
            }
        if (code == KeyEvent.VK_P) {
            if (gp.gameState == gp.playState) {
                gp.gameState = gp.stopState;
            } else if (gp.gameState == gp.stopState) {
                gp.gameState = gp.playState;
            }
        }
        if (code == KeyEvent.VK_ESCAPE) {
            if (gp.gameState == gp.dialogueState) {
                gp.gameState = gp.playState;
            }
        }
        if (code == KeyEvent.VK_SPACE && gp.gameState == gp.dialogueState) {
            spacePressed = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = false;
            if (footstep == true)
            {
                gp.stopMusic2();
                footstep = false;
            }
        }
        if (code == KeyEvent.VK_S){
            downPressed = false;
            if (footstep == true)
            {
                gp.stopMusic2();
                footstep = false;
            }
        }
        if (code == KeyEvent.VK_A){
            leftPressed = false;
            if (footstep == true)
            {
                gp.stopMusic2();
                footstep = false;
            }
        }
        if (code == KeyEvent.VK_D){
            rightPressed = false;
            if (footstep == true)
            {
                gp.stopMusic2();
                footstep = false;
            }
        }
        if (code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
    public void shot_sound_effect()
    {
        if (gp.player.ammo > 0)
        {
            gp.playSoundEffect(9);
        }
        else
        {
            gp.playSoundEffect(8);
        }

    }
}
