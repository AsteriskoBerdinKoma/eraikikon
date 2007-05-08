package partekatuak;

import java.io.Serializable;

/**
 * Irakasle gatazkatsu baten datuak gordetzeko klasea. Klase honek
 * {@link Serializable} klasea inplementatzen du, bere datuak RMI bitartez
 * bidali ahal izateko. Era berean, {@link Comparable} klasea inplementatzen da,
 * objektuak ukapen kopuruaren arabera ordenatu ahal izateko.
 * 
 * @author 5. TALDEA
 * 
 */
public class IrakasleGatazkatsuaDatuak implements
		Comparable<IrakasleGatazkatsuaDatuak>, Serializable {

	private static final long serialVersionUID = 1L;

	private Integer erabId = null;

	private String erabIzen = null;

	private Integer txartelId = null;

	private Integer ukaKop = null;

	private Integer txartelIrakUkatuenaId = null;

	/**
	 * Irakasle gatazkatsu baten informazioa gordetzen du, bere izena izan ezik.
	 * Izena esleitzeko set metodo bat erabiliko da.
	 * 
	 * @param erab
	 *            Erabiltzailearen id-a adierazten duen zenbakia bat da.
	 * @param txid
	 *            Erabiltzaile bati dagokion txartelaren id-a adierazten duen
	 *            zenbaki bat da.
	 * @param uka
	 *            Data batetik aurrera erabiltzaile bati dagozkion
	 *            sarbide-eskaera ukatu kopurua adierazten duen zenbakia.
	 * @param txuid
	 *            Data batetik aurrera erabiltzaile bati dagozkion
	 *            sarbide-eskaera ukatuen artean, gehiengoa zein txartel
	 *            irakurgailutan gertatu den adieratzen duen txartel
	 *            irakurgailuaren id-a.
	 */
	public IrakasleGatazkatsuaDatuak(int erab, int txid, int uka, int txuid) {
		erabId = erab;
		txartelId = txid;
		ukaKop = uka;
		txartelIrakUkatuenaId = txuid;
	}

	/**
	 * Erabiltzailearen id-a itzultzeko.
	 * 
	 * @return Erabiltzaile id bat itzultzen du, zenbaki bat.
	 */
	public int getErabId() {
		return erabId;
	}

	/**
	 * Erabiltzailearen izena itzultzeko.
	 * 
	 * @return Erabiltzailearen izena itzultzen du, String bat.
	 */
	public String getErabIzena() {
		return erabIzen;
	}

	/**
	 * Erabiltzailearen txartel id-a itzultzeko.
	 * 
	 * @return Txartel id bat itzultzen du, zenbaki bat.
	 */
	public int getTxartelId() {
		return txartelId;
	}

	/**
	 * Erabiltzaile batek, data batetik aurrera izandako sarbide-eskaera ukatu
	 * kopurua itzultzen du.
	 * 
	 * @return Ukapen kopurua itzultzen du, zenbaki bat.
	 */
	public int getUkapenKop() {
		return ukaKop;
	}

	/**
	 * Erabiltzaile batek, data batetik aurrera izandako sarbide-eskaera ukatuen
	 * artean txartel irakurgailu ukatuena itzultzen du.
	 * 
	 * @return Txartel-irakurgailu id bat itzultzen du, zenbaki bat.
	 */
	public int getTxartelIrakUkatuena() {
		return txartelIrakUkatuenaId;
	}

	/**
	 * Irakasle gatazkatsu bati izena esleitzen dio
	 * 
	 * @param izena
	 *            Erabiltzailea baten izena adierazten duen String bat.
	 */
	public void setErabIzena(String izena) {
		erabIzen = izena;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(IrakasleGatazkatsuaDatuak vGataz) {
		return -(this.ukaKop - vGataz.getUkapenKop());
	}

}
