package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/**
 * Txartelekin erlazionaturik dauden datu-basearen aurkako eskaerak gauzatzeko
 * klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class TxartelKud {

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
	public TxartelKud(Connection kon) {
		try {
			konexioa = kon;
			agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Erabiltzaile baten identifikazioa emanda, orain dela 2 urte baino denbora
	 * tarte gutxiagoan gaituak izan direnak eta gaur egun gaituta jarraitzen
	 * dutenak itzultzen ditu.
	 * 
	 * @param erabId
	 *            erabiltzaile baten identifikazioa daukan zenbaki oso bat
	 * @return txartelaren identifikazioak
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public int getTxartel2Urte(int erabId) throws IllegalStateException,
			SQLException {
		Integer biUrte = null;
		String c2 = "SELECT id " + "FROM txartelak " + "WHERE erabId= "
				+ erabId + " AND gaituData<=DATE_SUB(NOW(), "
				+ "INTERVAL 2 YEAR) AND desgaituData IS NULL";
		ResultSet q = agindua.executeQuery(c2);
		if (q.next())
			biUrte = (Integer) q.getInt("id");
		else
			biUrte = -1;
		return biUrte.intValue();
	}
}
