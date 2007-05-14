package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProfKud {
	private Connection konexioa;

	private Statement agindua;

	public ProfKud(Connection kon) {
		try {
			this.konexioa = kon;
			this.agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<String> getProfilak() throws IllegalStateException, SQLException {
		Vector<String> profMotaV = new Vector<String>();
		String c1 = "SELECT mota  FROM profilak";
		ResultSet q = agindua.executeQuery(c1);
		while (q.next())
			profMotaV.addElement(new String(q.getString("mota")));
		return profMotaV;
	}
	
	public int profilZenbakia(String mota) throws SQLException{
		int profZenb = 0;
		String c2= "SELECT id FROM profilak WHERE mota ='"+mota+"'";
		ResultSet rs = agindua.executeQuery(c2);
		if(rs.next())
			profZenb = rs.getInt("id");
		return profZenb;
		
	}
	
}
