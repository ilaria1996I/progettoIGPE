package gioco;

import java.io.File;
import java.util.Scanner;

public class leggiFileAggiornamentoPosizione{
	private Scanner y;
		
	public void openFileS() {
			try {
				y = new Scanner (new File("SalvoDati"));
			}
			catch (Exception e) {
				
				}
			}
	public void readFileS () {
		while(y.hasNext()){
			Domandee.punteggio = y.nextInt();
			Domandee.posizioneFrame = y.nextInt();
		}
	}			
}

