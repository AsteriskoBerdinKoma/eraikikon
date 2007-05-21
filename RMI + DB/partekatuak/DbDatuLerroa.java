package partekatuak;

import java.io.Serializable;

/**
 * Datu-basetik lortutako datu-multzoa gordetzeko klasea. Klase honek
 * {@link Serializable} klasea inplementatzen du, bere datuak RMI bitartez
 * bidali ahal izateko.
 * 
 * @author 5. Taldea
 * 
 */
public class DbDatuLerroa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ateId;

	private String sarbideData;

	private int txartelId;

	private int txartelIrakId;

	private int hasieraGune;

	private int helburuGune;

	private String baimenduta;

	private String ukapenarenArrazoia;

	/**
	 * Metodo eraikitzailea. Objektuari balio guztiak hasieratik esleitzeko
	 * erabili daiteke.
	 * 
	 * @param a
	 *            Ate baten identifikadorea, zenbakizkoa.
	 * @param s
	 *            Data bat UUUU-hh-ee formatuan, String bat.
	 * @param t
	 *            Txartel baten identifikadorea, zenbakizkoa.
	 * @param ti
	 *            Txartel-irakurgailu baten identifikadorea, zenbaki bat.
	 * @param ha
	 *            Sarbide-eskaeraren hasierako gunearen identifikadore bat,
	 *            zenbakizkoa.
	 * @param he
	 *            Sarbide-eskaeraren helburu gunearen indentifikadore bat,
	 *            zenbakizkoa.
	 * @param b
	 *            Sarbide-eskaera baimenduta izan den edo ez adierazten duen '0'
	 *            edo '1' zenbakia.
	 * @param u
	 *            Sarbide-eskaera bat ukatzearen arrazoia deskribatzen duen
	 *            String bat.
	 */
	public DbDatuLerroa(int a, String s, int t, int ti, int ha, int he, int b,
			String u) {
		ateId = a;
		sarbideData = s;
		txartelId = t;
		txartelIrakId = ti;
		hasieraGune = ha;
		helburuGune = he;
		if (b == 0)
			baimenduta = "Ez";
		else
			baimenduta = "Bai";
		ukapenarenArrazoia = u;

	}

	/**
	 * Metodo eraikitzailea. Objektu hutsa sortzeko erabiltzen da.
	 * 
	 */
	public DbDatuLerroa() {

	}

	/**
	 * Atearen identifikadorea lortzeko
	 * 
	 * @return Atearen identifikadore bat den zenbakia itzultzen du.
	 */
	public int getAteId() {
		return ateId;
	}

	/**
	 * Sarbide-eskaeraren data lortzeko
	 * 
	 * @return Sarbide-eskaeraren data itzultzen du UUUU-hh-ee formatua duen
	 *         String batean.
	 */
	public String getSarbideData() {
		return sarbideData;
	}

	/**
	 * Txartelaren identifikatzailea lortzeko
	 * 
	 * @return Txartelaren identifikadore bat den zenbakia itzultzen du.
	 */
	public int getTxartelId() {
		return txartelId;
	}

	/**
	 * Txartel-irakurgailuaren identifikatzailea lortzeko
	 * 
	 * @return Txartel-irakurgailu identifikadore bat den zenbakia itzultzen du.
	 */
	public int getTxartelIrakId() {
		return txartelIrakId;
	}

	/**
	 * Sarbide-eskaera baten hasiera-gunea lortzeko
	 * 
	 * @return Sarbide-eskaera baten hasierako gunearen identifikadorea
	 *         itzultzen du, zenbaki bat.
	 */
	public int getHasieraGune() {
		return hasieraGune;
	}

	/**
	 * Sarbide-eskaera baten helburu-gunea lortzeko
	 * 
	 * @return Sarbide-eskaera baten helburu-gunearen identifikadorea itzultzen
	 *         du, zenbaki bat.
	 */
	public int getHelburuGune() {
		return helburuGune;
	}

	/**
	 * Sarbide-eskaera baimenduta izan den ala ez jakiteko
	 * 
	 * @return "Bai" edo "Ez" duen String bat itzuliko du, sarbide-eskaeraren
	 *         baimentze egoeraren arabera.
	 */
	public String getBaimenduta() {
		return baimenduta;
	}

	/**
	 * Sarbide-eskaera ukatzearen arrazoia lortzeko
	 * 
	 * @return Sarbide-eskaera ukatua izatearen arrazoia itzultzen du String
	 *         batean.
	 */
	public String getUkapenarenArrazoia() {
		return ukapenarenArrazoia;
	}

	/**
	 * Ate identifikadorea esleitzeko
	 * 
	 * @param a
	 *            Ate identifikadore bat adierazten duen zenbaki bat.
	 */
	public void setAteId(int a) {
		ateId = a;
	}

	/**
	 * Sarbide-eskaera data esleitzeko
	 * 
	 * @param s
	 *            UUUU-hh-ee formatua duen eta data bat adierazten duen String
	 *            bat.
	 */
	public void setSarbideData(String s) {
		sarbideData = s;
	}

	/**
	 * Txartelaren identifikadorea esleitzeko
	 * 
	 * @param t
	 *            Txartel identifikadore bat adierazten duen zenbaki bat.
	 */
	public void setTxartelId(int t) {
		txartelId = t;
	}

	/**
	 * Txartel-irakurgailuaren identifikadorea esleitzeko
	 * 
	 * @param t
	 *            Txartel-irakurgailu identifikadore bat adierazten duen zenbaki
	 *            bat.
	 */
	public void setTxartelIrakId(int t) {
		txartelIrakId = t;
	}

	/**
	 * Sarbide-eskaeraren hasierako gunea esleitzeko
	 * 
	 * @param h
	 *            Gune identifikadore bat adierazten duen zenbaki bat.
	 */
	public void setHasieraGune(int h) {
		hasieraGune = h;
	}

	/**
	 * Sarbide-eskaeraren helburu-gunea esleitzeko
	 * 
	 * @param h
	 *            Gune identifikadore bat adierazten duen zenbaki bat.
	 */
	public void setHelburuGune(int h) {
		helburuGune = h;
	}

	/**
	 * Sarbide-eskaeraren baimentze egoera esleitzeko.
	 * 
	 * @param b
	 *            '0' edo '1' zenbakia jasotzen da. '0'k sarbide-eskaera
	 *            baimenik ez duela adierazten du eta '1'k baimena duela
	 */
	public void setBaimenduta(int b) {
		if (b == 0)
			baimenduta = "Ez";
		else
			baimenduta = "Bai";
	}

	/**
	 * Sarbide-eskaeraren ukapenaren arrazoia esleitzeko
	 * 
	 * @param u
	 *            Ukapen arrazoi bat adierazten duen String bat.
	 */
	public void setUkapenarenArrazoia(String u) {
		ukapenarenArrazoia = u;
	}
}
