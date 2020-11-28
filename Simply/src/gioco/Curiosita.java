package gioco;

import java.awt.Color;    
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class Curiosita{
	static scriviFileleggiFileAggiornamentoPosizione g = new scriviFileleggiFileAggiornamentoPosizione();
	static boolean rispostaCorretta;
		
	public static void cur() throws IOException {
		Lettore Lettore = new Lettore();
		String laRisp = Lettore.laRispSbagliataEra(Domandee.posizioneFrame);
		String curiosita = Lettore.letturaDellaCuriosita(Domandee.posizioneFrame);
		
		JFrame curiosita1 = new JFrame();
		curiosita1.setBounds(700, 700, 650, 600);
		curiosita1.getContentPane().setLayout(null);
		curiosita1.setVisible(true);
			
		Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = curiosita1.getSize ();
		curiosita1.setLocation ((screenSize.width - frameSize.width) / 2,
		(screenSize.height - frameSize.height) / 2);
		
		JLabel lblNewLabel_1 = new JLabel("");
    	lblNewLabel_1.setBounds(157, 27, 312, 214);
    	JLabel txtrRispostaCorretta = new JLabel();
    	
    	if (rispostaCorretta == false) {
    	lblNewLabel_1.setIcon(new ImageIcon("immaginiGioco"+ File.separator  + "tristeno (1) (1) (1).gif"));
    	curiosita1.getContentPane().add(lblNewLabel_1);
    	
    	JLabel lblNewLabel = new JLabel(laRisp);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(110, 106, 407, 57);
		curiosita1.getContentPane().add(lblNewLabel);
		
		txtrRispostaCorretta.setForeground(new Color(0, 0, 0));
		txtrRispostaCorretta.setText("              RISPOSTA SBAGLIATA");
		txtrRispostaCorretta.setBackground(Color.RED);
		
		g.openFile();
		g.RispostaErrata();
		g.chiudi();
    	}
    	
    	else {
    	lblNewLabel_1.setIcon(new ImageIcon("immaginiGioco" + File.separator  + "felice1.gif"));	
    	curiosita1.getContentPane().add(lblNewLabel_1);
    	
    	txtrRispostaCorretta.setForeground(new Color(0, 0, 0));
		txtrRispostaCorretta.setText("              RISPOSTA CORRETTA");
		txtrRispostaCorretta.setBackground(Color.GREEN);
		
		g.openFile();
		g.RispostaEsatta();
		g.chiudi();
    	}
    	
    	
    			
		Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("gif");
            	lblNewLabel_1.setVisible(true);
            }
        });
		
		new java.util.Timer().schedule(new TimerTask() {
			public void run() {
			lblNewLabel_1.setVisible(false);
			timer.stop();
			}
			},2000);

		txtrRispostaCorretta.setOpaque(true);
		txtrRispostaCorretta.setFont(new Font("Arial", Font.PLAIN, 21));
		txtrRispostaCorretta.setBounds(110, 60, 407, 29);
		curiosita1.getContentPane().add(txtrRispostaCorretta);
		
		JButton btnNewButton = new JButton("CONTINUA");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 19));
		btnNewButton.setBounds(0, 508, 644, 57);
		btnNewButton.setBackground(Color.GRAY);
		curiosita1.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent corretta) {
					gioco.Domandee.domande.setVisible(false);
					curiosita1.setVisible(false);
					try {
						gioco.Domandee.FrameVisible();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		});	
	
		JLabel fattoDivertente1 = new JLabel();
		fattoDivertente1.setBounds(30, 202, 577, 270);
		curiosita1.getContentPane().add(fattoDivertente1);
		fattoDivertente1.setForeground(Color.BLACK);
		fattoDivertente1.setFont(new Font("Arial", Font.PLAIN, 18));
		fattoDivertente1.setBackground(Color.LIGHT_GRAY);
		fattoDivertente1.setText(curiosita);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setAutoscrolls(true);
		panel.setBounds(0, 0, 644, 565);
		curiosita1.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		curiosita1.setResizable(true);
		curiosita1.isOpaque();
		curiosita1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}