package zerbitzaria.kudeatzaileak;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import partekatuak.*;

/**
 * IrakasleGatazkatsuena-ren zerbitzaria hasieratuko duen klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class UrrunekoNegozioLogika extends UnicastRemoteObject implements
		UrrunekoInterfazea {

	private static final long serialVersionUID = 1L;

	private ErabKud erak;

	private TxartelKud txk;

	private SarbideEskKud sek;

	private IntziKud intz;

	private FakulKud fakul;

	private TxartelIrakKud tik;

	private AteKud ate;

	private ProfKud prof;

	private GuneKud gunek;

	private OrdutegiKud ord;

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DATABASE_URL = "jdbc:mysql://localhost/eraikikon";

	private static final String USERNAME = "ikasle01";

	private static final String PASSWORD = "ikasle01";

	protected Connection kon;

	private boolean connectedToDatabase = false;

	/**
	 * Zerbitzuak izango duen izena.
	 */
	public static final String zerbitzuIzena = "EraikiKon";

	/**
	 * Zerbitzaria martxan dagoen bitartean datu basea atzitzeko erabiliko den
	 * konexioa irekitzen du eta erabiliko diren beste kudeatzaileak hasieratzen
	 * ditu.
	 * 
	 * @throws RemoteException
	 */
	public UrrunekoNegozioLogika() throws RemoteException {
		try {
			Class.forName(JDBC_DRIVER);
			kon = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Driverra Kargatuta.");
			connectedToDatabase = true;
		} catch (SQLException e) {
			System.out.println("Ezin izan da datu basearekin konexioa ezarri");
		} catch (ClassNotFoundException e) {
			System.out.println("Ez da " + JDBC_DRIVER + " driverra aurkitu");
		}
		try {
			erak = new ErabKud(kon);
			txk = new TxartelKud(kon);
			sek = new SarbideEskKud(kon);
			intz = new IntziKud(kon);
			tik = new TxartelIrakKud(kon);
			fakul = new FakulKud(kon);
			ate = new AteKud(kon);
			prof = new ProfKud(kon);
			gunek = new GuneKud(kon);
			ord = new OrdutegiKud(kon);
		} catch (SQLException e) {
			System.out.println("Errorea: " + e.toString());
		}
	}

	/**
	 * Datu basearekin konexioa irekita badago itxi egiten du.
	 * 
	 * @throws SQLException
	 * 
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		if (connectedToDatabase) {
			kon.close();
			connectedToDatabase = false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#createIntzidentzia(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void createIntzidentzia(String txartId, String tIrakId,
			String noiztikNora) throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		intz.insertIntzGatazkatsuena(txartId, tIrakId, noiztikNora);
	}

	public void createErabiltzailea(int nan, String izena, String pasahitza,
			int profId) throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		erak.insertErabiltzailea(nan, izena, pasahitza, profId);
	}

	public void createTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		txk.createTxartela(nan);
	}

	public void createProfila(String mota, String deskribapena) {
		try {
			prof.createProfila(mota, deskribapena);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int gaituTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.gaituTxartela(nan);
	}

	public int desgaituTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.desgaituTxartela(nan);
	}

	public int profilZenbakia(String mota) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		int profZenb;
		profZenb = prof.profilZenbakia(mota);
		return profZenb;
	}

	public int profilZenbakia(String mota, String deskribapena)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		int profZenb;
		profZenb = prof.profilZenbakia(mota, deskribapena);
		return profZenb;
	}

	public void alarmaIntzidentziaSortu() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		intz.insertAlarma();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getGatazkatsuenak(java.lang.String)
	 */
	public Vector<IrakasleGatazkatsuaDatuak> getGatazkatsuenak(String sarData)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		Vector<Integer> vErabiltzaileak;
		Vector<Integer> vErabTxartelIrakUkatu;
		Vector<IrakasleGatazkatsuaDatuak> vIrakGataz = new Vector<IrakasleGatazkatsuaDatuak>();
		String Izena = null;
		int txartelId = -1;
		vErabiltzaileak = erak.getErabiltzaileak("Irakaslea");
		if (vErabiltzaileak.size() != 0) {
			for (Integer erabId : vErabiltzaileak) {
				txartelId = txk.getTxartel2Urte(erabId.intValue());
				if (txartelId != -1) {
					vErabTxartelIrakUkatu = sek.getSarbideEskaeraUkatuak(
							txartelId, sarData);
					if (vErabTxartelIrakUkatu.size() != 0) {
						int ukapenKop = vErabTxartelIrakUkatu.size();
						int bereTxartelIrakUkatuena = vErabTxartelIrakUkatu
								.firstElement();
						vIrakGataz.addElement(new IrakasleGatazkatsuaDatuak(
								erabId, txartelId, ukapenKop,
								bereTxartelIrakUkatuena));
					}
				}
			}
		}
		Collections.sort(vIrakGataz);
		if (vIrakGataz.size() > 10)
			vIrakGataz.setSize(10);
		for (int i = 0; i < vIrakGataz.size(); i++) {
			Izena = erak.getErabDatuak(vIrakGataz.elementAt(i).getErabId());
			if (Izena != null)
				vIrakGataz.elementAt(i).setErabIzena(Izena);
		}
		return vIrakGataz;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getIntzidentziak()
	 */
	public Vector<Vector<Object>> getIntzidentziak()
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return intz.getIntzidentziak();
	}

	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData,
			String bukData, String hasOrd, String bukOrd)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return sek.getSarbideEskaerak(txartelid, hasData + " " + hasOrd,
				bukData + " " + bukOrd);
	}

	public Vector<String> getProfilak() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return prof.getProfilak();
	}

	public Vector<DbDatuLerroa> getSarbideEskaerak(String data)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		Vector<DbDatuLerroa> vTratatzekoDatuak;
		vTratatzekoDatuak = sek.getSarbideEskaerak(data);
		if (vTratatzekoDatuak.size() != 0) {
			for (DbDatuLerroa lerro : vTratatzekoDatuak) {
				int a = lerro.getAteId();
				int b = lerro.getHasieraGune();
				int helburugune = tik.getHelburuGunea(a, b);
				lerro.setHelburuGune(helburugune);
			}
			return vTratatzekoDatuak;
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getEraikinekoPertsonKop()
	 */
	public int getEraikinekoPertsonKop() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return fakul.getEraikinekoPertsonKop();
	}

	public String getErabIzena(int txId) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.getErabIzena(txId);
	}

	public int loginEgin(String erab, String pasahitza)
			throws IllegalStateException, RemoteException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		if (erak.isLoginZuzena(erab, pasahitza))
			return erak.getProfila(erab);
		else
			return -1;
	}

	public void irekiAteak() throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		ate.IrekiAteak();
	}

	public void ItxiAteak() throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		ate.ItxiAteak();
	}

	public void pertsonakAteraEraikinetik() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.pertsonakAteraEraikinetik();
	}

	public Vector<Vector<Object>> getGuneGuztiak()
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return gunek.getGuneGuztiak();
	}

	public Vector<Vector<Object>> getErabiltzaileKokapena(String txId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.getErabiltzaileKokapena(txId);
	}

	public boolean erabiltzaileaFakultatean(String erabId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return fakul.erabiltzaileaFakultatean(erabId);
	}

	public void kokapenaEguneratu(String erabId, String guneId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.kokapenaEguneratu(erabId, guneId);
	}

	public void kokapenaSartu(String erabId, String guneId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.kokapenaSartu(erabId, guneId);
	}

	public void createBisitariBaimenak(int profId, Vector<Integer> gune)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		for (Integer i : gune) {
			ord.createOrdutegia(false, "08:00:00", "19:30:00", profId, i
					.intValue());
		}
	}

	/**
	 * UrrunekoNegozioLogika-ren zerbitzaria hasieratzen du zerbitzuIzena
	 * atributuan definitutako zerbitzu izenarekin.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("java.security.policy", "client.policy");

		// Assingn security manager
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());

		try {
			UrrunekoNegozioLogika zerbitzariObj = new UrrunekoNegozioLogika();
			System.out.println("objektua jaurtia");

			try {
				java.rmi.registry.LocateRegistry.createRegistry(1099); // RMIREGISTRY
				// jaurtitzearen
				// baliokidea
			} catch (Exception e) {
				System.out
						.println(e.toString()
								+ "\nSuposatzen dugu errorea dela rmiregistry aurretik jaurti delako ");
			}
			// Urruneko zerbitzua erregistratu
			Naming.rebind(zerbitzuIzena, zerbitzariObj);
			// "//IPHelbidea:PortuZenb/zerbitzuIzena"
			// EZ DABIL rmiregistry izen zerbitzaria localhost-en EZ BADAGO

		} catch (Exception e) {
			System.out
					.println("Errorea zerbitzaria jaurtitzean" + e.toString());
		}
	}
}
