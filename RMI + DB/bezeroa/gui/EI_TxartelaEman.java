package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import partekatuak.UrrunekoInterfazea;

/**
 * Erabiltzaile bati txartel bat esleitzea ahalbidetzen digun elkarrizketa leiho
 * bat.
 * 
 * @author 5. TALDEA
 * 
 */
public class EI_TxartelaEman extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JLabel jLabel1 = null;

	private JTextField jTextField1 = null;

	private JLabel jLabel2 = null;

	private JComboBox jComboBox = null;

	private JButton jButton = null;

	private JButton jButton1 = null;

	private JDialog bisitari;

	private JLabel jLabel3 = null;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	private JPasswordField jPasswordField = null;

	/**
	 * Elkarrizketa leihoa hasieratzen du.
	 * 
	 * @param arduraduna
	 */
	public EI_TxartelaEman(EI_SegurtasunArduraduna arduraduna) {
		super(arduraduna, true);
		bisitari = new EI_BisitariaTxartela(arduraduna);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(297, 192);
		this.setTitle("Txartela Eman");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints12.gridy = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.insets = new Insets(5, 5, 0, 10);
			gridBagConstraints12.gridwidth = 2;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.insets = new Insets(5, 10, 0, 5);
			gridBagConstraints11.gridy = 2;
			jLabel3 = new JLabel();
			jLabel3.setText("Pasahitza:");
			jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel3.setHorizontalTextPosition(SwingConstants.RIGHT);
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.insets = new Insets(5, 5, 5, 10);
			gridBagConstraints8.gridy = 4;
			gridBagConstraints8.ipadx = 0;
			gridBagConstraints8.ipady = 0;
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.weightx = 1.0D;
			gridBagConstraints8.gridx = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 4;
			gridBagConstraints7.ipadx = 0;
			gridBagConstraints7.ipady = 0;
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.weightx = 1.0D;
			gridBagConstraints7.gridwidth = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridheight = -1;
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.ipadx = -34;
			gridBagConstraints6.ipady = -10;
			gridBagConstraints6.gridwidth = -1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 3;
			gridBagConstraints5.ipadx = 0;
			gridBagConstraints5.ipady = 0;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(5, 5, 5, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(5, 10, 5, 5);
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.ipadx = 0;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(5, 5, 0, 10);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(5, 10, 0, 5);
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 1;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(5, 5, 0, 10);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(5, 10, 0, 5);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridx = 0;
			jLabel2 = new JLabel();
			jLabel2.setText("Profila:");
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel1 = new JLabel();
			jLabel1.setText("Izena:");
			jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel = new JLabel();
			jLabel.setText("NAN:");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints2);
			jContentPane.add(getJTextField1(), gridBagConstraints3);
			jContentPane.add(jLabel2, gridBagConstraints4);
			jContentPane.add(getJComboBox(), gridBagConstraints5);
			jContentPane.add(getJButton(), gridBagConstraints7);
			jContentPane.add(getJButton1(), gridBagConstraints8);
			jContentPane.add(new JButton(), gridBagConstraints6);
			jContentPane.add(jLabel3, gridBagConstraints11);
			jContentPane.add(getJPasswordField(), gridBagConstraints12);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
		}
		return jTextField1;
	}

	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(90, 85, 177, 25));
			jComboBox.addItem("Profil bat aukeratu");
			jComboBox.addItem("Bisitari");
			jComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED &&
				e.getItem().equals("Bisita") ){
				bisitari.setVisible(true);
				bisitari.pack();
				}
				}
				});
		}
		return jComboBox;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Ezeztatu");
			jButton.setPreferredSize(new Dimension(67, 25));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Sortu");
			jButton1.setBounds(new Rectangle(145, 127, 126, 26));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String nan = jTextField.getText();
						String izena = jTextField1.getText();
						String pasahitza = String.valueOf(jPasswordField
								.getPassword());
						// bisita bada zelan ein???
						int aukProf = urrunekoKud.profilZenbakia(jComboBox
								.getSelectedItem().toString());
						int bal = Integer.parseInt(nan);
						urrunekoKud.createErabiltzailea(bal, izena, pasahitza,
								aukProf);
						urrunekoKud.gaituTxartela(bal);
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

		}
		return jButton1;
	}

	/**
	 * This method initializes jPasswordField
	 * 
	 * @return javax.swing.JPasswordField
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
		}
		return jPasswordField;
	}

	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui) {
		this.urrunekoKud = ui;
	}

	public void profilakKargatu() {
		try {
			Vector<String> vProfilak = null;
			vProfilak = urrunekoKud.getProfilak();
			if (vProfilak.size() != 0) {
				for (String prof : vProfilak)
					jComboBox.addItem(prof);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} // @jve:decl-index=0:visual-constraint="10,10"
