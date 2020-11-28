package gioco;

 import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

class MusicaRisposte extends Thread{	
    private String filename;
    private static Player player;
    static Thread playMusic;
  	    public MusicaRisposte(String filename) {
        this.filename = filename;
    }
    public void play() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }
    }

    public void start() {
        play();
        playMusic = new Thread(new PlayMusic());
        playMusic.start();
       
    }

    class PlayMusic implements Runnable {

        public void run() {
            try {
                player.play();
                if(PartiMain.sonoInDomande == false) {
            }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }		    
}