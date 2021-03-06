package bezeroa.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import partekatuak.MezuLeiho;
import partekatuak.UrrunekoInterfazea;

/**
 * Segurtasun arduradunaren erabilpen kasu guztiak bateratzeko interfaze
 * grafikoa duen klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class EI_SegurtasunArduraduna extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jJMenuBar = null;

	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JMenu jMenu2 = null;

	private JScrollPane jScrollPane = null;

	private JTable jTable = null;

	private JLabel jLabel = null;

	private DefaultTableModel tableModel = null;

	public static final String zerbitzuIzena = "irakasleGatazkatsuena"; // @jve:decl-index=0:

	private UrrunekoInterfazea urrunekoKud; // @jve:decl-index=0:

	private JMenuItem jMenuItem = null;
	private JMenuItem jMenuItem2 = null;
	private JMenuItem jMenuItem3 = null;
	private JMenuItem jMenuItem4 = null;
	private JMenuItem jMenuItem5 = null;
	private JMenuItem jMenuItem7 = null;

	//private String host = "localhost";  //  @jve:decl-index=0:

	private EI_TxartelaEman txart_eman = new EI_TxartelaEman(this);  //  @jve:decl-index=0:visual-constraint="10,165"
	private EI_TxartelaDesgaitu txart_desgaitu =  new EI_TxartelaDesgaitu(this);
	private EI_TxartelaGaitu txart_gaitu =  new EI_TxartelaGaitu(this);//  @jve:decl-index=0:visual-constraint="10,165"
	
	private EI_IrakasleGatazkatsuena irakGatazk = new EI_IrakasleGatazkatsuena(this);  //  @jve:decl-index=0:visual-constraint="13,55"
	private EI_PresentziaKontrolatu presKontr = new EI_PresentziaKontrolatu(this);  //  @jve:decl-index=0:visual-constraint="13,91"
	private EI_SarbideakKontsultatu sarbKonts = new EI_SarbideakKontsultatu(this);  //  @jve:decl-index=0:visual-constraint="12,126"
	private EI_AlarmaGaitu alarma_gaitu = new EI_AlarmaGaitu(this);
	private EI_KokapenaEguneratu kokEgun = new EI_KokapenaEguneratu(this);

	private JMenuItem jMenuItem8 = null;

	private JMenu jMenu3 = null;

	private JMenuItem jMenuItem61 = null;

	
	/**
	 * Interfaze grafikoa hasieratzen du.
	 * 
	 */
	public EI_SegurtasunArduraduna(UrrunekoInterfazea ui) {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUrrunekoNegozioLogika(ui);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
//		boolean negLog = setNegozioLogika();
//		if (negLog == false)
//			System.exit(1);
		//txart_eman.setSize(new Dimension(332, 192));
		this.setExtendedState(getExtendedState()| MAXIMIZED_BOTH);
		this.setSize(491, 223);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Segurtasun Administratzailea");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText("Gertakariak: ");
			jLabel.setForeground(Color.red);
			jLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
			jContentPane.add(jLabel, BorderLayout.NORTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
			jJMenuBar.add(getJMenu3());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("Alarma");
			jMenu.setMnemonic(KeyEvent.VK_A);
			jMenu.add(getJMenuItem5());
		}
		return jMenu;
	}
	
	private JMenuItem getJMenuItem5() {
		if (jMenuItem5 == null) {
			jMenuItem5 = new JMenuItem();
			jMenuItem5.setText("Gaitu/Desgaitu");
			jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					alarma_gaitu.setEraikinekoPertsonKop();
					alarma_gaitu.setLocationRelativeTo(null);
					alarma_gaitu.setVisible(true);
				}
			});
		}
		return jMenuItem5;
	}
	
	/**
	 * This method initializes jMenu1
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Txartelak");
			jMenu1.setMnemonic(KeyEvent.VK_T);
			jMenu1.add(getJMenuItem());
			jMenu1.add(getJMenuItem2());
			jMenu1.add(getJMenuItem3());
		}
		return jMenu1;
	}

	/**
	 * This method initializes jMenuItem
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("Txartela Eman");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txart_eman.setLocationRelativeTo(null);
					txart_eman.profilakKargatu();
					txart_eman.setVisible(true);
				}
			});
		}
		return jMenuItem;
	}

	/**
	 * This method initializes jMenuItem2
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Txartela Gaitu");
			jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txart_gaitu.setLocationRelativeTo(null);
					txart_gaitu.setVisible(true);
				}
			});
		}
		return jMenuItem2;
	}

	/**
	 * This method initializes jMenuItem3
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Txartela Desgaitu");
			jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					txart_desgaitu.setLocationRelativeTo(null);
					txart_desgaitu.setVisible(true);
				}
			});
		}
		return jMenuItem3;
	}

	/**
	 * This method initializes jMenu2
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Kontsultak");
			jMenu2.setMnemonic(KeyEvent.VK_K);
			jMenu2.add(getJMenuItem4());
			jMenu2.add(getJMenuItem7());
			jMenu2.add(getJMenuItem8());
		}
		return jMenu2;
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
		try {
			if (jTable == null) {
				Vector<String> v = new Vector<String>();
				v.addElement("Erabiltzaile ID");
				v.addElement("Data");
				v.addElement("Larritasuna");
				v.addElement("Mota");
				v.addElement("Deskribapena");
				v.addElement("Txartel Zenbakia");
				v.addElement("Atea");
				v.addElement("Txartel Irakurgailua");
				v.addElement("Gaitua");
				v.addElement("Noiztik Nora");
				tableModel = new DefaultTableModel(urrunekoKud.getIntzidentziak(), v);
				jTable = new JTable(tableModel);
			}
		} catch (RemoteException e) {
			new MezuLeiho("REMOTE");
			e.printStackTrace();
			return null;
		} catch (IllegalStateException e) {
			new MezuLeiho("DB");
			e.printStackTrace();
		} catch (SQLException e) {
			new MezuLeiho("SQL","Ezin izan dira intzidentziak lortu eta ondorioz ezin da gertakari taula eguneratu");
			e.printStackTrace();
		}
		return jTable;
	}

	/**
	 * This method initializes jMenuItem4
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem4() {
		if (jMenuItem4 == null) {
			jMenuItem4 = new JMenuItem("Irakasle Gatazkatsuenak");
			jMenuItem4.setText("Irakasle Gatazkatsuenak");
			jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					irakGatazk.setLocationRelativeTo(null);
					irakGatazk.setVisible(true);
				}
			});
		}
		return jMenuItem4;
	}

	/**
	 * Klaseko {@link JTable}-ak erabiliko duen egitura definitzeko erabiliko
	 * da. Egitura honek Taularen zutabeen izenak, eta lerro kopurua definitzeko
	 * balio du, besteak beste.
	 * 
	 * @param datuak
	 *            Taulari dagozkion datuen bektorea da, bektore hau bektorez
	 *            ostatuta dago. Azpibektore bakoitzean Object motako objektuak
	 *            daude. Objektu bakoitza intzidentziaren datu bat da.
	 * @param zutabeIzenak
	 *            Taulari dagozkien zutabeen goiburuak definitzen dituen
	 *            String-ez osatutako bektorea.
	 */
	public void setTableModel(Vector datuak, Vector zutabeIzenak) {
		this.tableModel.setDataVector(datuak, zutabeIzenak);
		this.tableModel.fireTableStructureChanged();
	}

	/**
	 * Interfaze grafikoari pasatako negozio logika esleitzen dio. Honek sortzen dituen elkarrizketa-leiho guztiei
	 * negozio-logika bera esleitzen die.
	 * 
	 * @param ui
	 *            interfaze grafikoak erabiliko duen UrrunekoInterfazea motako
	 *            objektu bat urruneko zerbitzariarekin konexioa ezarri ahal
	 *            izateko.
	 */
	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui)
	{
		this.urrunekoKud = ui;
		
		irakGatazk.setUrrunekoNegozioLogika(urrunekoKud);
		presKontr.setUrrunekoNegozioLogika(urrunekoKud);
		alarma_gaitu.setUrrunekoNegozioLogika(urrunekoKud);
		sarbKonts.setUrrunekoNegozioLogika(urrunekoKud);
		kokEgun.setUrrunekoNegozioLogika(urrunekoKud);
		txart_eman.setUrrunekoNegozioLogika(urrunekoKud);
		txart_desgaitu.setUrrunekoNegozioLogika(urrunekoKud);
		txart_gaitu.setUrrunekoNegozioLogika(urrunekoKud);
		
	}


	/**
	 * This method initializes jMenuItem7	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem7() {
		if (jMenuItem7 == null) {
			jMenuItem7 = new JMenuItem();
			jMenuItem7.setText("Presentzia Kontrolatu");
			jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					presKontr.setLocationRelativeTo(null);
					presKontr.setVisible(true);
				}
			});
		}
		return jMenuItem7;
	}

	/**
	 * This method initializes jMenuItem8	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem8() {
		if (jMenuItem8 == null) {
			jMenuItem8 = new JMenuItem();
			jMenuItem8.setText("Sarbide-Eskaerak");
			jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					sarbKonts.setLocationRelativeTo(null);
					sarbKonts.setVisible(true);
				}
			});
		}
		return jMenuItem8;
	}

	/**
	 * This method initializes jMenu3	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu3() {
		if (jMenu3 == null) {
			jMenu3 = new JMenu();
			jMenu3.setMnemonic(KeyEvent.VK_E);
			jMenu3.setText("Erabiltzaileak");
			jMenu3.add(getJMenuItem61());
		}
		return jMenu3;
	}

	/**
	 * This method initializes jMenuItem61	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem61() {
		if (jMenuItem61 == null) {
			jMenuItem61 = new JMenuItem();
			jMenuItem61.setText("Kokapena Eguneratu");
			jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					kokEgun.setLocationRelativeTo(null);
					kokEgun.setVisible(true);
				}
			});
		}
		return jMenuItem61;
	}
} // @jve:decl-index=0:visual-constraint="201,10"
