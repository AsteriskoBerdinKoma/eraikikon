package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TxartelIrakKud {

	private Connection konexioa;

	private Statement agindua;

	public TxartelIrakKud(Connection kon){
		try {
			this.konexioa = kon;
			this.agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getHelburuGunea(int ateid,int guneid) 
			throws IllegalStateException, SQLException {
		String c6="SELECT T.guneId " +
				  "FROM txartelirakurgailuak AS T" +
				  "WHERE T.ateId="+ateid+" AND T.guneId!="+guneid;
		ResultSet q = agindua.executeQuery(c6);
		if (q.next())
			return q.getInt("T.guneId");
		else
			return -1;
					
		
	}
}