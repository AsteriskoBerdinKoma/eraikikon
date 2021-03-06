package partekatuak;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Errore-mezuak bistaratzeko leiho-mezu sistema. Aplikazioak jaurtitzen dituen mezu-leiho guztiak kudeatuko ditu.
 * 
 * @author 5. Taldea
 *
 */
public class MezuLeiho {

	private String mezua;
	private String botoia;
	private String titulua;
	private int mota;
	
	
	/**
	 * Metodo eraikitzailea. Mezuaren izaera definitzeko erabiltzen da.
	 * 
	 * @param mezu Mezu-leihoan agertuko den mezua, String bat.
	 * @param botoi Mezu-leihoan agertzen den botoiaren testua, String bat.
	 * @param titulu Mezu-leihoaren tituluko testua, String bat.
	 * @param mezu_mota JOptionPane-en mota adierazten duen zenbaki bat.
	 */
	public MezuLeiho(String mezu, String botoi, String titulu, int mezu_mota){
		this.mezua = mezu;
		this.botoia = botoi;
		this.titulua = titulu;
		this.mota = mezu_mota;
		
		this.sortuMezua();
	}
	
	/**
	 * Metodo eraikitzailea. Mezuaren izaera definitzeko erabiltzen da.
	 * 
	 * @param exceptionMota Mezua jaurti duen salbuespen-mota, String bat.
	 * @param mezu Mezu-leihoan agertuko den mezua, String bat.
	 */
	public MezuLeiho(String exceptionMota, String mezu){
		if(exceptionMota.equals("SQL")){
			this.mezua = mezu;
			this.botoia = "Ados";
			this.titulua = "SQL Errorea";
			this.mota =JOptionPane.ERROR_MESSAGE;
		}
		this.sortuMezua();
	}
	
	/**
	 * Metodo eraikitzailea. Mezuaren izaera definitzeko erabiltzen da.
	 * 
	 * @param exceptioMota Mezua jaurti duen salbuespen-mota, String bat.
	 */
	public MezuLeiho(String exceptioMota){
		if (exceptioMota.equals("REMOTE")){
			this.mezua = "Ezin izan da zerbitzariarekin konexioa ezarri";
			this.botoia = "Ados";
			this.titulua = "Konexio errorea";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		if(exceptioMota.equals("IO")){
			this.mezua = "Baliabide baten atzipena egiterakoan arazoa egon da";
			this.botoia = "Ados";
			this.titulua = "Sarrera/Irteera arazoa";
			this.mota = JOptionPane.ERROR_MESSAGE;
		}
		if(exceptioMota.equals("ZerbitzariEzezaguna")){
			this.mezua = "Ezin izan da zerbitzaria aurkitu";
			this.botoia = "Ados";
			this.titulua = "Zerbitzari Ezezaguna";
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
