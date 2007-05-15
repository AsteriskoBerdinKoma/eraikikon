package bezeroa.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import partekatuak.*;

public class EI_Jaurtitzailea extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8712125931329249252L;

	JPanel jPanel1 = new JPanel();

	JLabel jLabel1 = new JLabel();

	JTextField jTextField1 = new JTextField();

	JButton jButton1 = new JButton();

	JButton jButton2 = new JButton();

	EI_Identifikazioa a = new EI_Identifikazioa(); // @jve:decl-index=0:visual-constraint="343,10"

	public static final String zerbitzuIzena = "EraikiKon";

	private JScrollPane jScrollPane = null;

	private JTextArea jTextArea1 = null;

	public EI_Jaurtitzailea() {
		super();
		this.setLocationRelativeTo(null);
		try {
			jbInit();
		} catch (Exception e) {
			new MezuLeiho("Errore bat egon da","Ados","Errorea", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(null);
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.weighty = 1.0;
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.gridy = 3;
		gridBagConstraints5.gridwidth = 1;
		gridBagConstraints5.gridheight = 1;
		gridBagConstraints5.insets = new Insets(10, 10, 10, 10);
		gridBagConstraints5.weightx = 1.0;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.insets = new Insets(5, 10, 5, 10);
		gridBagConstraints3.gridy = 2;
		gridBagConstraints3.ipadx = 0;
		gridBagConstraints3.ipady = 0;
		gridBagConstraints3.gridx = 0;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
		gridBagConstraints2.gridy = 4;
		gridBagConstraints2.ipadx = 0;
		gridBagConstraints2.ipady = 0;
		gridBagConstraints2.gridx = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.ipadx = 0;
		gridBagConstraints1.ipady = 0;
		gridBagConstraints1.weightx = 0.0D;
		gridBagConstraints1.insets = new Insets(5, 10, 5, 10);
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 10, 5, 10);
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.gridx = 0;
		this.setSize(new Dimension(309, 291));
		this.setContentPane(jPanel1);
		jPanel1.setLayout(new GridBagLayout());
		jLabel1.setText("Negozio logika duen hostIzena:portua :");
		jTextField1.setText("localhost");
		jTextField1.setPreferredSize(new Dimension(250, 19));
		jButton1.setText("Aurkezpena egikaritu");
		jButton1.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});
		jButton2.setText("Negozioaren Logika esleitu");
		jButton2.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jButton2_actionPerformed(e);
			}
		});
		this.setTitle("Negozio Logika Aukeratu");
		jPanel1.add(jLabel1, gridBagConstraints);
		jPanel1.add(jTextField1, gridBagConstraints1);
		jPanel1.add(jButton1, gridBagConstraints2);
		jPanel1.add(jButton2, gridBagConstraints3);
		jPanel1.add(getJScrollPane(), gridBagConstraints5);
		// this.getContentPane().add(jPanel1, null);
	}

	void jButton1_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		a.setLocationRelativeTo(null);
		a.setVisible(true);
	}

	void jButton2_actionPerformed(ActionEvent e) {
		try {
			System.setProperty("java.security.policy", "client.policy");

			// Assingn security manager
			if (System.getSecurityManager() == null)
				System.setSecurityManager(new RMISecurityManager());
			UrrunekoInterfazea urrunekoObj;

			String host = jTextField1.getText();
			String zerbIzena = "rmi://" + host + "/" + zerbitzuIzena;
			// "rmi://IP_Helbidea:PortuZenb/ZerbitzuarenIzena"

			urrunekoObj = (UrrunekoInterfazea) Naming.lookup(zerbIzena);
			a.setNegozioLogika(urrunekoObj);
			jTextArea1.setText("Negozio logika esleitua\n");
		} catch (Exception ex) {
			jTextArea1.setText("Errorea negozio logika esleitzean\n");
			jTextArea1.append(ex.toString());
			new MezuLeiho("NegozioLogika");
		}
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTextArea1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea1
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
		}
		return jTextArea1;
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
		EI_Jaurtitzailea u = new EI_Jaurtitzailea();
		u.setVisible(true);
		u.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
} // @jve:decl-index=0:visual-constraint="10,10"

