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
			String NoiztikNora) throws IllegalStateException, RemoteException, SQLException;

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
	public Vector<Vector<Object>> getIntzidentziak() throws IllegalStateException, RemoteException, SQLException;
	
	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData, String bukData, String hasOrd, String bukOrd) throws IllegalStateException, RemoteException, SQLException;
	
	/**
	 * Eraikinean dauden pertsonen kopurua itziltzen du. 
	 * @return int batean eraikinean dauden pertsonen kopurua.
	 * @throws SQLException 
	 * @throws SQLException
	 */
	public int getEraikinekoPertsonKop() throws IllegalStateException, RemoteException, SQLException;

	public String getErabIzena(int txId) throws IllegalStateException, RemoteException, SQLException;
	
	public int loginEgin(String erab, String pasahitza) throws IllegalStateException, RemoteException, SQLException;
	
	public Vector<DbDatuLerroa> getSarbideEskaerak(String data) throws IllegalStateException, RemoteException, SQLException;
	
	public void irekiAteak() throws IllegalStateException, RemoteException, SQLException;
	
	public void ItxiAteak() throws IllegalStateException, RemoteException, SQLException;
	
	public void alarmaIntzidentziaSortu() throws IllegalStateException, RemoteException, SQLException;

	public void pertsonakAteraEraikinetik() throws IllegalStateException, RemoteException, SQLException;
	
	public Vector<String> getProfilak() throws IllegalStateException, RemoteException, SQLException;
	
	public void createErabiltzailea(int nan, String izena, String pasahitza, int profId) throws IllegalStateException, RemoteException, SQLException;
	
	public int profilZenbakia(String mota) throws IllegalStateException, RemoteException, SQLException;
	
	public int profilZenbakia(String mota,String deskribapena) throws IllegalStateException, RemoteException, SQLException;
	
	public void createTxartela(int nan) throws RemoteException, IllegalStateException, SQLException;
	
	public int gaituTxartela(int nan) throws IllegalStateException, RemoteException, SQLException;
	
	public void createProfila(String mota, String deskribapena) throws RemoteException;
	
	public int desgaituTxartela(int nan) throws IllegalStateException, RemoteException, SQLException;

	public Vector<Vector<Object>> getErabiltzaileKokapena (String txId) throws IllegalStateException, RemoteException, SQLException;
	
	public Vector<Vector<Object>> getGuneGuztiak() throws IllegalStateException, RemoteException, SQLException;
	
	public boolean erabiltzaileaFakultatean(String erabId) throws IllegalStateException, RemoteException, SQLException;
	
	public void kokapenaEguneratu( String erabId, String guneId) throws IllegalStateException, RemoteException, SQLException;
	
	public void kokapenaSartu( String erabId, String guneId)throws IllegalStateException, RemoteException, SQLException;
	
	public void sarbideEskaeraEguneratu(int tx,int tirak) throws RemoteException;

	public void createBisitariBaimenak(int profId, Vector<Integer> gune) throws IllegalStateException, RemoteException, SQLException;


}
