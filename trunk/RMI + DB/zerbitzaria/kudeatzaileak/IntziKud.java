package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Intzidentziekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class IntziKud {

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
	public IntziKud(Connection kon) throws SQLException {
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
	 * @throws SQLException
	 */
	public Vector<Vector<Object>> getIntzidentziak() throws SQLException {
		String query = "SELECT * FROM intzidentziak";
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

	/**
	 * Denbora tarte bateko irakasle gatazkatsuenarekin itzidentzia bat sortzen
	 * du.
	 * 
	 * @param TxartelId
	 *            Irakasle gatazkatsuenaren txartel identifikadorea daukan
	 *            String bat
	 * @param TxartelIrakId
	 *            Irakasle gatazkatsuenak arazo gehien eduki duen txartel
	 *            irakurgailuaren identifikadorea daukan String bat
	 * @param noiztikNora
	 *            Zein denbora tartean izan den irakasle hori gatazkatsuena.
	 *            String-ak honako formatua eduki behar du:
	 *            <p>
	 *            UUUU-HH/UUUU-HH
	 * @throws SQLException
	 */
	public void insertIntzGatazkatsuena(String TxartelId, String TxartelIrakId,
			String noiztikNora) throws SQLException {
		String intz = "INSERT INTO intzidentziak (data, mota, idTxartela, idTxartelIrakurgailua, gaituta, noiztikNora) "
				+ "VALUES (NOW(), 'irakasleGatazkatsua',"
				+ TxartelId
				+ ", "
				+ TxartelIrakId + ",true, '" + noiztikNora + "')";
		this.agindua.executeUpdate(intz);
	}

	public void insertAlarma() throws SQLException {
		String intz = "INSERT INTO intzidentziak (data, mota, gaituta) "
				+ "VALUES (NOW(), 'alarma', true)";
		this.agindua.executeUpdate(intz);
	}
}
