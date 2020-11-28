package gioco;
import java.util.Formatter;

public class scriviFileleggiFileAggiornamentoPosizione{
	
private static Formatter x;

	public void openFile() {
	try {
		x = new Formatter ("SalvoDati");
	}
	catch (Exception e) {
		System.out.println("Problema");
		}
	}//metodo
	
	public void Azzera () {
		Domandee.punteggio = 0;
		Domandee.posizioneFrame = -1;
		x.format("%d %d", Domandee.punteggio,Domandee.posizioneFrame);
		

	}
	public void RispostaEsatta () {
		Domandee.punteggio ++;
		Domandee.punteggio ++;

		x.format("%d %d", Domandee.punteggio,Domandee.posizioneFrame);
	}
	
	public void Decrementa () {
		
		Domandee.posizioneFrame --;
		x.format("%d %d", Domandee.punteggio,Domandee.posizioneFrame);
	}
	
	public  void RispostaErrata () {
		x.format("%d %d", Domandee.punteggio,Domandee.posizioneFrame);
		}
	public void chiudi() {
		x.close();
	}
}//class
