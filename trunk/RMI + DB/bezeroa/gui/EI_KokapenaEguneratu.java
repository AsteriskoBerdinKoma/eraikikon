package bezeroa.gui;

import javax.swing.JPanel;


import javax.swing.JDialog;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.rmi.RemoteException;
import java.util.Vector;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


import partekatuak.UrrunekoInterfazea;

public class EI_KokapenaEguneratu extends JDialog {
	
	private EI_SegurtasunArduraduna jabea;
	
	

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel1;
	private UrrunekoInterfazea urruIn;  //  @jve:decl-index=0:
	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JButton jButton = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable1 = null;



	private JScrollPane jScrollPane1 = null;



	private JTable jTable = null;



	private JLabel jLabel1 = null;



	private JButton jButton1 = null;

	/**
	 * @param owner
	 */
	public EI_KokapenaEguneratu(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
		this.jabea=owner;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(605, 303);
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
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 102, 107, 28));
			jLabel1.setText("Guneak:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(12, 7, 103, 27));
			jLabel.setText("Txartel kodea:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJButton1(), null);
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
			jTextField.setBounds(new Rectangle(125, 8, 109, 26));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(243, 10, 174, 23));
			jButton.setText("Kokapena Erakutsi");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					
					try {
						String kode = jTextField.getText().toString();
						taulaKokapenaEguneratu(kode);
						taulaGuneakEguneratu();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
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
			jScrollPane.setBounds(new Rectangle(14, 49, 571, 36));
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
		this.urruIn = ui;
		
	}
	
	
	public void taulaKokapenaEguneratu(String kode) throws RemoteException{
		
		Vector<Vector<Object>> taula = new Vector<Vector<Object>>();
		
		Vector<Object> zutIzen = new Vector<Object>();
		zutIzen.addElement("Erabiltzaile Izena");
		zutIzen.addElement("Erabiltzaile Id");
		zutIzen.addElement("Txartel Zenbakia");
		zutIzen.addElement("Gune Zenbakia");
		zutIzen.addElement("Gune Izena");
		zutIzen.addElement("Data");
		
		
			taula = urruIn.getErabiltzaileKokapena(kode);
			
			tableModel.setDataVector(taula, zutIzen);
			
			tableModel.fireTableStructureChanged();
		
	}
	
	public void taulaGuneakEguneratu() throws RemoteException{
		Vector<Vector<Object>> taula2 = new Vector<Vector<Object>>();
		Vector<Object> zutabeak = new Vector<Object>();
		zutabeak.addElement("Id");
		zutabeak.addElement("Izena");
		taula2 = urruIn.getGuneGuztiak();
		tableModel1.setDataVector(taula2, zutabeak);
		tableModel1.fireTableStructureChanged();
		
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(14, 135, 571, 84));
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
			
			tableModel1 = new DefaultTableModel();
			jTable = new JTable(tableModel1);
			
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
			jButton1.setBounds(new Rectangle(467, 227, 104, 31));
			jButton1.setText("Eguneratu");
		}
		return jButton1;
	}

}  //  @jve:decl-index=0:visual-constraint="56,17"

