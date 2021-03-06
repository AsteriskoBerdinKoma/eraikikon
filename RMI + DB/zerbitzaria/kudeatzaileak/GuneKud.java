package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.mysql.jdbc.Statement;

/**
 * Guneekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class GuneKud {

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
	public GuneKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	/**
	 * Datu basean dauden intzidentzia guztiak itzultzen ditu. Intzidentziaren
	 * datu bakoitza {@link Object} datu mota batetan gordetzen du eta lerro
	 * bateko objektu guztiekin bektore bat osatuko du. Azkenik, lerro guztiekin
	 * beste bektore bat osatuko du.
	 * 
	 * @return lehenengo bektorean lerroak gordeko dira datu bakoitzeko Object
	 *         bat sortuz. Sortutako lerro bakoitzeko bektorea bigarren
	 *         bektorean gordetzen da azken honek taula osoa osatuz.
	 */
	public Vector<Vector<Object>> getGuneGuztiak()throws SQLException {

		String query = 
			"SELECT g.id,g.izena,t.ateid,t.id " +
			"FROM txartelirakurgailuak t INNER JOIN ateak a ON t.ateid=a.id " +
				 "INNER JOIN guneak g ON g.id=t.guneid " +
			"ORDER BY g.id";
		ResultSet rs = this.agindua.executeQuery(query);
		Vector<Vector<Object>> lerroak = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				row.addElement(rs.getObject(i));
			lerroak.addElement(row);
		}
		return lerroak;

	}

}
