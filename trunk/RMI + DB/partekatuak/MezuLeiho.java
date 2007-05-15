package partekatuak;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MezuLeiho {

	private String mezua;
	private String botoia;
	private String titulua;
	private int mota;
	
	
	/**
	 * @param mezu
	 * @param botoi
	 * @param titulu
	 * @param mezu_mota JOptionPane-en motak
	 */
	public MezuLeiho(String mezu, String botoi, String titulu, int mezu_mota){
		this.mezua = mezu;
		this.botoia = botoi;
		this.titulua = titulu;
		this.mota = mezu_mota;
		
		this.sortuMezua();
	}
	
	public MezuLeiho(String exceptionMota, String mezu){
		if(exceptionMota.equals("SQL")){
			this.mezua = mezu;
			this.botoia = "Ados";
			this.titulua = "SQL Errorea";
			this.mota =JOptionPane.ERROR_MESSAGE;
		}
		this.sortuMezua();
	}
	
	public MezuLeiho(String exceptioMota){
		if (exceptioMota.equals("REMOTE")){
			this.mezua = "Ezin izan da zerbitzariarekin konexioa ezarri";
			this.botoia = "Ados";
			this.titulua = "Konexio errorea";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		if(exceptioMota.equals("IO")){
			this.mezua = " baliabide baten atzipena egiterakoan arazoa egon da";
			this.botoia = "Ados";
			this.titulua = "Sarrera/Irteera arazoa";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		if(exceptioMota.equals("NegozioLogika")){
			this.mezua = " Errorea negozio logika esleitzean";
			this.botoia = "Ados";
			this.titulua = "Negozio logika errorea";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		if(exceptioMota.equals("DB")){
			this.mezua = "Zerbitzaria ez da Datu basearekin Konketatu";
			this.botoia = "Ados";
			this.titulua = "Zerbitzari/Datu Base Errorea";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		this.sortuMezua();
	}
	
	private void sortuMezua(){
//		create an instance of a JOptionPane, with only an ok button and
		// message.
		JOptionPane optPane = new JOptionPane(mezua,mota);
		JPanel buttonPanel = (JPanel) optPane.getComponent(1);
		JButton buttonOk = (JButton) buttonPanel.getComponent(0);
		buttonOk.setText(botoia);
		JDialog d = optPane.createDialog(null, titulua);
		d.setVisible(true);
	}
}
