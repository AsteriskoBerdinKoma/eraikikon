package bezeroa.gui;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class EI_TxartelaJaso extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JButton jButton = null;

	private JLabel jLabel1 = null;

	private JPasswordField jPasswordField = null;
	
	private UrrunekoInterfazea ui;

	/**
	 * @param owner
	 */
	public EI_TxartelaJaso(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(318, 179);
		this.setTitle("Txartela Jaso");
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
			jLabel1.setBounds(new Rectangle(10, 48, 115, 26));
			jLabel1.setText("  Pasahitza: ");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(10, 13, 115, 26));
			jLabel.setText("  Erabiltzaile izena:   ");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJPasswordField(), null);
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
			jTextField.setBounds(new Rectangle(144, 13, 150, 22));
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
			jButton.setBounds(new Rectangle(78, 92, 145, 37));
			jButton.setText("Desgaitu txartela");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String erabIzen=jTextField.getText();
		    		String erabPas=String.valueOf(jPasswordField.getPassword());
		    		boolean b;
//					boolean b = NegLog.loginEgin(erabIzen,erabPas);
//		    		if (b==false)
//		    			jLabel.setText("ERROEA:Izena edo pasahitza ez da ondo sartu.Saiatu berriz.");
				//HOLAKO BAT NON SARTU?????
//		    		public interface NegozioLogikaInterfazea {
//		    			
//		    			public boolean loginEgin(String erabIzen,String erabPas);
//
//		    		}
		    		
		    		ui.desgaituTxartela(erabId);
		    		
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setBounds(new Rectangle(144, 49, 150, 22));
		}
		return jPasswordField;
	}

}  //  @jve:decl-index=0:visual-constraint="9,8"
