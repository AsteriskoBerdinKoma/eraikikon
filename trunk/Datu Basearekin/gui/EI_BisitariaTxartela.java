package gui;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class EI_BisitariaTxartela extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

	private JButton jButton1 = null;

	private JButton jButton2 = null;

	private JButton jButton3 = null;

	private JButton jButton4 = null;

	private JButton jButton5 = null;
 
	private Vector<Botoia> vBotoi = new Vector<Botoia>();  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public EI_BisitariaTxartela(EI_SegurtasunArduraduna owner) {
		super(owner, true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(417, 252);
		this.setTitle("Bisitari Txartela");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(3);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton5(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			new Botoia(jButton);
			jButton.setIcon(new ImageIcon(getClass().getResource("g1.png")));
			jButton.setBackground(Color.blue);
			jButton.addActionListener(new JButton_actionPerformed());
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
			new Botoia(jButton1);
			jButton1.setIcon(new ImageIcon(getClass().getResource("g2.png")));
			jButton1.setBackground(Color.blue);
			jButton1.addActionListener(new JButton_actionPerformed());
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			new Botoia(jButton2);
			jButton2.setIcon(new ImageIcon(getClass().getResource("g4.png")));
			jButton2.setBackground(Color.blue);
			jButton2.addActionListener(new JButton_actionPerformed());
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			new Botoia(jButton3);
			jButton3.setIcon(new ImageIcon(getClass().getResource("g5.png")));
			jButton3.setBackground(Color.blue);
			jButton3.addActionListener(new JButton_actionPerformed());
		}
		return jButton3;
	}

	/**
	 * This method initializes jButton4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			new Botoia(jButton4);
			jButton4.setIcon(new ImageIcon(getClass().getResource("g6.png")));
			jButton4.setBackground(Color.blue);
			jButton4.addActionListener(new JButton_actionPerformed());
		}
		return jButton4;
	}

	/**
	 * This method initializes jButton5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			new Botoia(jButton5);
			jButton5.setMnemonic(KeyEvent.VK_UNDEFINED);
			jButton5.setBackground(Color.blue);
			jButton5.setIcon(new ImageIcon(getClass().getResource("g3.png")));
			jButton5.addActionListener(new JButton_actionPerformed());
		}
		return jButton5;
	}

	public class JButton_actionPerformed implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			for (Botoia bo: vBotoi)
			{
				if (bo.getBotoia().equals(e.getSource()))
				{
					bo.egoeraAldatu();
					if (bo.akt)
						bo.getBotoia().setBackground(Color.yellow);
					else
						bo.getBotoia().setBackground(Color.blue);
					break;
				}
			}
		}
	}
	
	public class Botoia {
		
		private JButton bot;
		private boolean akt;
		
		public Botoia(JButton b)
		{
			this.bot = b;
			this.akt = false;
			vBotoi.addElement(this);
		}
		
		public JButton getBotoia()
		{
			return bot;
		}
		
		public boolean isAktibatuta()
		{
			return akt;
		}
		
		public void egoeraAldatu()
		{
			this.akt = !akt;
		}
		
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
