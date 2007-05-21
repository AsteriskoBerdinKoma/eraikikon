package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Txartel irakurleekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class TxartelIrakKud {

	private Connection konexioa;

	private Statement agindua;

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
	public TxartelIrakKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	/**
	 * Emandako ateak pasatako gunea ez den beste gunearen id-a itzultzen du
	 * 
	 * @param ateid Bere beste gunea jakin nahi dugun atea
	 * @param guneid Jakin nahi dugun atearen gunea ez den gunea
	 * @return Pasatako atearen gunea, pasatako gunea ez dena
	 * @throws SQLException
	 */
	public int getHelburuGunea(int ateid, int guneid)throws SQLException {
		String c6 = "SELECT guneId " + "FROM txartelirakurgailuak "
				+ "WHERE ateId=" + ateid + " AND guneId!=" + guneid;
		ResultSet q = agindua.executeQuery(c6);
		if (q.next())
			return q.getInt("guneId");
		else
			return -1;

	}
}