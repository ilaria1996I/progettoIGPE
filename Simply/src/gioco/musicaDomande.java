
package gioco;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class musicaDomande {
	    private String filename;
	    private static Player player;
	    static Thread playMusic;

	    public musicaDomande(String filename) {
	        this.filename = filename;
	    }
	    
	    public void play() {
	        try {
	            FileInputStream musicaDomand = new FileInputStream(filename);
	            BufferedInputStream biss = new BufferedInputStream(musicaDomand);
	            player = new Player(biss);
	        } catch (Exception e) {
	        }
	    }

	    public void start() {
	    	musicaAvvioPartita.close();
	        play();
	        playMusic = new Thread(new PlayMusic());
	        playMusic.start();  
	    }

	    public static void stop() {
	        close();
	        playMusic = null;
	    }

	    public static void close() {
	        if (player != null) {
	            player.close();
	        }
	    }

	    class PlayMusic implements Runnable {

	        public void run() {
	            try {
	                player.play();
	                if(PartiMain.sonoInDomande == true) {
	                try {
	                	start();
	                	Thread.sleep(264000);
	        		} catch (InterruptedException e) {
	        			e.printStackTrace();
	        		}
	                }
	            }
	            catch (Exception e) {
	                System.out.println(e);
	            }
	        }
	    }
}