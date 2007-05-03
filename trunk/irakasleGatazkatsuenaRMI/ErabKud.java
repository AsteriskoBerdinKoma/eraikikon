package irakasleGatazkatsuenaRMI;

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
	 */
	public ErabKud(Connection kon) {
		try {
			konexioa = kon;
			agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public Vector<Integer> getErabiltzaileak(String mota)
			throws IllegalStateException, SQLException {

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
	public String getErabDatuak(int erabId) throws IllegalStateException,
			SQLException {
		String izena = null;
		String c4 = "SELECT E.izena "
				+ "FROM erabiltzaileak AS E INNER JOIN txartelak AS T ON T.erabId=E.id "
				+ "WHERE E.id = " + erabId;
		ResultSet q = agindua.executeQuery(c4);
		while (q.next())
			izena = q.getString("E.izena");
		return izena;
	}
}
