package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.mysql.jdbc.Statement;

/**
 * Erabiltzailearekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class ErabKud {

	private Statement agindua;

	private Connection konexioa;

	/**
	 * Programaren exekuzioan zehar erabiliko den datu-basearen aurkako konexioa
	 * esleituko du. Konexioa {@link Connection} klaseko objektu bat da.
	 * 
	 * @param kon
	 *            Datu-basearen aurkako konexioaren parametroak gordetzen dituen
	 *            klasea da. Negozio logika egikaritzean sortuko da eta honek
	 *            egikarituriko klase guztiek erabiliko dute.
	 * @throws SQLException
	 */
	public ErabKud(Connection kon) throws SQLException {
		konexioa = kon;
		agindua = (Statement) konexioa.createStatement();
	}

	/**
	 * Emandako motako erabiltzaileen id-ak lortzen ditu. Datuak {@link Vector}
	 * 
	 * @param mota
	 *            Erabiltzailearen mota adierazten duen string bat. Mota hauek
	 *            Profilak taulan adierazita daude.
	 * @return Erabiltzaile id-z osatutako bektore bat itzuliko du.
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public Vector<Integer> getErabiltzaileak(String mota)throws SQLException {

		Vector<Integer> id = new Vector<Integer>();
		String c1 = "SELECT E.id "
				+ "FROM profilak AS P INNER JOIN erabiltzaileak AS E ON P.id = E.profId "
				+ "WHERE P.mota = '" + mota + "'";
		ResultSet q = agindua.executeQuery(c1);
		while (q.next())
			id.addElement(new Integer(q.getInt("E.id")));
		return id;
	}

	/**
	 * Emandako erabiltzaile Id-ari dagokion erabiltzaile izena itzultzen du.
	 * 
	 * @param erabId
	 *            Datu-baseko erabiltzaile baten id-a adierazten duen zenbaki
	 *            bat. Erabiltzaileak taulan adierazita dago.
	 * @return Emandako erabiltzailearen izena duen String bat itzultzen du.
	 *         Erabiltzaile Id batentzako izenik aurkitzen ez badu, null balioa
	 *         itzuliko du.
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public String getErabDatuak(int erabId) throws SQLException {
		String izena = null;
		String c4 = "SELECT E.izena "
				+ "FROM erabiltzaileak AS E INNER JOIN txartelak AS T ON T.erabId=E.id "
				+ "WHERE E.id = " + erabId;
		ResultSet q = agindua.executeQuery(c4);
		while (q.next())
			izena = q.getString("E.izena");
		return izena;
	}

	/**
	 * Emandako erabiltzailearen id-a, erabilzailearen izena, pasahitza eta profil id-a duen
	 * erabiltzailea sortzen du.
	 * 
	 * @param nan Erabiltzailearen identifikatzailea edo nan zenbakia
	 * @param izena Erabiltzailearen izena
	 * @param pasahitza Erabiltzaileak bere burua identifikatzeko sartu beharko duen pasahitza
	 * @param profId Erabiltzaile horri dagokion profilaren id-a
	 * @throws SQLException
	 */
	public void insertErabiltzailea(int nan, String izena, String pasahitza,
			int profId) throws SQLException {
		String erab = "INSERT INTO erabiltzaileak (id,izena,pasahitza,profId) "
				+ "VALUES (" + nan + ",'" + izena + "','" + pasahitza + "',"
				+ profId + ")";
		this.agindua.executeUpdate(erab);
	}

	/**
	 * Emandako erabiltzailearen identifikazioari pasatako pasahitza dagokion edo ez esaten du
	 * 
	 * @param nan Erabiltzailearen identifikazioa
	 * @param pasahitza Erabitzailearen pasahitza
	 * @return Emandako erabiltzailea existitzen bada eta bere pasahitza emandakoa bada true itzultzen du, bestela false
	 * @throws SQLException
	 */
	public boolean isLoginZuzena(int nan, String pasahitza)
			throws SQLException {
		String query = "SELECT * FROM erabiltzaileak WHERE id = " + String.valueOf(nan)
				+ " AND pasahitza = '" + pasahitza + "'";
		ResultSet r = agindua.executeQuery(query);
		return r.next();
	}

	/**
	 * Erabiltzaile baten idetifikazioa emanda, erabiltzaile horri dagokion profilaren identifikazioa itzultzen du
	 * 
	 * @param nan Erabiltzailearen identifikatzailea
	 * @return Emandako erabiltzaileari dagokion profilaren id-a
	 * @throws SQLException
	 */
	public int getProfila(int nan) throws SQLException {
		String query = "SELECT P.id FROM erabiltzaileak AS E INNER JOIN profilak AS P ON E.profId = P.id WHERE E.id = "
				+ String.valueOf(nan);
		ResultSet r = agindua.executeQuery(query);
		if (r.next())
			return r.getInt("id");
		else
			return -1;
	}
}
