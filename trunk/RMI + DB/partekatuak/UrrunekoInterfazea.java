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
	 */
	public Vector<IrakasleGatazkatsuaDatuak> getGatazkatsuenak(String sarData)
			throws RemoteException;

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
	 */
	public void createIntzidentzia(String TxartelId, String TxartelIrakId,
			String NoiztikNora) throws RemoteException;

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
	 */
	public Vector getIntzidentziak() throws RemoteException;
	
	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData, String bukData, String hasOrd, String bukOrd) throws RemoteException;
	
	/**
	 * Eraikinean dauden pertsonen kopurua itziltzen du. 
	 * @return int batean eraikinean dauden pertsonen kopurua.
	 * @throws SQLException
	 */
	public int getEraikinekoPertsonKop() throws RemoteException;

	public boolean loginEgin(String erab, String pasahitza) throws RemoteException;
}
