package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed,
            shootingPressedUp,shootingPressedDown, shootingPressedLeft, shootingPressedRight;

    public KeyHandler(GamePanel gp){
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
                    if (gp.ui.commandNum < 0) {
                        gp.ui.commandNum = 2;
                    }

                }
                if (code == KeyEvent.VK_S) {
                    gp.ui.commandNum++;
                    if (gp.ui.commandNum > 2) {
                        gp.ui.commandNum = 0;
                    }
                }
                if (code == KeyEvent.VK_ENTER) {
                    if (gp.ui.commandNum == 0) {
                        gp.ui.titleScreenState = 1;

                    }
                    if (code == KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 2) {
                            System.exit(0);
                        }
                    }
                }
            }
            } else if (gp.ui.titleScreenState == 1) {

                if (gp.gameState == gp.menuState) {

                    if (code == KeyEvent.VK_W) {
                        gp.ui.commandNum--;
                        if (gp.ui.commandNum < 0) {
                            gp.ui.commandNum = 3;
                        }
                        gp.repaint();
                    }
                    if (code == KeyEvent.VK_S) {
                        gp.ui.commandNum++;
                        if (gp.ui.commandNum > 3) {
                            gp.ui.commandNum = 0;
                        }
                        gp.repaint();
                    }
                    if (code == KeyEvent.VK_ENTER) {
                        if (gp.ui.commandNum == 0) {
                            gp.gameState = gp.playState;
                            gp.player.skin = 1;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();
                            gp.ui.titleScreenState = 2;
                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 1) {
                            gp.gameState = gp.playState;
                            gp.player.skin = 2;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();

                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 2) {
                            gp.gameState = gp.playState;
                            gp.player.skin = 3;
                            gp.player.getPlayerImage();
                            gp.player.getPlayerAttackImage();

                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 3) {
//                            gp.ui.titleScreenState = 0;
                        }
                        gp.repaint();
                    }
                }
            } if (gp.gameState == gp.playState) {

                if (code == KeyEvent.VK_W) {
                    upPressed = true;
                }
                if (code == KeyEvent.VK_S) {
                    downPressed = true;
                }
                if (code == KeyEvent.VK_A) {
                    leftPressed = true;
                }
                if (code == KeyEvent.VK_D) {
                    rightPressed = true;
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
                    }
                }
                if (code == KeyEvent.VK_DOWN) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("down");
                    }
                }
                if (code == KeyEvent.VK_LEFT) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("left");
                    }
                }
                if (code == KeyEvent.VK_RIGHT) {
                    if (gp.gameState == gp.playState) {
                        gp.player.shoot("right");
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
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = false;
        }
        if (code == KeyEvent.VK_S){
            downPressed = false;
        }
        if (code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
