package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import partekatuak.MezuLeiho;
import partekatuak.UrrunekoInterfazea;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import java.awt.Dimension;
import java.awt.Color;

public class EI_AlarmaGaitu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JButton jButton = null;

	private boolean gaituta = false;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	private InputStream in;

	private AudioStream as;

	private AudioData ad;

	private ContinuousAudioDataStream cas;

	private EI_SegurtasunArduraduna jabea;

	private JLabel jLabel1 = null;

	/**
	 * @param owner
	 */
	public EI_AlarmaGaitu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
		this.jabea = owner;
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
			ad = as.getData();
			cas = new ContinuousAudioDataStream(ad);
		} catch (FileNotFoundException e) {
			new MezuLeiho("Alarmaren soinua duen Fitxategia ez da aurkitu",
					"Ados", "Alarma soinua ez dago", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			new MezuLeiho("IO");
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
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 0;
			jLabel1 = new JLabel();
			jLabel1.setText("");
			jLabel1.setForeground(Color.red);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints1.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints.gridy = 1;
			jLabel = new JLabel();
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJButton(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints11);
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
			jButton.setPreferredSize(new Dimension(160, 20));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (!gaituta) {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//						 Use the static class member "player" from class
						// AudioPlayer to play
						// clip.
						AudioPlayer.player.start(cas);
						jButton.setText("Alarma Desgaitu");
						jLabel.setText("");
						jLabel.setIcon(new ImageIcon(getClass().getResource(
								"sirena.GIF")));
						jLabel1.setText("Alarma Gaitu Da!");
						try {
							urrunekoKud.irekiAteak();
							try {
								urrunekoKud.alarmaIntzidentziaSortu();
								new MezuLeiho("Ate guztiak ireki dira eta alarmaren intzidentzia sortu da", "Ados", "Alarma Gaitua", JOptionPane.INFORMATION_MESSAGE);
							} catch (SQLException e1) {
								new MezuLeiho("SQL","Ezin izan da alarmaren intzidentzia sortu");
								e1.printStackTrace();
							}
						} catch (RemoteException e1) {
							new MezuLeiho("REMOTE");
							e1.printStackTrace();
						} catch (IllegalStateException e1) {
							new MezuLeiho("DB");
							e1.printStackTrace();
						} catch (SQLException e1) {
							new MezuLeiho("SQL",
									"Ezin izan dira ateak ireki");
							e1.printStackTrace();
						}
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
						try {
							jabea.setTableModel(urrunekoKud.getIntzidentziak(),
									zutIzenak);
						} catch (IllegalStateException e1) {
							new MezuLeiho("DB");
							e1.printStackTrace();
						} catch (RemoteException e1) {
							new MezuLeiho("REMOTE");
							e1.printStackTrace();
						} catch (SQLException e1) {
							new MezuLeiho(
									"SQL",
									"Ezin izan dira intzidentziak hartu, eta ondoren ezin da gertakari taula eguneratu");
							e1.printStackTrace();
						}
					}

					else {
						try {
							try {
								urrunekoKud.ItxiAteak();
							} catch (SQLException e1) {
								new MezuLeiho("SQL",
										"Ezin izan dira ateak itxi");
								e1.printStackTrace();
							}
							urrunekoKud.pertsonakAteraEraikinetik();
						} catch (RemoteException e1) {
							new MezuLeiho("REMOTE");
							e1.printStackTrace();
						} catch (IllegalStateException e1) {
							new MezuLeiho("DB");
							e1.printStackTrace();
						} catch (SQLException e1) {
							new MezuLeiho("SQL",
									"Ezin da jakin zenbat pertsona dauden eraikinean");
							e1.printStackTrace();
						}
						jButton.setText("Alarma Gaitu");
						jLabel.setIcon(null);
						jLabel1.setText("");
						setEraikinekoPertsonKop();
						AudioPlayer.player.stop(cas);
						setDefaultCloseOperation(HIDE_ON_CLOSE);
						setVisible(false);
						new MezuLeiho("Alarma desgaitua izan da\n Ate guztiak itxi egin dira", "Ados",
								"Alarma Desgaitua",
								JOptionPane.INFORMATION_MESSAGE);
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
			new MezuLeiho("REMOTE");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			new MezuLeiho("DB");
			e.printStackTrace();
		} catch (SQLException e) {
			new MezuLeiho("SQL",
					"Ezin da jakin zenbat pertsona dauden eraikinean");
			e.printStackTrace();
		}
		jLabel.setText("Eraikinean dauden pertsonen kopurua: " + kop);
	}
}
