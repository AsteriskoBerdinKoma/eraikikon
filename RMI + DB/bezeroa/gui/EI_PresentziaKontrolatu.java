package bezeroa.gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Insets;

public class EI_PresentziaKontrolatu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JLabel jLabel1 = null;

	private JComboBox jComboBox = null;

	private JComboBox jComboBox1 = null;

	private JComboBox jComboBox2 = null;

	private JLabel jLabel2 = null;

	private JComboBox jComboBox3 = null;

	private JComboBox jComboBox4 = null;

	private JComboBox jComboBox5 = null;

	private JButton jButton = null;

	private JLabel jLabel3 = null;

	private JLabel jLabel4 = null;

	private JComboBox jComboBox6 = null;

	private JComboBox jComboBox7 = null;

	private JComboBox jComboBox9 = null;

	private JComboBox jComboBox10 = null;

	private JComboBox jComboBox11 = null;

	private JComboBox jComboBox12 = null;

	/**
	 * @param owner
	 */
	public EI_PresentziaKontrolatu(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(463, 257);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints18.gridy = 2;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.gridx = 7;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints17.gridy = 1;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.gridx = 7;
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints16.gridy = 2;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.gridx = 6;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints15.gridy = 1;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.gridx = 6;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints14.gridy = 2;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridx = 5;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints13.gridy = 1;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.gridx = 5;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 4;
			gridBagConstraints12.anchor = GridBagConstraints.EAST;
			gridBagConstraints12.gridy = 2;
			jLabel4 = new JLabel();
			jLabel4.setText("Bukaera Ordua:");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 4;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.gridy = 1;
			jLabel3 = new JLabel();
			jLabel3.setText("Bukaera Eguna:");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 4;
			gridBagConstraints10.gridy = 3;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints9.gridy = 2;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 3;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints8.gridy = 2;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.gridx = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints7.gridy = 2;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("Hasierako Ordua:");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints5.gridy = 1;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.gridx = 3;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridx = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Hasierako Eguna:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridwidth = 3;
			gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Txartel Kodea:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints2);
			jContentPane.add(getJComboBox(), gridBagConstraints3);
			jContentPane.add(getJComboBox1(), gridBagConstraints4);
			jContentPane.add(getJComboBox2(), gridBagConstraints5);
			jContentPane.add(jLabel2, gridBagConstraints6);
			jContentPane.add(getJComboBox3(), gridBagConstraints7);
			jContentPane.add(getJComboBox4(), gridBagConstraints8);
			jContentPane.add(getJComboBox5(), gridBagConstraints9);
			jContentPane.add(getJButton(), gridBagConstraints10);
			jContentPane.add(jLabel3, gridBagConstraints11);
			jContentPane.add(jLabel4, gridBagConstraints12);
			jContentPane.add(getJComboBox6(), gridBagConstraints13);
			jContentPane.add(getJComboBox7(), gridBagConstraints14);
			jContentPane.add(getJComboBox9(), gridBagConstraints15);
			jContentPane.add(getJComboBox10(), gridBagConstraints16);
			jContentPane.add(getJComboBox11(), gridBagConstraints17);
			jContentPane.add(getJComboBox12(), gridBagConstraints18);
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
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
		}
		return jComboBox;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
		}
		return jComboBox1;
	}

	/**
	 * This method initializes jComboBox2	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
		}
		return jComboBox2;
	}

	/**
	 * This method initializes jComboBox3	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox3() {
		if (jComboBox3 == null) {
			jComboBox3 = new JComboBox();
		}
		return jComboBox3;
	}

	/**
	 * This method initializes jComboBox4	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox4() {
		if (jComboBox4 == null) {
			jComboBox4 = new JComboBox();
		}
		return jComboBox4;
	}

	/**
	 * This method initializes jComboBox5	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox5() {
		if (jComboBox5 == null) {
			jComboBox5 = new JComboBox();
		}
		return jComboBox5;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Bilatu");
		}
		return jButton;
	}

	/**
	 * This method initializes jComboBox6	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox6() {
		if (jComboBox6 == null) {
			jComboBox6 = new JComboBox();
		}
		return jComboBox6;
	}

	/**
	 * This method initializes jComboBox7	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox7() {
		if (jComboBox7 == null) {
			jComboBox7 = new JComboBox();
		}
		return jComboBox7;
	}

	/**
	 * This method initializes jComboBox9	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox9() {
		if (jComboBox9 == null) {
			jComboBox9 = new JComboBox();
		}
		return jComboBox9;
	}

	/**
	 * This method initializes jComboBox10	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox10() {
		if (jComboBox10 == null) {
			jComboBox10 = new JComboBox();
		}
		return jComboBox10;
	}

	/**
	 * This method initializes jComboBox11	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox11() {
		if (jComboBox11 == null) {
			jComboBox11 = new JComboBox();
		}
		return jComboBox11;
	}

	/**
	 * This method initializes jComboBox12	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox12() {
		if (jComboBox12 == null) {
			jComboBox12 = new JComboBox();
		}
		return jComboBox12;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
