package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import partekatuak.MezuLehio;
import partekatuak.UrrunekoInterfazea;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.awt.Dimension;

public class EI_AlarmaGaitu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JButton jButton = null;
	
	private boolean gaituta=false;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:
	
	private InputStream in;
	
	private AudioStream as;
	
	private AudioData ad;
	
	
	private ContinuousAudioDataStream cas;
	
	private EI_SegurtasunArduraduna jabea;

	/**
	 * @param owner
	 */
	public EI_AlarmaGaitu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
		this.jabea= owner;
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
			try {
				in = new FileInputStream("alarm.wav");
			// Create an AudioStream object from the input stream.
				as = new AudioStream(in);
				ad= as.getData();
				cas= new ContinuousAudioDataStream(ad);
			} catch (FileNotFoundException e) {
				new MezuLehio("Alarmaren soinua duen Fitxategia ez da aurkitu","Ados","Alarma soinua ez dago",JOptionPane.ERROR_MESSAGE);
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				new MezuLehio("IO");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
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
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
						try {
								urrunekoKud.irekiAteak();
							} catch (RemoteException e1) {
								new MezuLehio("REMOTE");
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						try {
							urrunekoKud.alarmaIntzidentziaSortu();
							Vector<String> zutIzenak = new Vector<String>();
							zutIzenak.addElement("Erabiltzaile ID");
							zutIzenak.addElement("Data");
							zutIzenak.addElement("Larritasuna");
							zutIzenak.addElement("Mota");
							zutIzenak.addElement("Deskribapena");
							zutIzenak.addElement("Txartel Zenbakia");
							zutIzenak.addElement("Atea");
							zutIzenak.addElement("Txartel Irakurgailua");
							zutIzenak.addElement("Gaitua");
							zutIzenak.addElement("Noiztik Nora");
							jabea.setTableModel(urrunekoKud.getIntzidentziak(),
									zutIzenak);
						} catch (RemoteException e1) {
							new MezuLehio("REMOTE");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//Use the static class member "player" from class AudioPlayer to play
						// clip.
						AudioPlayer.player.start(cas);
						jButton.setText("Alarma Desgaitu");
						jLabel.setText("");
						jLabel.setIcon(new ImageIcon(getClass().getResource("sirena.GIF")));
					}
						
					else {
						try {
							urrunekoKud.ItxiAteak();
							urrunekoKud.pertsonakAteraEraikinetik();
						} catch (RemoteException e1) {
							new MezuLehio("REMOTE");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						jButton.setText("Alarma Gaitu");
						jLabel.setIcon(null);
						setEraikinekoPertsonKop();
						AudioPlayer.player.stop(cas);
						setDefaultCloseOperation(HIDE_ON_CLOSE);
						setVisible(false);
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
				new MezuLehio("REMOTE");
				e.printStackTrace();
			}
		jLabel.setText("Eraikinean dauden pertsonen kopurua: "+ kop);
	}
}
