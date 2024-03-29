package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){

        soundURL[0] = getClass().getResource("/sound/SMCEBI_Theme_Menu.wav");
        soundURL[1] = getClass().getResource("/sound/pickup.wav");
        soundURL[2] = getClass().getResource("/sound/openDoor.wav");
        soundURL[3] = getClass().getResource("/sound/hitmonster.wav");
        soundURL[4] = getClass().getResource("/sound/hitmonster2.wav");
        soundURL[5] = getClass().getResource("/sound/attack.wav");
//        soundURL[6] = getClass().getResource("/sound/Menu_wasd.wav");
        soundURL[7] = getClass().getResource("/sound/SMCEBI_Game_Background.wav");
        soundURL[8] = getClass().getResource("/sound/Gun_shoot.wav");
        soundURL[9] = getClass().getResource("/sound/Gun_shoot2.wav");


//        soundURL[10] = getClass().getResource("/sound/enter.wav");
//        soundURL[10] = getClass().getResource("/sound/footstep.wav");


    }

    public void setFile(int i){

        try{

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        }catch(Exception e){

        }

    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.flush();
        }
    }
}

