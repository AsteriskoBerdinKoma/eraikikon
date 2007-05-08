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

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DATABASE_URL = "jdbc:mysql://localhost/eraikikon";

	private static final String USERNAME = "ikasle01";

	private static final String PASSWORD = "ikasle01";

	protected Connection kon;

	private boolean connectedToDatabase = false;

	/**
	 * Zerbitzuak izango duen izena.
	 */
	public static final String zerbitzuIzena = "irakasleGatazkatsuena";

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
		} catch (Exception ex) {
			System.out.println("Errorea: " + ex.toString());
		}
		erak = new ErabKud(kon);
		txk = new TxartelKud(kon);
		sek = new SarbideEskKud(kon);
		intz = new IntziKud(kon);
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
		intz.insertIntzGatazkatsuena(txartId, tIrakId, noiztikNora);
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
		return intz.getIntzidentziak();
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
