package gioco;
import java.awt.Color;  
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;

public class attestatiRicevuti {
static int visualizzoAttestatoNumero;
static JFrame attestati;
static musicaAvvioPartita principale = new musicaAvvioPartita("PPAP - Instrumental bene.mp3");
static int pos = Domandee.posizioneFrame;
static int punt = Domandee.punteggio;
static JFrame Finale;

public attestatiRicevuti() {
		initialize();
}
	static void initialize(){
		InterfacciaDiPartenza InterfacciaDiPartenza = new InterfacciaDiPartenza();
		JFrame attestati = new JFrame();
		attestati.setVisible(true);
		attestati.setBounds(700, 700, 629, 571);
		attestati.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		attestati.getContentPane().setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = attestati.getSize ();
		attestati.setLocation ((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);

		JButton btnNewButton_4 = new JButton("Indietro");
		btnNewButton_4.setFont(new Font("Arial", Font.ITALIC, 18));
		btnNewButton_4.setBackground(Color.GRAY);
		btnNewButton_4.setBounds(0, 0, 97, 31);
		btnNewButton_4.setVisible(true);
		attestati.getContentPane().add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent sbagliata){
				attestati.setVisible(false);
				InterfacciaDiPartenza.start();
			}
		});
		
		JButton[] bottoniAttestatiParziali= new JButton[5];
		for (int i = 0; i < bottoniAttestatiParziali.length; i++) {
			bottoniAttestatiParziali[i] = new JButton();
			bottoniAttestatiParziali[i].setFont(new Font("Arial", Font.ITALIC, 18));
			bottoniAttestatiParziali[i].setForeground(new Color(255, 255, 255));
			bottoniAttestatiParziali[i].setVisible(false);
			attestati.getContentPane().add(bottoniAttestatiParziali[i]);
			
			bottoniAttestatiParziali[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent numero){
						attestati.setVisible(false);
						
							for(int l = 0; l<5 ; l++) {
							if(numero.getSource() == bottoniAttestatiParziali[l]) {
								visualizzoAttestatoNumero = l;
								System.out.println(visualizzoAttestatoNumero);
							}
							}//for di l
							visualizzoAttestato();
						}
			});	
		}
		
		bottoniAttestatiParziali[0].setBackground(Color.ORANGE); 
		bottoniAttestatiParziali[0].setIcon(new ImageIcon("immaginiGioco"+File.separator+"picc1.png"));
		bottoniAttestatiParziali[0].setBounds(12, 54, 97, 105); 
		
		bottoniAttestatiParziali[1].setBackground(Color.RED);
		bottoniAttestatiParziali[1].setIcon(new ImageIcon("immaginiGioco"+File.separator+"picc2.png"));
		bottoniAttestatiParziali[1].setBounds(168, 54, 97, 105);
		
		bottoniAttestatiParziali[2].setBackground(Color.GREEN);
		bottoniAttestatiParziali[2].setIcon(new ImageIcon("immaginiGioco"+File.separator+"picc3.png"));
		bottoniAttestatiParziali[2].setBounds(314, 54, 97, 105);
		
		bottoniAttestatiParziali[3].setIcon(new ImageIcon("immaginiGioco"+File.separator+"PICC4.png"));
		bottoniAttestatiParziali[3].setBackground(Color.BLUE);
		bottoniAttestatiParziali[3].setBounds(466, 54, 97, 105);
		
		bottoniAttestatiParziali[4].setIcon(new ImageIcon("immaginiGioco"+File.separator+"questo.png"));
		bottoniAttestatiParziali[4].setBackground(Color.yellow);
		bottoniAttestatiParziali[4].setBounds(183, 212, 191, 139);
		
		if(pos >=5) 
			bottoniAttestatiParziali[0].setVisible(true);
					
		if(pos>=10) 
			bottoniAttestatiParziali[1].setVisible(true);
	
		if(pos >=12) 
			bottoniAttestatiParziali[2].setVisible(true);
				
		if(pos >=15) {
			bottoniAttestatiParziali[3].setVisible(true);	
			bottoniAttestatiParziali[4].setVisible(true);
		}
			
		JLabel domanda1 = new JLabel("");
		domanda1.setForeground(new Color(51, 153, 153));
		domanda1.setIcon(new ImageIcon("immaginiGioco"+File.separator+"attestati.jpg"));
		domanda1.setBounds(-14, -31, 664, 602);
		domanda1.setBackground (Color.black) ;
		
		attestati.getContentPane().add(domanda1);
		attestati.setResizable(false);
	}
	
		static void visualizzoAttestato() {
			JFrame visualizzo = new JFrame();
			visualizzo.getContentPane().setBackground(Color.LIGHT_GRAY);
			visualizzo.setVisible(true);
			visualizzo.setBounds(700, 700, 680, 632);
			visualizzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			visualizzo.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("");
			visualizzo.getContentPane().add(lblNewLabel);
			
			Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
			Dimension frameSize = visualizzo.getSize ();
			visualizzo.setLocation ((screenSize.width - frameSize.width) / 2,
			(screenSize.height - frameSize.height) / 2);
			
			JButton btnNewButton_4 = new JButton("Indietro");
			btnNewButton_4.setFont(new Font("Arial", Font.ITALIC, 18));
			btnNewButton_4.setBackground(Color.GRAY);
			btnNewButton_4.setBounds(0, 0, 97, 31);
			btnNewButton_4.setVisible(true);
			visualizzo.getContentPane().add(btnNewButton_4);
			
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent sbagliata){
					visualizzo.setVisible(false);
					attestatiRicevuti.initialize();
				}
			});
		
		
			if(visualizzoAttestatoNumero == 0) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"Dali-1PiccGra.png"));
				lblNewLabel.setBounds(92, 13, 666, 583);
			}
			else if (visualizzoAttestatoNumero == 1) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"download (1) picc2 grande.png"));
				lblNewLabel.setBounds(127, 36, 380, 486);
			}
			else if (visualizzoAttestatoNumero == 2) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"download (3)picc.png"));
				lblNewLabel.setBounds(86, -50, 666, 611);
			}
			else if (visualizzoAttestatoNumero == 3) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"download picc.png"));
				lblNewLabel.setBounds(79, -29, 666, 583);
			}
			
			else if (visualizzoAttestatoNumero == 4 && punt>=10) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"download (5)ok1ok.png"));
				lblNewLabel.setBounds(0, -64, 666, 583);
			}
			
			else if (visualizzoAttestatoNumero == 4 && punt<10) {
				lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator +"download%20(4)okokok.png"));
				lblNewLabel.setBounds(79, -29, 666, 583);
			}
			lblNewLabel.setVisible(true);	
		}
		
