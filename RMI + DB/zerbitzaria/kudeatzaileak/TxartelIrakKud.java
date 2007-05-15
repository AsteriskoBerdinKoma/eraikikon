package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TxartelIrakKud {

	private Connection konexioa;

	private Statement agindua;

	public TxartelIrakKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

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