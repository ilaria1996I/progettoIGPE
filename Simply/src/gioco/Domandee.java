package gioco;
import java.awt.Color;  
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Domandee {
	static InterfacciaDiPartenza Interfaccia;
	static scriviFileleggiFileAggiornamentoPosizione g = new scriviFileleggiFileAggiornamentoPosizione();
	static leggiFileAggiornamentoPosizione p = new leggiFileAggiornamentoPosizione();
	static musicaDomande musicaDomande = new musicaDomande("Mozart, Piano Sonata in C major, No 16, K 545, Allegro.mp3");
	static musicaAvvioPartita principale = new musicaAvvioPartita("PPAP - Instrumental bene.mp3");
	static MusicaRisposte correttaM = new MusicaRisposte("Cartoon Winning Sound Effect (mp3cut.net) (3).mp3");
	static MusicaRisposte sbagliataM = new MusicaRisposte("Buzzer Wrong Answer - Gaming Sound Effect (HD) (mp3cut.net).mp3");
	public static JFrame domande;
	static int punteggio;
	static int posizioneFrame = -1;
	static String domandaDalTxt;
	static String bottUno;
	static String bottDue;
	static String bottTre;
	static String bottQuattro;
	static String corretta;
	static String hoCliccato;
	
	//invocano la curiosita giusta o sbagliata
	private static void invocoCuriosita() throws IOException {
		
		if (corretta.equals(hoCliccato)) {
			gioco.Curiosita.rispostaCorretta = true;
			correttaM.start();
		}
		else {
			gioco.Curiosita.rispostaCorretta = false;
			sbagliataM.start();
		}
		
		gioco.Curiosita.cur(); //parte la curiosita
	}
	
	//incrementa la posizione delle domande e invoca i vari metodi che "aggiornano" le stringhe bottoni, domande, curiosita 
	public static void FrameVisible() throws IOException {
		Lettore Lettore = new Lettore();
		posizioneFrame ++;
		if(posizioneFrame == 20) {
			attestatiRicevuti.finale();
		}
		else {	
		corretta = Lettore.letturaDellaRispostaCorretta(posizioneFrame);
		domandaDalTxt = Lettore.letturaDellaDomande(posizioneFrame);
		Lettore.letturaDeiNomiDeiBottoni(posizioneFrame);
		domandeVarie();
		}
	}
	
	
	//legge le varie domande prendendo testo/bottoni ecc.. da txt
	private static void domandeVarie() {
		domande = new JFrame();
		domande.setBounds(700, 700, 650, 600);
		domande.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		domande.getContentPane().setLayout(null);
		domande.setResizable(false);
		domande.setVisible(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = domande.getSize ();
		domande.setLocation ((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
		
		JLabel txtpnInCheAnno = new JLabel();
		txtpnInCheAnno.setForeground(Color.black);
		txtpnInCheAnno.setText(domandaDalTxt);
		txtpnInCheAnno.setFont(new Font("Arial", Font.PLAIN, 19));
		txtpnInCheAnno.setBackground(new Color(128, 128, 128));	
		txtpnInCheAnno.setBounds(0, 219, 644, 167);
		txtpnInCheAnno.setVisible(true);
		domande.getContentPane().add(txtpnInCheAnno);

		String testo_bott[] = {bottUno, bottDue,bottTre,bottQuattro,"Menu"};
		JButton[] bottoni= new JButton[5];
		
		//creo i 4 bottoni per le 4 possibili risposte
		for (int i = 0; i < bottoni.length; i++) {
			bottoni[i] = new JButton(testo_bott[i]);
			bottoni[i].setBackground(new Color(128, 128, 128));
			bottoni[i].setForeground(new Color(255, 255, 255));
			bottoni[i].setFont(new Font("Arial", Font.ITALIC, 18));
			bottoni[i].setVisible(true);
			bottoni[i].setOpaque(true);
			domande.getContentPane().add(bottoni[i]);
		}
		for (int i = 0; i < bottoni.length-1; i++) {
		bottoni[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent corretta){
					domande.setVisible(false);
						for(int l = 0; l<4 ; l++) {
						if(corretta.getSource() == bottoni[l])
							hoCliccato = bottoni[l].getText();
						}//for 
					try {
						invocoCuriosita();
					} catch (IOException e) {
						e.printStackTrace();
					}
					}
		}); 
}//for dei bottoni
	
		//do una posizione ai bottoni
		bottoni[0].setBounds(362, 467, 238, 25);
		bottoni[1].setBounds(25, 467, 243, 25);
		bottoni[2].setBounds(25, 527, 243, 25);
		bottoni[3].setBounds(362, 527, 243, 25);
		bottoni[4].setBounds(0, 0, 120, 30);
		
		JLabel	sfondod1 = new JLabel("");
		sfondod1.setBounds(0, 0, 644, 565);
		sfondod1.setOpaque(true);
		sfondod1.setBackground(new Color(211, 211, 211));
		domande.getContentPane().add(sfondod1);
		
		//bottone per tornare al menu gestisco il listener
		bottoni[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent sbagliata) {
				gioco.InterfacciaDiPartenza.frame.setVisible(true);
	        	domande.setVisible(false); 
	        	g.openFile();
				g.Decrementa();
				g.chiudi();
				
				PartiMain.sonoInDomande = false;
				principale.start();
				gioco.musicaDomande.close();
			}
		});
	}		
}