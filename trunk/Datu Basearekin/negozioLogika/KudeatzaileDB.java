package negozioLogika;

import java.sql.SQLException;

public class KudeatzaileDB {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/eraikikon";
	private static final String USERNAME = "ikasle01";
	private static final String PASSWORD = "ikasle01";
	
	static final String DEFAULTQUERY="SELECT * FROM intzidentziak";
	
	private ResultSetTableModel r;
	
	public KudeatzaileDB()
	{
		try {
			r = new ResultSetTableModel(JDBC_DRIVER, DATABASE_URL, USERNAME, PASSWORD, KudeatzaileDB.DEFAULTQUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSetTableModel getIntzidendentziak()
	{
		String query = "SELECT * FROM intzidentziak";
		try {
			r.setQuery(query);
			return r;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSetTableModel getGatazkatsuenak(String data)
	{
		String query = "SELECT E.id AS 'Erabiltzaile ID', E.izena AS 'Erabiltzaile Izena', T.id AS 'Txartel Zenbakia', COUNT(*) AS 'Ukapen Kopurua' FROM (((profilak AS P INNER JOIN erabiltzaileak AS E ON E.profId=P.id)INNER JOIN txartelak AS T ON T.erabId=E.id) INNER JOIN sarbideeskaerak AS S ON S.txId=T.id) INNER JOIN txartelirakurgailuak AS I ON S.txIrakurId=I.id WHERE P.mota='irakaslea' AND T.desgaituData IS NULL AND T.gaituData <= DATE_SUB(NOW(), INTERVAL 2 YEAR) AND S.data>='"+data+"' AND S.baimenduta='0' GROUP BY E.id, E.izena, T.id ORDER BY COUNT(*) DESC LIMIT 10";
		try {
			r.setQuery(query);
			return r;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSetTableModel getTxartelIrak(String txartId)
	{
		String query="SELECT txIrakurId, COUNT(*) FROM sarbideeskaerak WHERE txid=" + txartId + " AND baimenduta=0 GROUP BY txId, txIrakurId HAVING COUNT(*) >= ALL (SELECT COUNT(*) FROM sarbideeskaerak WHERE txId=" + txartId +" AND baimenduta=0 GROUP BY txId, txIrakurId)";
		try {
			r.setQuery(query);
			return r;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void createIntzidentzia(String txartId, String tIrakId, String noiztikNora)
	{
		String insert="INSERT INTO intzidentziak (data, mota, idTxartela, idTxartelIrakurgailua, gaituta, noiztikNora) VALUES (NOW(), 'irakasleGatazkatsua'," + txartId + ", " + tIrakId + ",true, '" + noiztikNora + "')";
		try {
			r.setUpdate(insert);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deskonektatu()
	{
		r.disconnectFromDatabase();
	}
}
