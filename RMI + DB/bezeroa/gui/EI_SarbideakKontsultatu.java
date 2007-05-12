package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import partekatuak.UrrunekoInterfazea;

public class EI_SarbideakKontsultatu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:
	private DefaultTableModel tableModel;
	private EI_SegurtasunArduraduna jabea;

	private DateComboBox jDateComboBox = null;

	private JLabel jLabel = null;

	private JButton jButton = null;

	private JTable jTable = null;

	private JScrollPane jScrollPane1 = null;

	private JList jList = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable1 = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	/**
	 * @param owner
	 */
	public EI_SarbideakKontsultatu(EI_SegurtasunArduraduna owner) {
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
		this.setSize(557, 300);
		this.setTitle("Sarbide-Eskaerak Kontsultatu");
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
			gridBagConstraints18.gridx = 2;
			gridBagConstraints18.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints18.gridy = 1;
			jLabel2 = new JLabel();
			jLabel2.setText("Ateko sarbide-eskaerak: ");
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints17.anchor = GridBagConstraints.WEST;
			gridBagConstraints17.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Ateak: ");
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 2;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.weighty = 1.0;
			gridBagConstraints16.gridwidth = 3;
			gridBagConstraints16.insets = new Insets(5, 10, 10, 10);
			gridBagConstraints16.gridx = 1;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			gridBagConstraints13.gridy = 2;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.insets = new Insets(5, 10, 10, 10);
			gridBagConstraints13.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 3;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints4.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("datako Sarbide-eskerak");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(10, 10, 5, 5);
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.gridx = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJDateComboBox(), gridBagConstraints1);
			jContentPane.add(jLabel, gridBagConstraints4);
			jContentPane.add(getJButton(), gridBagConstraints);
			jContentPane.add(getJScrollPane1(), gridBagConstraints13);
			jContentPane.add(getJScrollPane(), gridBagConstraints16);
			jContentPane.add(jLabel1, gridBagConstraints17);
			jContentPane.add(jLabel2, gridBagConstraints18);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private DateComboBox getJDateComboBox() {
		if (jDateComboBox == null) {
			jDateComboBox = new DateComboBox();
		}
		return jDateComboBox;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Kontsultatu");
		}
		return jButton;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
		}
		return jTable;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJList());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList();
		}
		return jList;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable1	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
		}
		return jTable1;
	}

}  //  @jve:decl-index=0:visual-constraint="182,31"
