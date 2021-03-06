package bezeroa.gui;

import javax.swing.JPanel;

import javax.swing.JDialog;

import javax.swing.JLabel;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import partekatuak.MezuLeiho;
import partekatuak.UrrunekoInterfazea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;

/**
 * Emandako erabiltzailearen kokapena eguneratzen du eraikinaren barnean.
 * 
 * @author 5. Taldea
 *
 */
public class EI_KokapenaEguneratu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private DefaultTableModel tableModel = new DefaultTableModel();

	private DefaultTableModel tableModel1 = new DefaultTableModel();;

	private UrrunekoInterfazea urruIn; // @jve:decl-index=0:

	private JTextField jTextField = null;

	private JButton jButton = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable1 = null;

	private JScrollPane jScrollPane1 = null;

	private JTable jTable = null;

	private JButton jButton1 = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	Vector<Integer> txartelIrak = new Vector<Integer>(); // @jve:decl-index=0:

	Vector<Object> zutabeak = new Vector<Object>();

	/**
	 * Elkarrizketa leihoa hasieratzen du era modalean.
	 * 
	 * @param owner
	 *            Elkarrizketa leihoaren jabea den Frame objektua adierazten du.
	 */
	public EI_KokapenaEguneratu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
		zutabeak.addElement("Oraingo Gunea");
		zutabeak.addElement("Izena");
		zutabeak.addElement("Atea");
		zutabeak.addElement("Helburu Gunea");
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(614, 380);
		this.setTitle("Erabiltzailearen Kokapena Eguneratu");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.insets = new Insets(5, 10, 5, 10);
			gridBagConstraints31.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("Guneak:");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.insets = new Insets(10, 10, 5, 5);
			gridBagConstraints21.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Txartel Kodea:");
			jLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.insets = new Insets(5, 10, 10, 10);
			gridBagConstraints6.gridy = 4;
			gridBagConstraints6.ipadx = 0;
			gridBagConstraints6.ipady = 0;
			gridBagConstraints6.anchor = GridBagConstraints.EAST;
			gridBagConstraints6.gridx = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridwidth = 4;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.ipadx = 0;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.weighty = 1.0;
			gridBagConstraints4.insets = new Insets(5, 10, 10, 10);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridwidth = 4;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.insets = new Insets(5, 10, 10, 10);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.insets = new Insets(10, 5, 5, 10);
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.ipady = 0;
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridx = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.ipady = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(10, 5, 5, 5);
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(getJButton(), gridBagConstraints2);
			jContentPane.add(getJScrollPane(), gridBagConstraints3);
			jContentPane.add(getJScrollPane1(), gridBagConstraints4);
			jContentPane.add(getJButton1(), gridBagConstraints6);
			jContentPane.add(jLabel, gridBagConstraints21);
			jContentPane.add(jLabel1, gridBagConstraints31);
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
			jTable1 = new JTable(tableModel);
		}
		return jTable1;
	}

	


	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTable());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(tableModel1);
		}
		return jTable;
	}

	/**
	 * Urruneko negozio logikaren erreferentzia esleitzen du.
	 * 
	 * @param ui Emandako urruneko negozio logikaren erreferentzia
	 */
	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui) {
		this.urruIn = ui;

	}

	/**
	 * Emandako txartel kodeari dagokion erabiltzailearen eguneko kokapenaren informazioa
	 * taula batean itzultzen du.
	 * 
	 * @param kode Erabiltzaile txartel-kodea, zenbaki bat.
	 */
	public void taulaKokapenaEguneratu(String kode) {

		Vector<Vector<Object>> taula = new Vector<Vector<Object>>();
		Vector<Object> zutIzen = new Vector<Object>();
		zutIzen.addElement("Erabiltzaile Izena");
		zutIzen.addElement("Erabiltzaile Id");
		zutIzen.addElement("Txartel Zenbakia");
		zutIzen.addElement("Gune Zenbakia");
		zutIzen.addElement("Gune Izena");
		zutIzen.addElement("Data");
		try{
			taula = urruIn.getErabiltzaileKokapena(kode);
			if (taula.size() != 0) {
				jButton1.setEnabled(true);
				tableModel.setDataVector(taula, zutIzen);
				tableModel.fireTableStructureChanged();
				taulaGuneakEguneratu();
			} else {
				new MezuLeiho("Erabiltzailea ez da eraikinean izan", "Ados",
					"Txartel Kodea Sartu", JOptionPane.INFORMATION_MESSAGE);
				jButton1.setEnabled(false);
				tableModel.setDataVector(new Vector<Object>(), zutIzen);
				tableModel.fireTableStructureChanged();
			}
		} catch (RemoteException e1) {
				new MezuLeiho("REMOTE");
				e1.printStackTrace();
		} catch (IllegalStateException e3) {
				new MezuLeiho("DB");
		} catch (SQLException e4) {
			new MezuLeiho("SQL","Ezin da erabiltzailearen kokapena lortu Datu Basetik");	
		}

	}

	/**
	 * Eraikinean dauden gune guztiei buruzko informazioa taula batean itzultzen du.
	 * 
	 */
	public void taulaGuneakEguneratu() {
		Vector<Vector<Object>> taula2;
		
		try{
			taula2 = urruIn.getGuneGuztiak();
			if (taula2 != null) {
				for (Vector<Object> lerro : taula2) {
					String tx = lerro.lastElement().toString();
					Integer txi = Integer.parseInt(tx);
					txartelIrak.addElement(txi);
					lerro.removeElementAt(4);
				}
			} else
				taula2 = new Vector<Vector<Object>>();
			tableModel1.setDataVector(taula2, zutabeak);
			tableModel1.fireTableStructureChanged();
		} catch (RemoteException e1) {
			new MezuLeiho("REMOTE");
			e1.printStackTrace();
		} catch (IllegalStateException e3) {
			new MezuLeiho("DB");
		} catch (SQLException e4) {
		new MezuLeiho("SQL","Ezin da erabiltzailearen kokapena lortu Datu Basetik");	
		}

	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Eguneratu");
			jButton1.setPreferredSize(new Dimension(92, 20));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String erabId = jTable1.getValueAt(0, 1).toString();
					String txartelId = jTable1.getValueAt(0, 2).toString();

					int x = jTable.getSelectedRow();

					if (x == -1) {
						new MezuLeiho("Ez duzu gunerik aukeratu", "Ados",
								"Gunea Aukeratu", JOptionPane.ERROR_MESSAGE);
					} else {
						String guneId = jTable.getValueAt(x, 3).toString();
						Integer txIra = (Integer) txartelIrak.elementAt(x);

						try {
							System.out.println(txIra.intValue());
							urruIn.sarbideEskaeraEguneratu(Integer.parseInt(txartelId), txIra.intValue());
							boolean b = urruIn.erabiltzaileaFakultatean(erabId);
							if (b == true)
								urruIn.kokapenaEguneratu(erabId, guneId);
							else
								urruIn.kokapenaSartu(erabId, guneId);
							taulaKokapenaEguneratu(jTextField.getText().toString());
						} catch (RemoteException e1) {
							new MezuLeiho("REMOTE");
							e1.printStackTrace();
						} catch (IllegalStateException e3) {
							new MezuLeiho("DB");
						} catch (SQLException e4) {
						new MezuLeiho("SQL","Ezin da erabiltzailearen kokapena lortu Datu Basetik");	
						}
					}
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Kokapena Erakutsi");
			jButton.setPreferredSize(new Dimension(140, 20));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						int i = Integer.parseInt(jTextField.getText()
								.toString());
						String kode = String.valueOf(i);
						taulaKokapenaEguneratu(kode);
					} catch (NumberFormatException e2) {
						new MezuLeiho(
								"Ez duzu Txartel Koderik sartu edo sartutako txartel-kodea ez da zuzena",
								"Ados", "Txartel Kodea Okerra",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			});
		}
		return jButton;
	}

} // @jve:decl-index=0:visual-constraint="56,17"

