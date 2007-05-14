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

import javax.swing.JOptionPane;

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

			erak = new ErabKud(kon);
			txk = new TxartelKud(kon);
			sek = new SarbideEskKud(kon);
			intz = new IntziKud(kon);
			tik = new TxartelIrakKud(kon);
			fakul = new FakulKud(kon);
			ate = new AteKud(kon);
			prof = new ProfKud(kon);
			gunek = new GuneKud(kon);
			
		} catch (Exception ex) {
			System.out.println("Errorea: " + ex.toString());
		}
	}

	/**
	 * Datu basearekin konexioa irekita badago itxi egiten du.
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
			String noiztikNora) {
		try {
			intz.insertIntzGatazkatsuena(txartId, tIrakId, noiztikNora);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createErabiltzailea(int nan, String izena, String pasahitza,
			int profId) {
		try {
			erak.insertErabiltzailea(nan, izena, pasahitza, profId);
		} catch (SQLException e) {
			new MezuLeiho("Erabiltzaile hori jadanik existitzen da", "Ados",
					"Arazoa erabiltzailea sortzerakoan",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void gaituTxartela(int nan) {
		try {
			txk.gaituTxartela(nan);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void gaitTxartela(int nan) {
		try {
			txk.gaitTxartela(nan);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desgaituTxartela(int nan) {
		try {
			txk.desgaituTxartela(nan);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int profilZenbakia(String mota) {
		try {
			int profZenb;
			profZenb = prof.profilZenbakia(mota);
			return profZenb;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void alarmaIntzidentziaSortu() {
		try {
			intz.insertAlarma();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getGatazkatsuenak(java.lang.String)
	 */
	public Vector<IrakasleGatazkatsuaDatuak> getGatazkatsuenak(String sarData) {
		if (!connectedToDatabase)
			throw new IllegalStateException(
					"Datu-basearekin ez dago konexiorik.");
		try {
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
							vIrakGataz
									.addElement(new IrakasleGatazkatsuaDatuak(
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
		} catch (IllegalStateException e) {
			System.out.println("DB errorea:" + e.toString());
			return null;
		} catch (SQLException e) {
			System.out.println("DB errorea:" + e.toString());
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getIntzidentziak()
	 */
	public Vector<Vector<Object>> getIntzidentziak() {
		try {
			return intz.getIntzidentziak();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vector<Vector<Object>> getGuneak(int txartelid, String hasData,
			String bukData, String hasOrd, String bukOrd) {
		try {
			return sek.getSarbideEskaerak(txartelid, hasData + " " + hasOrd,
					bukData + " " + bukOrd);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Vector<String> getProfilak() throws IllegalStateException,
			SQLException {
		return prof.getProfilak();
	}

	public Vector<DbDatuLerroa> getSarbideEskaerak(String data) {

		try {
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
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see irakasleGatazkatsuenaRMI.UrrunekoInterfazea#getEraikinekoPertsonKop()
	 */
	public int getEraikinekoPertsonKop() {
		try {
			return fakul.getEraikinekoPertsonKop();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getErabIzena(int txId) {
		try {
			return txk.getErabIzena(txId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int loginEgin(String erab, String pasahitza) throws RemoteException {
		try {
			if (erak.isLoginZuzena(erab, pasahitza))
				return erak.getProfila(erab);
			else
				return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void irekiAteak() {
		try {
			ate.IrekiAteak();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ItxiAteak() {
		try {
			ate.ItxiAteak();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pertsonakAteraEraikinetik() {
		try {
			fakul.pertsonakAteraEraikinetik();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Vector<Object>> getGuneGuztiak() {
		try {
			return gunek.getGuneGuztiak();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public Vector<Vector<Object>> getErabiltzaileKokapena(String txId) {

		try {
			return txk.getErabiltzaileKokapena(txId);
		} catch (IllegalStateException e) {

			e.printStackTrace();
			return null;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public boolean erabiltzaileaFakultatean(String erabId) {
		try {
			return fakul.erabiltzaileaFakultatean(erabId);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void kokapenaEguneratu(String erabId, String guneId) {
		try {
			fakul.kokapenaEguneratu(erabId, guneId);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void kokapenaSartu(String erabId, String guneId) {
		try {
			fakul.kokapenaSartu(erabId, guneId);
		} catch (IllegalStateException e) {
			e.printStackTrace();
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
