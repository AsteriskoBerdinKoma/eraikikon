package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Statement;

/**
 * Sarbide eskaerekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class SarbideEskKud {

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

	public SarbideEskKud(Connection kon) {
		try {
			konexioa = kon;
			agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Emandako txartel zenbakiak, emandako datatik aurrera izandako
	 * sarbide-eskaera ukatuak itzultzen ditu. Datuak {@link Vector} klase
	 * batean gordetzen dira. Bektorea txartelirakurgailuen arabera ordenatuta
	 * dago.
	 * 
	 * @param txartelId
	 *            Datu-baseko sarbideeskaerak taulan adierazitako txartelaren id
	 *            bat da, zenbaki bat.
	 * 
	 * @param data
	 *            Erabitlzaileak emandako data bat adierazten du (UUUU-HH-EE)
	 *            formatuarekin. Aldagai hau String motakoa da, datu-baseari
	 *            galdera egiteko sententzian gehitu ahal izateko.
	 * @return Txartel batek, data batetik aurrera dituen sarbide-eskaera
	 *         ukatuen txartel-irakurgailuen id-ak itzultzen dira. Emaitza
	 *         txartel batek txartel-irakurgailu batean izandako ukapen
	 *         kopuruaren arabera ordenatzen da. Lehenengo posizioan txartel
	 *         horren txartel irakurgailu ukatuena egongo da. Txartelak emandako
	 *         datatik aurrera sarbide-eskaera ukaturik izan ez badu bektore
	 *         hutsa itzuliko da.
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public Vector<Integer> getSarbideEskaeraUkatuak(int txartelId, String data)
			throws IllegalStateException, SQLException {
		Vector<Integer> vTxIrakurId = new Vector<Integer>();
		String c3 = "SELECT S.txIrakurId AS TxartelIrak, COUNT(*) AS Kop "
				+ "FROM sarbideeskaerak AS S INNER JOIN txartelirakurgailuak AS T ON S.txIrakurId=T.id "
				+ "WHERE S.txId=" + txartelId + " AND S.data>='" + data
				+ "' AND S.baimenduta='0' " + "GROUP BY S.txIrakurId "
				+ "ORDER BY COUNT(*) DESC";

		ResultSet q = agindua.executeQuery(c3);
		while (q.next()) {
			for (int i = 0; i < q.getInt("Kop"); i++) {
				vTxIrakurId.addElement(q.getInt("TxartelIrak"));
			}
		}
		return vTxIrakurId;
	}
	
	public Vector getSarbideEskaerak(String data) 
			throws IllegalStateException, SQLException {
		Vector<Integer> vTxIrakurId = new Vector<Integer>();
		String c4=
			"SELECT A.id AS AteID,S.data AS SarbideData,S.txId AS TxartelID,G.id AS GuneID,S.baimenduta,S.ukapenarenArrazoia "+
			"FROM ((sarbideeskaerak AS S INNER JOIN txartelirakurgailuak AS T ON S.txIrakurId=T.id) " +
				 "INNER JOIN guneak AS G ON G.id=T.guneId) INNER JOIN ateak AS A ON A.id=T.ateId "+
			"WHERE S.data BETWEEN '"+data+" 00:00:00' AND '"+data+" 23:59:59' " +
			"GROUP BY A.id "+
			"ORDER BY S.data ";
		ResultSet q = agindua.executeQuery(c4);
		//while (q.next()) {
		//	for (int i = 0; i < q.getInt("Kop"); i++) {
		//		vTxIrakurId.addElement(q.getInt("TxartelIrak"));
		//	}
		//}
		return vTxIrakurId;
	}
}
