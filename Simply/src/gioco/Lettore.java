package gioco;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//in questa classe leggo i bottoni, le domande, rispostegiuste, la rispostaGiustaEra.
public class Lettore {
private static Scanner y;

	@SuppressWarnings("resource")
	public String letturaDellaRispostaCorretta(int posizioneFrame) throws IOException {	
	    FileReader f;
	    System.out.println(posizioneFrame);
	    f=new FileReader(new File ("rispostaCorretta"+File.separator +"Corretta"+posizioneFrame + ".txt")); 
	    
	    BufferedReader b;
	    b=new BufferedReader(f);
	   String corretta = b.readLine();
    	return corretta;
    }
	
	@SuppressWarnings("resource")
	public String laRispSbagliataEra(int posizioneFrame) throws IOException {		
	    FileReader f;
	    f=new FileReader(new File ("LaRispCorrEra"+File.separator+"laRispCorrEra"+posizioneFrame + ".txt")); 
	    BufferedReader b;
	    b=new BufferedReader(f);
	    String LaRisp = b.readLine();
	    return LaRisp;
    }
	
	public void letturaDeiNomiDeiBottoni(int posizioneFrame) throws IOException {
	    y = new Scanner (new File("bottoni" + File.separator + "bottoni"  +posizioneFrame + ".txt"));
	    
	    while(y.hasNextLine()){
	    	Domandee.bottUno = y.nextLine();
	    	Domandee.bottDue = y.nextLine();
	    	Domandee.bottTre = y.nextLine();
	    	Domandee.bottQuattro = y.nextLine();
	    }//while
	}
	
	@SuppressWarnings("resource")
	public String letturaDellaCuriosita(int posizioneFrame) throws IOException {		
	    FileReader f;
	    f=new FileReader(new File ("curiosita"+File.separator+"curiosita"+posizioneFrame + ".txt")); 
	    
	    BufferedReader b;
	    b=new BufferedReader(f);
	    String curiosita = b.readLine();
    	return curiosita;
    }
	
	@SuppressWarnings("resource")
	public String letturaDellaDomande(int posizioneFrame) throws IOException {
	    FileReader f;
	    f=new FileReader(new File ("DomandeTXT"+ File.separator+ "domanda"+ posizioneFrame + ".txt"));     
	    BufferedReader b;
	    b=new BufferedReader(f);
	    
	    String domandaDalTxt = b.readLine();
    	return domandaDalTxt;
	}
}
