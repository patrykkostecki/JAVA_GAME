package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;

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
//                    gp.playMusic(0);

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
                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 1) {
                            gp.gameState = gp.playState;
                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 2) {
                            gp.gameState = gp.playState;
                        }
                        gp.repaint();
                        if (gp.ui.commandNum == 3) {
                            gp.ui.titleScreenState = 0;
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
