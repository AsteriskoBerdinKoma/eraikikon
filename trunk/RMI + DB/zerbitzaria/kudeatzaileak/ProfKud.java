package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProfKud {
	private Connection konexioa;

	private Statement agindua;

	public ProfKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	public Vector<String> getProfilak() throws SQLException {
		Vector<String> profMotaV = new Vector<String>();
		String c1 = "SELECT mota  FROM profilak WHERE mota !='Bisitari'";
		ResultSet q = agindua.executeQuery(c1);
		while (q.next())
			profMotaV.addElement(new String(q.getString("mota")));
		return profMotaV;
	}

	public int profilZenbakia(String mota) throws IllegalStateException,SQLException {
		int profZenb = 0;
		String c2 = "SELECT id FROM profilak WHERE mota ='" + mota + "'";
		ResultSet rs = agindua.executeQuery(c2);
		if (rs.next())
			profZenb = rs.getInt("id");
		return profZenb;
	}
	
	public void createProfila(String mota, String deskribapena) throws IllegalStateException,SQLException {
		String txart = "INSERT INTO profilak (mota,deskribapena) "
				+ "VALUES ('"+mota+"','" + deskribapena + "')";
		agindua.executeUpdate(txart);
	}

	public int profilZenbakia(String mota, String deskribapena) throws SQLException {
		int profZenb = 0;
		String c2 = "SELECT id FROM profilak WHERE mota ='" + mota + "' AND deskribapena = '"+deskribapena+"'";
		ResultSet rs = agindua.executeQuery(c2);
		if (rs.next())
			profZenb = rs.getInt("id");
		return profZenb;
	}

}