//questa finestra si apre solo dopo aver risposto a tutte le domande, quando hai completato il gioco si aprira una volta solo!
		//avvisa che hai finito le domande
				static void finale() {
					Finale = new JFrame();
					Finale.setBounds(700, 700, 630, 571);
					Finale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Finale.getContentPane().setLayout(null);
					Finale.setVisible(true);
					
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon("immaginiGioco"+File.separator+"fuochi.gif"));
					lblNewLabel_1.setBounds(0, 0, 624, 536);
					lblNewLabel_1.setVisible(true);
					Finale.getContentPane().add(lblNewLabel_1);
							
					JLabel lblNewLabel_2 = new JLabel("<HTML> Per ammirare al meglio il patrimonio artistico mondiale, potremmo paragonarlo ad un grande affresco, ad un grande quadro, realizzato da ogni generazione nel corso dei secoli, possiamo trovare un volto, un castello o un paesaggio, e l\u2019insieme nonostante sia stato fatto con pennellate diverse e con tinte diverse, si riesce ad unire in un\u2019armonia incredibile. Un\u2019armonia che \u00E8 stata organizzata con orgoglio per rappresentare al meglio il concetto di bellezza di quell\u2019 epoca, e l\u2019insieme rappresenta la nostra identit\u00E0, il nostro modo di pensare, ma soprattutto di VIVERE... \r\n\r\nL\u2019insieme rappresenta un patrimonio straordinario che noi abbiamo il dovere di tutelare, proteggere e valorizzare, e in fine regalare alle prossime generazioni perch\u00E9 possano meravigliarsi esattamente come lo possiamo fare noi.- Alberto Angela.");
					lblNewLabel_2.setBackground(Color.GRAY);
					lblNewLabel_2.setForeground(Color.BLACK);
					lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
					lblNewLabel_2.setBounds(0, 86, 624, 379);
					lblNewLabel_2.setBackground(new Color(128, 128, 128));
					lblNewLabel_2.setVisible(false);
					Finale.getContentPane().add(lblNewLabel_2);
					
					JLabel	sfondod1 = new JLabel("");
					sfondod1.setBounds(0, 102, 624, 363);
					sfondod1.setOpaque(true);
					sfondod1.setBackground(new Color(211, 211, 211));
					sfondod1.setVisible(true);
					
					
					JLabel txtComplimentiHaiFinito = new 		JLabel();
					txtComplimentiHaiFinito.setForeground(Color.YELLOW);
					txtComplimentiHaiFinito.setHorizontalAlignment(SwingConstants.CENTER);
					txtComplimentiHaiFinito.setBackground(Color.LIGHT_GRAY);
					txtComplimentiHaiFinito.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 19));
					txtComplimentiHaiFinito.setText("COMPLIMENTI HAI COMPLETATO IL GIOCO!");
					txtComplimentiHaiFinito.setBounds(0, 85, 624, 99);
					txtComplimentiHaiFinito.setVisible(true);
					Finale.getContentPane().add(txtComplimentiHaiFinito);
					Finale.getContentPane().add(sfondod1);
					
					JButton btnNewButton = new JButton("ATTESTATI");
					btnNewButton.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
					btnNewButton.setBounds(150, 459, 429, 141);
					Finale.getContentPane().add(btnNewButton);
					btnNewButton.setForeground(new Color(255, 255, 255));
					btnNewButton.setBackground(new Color(128, 128, 128));
					btnNewButton.setFont(new Font("Arial", Font.ITALIC, 18));
					btnNewButton.setBounds(362, 467, 238, 25);
					btnNewButton.setOpaque(true);
					
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("immaginiGioco"+File.separator+"attestati.jpg"));
					lblNewLabel.setBounds(0, -14, 644, 565);
					Finale.getContentPane().add(lblNewLabel);
					
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent corretta) {
							btnNewButton.setBackground (Color.green);
							Finale.setVisible(false);
							attestatiRicevuti.initialize();
							PartiMain.sonoInDomande = false;
							principale.start();
							gioco.musicaDomande.close();
							
						}
					});
					
					//fuochi d'artificio
					Timer timer = new Timer(300, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	lblNewLabel_1.setVisible(true);
			            	txtComplimentiHaiFinito.setVisible(true);
			            }
			        });
					
					new java.util.Timer().schedule(new TimerTask() {
						public void run() {
						lblNewLabel_1.setVisible(false);
						sfondod1.setVisible(true);
						lblNewLabel_2.setVisible(true);
						
						timer.stop();
						}
						},5000);
					
					
					
					Finale.setResizable(false);
					Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
					Dimension frameSize = Finale.getSize ();
					Finale.setLocation ((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);
					
				}
}