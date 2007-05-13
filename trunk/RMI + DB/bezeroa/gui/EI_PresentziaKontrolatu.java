package bezeroa.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import partekatuak.UrrunekoInterfazea;

public class EI_PresentziaKontrolatu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JButton jButton = null;

	private JLabel jLabel3 = null;

	private JLabel jLabel4 = null;

	private JSpinner hasOrd = null;

	private JSpinner bukOrd = null;

	private JSpinner hasMin = null;

	private JSpinner bukMin = null;

	private DateComboBox dataComboBox = null;

	private DateComboBox dataComboBox1 = null;

	private JLabel jLabel7 = null;

	private JLabel jLabel8 = null;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	private JScrollPane jScrollPane = null;

	private JTable jTable = null;

	private Calendar cal = new GregorianCalendar(); // @jve:decl-index=0:

	private DefaultTableModel tableModel;

	private JLabel jLabel5 = null;

	/**
	 * @param arduraduna
	 */
	public EI_PresentziaKontrolatu(EI_SegurtasunArduraduna arduraduna) {
		super(arduraduna, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(460, 302);
		this.setTitle("Presentzia Kontrolatu");
		this.setContentPane(getJContentPane());
		cal.setTime(new Date());
		hasOrd.setValue(cal.get(Calendar.HOUR_OF_DAY));
		bukOrd.setValue(cal.get(Calendar.HOUR_OF_DAY));
		hasMin.setValue(cal.get(Calendar.MINUTE));
		bukMin.setValue(cal.get(Calendar.MINUTE));
		Vector<Object> zutIzen = new Vector<Object>();
		zutIzen.addElement("Gunearen IDa");
		zutIzen.addElement("Gunearen Izena");
		zutIzen.addElement("Data eta Ordua");
		tableModel.setDataVector(null, zutIzen);
		tableModel.fireTableStructureChanged();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.gridwidth = 6;
			gridBagConstraints15.anchor = GridBagConstraints.WEST;
			gridBagConstraints15.insets = new Insets(10, 10, 5, 10);
			gridBagConstraints15.gridy = 3;
			jLabel5 = new JLabel();
			jLabel5.setText("");
			jLabel5.setPreferredSize(new Dimension(0, 20));
			jLabel5.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 4;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.weighty = 1.0;
			gridBagConstraints14.gridwidth = 3;
			gridBagConstraints14.insets = new Insets(5, 10, 5, 0);
			gridBagConstraints14.gridheight = 2;
			gridBagConstraints14.gridx = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 5;
			gridBagConstraints8.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.ipadx = 10;
			gridBagConstraints8.gridy = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 5;
			gridBagConstraints7.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.ipadx = 10;
			gridBagConstraints7.gridy = 1;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 4;
			gridBagConstraints61.insets = new Insets(0, 2, 0, 2);
			gridBagConstraints61.gridy = 2;
			jLabel8 = new JLabel();
			jLabel8.setText(":");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 4;
			gridBagConstraints5.insets = new Insets(0, 2, 0, 2);
			gridBagConstraints5.gridy = 1;
			jLabel7 = new JLabel();
			jLabel7.setText(":");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 3;
			gridBagConstraints4.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.ipadx = 10;
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 3;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.ipadx = 10;
			gridBagConstraints3.gridy = 1;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints21.ipadx = 0;
			gridBagConstraints21.ipady = -5;
			gridBagConstraints21.weightx = 1.0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			gridBagConstraints13.gridy = 1;
			gridBagConstraints13.weightx = 1.0;
			gridBagConstraints13.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints13.ipady = -5;
			gridBagConstraints13.gridx = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 2;
			gridBagConstraints12.anchor = GridBagConstraints.EAST;
			gridBagConstraints12.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints12.gridy = 2;
			jLabel4 = new JLabel();
			jLabel4.setText("Bukaera Ordua:");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints11.gridy = 2;
			jLabel3 = new JLabel();
			jLabel3.setText("Bukaera Eguna:");
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 3;
			gridBagConstraints10.gridwidth = 3;
			gridBagConstraints10.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.ipadx = 0;
			gridBagConstraints10.ipady = -5;
			gridBagConstraints10.gridy = 4;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 2;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints6.gridy = 1;
			jLabel2 = new JLabel();
			jLabel2.setText("Hasierako Ordua:");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints2.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText("Hasierako Eguna:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.insets = new Insets(10, 5, 5, 5);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Txartel Kodea:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(jLabel1, gridBagConstraints2);
			jContentPane.add(jLabel2, gridBagConstraints6);
			jContentPane.add(getJButton(), gridBagConstraints10);
			jContentPane.add(jLabel3, gridBagConstraints11);
			jContentPane.add(jLabel4, gridBagConstraints12);
			jContentPane.add(getdataComboBox(), gridBagConstraints13);
			jContentPane.add(getDataComboBox1(), gridBagConstraints21);
			jContentPane.add(gethasOrd(), gridBagConstraints3);
			jContentPane.add(getbukOrd(), gridBagConstraints4);
			jContentPane.add(jLabel7, gridBagConstraints5);
			jContentPane.add(jLabel8, gridBagConstraints61);
			jContentPane.add(gethasMin(), gridBagConstraints7);
			jContentPane.add(getbukMin(), gridBagConstraints8);
			jContentPane.add(getJScrollPane(), gridBagConstraints14);
			jContentPane.add(jLabel5, gridBagConstraints15);
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
			jTextField.setText("");
		}
		return jTextField;
	}

	private JSpinner gethasOrd() {
		if (hasOrd == null) {
			hasOrd = new JSpinner();
			hasOrd.setPreferredSize(new Dimension(40, 20));
		}
		return hasOrd;
	}

	private JSpinner getbukOrd() {
		if (bukOrd == null) {
			bukOrd = new JSpinner();
			bukOrd.setPreferredSize(new Dimension(40, 20));
		}
		return bukOrd;
	}

	private JSpinner gethasMin() {
		if (hasMin == null) {
			hasMin = new JSpinner();
			hasMin.setPreferredSize(new Dimension(40, 20));
		}
		return hasMin;
	}

	private JSpinner getbukMin() {
		if (bukMin == null) {
			bukMin = new JSpinner();
			bukMin.setPreferredSize(new Dimension(40, 20));
		}
		return bukMin;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Erakutsi");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String hasData = dataComboBox.getSelectedItem()
								.toString().replace('/', '-');
						String bukData = dataComboBox1.getSelectedItem()
								.toString().replace('/', '-');
						String hasOrdu = hasOrd.getValue().toString() + ":"
								+ hasMin.getValue().toString();
						String bukOrdu = bukOrd.getValue().toString() + ":"
								+ bukMin.getValue().toString();
						int txId;
						try {
							txId = Integer.parseInt(jTextField.getText());
						} catch (NumberFormatException ex) {
							txId = -1;
						}
						String erabIzen = urrunekoKud.getErabIzena(txId);
						if (erabIzen != null)
							jLabel5.setText(erabIzen + " erabiltzaileak zeharkatu dituen guneak.");
						else
							jLabel5.setText("Ez dago txartel hori dagokion erabiltzailerik.");
						taulaEguneratu(txId, hasData, bukData, hasOrdu, bukOrdu);
					} catch (RemoteException ex) {
						// create an instance of a JOptionPane, with only an ok
						// button and
						// message.
						JOptionPane optPane = new JOptionPane(
								"Ezin izan da zerbitzariarekin konexioa ezarri",
								JOptionPane.ERROR_MESSAGE);

						JPanel buttonPanel = (JPanel) optPane.getComponent(1);
						JButton buttonOk = (JButton) buttonPanel
								.getComponent(0);
						buttonOk.setText("Ados");

						JDialog d = optPane.createDialog(null,
								"Konexio errorea");
						d.setVisible(true);

						ex.printStackTrace();

						System.exit(1); // terminate application
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private DateComboBox getdataComboBox() {
		if (dataComboBox == null) {
			dataComboBox = new DateComboBox();
			dataComboBox.setPreferredSize(new Dimension(83, 20));
		}
		return dataComboBox;
	}

	/**
	 * This method initializes dataComboBox1
	 * 
	 * @return bezeroa.gui.DateComboBox
	 */
	private DateComboBox getDataComboBox1() {
		if (dataComboBox1 == null) {
			dataComboBox1 = new DateComboBox();
			dataComboBox1.setPreferredSize(new Dimension(83, 20));
		}
		return dataComboBox1;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			tableModel = new DefaultTableModel();
			jTable = new JTable(tableModel);
		}
		return jTable;
	}

	/**
	 * Interfaze grafikoari pasatako negozio logika esleitzen dio.
	 * 
	 * @param ui
	 *            interfaze grafikoak erabiliko duen UrrunekoInterfazea motako
	 *            objektu bat urruneko zerbitzariarekin konexioa ezarri ahal
	 *            izateko.
	 */
	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui) {
		this.urrunekoKud = ui;
	}

	public void taulaEguneratu(int txartelId, String hasData, String bukData,
			String hasOrdu, String bukOrdu) throws RemoteException {
		Vector<Object> zutIzen = new Vector<Object>();
		zutIzen.addElement("Gunearen IDa");
		zutIzen.addElement("Gunearen Izena");
		zutIzen.addElement("Data eta Ordua");
		Vector<Vector<Object>> taula = urrunekoKud.getGuneak(txartelId,
				hasData, bukData, hasOrdu, bukOrdu);
		tableModel.setDataVector(taula, zutIzen);
		tableModel.fireTableStructureChanged();
	}
} // @jve:decl-index=0:visual-constraint="10,10"
