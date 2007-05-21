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

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#createErabiltzailea(int, java.lang.String, java.lang.String, int)
	 */
	public void createErabiltzailea(int nan, String izena, String pasahitza,
			int profId) throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		erak.insertErabiltzailea(nan, izena, pasahitza, profId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#createTxartela(int)
	 */
	public void createTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		txk.createTxartela(nan);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#createProfila(java.lang.String, java.lang.String)
	 */
	public void createProfila(String mota, String deskribapena) {
		try {
			prof.createProfila(mota, deskribapena);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#gaituTxartela(int)
	 */
	public int gaituTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.gaituTxartela(nan);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#desgaituTxartela(int)
	 */
	public int desgaituTxartela(int nan) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.desgaituTxartela(nan);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#profilZenbakia(java.lang.String)
	 */
	public int profilZenbakia(String mota) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		int profZenb;
		profZenb = prof.profilZenbakia(mota);
		return profZenb;
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#profilZenbakia(java.lang.String, java.lang.String)
	 */
	public int profilZenbakia(String mota, String deskribapena)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		int profZenb;
		profZenb = prof.profilZenbakia(mota, deskribapena);
		return profZenb;
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#alarmaIntzidentziaSortu()
	 */
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

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getGuneak(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData,
			String bukData, String hasOrd, String bukOrd)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return sek.getSarbideEskaerak(txartelid, hasData + " " + hasOrd,
				bukData + " " + bukOrd);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getProfilak()
	 */
	public Vector<String> getProfilak() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return prof.getProfilak();
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getSarbideEskaerak(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getErabIzena(int)
	 */
	public String getErabIzena(int txId) throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.getErabIzena(txId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#loginEgin(int, java.lang.String)
	 */
	public int loginEgin(int nan, String pasahitza)
			throws IllegalStateException, RemoteException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		if (erak.isLoginZuzena(nan, pasahitza))
			return erak.getProfila(nan);
		else
			return -1;
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#irekiAteak()
	 */
	public void irekiAteak() throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		ate.IrekiAteak();
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#ItxiAteak()
	 */
	public void ItxiAteak() throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		ate.ItxiAteak();
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#pertsonakAteraEraikinetik()
	 */
	public void pertsonakAteraEraikinetik() throws IllegalStateException,
			SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.pertsonakAteraEraikinetik();
	}


	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getGuneGuztiak()
	 */
	public Vector<Vector<Object>> getGuneGuztiak() 
			throws IllegalStateException, SQLException{
		Vector<Vector<Object>> vGuneInfo;
		
			vGuneInfo= gunek.getGuneGuztiak();
			if (vGuneInfo!=null){
				for (Vector<Object> lerro: vGuneInfo){
					String ateid= lerro.elementAt(2).toString();
					String guneid=lerro.elementAt(0).toString();
					lerro.insertElementAt(tik.getHelburuGunea(Integer.parseInt(ateid), Integer.parseInt(guneid)), 3);
				}
				return vGuneInfo;
			}
			else
				return null;
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#getErabiltzaileKokapena(java.lang.String)
	 */
	public Vector<Vector<Object>> getErabiltzaileKokapena(String txId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return txk.getErabiltzaileKokapena(txId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#erabiltzaileaFakultatean(java.lang.String)
	 */
	public boolean erabiltzaileaFakultatean(String erabId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		return fakul.erabiltzaileaFakultatean(erabId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#kokapenaEguneratu(java.lang.String, java.lang.String)
	 */
	public void kokapenaEguneratu(String erabId, String guneId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.kokapenaEguneratu(erabId, guneId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#kokapenaSartu(java.lang.String, java.lang.String)
	 */
	public void kokapenaSartu(String erabId, String guneId)
			throws IllegalStateException, SQLException {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		fakul.kokapenaSartu(erabId, guneId);
	}

	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#createBisitariBaimenak(int, java.util.Vector)
	 */
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
	
	/* (non-Javadoc)
	 * @see partekatuak.UrrunekoInterfazea#sarbideEskaeraEguneratu(int, int)
	 */
	public void sarbideEskaeraEguneratu(int txartelid,int txartelirakid){
		try {
			sek.sarbideEskaeraEguneratu(txartelid,txartelirakid);
		} catch (SQLException e) {
			e.printStackTrace();
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
