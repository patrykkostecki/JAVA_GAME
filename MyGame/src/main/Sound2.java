package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;

public class Sound2 {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound2(){

        soundURL[0] = getClass().getResource("/sound/Menu_wasd.wav");



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

