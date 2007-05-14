package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	
	public Vector<Vector<Object>> getErabiltzaileKokapena(String txId)throws 
	IllegalStateException,SQLException {


		String c3 = "SELECT e.izena, " + "e.id, t.id, g.id, g.izena, s.data " + 
		"FROM (((guneak g " + 
		"INNER JOIN txartelirakurgailuak ti ON g.id=ti.guneId) " +
		"INNER JOIN sarbideeskaerak s ON ti.id=s.txIrakurId) " +
		"INNER JOIN txartelak t ON s.txId=t.id) " +
		"INNER JOIN erabiltzaileak e ON t.erabId=e.id " +
		"WHERE s.txId= " + txId + " AND s.data <= ALL "+
		"(SELECT data FROM sarbideeskaerak "+
        "WHERE txId= " + txId + ")";


		ResultSet q = this.agindua.executeQuery(c3);
		Vector<Vector<Object>> erabKokapena = new Vector<Vector<Object>>();
		while (q.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int i = 1; i <=q.getMetaData().getColumnCount(); i++)
				row.addElement(q.getObject(i));
			erabKokapena.addElement(row);
		}
		return erabKokapena;
		}
	
	public String getErabIzena(int txId) throws SQLException
	{
		String query = "SELECT E.izena " +
					"FROM erabiltzaileak AS E INNER JOIN txartelak AS T ON E.id = T.erabId " +
					"WHERE T.id = " + txId;
		ResultSet r = agindua.executeQuery(query);
		if (r.next())
			return r.getString("izena");
		else
			return null;
	}
	
	public void gaituTxartela(int nan){
		String txart = "INSERT INTO txartelak (gaituData,desgaituData,erabId) "
			+ "VALUES (NOW(),'null,'"+nan+"')";
		try {
			this.agindua.executeUpdate(txart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void desgaituTxartela(int nan){
		String txart = "UPDATE txartelak SET desgaituData=NOW()WHERE erabId='"+nan+"'";
		try {
			this.agindua.executeUpdate(txart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gaitTxartela(int nan){
		String txart = "UPDATE txartelak SET gaituData=NOW(), desgaituData=null WHERE erabId='"+nan+"'";
		try {
			this.agindua.executeUpdate(txart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
