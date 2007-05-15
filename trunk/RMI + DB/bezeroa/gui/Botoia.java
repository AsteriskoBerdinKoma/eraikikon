package bezeroa.gui;

import javax.swing.JButton;

/**
 * Gunea adierazten duen irudi bakoitza gordetzen duen botoia adierazteko
 * klasea.
 * 
 * @author 5. TAlDEA
 * 
 */
public class Botoia {

	private JButton bot;
	private int guneId;
	private boolean akt;

	/**
	 * {@link JButton} bat gehitzen du botoiez osatutako bektore batera.
	 * 
	 * @param b
	 *            Bektorera gehitu beharreko botoia.
	 */
public Botoia(JButton b, int gunea) {
		this.bot = b;
		this.guneId = gunea;
		this.akt = false;
	}

	/**
	 * Botoia lortzeko
	 * 
	 * @return Botoi bat itzultzen du.
	 */
	public JButton getBotoia() {
		return bot;
	}

	/**
	 * Botoi bat aktibatuta dagoen ala ez esaten du.
	 * 
	 * @return Boolean bat itzultzen du. Botoia aktibatuta baldin badago
	 *         True itzultzen du, False bestela.
	 */
	public boolean isAktibatuta() {
		return akt;
	}

	/**
	 * Botoiaren egoera aldatzen du, aktibatu/desaktibatzeko balio du.
	 * 
	 */
	public void egoeraAldatu() {
		this.akt = !akt;
	}

	public int getGuneId(){
		return this.guneId;
	}
}