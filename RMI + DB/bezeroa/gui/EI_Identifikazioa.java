package bezeroa.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import partekatuak.MezuLeiho;
import partekatuak.UrrunekoInterfazea;
import sun.misc.BASE64Encoder;

public class EI_Identifikazioa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3372486190912554562L;

	BorderLayout borderLayout1 = new BorderLayout(); // @jve:decl-index=0:

	JPanel jPanel1 = new JPanel();

	JLabel jLabel1 = new JLabel();

	JLabel jLabel2 = new JLabel();

	JTextField jTextField1 = new JTextField();

	JPasswordField jPasswordField1 = new JPasswordField();

	JButton jButton1 = new JButton();

	UrrunekoInterfazea urrunekoKud;

	JLabel jLabel3 = new JLabel();
	
	private EI_SegurtasunArduraduna segArd;
	
	private EI_ZerbitzariaEsleitu zerbEsl = new EI_ZerbitzariaEsleitu(this); 

	private JLabel jLabel = null;

	private JButton jButton = null;

	private JPanel jPanel = null;

	private JLabel jLabel4 = null;

	public static final String zerbitzuIzena = "EraikiKon";
	
	private JToggleButton jToggleButton = null;

	private String host = "localhost";  //  @jve:decl-index=0:

	public EI_Identifikazioa() {
		super();
		System.setProperty("java.security.policy", "client.policy");
		try {
			jbInit();
			this.setLocationRelativeTo(null);
			this.getRootPane().setDefaultButton(this.getJButton1());
			this.setNegozioLogika();
		} catch (Exception e) {
			new MezuLeiho("Errorea identifikazio egiterakoan","Ados","Identifikazio Errorea", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(borderLayout1);
		GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
		gridBagConstraints61.gridx = 1;
		gridBagConstraints61.anchor = GridBagConstraints.WEST;
		gridBagConstraints61.insets = new Insets(0, 10, 0, 0);
		gridBagConstraints61.gridy = 4;
		GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
		gridBagConstraints51.gridx = 0;
		gridBagConstraints51.gridwidth = 4;
		gridBagConstraints51.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints51.weightx = 1.0D;
		gridBagConstraints51.gridy = 5;
		jLabel = new JLabel();
		jLabel.setText("Zerbitzaria:");
		jLabel3.setPreferredSize(new Dimension(148, 15));
		jTextField1.setPreferredSize(new Dimension(100, 20));
		jPasswordField1.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.insets = new Insets(5, 10, 10, 10);
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.gridy = 3;
		gridBagConstraints5.ipadx = 0;
		gridBagConstraints5.ipady = 0;
		gridBagConstraints5.anchor = GridBagConstraints.WEST;
		gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints5.gridwidth = 3;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.insets = new Insets(5, 10, 10, 10);
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.gridy = 2;
		gridBagConstraints4.ipadx = 0;
		gridBagConstraints4.ipady = 0;
		gridBagConstraints4.gridwidth = 3;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridx = 2;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.ipadx = 0;
		gridBagConstraints3.ipady = 0;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.insets = new Insets(10, 5, 10, 5);
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.gridx = 2;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.ipadx = 0;
		gridBagConstraints2.ipady = 0;
		gridBagConstraints2.weightx = 0.0D;
		gridBagConstraints2.insets = new Insets(10, 5, 10, 5);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.insets = new Insets(10, 10, 5, 5);
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.ipadx = 0;
		gridBagConstraints1.ipady = 0;
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.gridwidth = 2;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridx = 0;
		this.setSize(new Dimension(330, 201));
		this.setContentPane(jPanel1);
		jLabel1.setText("NAN Zenbakia:");
		jLabel1.setPreferredSize(new Dimension(100, 16));
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
		jButton1.setText("Sisteman Sartu");
		jButton1.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});
		jLabel2.setText("Pasahitza:");
		jLabel2.setPreferredSize(new Dimension(70, 15));
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jPanel1.setLayout(new GridBagLayout());
		this.setTitle("Identifikazioa");
		jPanel1.add(jLabel2, gridBagConstraints);
		jPanel1.add(jLabel1, gridBagConstraints1);
		jPanel1.add(jTextField1, gridBagConstraints2);
		jPanel1.add(jPasswordField1, gridBagConstraints3);
		jPanel1.add(jButton1, gridBagConstraints4);
		jPanel1.add(jLabel3, gridBagConstraints5);
		jPanel1.add(getJPanel(), gridBagConstraints51);
		jPanel1.add(getJToggleButton(), gridBagConstraints61);
	}

	public JButton getJButton1(){
		return jButton1;
	}
	
	public void setNegozioLogika() {
		try {
			// Assingn security manager
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());

			String zerbIzena = "rmi://" + host  + "/" + zerbitzuIzena;
			// "rmi://IP_Helbidea:PortuZenb/ZerbitzuarenIzena"

			urrunekoKud = (UrrunekoInterfazea) Naming.lookup(zerbIzena);
			jButton1.setEnabled(true);
			jLabel4.setForeground(Color.GREEN);
			jLabel4.setText(host);
			jLabel3.setText("");
			new MezuLeiho(
					"Zerbitzariarekin konexioa ondo ezarri da",
					"Ados", "Konexioa ezarria",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (ConnectException ex) {
			jButton1.setEnabled(false);
			jLabel4.setForeground(Color.RED);
			jLabel4.setText("Ez dago konexiorik zerbitzariarekin");
			jLabel3.setForeground(Color.RED);
			jLabel3.setText("NEGOZIO LOGIKAREKIN ARAZOAK DAUDE");
			new MezuLeiho(
					"Ezin izan da zerbitzariarekin konexioa ezarri. Egiaztatu adierazitako \n helbidean zerbitzaria martxan dagoela.",
					"Ados", "Errorea konexioa ezartzean",
					JOptionPane.ERROR_MESSAGE);
		} catch (UnknownHostException ex) {
			jButton1.setEnabled(false);
			jLabel4.setForeground(Color.RED);
			jLabel4.setText("Ez dago konexiorik zerbitzariarekin");
			jLabel3.setForeground(Color.RED);
			jLabel3.setText("NEGOZIO LOGIKAREKIN ARAZOAK DAUDE");
			new MezuLeiho("ZerbitzariEzezaguna");
		} catch (Exception ex) {
			jButton1.setEnabled(false);
			jLabel4.setForeground(Color.RED);
			jLabel4.setText("Ez dago konexiorik zerbitzariarekin");
			jLabel3.setForeground(Color.RED);
			jLabel3.setText("NEGOZIO LOGIKAREKIN ARAZOAK DAUDE");
			new MezuLeiho("Errore ezezagun bat suertatu da", "Ados",
					"Errore ezezaguna", JOptionPane.ERROR_MESSAGE);
		}
		this.pack();
	}

	void jButton1_actionPerformed(ActionEvent e) {
		try {
			int nan = Integer.parseInt(jTextField1.getText());
			String pasahitza = kodetu(String.valueOf(jPasswordField1.getPassword()));
			if (!pasahitza.equals("")) {
				if (urrunekoKud.loginEgin(nan, pasahitza) == 3) {
					jLabel3.setForeground(Color.GREEN);
					jLabel3.setText("AURRERA");
					segArd = new EI_SegurtasunArduraduna(urrunekoKud);
					this.setVisible(false);
					segArd.setLocationRelativeTo(null);
					segArd.setVisible(true);
				} else {
					new MezuLeiho("Ez duzu sartzeko baimenik","Ados","Baimenik Ez",JOptionPane.ERROR_MESSAGE);
					jLabel3.setForeground(Color.RED);
					jLabel3.setText("EZ DUZU SARTZEKO BAIMENIK");
				}
			}
			else {
				new MezuLeiho("Ez duzu sartzeko baimenik","Ados","Baimenik Ez",JOptionPane.ERROR_MESSAGE);
				jLabel3.setForeground(Color.RED);
				jLabel3.setText("EZ DUZU SARTZEKO BAIMENIK");
			}
		} catch (NumberFormatException ex) {
			new MezuLeiho("Ez duzu sartzeko baimenik","Ados","Baimenik Ez",JOptionPane.ERROR_MESSAGE);
			jLabel3.setForeground(Color.RED);
			jLabel3.setText("EZ DUZU SARTZEKO BAIMENIK");
		} catch (Exception ex) {
			new MezuLeiho("Negozio Logikarekin Arazoak Daude","Ados","Negozio Logika Erroreak",JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
			jLabel3.setForeground(Color.RED);
			jLabel3.setText("NEGOZIO LOGIKAREKIN ARAZOAK DAUDE");
		}
	}
	
	public String kodetu (String testusoila){
	    MessageDigest md = null;
	    try
	    {
	      md = MessageDigest.getInstance("SHA"); //2. pausua
	      md.update(testusoila.getBytes("UTF-8")); //3. pausua
	    }catch(NoSuchAlgorithmException e){
	    	new MezuLeiho("Ez da zifraketa algoritmoa aurkitu","Ados","Zifraketa Arazoa",JOptionPane.ERROR_MESSAGE);
	    	e.printStackTrace();
	    }catch(UnsupportedEncodingException e){
	    	new MezuLeiho("Errorea kodetzerakoan","Ados","Kodeketa Errorea",JOptionPane.ERROR_MESSAGE);
	      e.printStackTrace();
	    }
	    byte raw[] = md.digest(); //4. pausua
	    String hash = (new BASE64Encoder()).encode(raw); //5. pausua
	    return hash; //6. pausua
	  }

	public String getHost()
	{
		return this.host;
	}
	
	public void setHost(String helbidea)
	{
		this.host = helbidea;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Aldatu");
			jButton.setPreferredSize(new Dimension(75, 15));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					zerbEsl.setHostFieldText(host);
					zerbEsl.setVisible(true);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.insets = new Insets(5, 10, 10, 0);
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridx = 0;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.insets = new Insets(0, 0, 5, 10);
			gridBagConstraints10.gridy = 0;
			gridBagConstraints10.weightx = 1.0D;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.insets = new Insets(0, 10, 5, 5);
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.anchor = GridBagConstraints.EAST;
			gridBagConstraints9.gridx = 0;
			jLabel4 = new JLabel();
			jLabel4.setText("");
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridy = 0;
			gridBagConstraints8.insets = new Insets(5, 10, 5, 5);
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.anchor = GridBagConstraints.EAST;
			gridBagConstraints7.gridwidth = 2;
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.insets = new Insets(5, 10, 0, 0);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.gridx = -1;
			gridBagConstraints6.gridy = -1;
			gridBagConstraints6.insets = new Insets(0, 10, 0, 0);
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(SystemColor.inactiveCaption, 5), "Zerbitzariaren Aukerak", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.setVisible(false);
			jPanel.add(jLabel, gridBagConstraints9);
			jPanel.add(jLabel4, gridBagConstraints10);
			jPanel.add(getJButton(), gridBagConstraints11);
		}
		return jPanel;
	}

	/**
	 * This method initializes jToggleButton	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton() {
		if (jToggleButton == null) {
			jToggleButton = new JToggleButton();
			jToggleButton.setText("...");
			jToggleButton.setFont(new Font("Dialog", Font.PLAIN, 12));
			jToggleButton.setPreferredSize(new Dimension(41, 15));
			jToggleButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jPanel.setVisible(!jPanel.isVisible());
					pack();
				}
			});
		}
		return jToggleButton;
	}
	
	/**
	 * Main metodoa. Interfaze grafikoa egikaritzeko erabiltzen da. Interfazea
	 * ixterakoan egin beharreko ekintzak definitzen ditu.
	 * 
	 * @param args
	 *            Aplikazioa komando lerrotik jaurtitzean, beharrezkoak diren
	 *            parametroak (behar balitu) jasotzeko Array bat da.
	 */
	public static void main(String[] args) {
		EI_Identifikazioa ident = new EI_Identifikazioa();
		ident.setVisible(true);
		ident.pack();
		ident.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
