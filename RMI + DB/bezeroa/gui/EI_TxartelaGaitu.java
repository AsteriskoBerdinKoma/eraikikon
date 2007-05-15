package bezeroa.gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import partekatuak.MezuLeiho;
import partekatuak.UrrunekoInterfazea;

public class EI_TxartelaGaitu extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel;

	private JTextField jTextField;

	private JButton jButton;
	
	private UrrunekoInterfazea urrunekoKud;  //  @jve:decl-index=0:

	/**
	 * @param owner
	 */
	public EI_TxartelaGaitu(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(225, 130);
		this.setTitle("Txartela Gaitu");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.insets = new Insets(5, 10, 10, 10);
			gridBagConstraints2.gridy = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(10, 5, 5, 10);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.insets = new Insets(10, 10, 5, 5);
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("NAN:");
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
			jContentPane.add(getJTextField(), gridBagConstraints1);
			jContentPane.add(getJButton(), gridBagConstraints2);
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

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Txartela Gaitu");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
					String nan = jTextField.getText();
					int bal= Integer.parseInt(nan);
						urrunekoKud.gaituTxartela(bal);
						new MezuLeiho("Txartela gaitua izan da","Ados","Txartela gaitu",JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					} catch (RemoteException e1) {
						new MezuLeiho("REMOTE");
						e1.printStackTrace();
					} catch (IllegalStateException e1) {
						new MezuLeiho("DB");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						new MezuLeiho("SQL","Ezin da txartela gaitu Datu Basean");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return jButton;
	}
	public void setUrrunekoNegozioLogika(UrrunekoInterfazea ui)
	{
		this.urrunekoKud = ui;
	}
}
