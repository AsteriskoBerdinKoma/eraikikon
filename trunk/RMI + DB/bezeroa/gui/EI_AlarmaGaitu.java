package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import partekatuak.UrrunekoInterfazea;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.Dimension;

public class EI_AlarmaGaitu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JButton jButton = null;
	
	private boolean gaituta=false;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	/**
	 * @param owner
	 */
	public EI_AlarmaGaitu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 230);
		this.setTitle("Alarma Gaitu");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints1.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJButton(), gridBagConstraints1);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Alarma Gaitu");
			jButton.setPreferredSize(new Dimension(115, 20));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!gaituta){
						try {
							urrunekoKud.irekiAteak();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						/*try {
							urrunekoKud.alarmaIntzidentziaSortu();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}*/
						jButton.setText("Alarma Desgaitu");
						jLabel.setText("");
						jLabel.setIcon(new ImageIcon(getClass().getResource("sirena.GIF")));
						InputStream in;
						try {
							in = new FileInputStream("alarm.wav");
							// Create an AudioStream object from the input stream.
						AudioStream as = new AudioStream(in);         
						// Use the static class member "player" from class AudioPlayer to play
						// clip.
						AudioPlayer.player.start(as);
						// Similarly, to stop the audio.
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}	
					}
					else {
						try {
							urrunekoKud.ItxiAteak();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						jButton.setText("Alarma Gaitu");
						jLabel.setIcon(null);
						setEraikinekoPertsonKop();
					}
					gaituta = !gaituta;
				}
			});
		}
		return jButton;
	}

	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui) {
		this.urrunekoKud = ui;
	}

	public void setEraikinekoPertsonKop() {
		int kop = 0;
			try {
				kop = urrunekoKud.getEraikinekoPertsonKop();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		jLabel.setText("Eraikinean dauden pertsonen kopurua: "+ kop);
	}
}
