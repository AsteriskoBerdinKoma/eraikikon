package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EI_TxartelaDialog extends JDialog {

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
	
	private JDialog bisitari ;
	/**
	 * This is the default constructor
	 * @param arduraduna 
	 */
	public EI_TxartelaDialog(EI_SegurtasunArduraduna arduraduna) {
		super(arduraduna,true);
		bisitari = new EI_BisitariaTxartela(arduraduna);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(249, 163);
		this.setTitle("Txartela");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.insets = new Insets(5, 5, 5, 10);
			gridBagConstraints8.gridy = 3;
			gridBagConstraints8.ipadx = 0;
			gridBagConstraints8.ipady = 0;
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridx = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 3;
			gridBagConstraints7.ipadx = 0;
			gridBagConstraints7.ipady = 0;
			gridBagConstraints7.fill = GridBagConstraints.BOTH;
			gridBagConstraints7.gridwidth = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridheight = -1;
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.ipadx = -34;
			gridBagConstraints6.ipady = -10;
			gridBagConstraints6.gridwidth = -1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.ipadx = 0;
			gridBagConstraints5.ipady = 0;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(5, 5, 5, 10);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(5, 10, 5, 5);
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.ipadx = 0;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(5, 5, 5, 10);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(5, 10, 5, 5);
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 1;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridwidth = 2;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 10);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(5, 10, 5, 5);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.ipady = 0;
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridx = 0;
			jLabel2 = new JLabel();
			jLabel2.setText("Profila:");
			jLabel1 = new JLabel();
			jLabel1.setText("Izena:");
			jLabel = new JLabel();
			jLabel.setText("NAN:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints2);
			jContentPane.add(getJTextField1(), gridBagConstraints3);
			jContentPane.add(jLabel2, gridBagConstraints4);
			jContentPane.add(getJComboBox(), gridBagConstraints5);
			jContentPane.add(new JButton(), gridBagConstraints6);
			jContentPane.add(getJButton(), gridBagConstraints7);
			jContentPane.add(getJButton1(), gridBagConstraints8);
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
		Vector<String> itemNames = new Vector<String>();
		itemNames.addElement("Irakasleak");
		itemNames.addElement("Bisitak");
		itemNames.addElement("Ikasleak");
		itemNames.addElement("Arduraduna");
		if (jComboBox == null) {
			jComboBox = new JComboBox(itemNames);
			jComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED &&
							e.getItem().equals("Bisitak") ){
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
		}
		return jButton1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
