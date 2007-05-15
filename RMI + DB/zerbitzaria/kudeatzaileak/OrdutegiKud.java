package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdutegiKud {
	private Connection konexioa;

	private Statement agindua;

	public OrdutegiKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	public void createOrdutegia(boolean jaiEguna, String hasOrdua, String bukOrdua, int profId, int guneId) throws SQLException {
		String query= "INSERT INTO ordutegia (jaiEguna,hasieraOrdua,bukaeraOrdua,proId,guneId) VALUES ("+String.valueOf(jaiEguna)+",'"+hasOrdua+"','"+bukOrdua+"',"+profId+", "+guneId+")";
		agindua.executeUpdate(query);
	}
	
	
}
