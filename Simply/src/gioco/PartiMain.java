package gioco;
public class PartiMain {
	public static boolean sonoInDomande = false;
	public static void main(String[] args){
		musicaAvvioPartita principale = new musicaAvvioPartita("PPAP - Instrumental bene.mp3");
		InterfacciaDiPartenza interfaccia = new InterfacciaDiPartenza();
		interfaccia.start();	
		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		principale.start();    
	}
}