package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 5. Taldea
 *
 */
public class EI_ZerbitzariaEsleitu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JButton jButton = null;
	
	private EI_Identifikazioa jabea = null;
	
	/**
	 * Metodo eraikitzailea. Elkarrizketa leihoa modu modalean hasieratuko da.
	 * 
	 * @param owner Elkarrizketa leihoaren jabea.
	 */
	public EI_ZerbitzariaEsleitu(EI_Identifikazioa owner) {
		super(owner, true);
		this.jabea = owner;
		this.pack();
		this.setLocationRelativeTo(null);
		initialize();
		this.getRootPane().setDefaultButton(this.getJButton());
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(258, 177);
		this.setTitle("Zerbitzaria Aldatu");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(5, 10, 10, 10);
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Negozio logika duen hostIzena:portua :");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(getJButton(), gridBagConstraints2);
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
	 * Pasatutako helbidea testu eremuari esleitzen dio.
	 *  
	 * @param helbidea ip edo host izena adierazten duen String bat.
	 */
	public void setHostFieldText(String helbidea)
	{
		this.jTextField.setText(helbidea);
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Konexioa Ezarri");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jabea.setHost(jTextField.getText());
					jabea.setNegozioLogika();
					setVisible(false);
				}
			});
		}
		return jButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
