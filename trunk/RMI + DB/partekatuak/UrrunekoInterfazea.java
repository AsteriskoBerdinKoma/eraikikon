package partekatuak;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Urruneko negozio logikak izan beharreko metodoak definitzen dituen
 * interfazea.
 * 
 * @author 5.TALDEA
 * 
 */
public interface UrrunekoInterfazea extends Remote {

	/**
	 * Sarbide eskaera bat egin deneko data bat emanez, begiratuko ditu
	 * irakasleak direnak eta bektore batean sartuko ditu. Ondoren,irakasle
	 * bakoitzeko, ea txartela orain dela 2 urte baino gehiago gaitua izan
	 * zen,ta horrela bada, ea ate horretatik sartzeko baimena ukatua zuen edo
	 * ez. Horrela diren kasuetan, gatazkatsuenak izango diren bektore batean
	 * sartuko ditu.
	 * 
	 * @param sarData
	 *            Sarbide eskaera egin zeneko data
	 * @return Bektore bat itzultzen du, non irakasle gatazkatsuenak sartzen
	 *         dituen
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<IrakasleGatazkatsuaDatuak> getGatazkatsuenak(String sarData)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Intzidentzia bat sortzen du (data, mota, idTxartela,
	 * idTxartelIrakurgailua, gaituta, noiztikNora)datuekin. Datu hauek,
	 * getGatazkatsuenak itzuliko dizkio.
	 * 
	 * @param TxartelId
	 *            Txartelaren identifikazioa daukan string bat
	 * @param TxartelIrakId
	 *            Txartel irakurgailuaren identifikazioa daukan string bat
	 * @param NoiztikNora
	 *            Zein denbora tartetan izen den irakasle gatazkatsuena. Bere
	 *            formatua UUUU-HH/UUUU-HH
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void createIntzidentzia(String TxartelId, String TxartelIrakId,
			String NoiztikNora) throws IllegalStateException, RemoteException,
			SQLException;

	/**
	 * Datu basean dauden intzidentzia guztiak itzultzen ditu. Intzidentziaren
	 * datu bakoitza {@link Object} datu mota batetan gordetzen du eta lerro
	 * bateko objektu guztiekin bektore bat osatuko du. Azkenik, lerro guztiekin
	 * beste bektore bat osatuko du.
	 * 
	 * @return lehenengo bektorean lerroak gordeko dira datu bakoitzeko Object
	 *         bat sortuz. Sortutako lerro bakoitzeko bektorea bigarren
	 *         bektorean gordetzen da azken honek taula osoa osatuz.
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<Vector<Object>> getIntzidentziak()
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Erabiltzaile bat hasierako data eta ordu batetik bukaerako data eta ordu
	 * batera igarotako guneei buruzko informazioa itzultzen du {@link Vector}<{@link Vector}<{@link Object}>>
	 * batean.
	 * 
	 * @param txartelid
	 *            Erabiltzaile baten txartel-identifikadorea, zenbakizkoa.
	 * @param hasData
	 *            Erabiltzailearen kontrolaren hasierako data, UUUU-hh-ee
	 *            formatua duen String bat.
	 * @param bukData
	 *            Erabiltzailearen kontrolaren bukaerako data, UUUU-hh-ee
	 *            formatua duen String bat.
	 * @param hasOrd
	 *            Emandako data-tartean kontrolatu beharreko hasiera ordua,
	 *            HH:MM formatua duen String bat.
	 * @param bukOrd
	 *            Emandako data-tartean kontrolatu beharreko bukaera ordua,
	 *            HH:MM formatua duen String bat.
	 * @return Emandako data eta ordu-tartean erabiltzaileak igaro dituen guneei
	 *         buruzko informazioa duen objektu bektorez osatutako bektore bat.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData,
			String bukData, String hasOrd, String bukOrd)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Eraikinean une honetan dauden pertsonen kopurua itzultzen du.
	 * 
	 * @return Zenbaki bat eraikinean dauden pertsonen kopurua adierazten du.
	 * @throws SQLException
	 * @throws SQLException
	 */
	public int getEraikinekoPertsonKop() throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Emandako txartel identifikatzailearen jabearen izena itzultzen du.
	 * 
	 * @param txId
	 *            Txartel identifikatzaile bat, zenbakizkoa.
	 * @return Txartel identifikatzaileari dagokion erabiltzaile izena, String
	 *         bat.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public String getErabIzena(int txId) throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Emandako nan zenbakia (erabiltzailearen identifikatzailea) sisteman
	 * existitzen den eta erabiltzaile horri emandako pasahitza dagokion
	 * konprobatzen da. Lortutako emaitzaren arabera sisteman sartzen utziko du
	 * edo ez.
	 * 
	 * @param nan
	 *            Erabiltzaile baten identifikadorea edo nan zenbakia.
	 * @param pasahitza
	 *            Erabiltzaile horri dagokion pasahitza, String bat.
	 * @return Identifikazioa ondo joan bada 0 baino handiago edo berdina den
	 *         zenbaki bat, erabiltzaile horri dagokion profil identifikadorea,
	 *         itzuliko du honela dagokion menuan sartzeko. Bestela, -1 itzuliko
	 *         du eta errorea jaurtiko da.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public int loginEgin(int nan, String pasahitza)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Emandako datan izan diren sarbide eskaeren datuak itzultzen ditu.
	 * 
	 * @param data
	 *            Lortu behar diren sarbide-eskaeren data UUUU-hh-ee formatuan.
	 * @return {@link DbDatuLerroa}} objektuz osaturiko {@link Vector} bat
	 *         itzuliko du. DbDatuLerroa objektu bakoitzean datu-basetik
	 *         lortutako datu-lerro bat gordeko da.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<DbDatuLerroa> getSarbideEskaerak(String data)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Eraikineko ate guztiak irekitzen ditu
	 * 
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void irekiAteak() throws IllegalStateException, RemoteException,
			SQLException;

	/**
	 * Eraikineko ate guztiak isten ditu
	 * 
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void ItxiAteak() throws IllegalStateException, RemoteException,
			SQLException;

	/**
	 * Eraikineko alarma gaitzerakoan honen berri ematen duen intzidentzia
	 * sortzen du.
	 * 
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void alarmaIntzidentziaSortu() throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Datu-basetik eraikinaren barnean zeuden erabiltzaileak ezabatzen ditu
	 * 
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void pertsonakAteraEraikinetik() throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Existitzen diren profil mota guztiak itzultzen ditu
	 * 
	 * @return String-ez osatutako {@link Vector} bat non String bakoitza profil
	 *         mota bat den.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<String> getProfilak() throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Emandako datuekin erabiltzaile berri bat sortzen du.
	 * 
	 * @param nan
	 *            Erabiltzaile berriaren erabiltzaile identifikadorea edo nan-a,
	 *            zenbakizkoa.
	 * @param izena
	 *            Erabiltzaile berriaren izena, String bat.
	 * @param pasahitza
	 *            Erabiltzaile berriaren pasahitza SHA-1ekin kodetuta, String
	 *            bat.
	 * @param profId
	 *            Erabiltzaile berriari dagokion profil motaren identifikadorea,
	 *            zenbakizkoa.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void createErabiltzailea(int nan, String izena, String pasahitza,
			int profId) throws IllegalStateException, RemoteException,
			SQLException;

	/**
	 * Profil mota bati dagokion profil identifikadorea lortzen du.
	 * 
	 * @param mota
	 *            Profil mota bat adierazten duen String bat.
	 * @return Profil mota bati dagokion profil identifikadorea, zenbakizkoa.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public int profilZenbakia(String mota) throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Profil identifikadore eta deskribapena emanda profil identifikadorea
	 * lortzen du.
	 * 
	 * @param mota
	 *            Profil mota bat adierazten duen String bat.
	 * @param deskribapena
	 *            Profila deskribatzen duen String bat.
	 * @return Profil baten profil identifikadorea, zenbakizkoa.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public int profilZenbakia(String mota, String deskribapena)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Emandako nan zenbakiarentzat txartel bat sortzen du
	 * 
	 * @param nan
	 *            Erabiltzailearen identfikadore izango den nan zenbakia.
	 * @throws RemoteException
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public void createTxartela(int nan) throws RemoteException,
			IllegalStateException, SQLException;

	/**
	 * Emandako erabiltzaile identifikadorea duen txartela gaitzen du
	 * 
	 * @param nan
	 *            Erabiltzaile identifikadore bat adierazten duen zenbakia.
	 * @return Aldatutako txartel kopurua itzultzen du, '1' balioa izango du
	 *         dena ondo joan bada eta '0' bestela.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public int gaituTxartela(int nan) throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Emandako mota eta deskribapena duen profil berri bat sortzen du
	 * 
	 * @param mota
	 *            Profilaren mota adierazten duen String bat.
	 * @param deskribapena
	 *            Profila deskribatzen duen testua, String bat.
	 * @throws RemoteException
	 */
	public void createProfila(String mota, String deskribapena)
			throws RemoteException;

	/**
	 * Emandako erabiltzaile identifikatzailea duen txartela desgaitzen du
	 * 
	 * @param nan
	 *            Erabiltzaile identifikadore bat adierazten duen zenbakia.
	 * @return Txartelaren desgaipena gauzatu den ala ez itzultzen du.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public int desgaituTxartela(int nan) throws IllegalStateException,
			RemoteException, SQLException;

	/**
	 * Une honetan erabiltzailea non dagoen buruzko informazioa itzultzen du.
	 * 
	 * @param txId
	 *            Txartel identifikadore bat, zenbakizkoa.
	 * @return Erailtzailea une horretan dagoen gunearen, atearen... informazioa
	 *         Objektuz osatutako bektorezko bektore batean itzultzen du.
	 *         Azpibektore bakoitza informazio lerro bat delarik.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<Vector<Object>> getErabiltzaileKokapena(String txId)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Gune guztiei buruzko informazioa itzultzen du.
	 * 
	 * @return Eraikinean dauden gune guztiei buruzko informazioa itzultzen du
	 *         objektuz osatutako bektorezko bektore batean. Azpibektore
	 *         bakoitza gune bat informazioa gordetzen du.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public Vector<Vector<Object>> getGuneGuztiak()
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Erabiltzaile bat Fakultate barruan dagoen adierazten du.
	 * 
	 * @param erabId
	 *            Erabiltzaile identifikadore bat, zenbakizkoa.
	 * @return Erabiltzailea fakultatean badago 'True' itzuliko du, 'False'
	 *         bestela.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public boolean erabiltzaileaFakultatean(String erabId)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Emandako erabiltzailearen kokapena eguneratzen du, hau beste gune batera
	 * mugituz.
	 * 
	 * @param erabId
	 *            Erabiltzailearen identifikadorea, zenbakizkoa.
	 * @param guneId
	 *            Erabiltzailea mugituko den gunearen id-a.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void kokapenaEguneratu(String erabId, String guneId)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Erabiltzaiaren kokapena ezezaguna bada kokapen berria sortzen du, hau
	 * beste gune batera mugituz.
	 * 
	 * @param erabId
	 *            Erabiltzailearen identifikadorea, zenbakizkoa.
	 * @param guneId
	 *            Erabiltzailea mugituko den gunearen id-a.
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void kokapenaSartu(String erabId, String guneId)
			throws IllegalStateException, RemoteException, SQLException;

	/**
	 * Erabiltzaile baten kokapena aldatzean sarbide-eskaera eguneratua
	 * sortzeko.
	 * 
	 * @param tx
	 *            Txartel identifikadorea, zenbakizkoa.
	 * @param tirak
	 *            Txartel-irakurgailuaren identifikadorea, zenbakizkoa.
	 * @throws RemoteException
	 */
	public void sarbideEskaeraEguneratu(int tx, int tirak)
			throws RemoteException;

	/**
	 * Profil bati gune batzuetan sartzeko baimenak esleitzeko
	 * 
	 * @param profId
	 *            Profil identifikadorea, zenbakizkoa.
	 * @param gune
	 *            Gune identifikadorez osatutako bektore bat
	 * @throws IllegalStateException
	 * @throws RemoteException
	 * @throws SQLException
	 */
	public void createBisitariBaimenak(int profId, Vector<Integer> gune)
			throws IllegalStateException, RemoteException, SQLException;

}
