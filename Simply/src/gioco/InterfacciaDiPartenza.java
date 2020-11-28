package gioco;
import java.awt.Color;  
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class InterfacciaDiPartenza extends Thread {
	public static JFrame frame;
	static attestatiRicevuti att;
	musicaDomande musicaDomande = new musicaDomande("Mozart, Piano Sonata in C major, No 16, K 545, Allegro.mp3");
	musicaAvvioPartita principale = new musicaAvvioPartita("PPAP - Instrumental bene.mp3");
	
	public void run(){
		 try {  
				initialize();
				Domandee.p.openFileS();
				Domandee.p.readFileS();
				InterfacciaDiPartenza.frame.setVisible(true);
				
			 } catch (Exception e) {
			 }
	}
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(700, 700, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = frame.getSize ();
		frame.setLocation ((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
		
		String testo_bott[] = {"ATTESTATI", "NUOVA PARTITA","CARICA PARTITA"};
		JButton[] bottoni= new JButton[3];
		
		for (int i = 0; i < bottoni.length; i++) {
			bottoni[i] = new JButton(testo_bott[i]);
			bottoni[i].setFont(new Font("Arial", Font.ITALIC, 18));
			bottoni[i].setOpaque(true);
			bottoni[i].setVisible(true);
			bottoni[i].setBackground(new Color(72,118,255));
			bottoni[i].setForeground(Color.white);
			frame.getContentPane().add(bottoni[i]);
		}	
		
		//do una posizione ai bottoni
		bottoni[0].setBounds(253, 444, 364, 25);
		bottoni[1].setBounds(253, 482, 365, 25);
		bottoni[2].setBounds(0, 520, 632, 33);
		
		bottoni[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				attestatiRicevuti.initialize();
				frame.setVisible(false);
			}
		});
		bottoni[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent giusta) {
					Domandee.g.openFile();
					Domandee.g.Azzera();
					Domandee.g.chiudi();
					frame.setVisible(false);
					try {
						Domandee.FrameVisible();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PartiMain.sonoInDomande = true;
					musicaAvvioPartita.close();
					musicaDomande.start();
					
				}
		});
		bottoni[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent giusta) {
				try {
					Domandee.FrameVisible();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setVisible(false);
				PartiMain.sonoInDomande = true;
				musicaAvvioPartita.close();
				musicaDomande.start();
			}
		});
		
		
				
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("immaginiGioco"+File.separator+"quiz-autori-fb.jpg"));
		lblNewLabel_2.setBounds(0, -12, 632, 565);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator+"thumb-1920-3392.jpg"));
		lblNewLabel.setBounds(0, 0, 632, 553);
		lblNewLabel.setVisible(true);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel sfondo = new JLabel("");
		sfondo.setBounds(0, 0, 56, 16);
		sfondo.setBackground(Color.white);
		frame.getContentPane().add(sfondo);
    
	}
	
}