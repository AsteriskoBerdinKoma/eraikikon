package bezeroa.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import partekatuak.UrrunekoInterfazea;
import partekatuak.DbDatuLerroa;

public class EI_SarbideakKontsultatu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:
	private DefaultTableModel tableModel;

	private DateComboBox jDateComboBox = null;

	private JLabel jLabel = null;

	private JButton jButton = null;

	private JScrollPane jScrollPane1 = null;

	private JList jList = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable1 = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;
	
	private Vector<DbDatuLerroa> datuak=new Vector<DbDatuLerroa>();  //  @jve:decl-index=0:
	private DefaultListModel ateak=new DefaultListModel();

	/**
	 * @param owner
	 */
	public EI_SarbideakKontsultatu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
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
//			jDateComboBox.addActionListener(new java.awt.event.ActionListener() {
//				public void actionPerformed(java.awt.event.ActionEvent e) {
//					Calendar cal = new GregorianCalendar();
//					cal.setTime(new Date());
//					cal.getTime();
//					Date data= (Date)jDateComboBox.getSelectedItem();
//					if (data.after(cal.getTime())){
//						System.out.println("data ez da oraindik existitzen");
//					}
//				}
//			});
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
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String data = jDateComboBox.getSelectedItem().toString().replace('/', '-');
						System.out.println(data);
						listaKargatu(data);
					//data egokia den konprobatu.
					//egokia bada, emandako data String batean bilakatu eta horrekin datuakEguneraturi deitu
					//honek data horretako sarbide eskaera guztiak lortuko ditu eta atelista beteko du.
					//egkoia ez bada, joptionpane, data egokia sartzeko adieraziz.
					} catch (RemoteException e1) {
						System.out.println("Remote exception");
					}
				}
			});
		}
		return jButton;
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
			jList = new JList(ateak);
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
			tableModel = new DefaultTableModel();
			jTable1 = new JTable(tableModel);
		}
		return jTable1;
	}
	
	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui) {
//		try {
			this.urrunekoKud = ui;

//			Calendar cal = new GregorianCalendar();
//			cal.setTime(new Date());
//			// Daten formatua: UUUU-HH-E
//			String sarData = String.valueOf(cal.get(Calendar.YEAR)) + "-"
//					+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "-1";
//			this.noiztikNora = String.valueOf(cal.get(Calendar.YEAR)) + "-"
//					+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
//					+ String.valueOf(cal.get(Calendar.YEAR)) + "-"
//					+ String.valueOf(cal.get(Calendar.MONTH) + 1);
//			this.datuakEguneratu(sarData);

//		} catch (RemoteException e) {
			// create an instance of a JOptionPane, with only an ok button and
			// message.
//			JOptionPane optPane = new JOptionPane(
//					"Ezin izan da zerbitzariarekin konexioa ezarri",
//					JOptionPane.ERROR_MESSAGE);
//
//			JPanel buttonPanel = (JPanel) optPane.getComponent(1);
//			JButton buttonOk = (JButton) buttonPanel.getComponent(0);
//			buttonOk.setText("Ados");
//
//			JDialog d = optPane.createDialog(null, "Konexio errorea");
//			d.setVisible(true);
//
//			e.printStackTrace();
//
//			System.exit(1); // terminate application
//		}
	}
	
	public void listaKargatu(String data) throws RemoteException {
		datuak=urrunekoKud.getSarbideEskaerak(data);
		if (datuak.size() != 0) {
			for (DbDatuLerroa lerroa: datuak) {
				if((Integer) ateak.lastElement()!=lerroa.getAteId())
					ateak.addElement(lerroa.getAteId());
			}
			jList.setModel(ateak);
		} 
		else {
			//JOptionPane ez dago sarbide eskaerarik data horretan
		}

	}
	
	public void taulaEguneratu (int ateid){
		Vector<Object> zutIzen = new Vector<Object>();
		Vector<Object> lerroa = new Vector<Object>();
		Vector<Vector<Object>> vEskaerak = new Vector<Vector<Object>>();
		zutIzen.addElement("Ordua");
		zutIzen.addElement("Txartel Zenbakia");
		zutIzen.addElement("Hasiera Gunea");
		zutIzen.addElement("Helburu Gunea");
		zutIzen.addElement("Baimenduta?");
		zutIzen.addElement("Ukapenaren Arrazoia");
		for(DbDatuLerroa ddl: datuak){
			if(ddl.getAteId()==ateid){
				lerroa = new Vector<Object>();
				lerroa.addElement(ddl.getSarbideData());
				lerroa.addElement(ddl.getTxartelId());
				lerroa.addElement(ddl.getHasieraGune());
				lerroa.addElement(ddl.getHelburuGune());
				lerroa.addElement(ddl.getBaimenduta());
				lerroa.addElement(ddl.getUkapenarenArrazoia());
				vEskaerak.addElement(lerroa);
			}
		}
		tableModel.setDataVector(vEskaerak, zutIzen);
		tableModel.fireTableStructureChanged();
	}


}  //  @jve:decl-index=0:visual-constraint="182,31"
