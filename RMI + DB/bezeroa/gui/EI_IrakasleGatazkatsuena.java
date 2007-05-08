package bezeroa.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import partekatuak.*;

/**
 * Irakasle gatazkatsuenak ikusteko eta horiekin intzidentziak sortzeko
 * interfaze grafikoa.
 * 
 * @author 5. TALDEA
 * 
 */
public class EI_IrakasleGatazkatsuena extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JComboBox jComboBox = null;

	private JComboBox jComboBox1 = null;

	private JLabel jLabel = null;

	private JButton jButton = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable = null;

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	private DefaultTableModel tableModel;

	private String noiztikNora;

	private EI_SegurtasunArduraduna jabea;

	private JButton jButton1 = null;

	private static final int urteKop = 40; // urtearen comboboxean agertuko
											// diren urte kopurua

	private IrakasleGatazkatsuaDatuak gatazkatsuena;

	/**
	 * Metodo eraikitzailea. Elkarrizketa leihoa modu modalean hasieratuko da.
	 * 
	 * @param owner
	 *            Elkarrizketa leihoaren jabea.
	 */
	public EI_IrakasleGatazkatsuena(EI_SegurtasunArduraduna owner) {
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
		this.setSize(694, 280);
		this.setTitle("Irakasle Gatazkatsuenak");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.insets = new Insets(5, 5, 10, 10);
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.ipadx = 6;
			gridBagConstraints5.ipady = -7;
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.weightx = 0.0D;
			gridBagConstraints5.gridwidth = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridwidth = 5;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.ipadx = 157;
			gridBagConstraints4.ipady = -279;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.insets = new Insets(5, 10, 5, 10);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.insets = new Insets(10, 5, 5, 10);
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.ipadx = 4;
			gridBagConstraints3.ipady = -7;
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridwidth = 1;
			gridBagConstraints3.gridx = 4;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(10, 5, 5, 5);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 35;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridwidth = 1;
			gridBagConstraints2.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 23;
			gridBagConstraints1.ipady = -6;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(10, 5, 5, 5);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 53;
			gridBagConstraints.ipady = -6;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.insets = new Insets(10, 10, 5, 5);
			jLabel = new JLabel();
			jLabel.setText("datatik aurrera egondako irakasle gatazkatsuenak ");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJComboBox(), gridBagConstraints);
			jContentPane.add(getJComboBox1(), gridBagConstraints1);
			jContentPane.add(jLabel, gridBagConstraints2);
			jContentPane.add(getJButton(), gridBagConstraints3);
			jContentPane.add(getJScrollPane(), gridBagConstraints4);
			jContentPane.add(getJButton1(), gridBagConstraints5);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jComboBox
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			Vector<String> urteak = new Vector<String>();
			Calendar cal = new GregorianCalendar();
			int unekoUrte = cal.get(Calendar.YEAR);
			int i;
			for (i = unekoUrte; i >= (unekoUrte - urteKop); i--)
				urteak.addElement(String.valueOf(i));
			jComboBox = new JComboBox(urteak);
			jComboBox.setSelectedIndex(0);
			jComboBox.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					Calendar gaurkoUrte = new GregorianCalendar();
					gaurkoUrte.setTime(new Date());
					int egun = 12;
					if (e.getStateChange() == ItemEvent.SELECTED
							&& jComboBox
									.getSelectedItem()
									.toString()
									.equals(
											String
													.valueOf(/* gaurkoUrte.get(Calendar.YEAR) */2007)))
						egun = gaurkoUrte.get(Calendar.MONTH) + 1;
					jComboBox1.removeAllItems();
					for (int i = 1; i <= egun; i++)
						jComboBox1.addItem(new Integer(i));
				}

			});
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
			Calendar gaurkoUrte = new GregorianCalendar();
			gaurkoUrte.setTime(new Date());
			int egun = 12;
			if (jComboBox.getSelectedItem().toString().equals(
					String.valueOf(gaurkoUrte.get(Calendar.YEAR))))
				egun = gaurkoUrte.get(Calendar.MONTH) + 1;
			for (int i = 1; i <= egun; i++)
				jComboBox1.addItem(new Integer(i));
			jComboBox1.setSelectedItem(new Integer(gaurkoUrte
					.get(Calendar.MONTH) + 1));
		}
		return jComboBox1;
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
						String sarData = new String(jComboBox.getSelectedItem()
								.toString()
								+ "-" + jComboBox1.getSelectedItem() + "-1");
						Calendar cal = new GregorianCalendar();
						cal.setTime(new Date());
						noiztikNora = jComboBox.getSelectedItem().toString()
								+ "-" + jComboBox1.getSelectedItem().toString()
								+ "/" + String.valueOf(cal.get(Calendar.YEAR))
								+ "-"
								+ String.valueOf(cal.get(Calendar.MONTH) + 1);
						taulaEguneratu(sarData);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return jButton;
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
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Intzidentzia Sortu");
			jButton1.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (gatazkatsuena != null) {
						try {
							String txartId = String.valueOf(gatazkatsuena
									.getTxartelId());
							String txartIrakId = String.valueOf(gatazkatsuena
									.getTxartelIrakUkatuena());
							urrunekoKud.createIntzidentzia(txartId,
									txartIrakId, noiztikNora);
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
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jButton1;
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
		try {
			this.urrunekoKud = ui;

			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			// Daten formatua: UUUU-HH-E
			String sarData = String.valueOf(cal.get(Calendar.YEAR)) + "-"
					+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "-1";
			this.noiztikNora = String.valueOf(cal.get(Calendar.YEAR)) + "-"
					+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
					+ String.valueOf(cal.get(Calendar.YEAR)) + "-"
					+ String.valueOf(cal.get(Calendar.MONTH) + 1);
			this.taulaEguneratu(sarData);

		} catch (RemoteException e) {
			// create an instance of a JOptionPane, with only an ok button and
			// message.
			JOptionPane optPane = new JOptionPane(
					"Ezin izan da zerbitzariarekin konexioa ezarri",
					JOptionPane.ERROR_MESSAGE);

			JPanel buttonPanel = (JPanel) optPane.getComponent(1);
			JButton buttonOk = (JButton) buttonPanel.getComponent(0);
			buttonOk.setText("Ados");

			JDialog d = optPane.createDialog(null, "Konexio errorea");
			d.setVisible(true);

			e.printStackTrace();

			System.exit(1); // terminate application
		}
	}

	/**
	 * Intzidentzia guztiak lortzen ditu. Datu horiekin
	 * {@link DefaultTableModel} motako objektu bat osatuko du eta taulari
	 * esleituko zaio. Gero taula eguneratuko da datu berriak ikusteko.
	 * 
	 * @param sarData
	 *            urte bat eta hilabete batez osatutako String bat da. Data
	 *            horretatik honainoko irakasle gatazkatsuenak erakutsiko dira.
	 * @throws RemoteException
	 */
	public void taulaEguneratu(String sarData) throws RemoteException {
		Vector<Object> lerroa = new Vector<Object>();
		Vector<Vector<Object>> taula = new Vector<Vector<Object>>();
		Vector<Object> zutIzen = new Vector<Object>();
		zutIzen.addElement("Erabiltzaile ID");
		zutIzen.addElement("Erabiltzaile Izena");
		zutIzen.addElement("Txartel Zenbakia");
		zutIzen.addElement("Ukapen Kopurua");
		Vector<IrakasleGatazkatsuaDatuak> vGatazkatsuenak;

		vGatazkatsuenak = urrunekoKud.getGatazkatsuenak(sarData);
		if (vGatazkatsuenak.size() != 0) {
			gatazkatsuena = vGatazkatsuenak.firstElement();
			jButton1.setEnabled(true);
			for (IrakasleGatazkatsuaDatuak ig : vGatazkatsuenak) {
				lerroa = new Vector<Object>();
				lerroa.addElement(ig.getErabId());
				lerroa.addElement(ig.getErabIzena());
				lerroa.addElement(ig.getTxartelId());
				lerroa.addElement(ig.getUkapenKop());

				taula.addElement(lerroa);
			}
		} else {
			gatazkatsuena = null;
			jButton1.setEnabled(false);
		}
		tableModel.setDataVector(taula, zutIzen);
		tableModel.fireTableStructureChanged();
	}
}
