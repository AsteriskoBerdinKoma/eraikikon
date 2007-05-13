package bezeroa.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import partekatuak.UrrunekoInterfazea;

public class EI_Identifikazioa extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3372486190912554562L;

	BorderLayout borderLayout1 = new BorderLayout();  //  @jve:decl-index=0:

	JPanel jPanel1 = new JPanel();

	JLabel jLabel1 = new JLabel();

	JLabel jLabel2 = new JLabel();

	JTextField jTextField1 = new JTextField();

	JPasswordField jPasswordField1 = new JPasswordField();

	JButton jButton1 = new JButton();

	UrrunekoInterfazea urrunekoKud;

	JLabel jLabel3 = new JLabel();

	EI_SegurtasunArduraduna segArd;
	
	public EI_Identifikazioa() {
		super();
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.getContentPane().setLayout(borderLayout1);
		jLabel3.setPreferredSize(new Dimension(148, 15));
		jTextField1.setPreferredSize(new Dimension(100, 20));
		jPasswordField1.setPreferredSize(new Dimension(100, 20));
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.insets = new Insets(5, 10, 10, 10);
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.gridy = 3;
		gridBagConstraints5.ipadx = 0;
		gridBagConstraints5.ipady = 0;
		gridBagConstraints5.anchor = GridBagConstraints.WEST;
		gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints5.gridwidth = 2;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.insets = new Insets(5, 10, 10, 10);
		gridBagConstraints4.gridx = 0;
		gridBagConstraints4.gridy = 2;
		gridBagConstraints4.ipadx = 0;
		gridBagConstraints4.ipady = 0;
		gridBagConstraints4.gridwidth = 2;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridx = 1;
		gridBagConstraints3.gridy = 1;
		gridBagConstraints3.ipadx = 0;
		gridBagConstraints3.ipady = 0;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.insets = new Insets(10, 5, 10, 5);
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.gridx = 1;
		gridBagConstraints2.gridy = 0;
		gridBagConstraints2.ipadx = 0;
		gridBagConstraints2.ipady = 0;
		gridBagConstraints2.weightx = 0.0D;
		gridBagConstraints2.insets = new Insets(10, 5, 10, 5);
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.insets = new Insets(10, 10, 5, 5);
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.gridy = 0;
		gridBagConstraints1.ipadx = 0;
		gridBagConstraints1.ipady = 0;
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.gridwidth = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 0;
		gridBagConstraints.ipady = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.fill = GridBagConstraints.NONE;
		gridBagConstraints.gridx = 0;
		this.setSize(new Dimension(339, 206));
		this.setContentPane(jPanel1);
		jLabel1.setText("Idatzi erabiltzaile izena:");
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
		jButton1.setText("Sisteman sartu");
		jButton1.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jButton1_actionPerformed(e);
			}
		});
		jLabel2.setText("Idatzi passworda:");
		jLabel2.setPreferredSize(new Dimension(130, 15));
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
		jPanel1.setLayout(new GridBagLayout());
		this.setTitle("Identifikazioa");
		jPanel1.add(jLabel2, gridBagConstraints);
		jPanel1.add(jLabel1, gridBagConstraints1);
		jPanel1.add(jTextField1, gridBagConstraints2);
		jPanel1.add(jPasswordField1, gridBagConstraints3);
		jPanel1.add(jButton1, gridBagConstraints4);
		jPanel1.add(jLabel3, gridBagConstraints5);
		//this.getContentPane().add(jPanel1, BorderLayout.CENTER);
	}

	public void setNegozioLogika(UrrunekoInterfazea i) {
		// Lehen EZ URRUNEKOA
		this.urrunekoKud = i;
	}

	void jButton1_actionPerformed(ActionEvent e) {
		try {
			boolean b = urrunekoKud.loginEgin(jTextField1.getText(), String
					.valueOf(jPasswordField1.getPassword()));
			if (b)
			{
				jLabel3.setText("AURRERA");
				segArd = new EI_SegurtasunArduraduna(urrunekoKud);
				this.setVisible(false);
				segArd.setVisible(true);
			}
			else
				jLabel3.setText("EZ DUZU SARTZEKO BAIMENIK");
		} catch (Exception ex) {
			ex.printStackTrace();
			jLabel3.setText("NEGOZIO LOGIKAREKIN ARAZOAK DAUDE");
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
