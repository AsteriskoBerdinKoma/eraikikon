package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Profilekin erlazionaturik dauden datu-basearen aurkako eskaerak
 * gauzatzeko klasea.
 * 
 * @author 5. TALDEA
 * 
 */
public class ProfKud {
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
	public ProfKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	/**
	 * Bisitariak ez diren profil mota guztiak itzultzen ditu
	 * 
	 * @return Bisitariak ez diren profil guztien izenen Stringak dituen bektorea  
	 * @throws SQLException
	 */
	public Vector<String> getProfilak() throws SQLException {
		Vector<String> profMotaV = new Vector<String>();
		String c1 = "SELECT mota  FROM profilak WHERE mota !='Bisitari'";
		ResultSet q = agindua.executeQuery(c1);
		while (q.next())
			profMotaV.addElement(new String(q.getString("mota")));
		return profMotaV;
	}

	/**
	 * Emandako motari dagokion profil zenbakia itzultzen du
	 * 
	 * @param mota Zenbakia nahi dugun profilaren mota
	 * @return Emandako profil motari dagokion identifikatzailea. Existitzen ez bada 0 itzuliko du
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public int profilZenbakia(String mota) throws IllegalStateException,SQLException {
		int profZenb = 0;
		String c2 = "SELECT id FROM profilak WHERE mota ='" + mota + "'";
		ResultSet rs = agindua.executeQuery(c2);
		if (rs.next())
			profZenb = rs.getInt("id");
		return profZenb;
	}
	
	/**
	 * Emandako deskribapena eta mota duen profil bat sortze du
	 * 
	 * @param mota Profilaren mota
	 * @param deskribapena Profilaren deskribapena
	 * @throws IllegalStateException
	 * @throws SQLException
	 */
	public void createProfila(String mota, String deskribapena) throws IllegalStateException,SQLException {
		String txart = "INSERT INTO profilak (mota,deskribapena) "
				+ "VALUES ('"+mota+"','" + deskribapena + "')";
		agindua.executeUpdate(txart);
	}

	/**
	 * Emandako mota eta deskribapenari dagokion profil zenbakia itzultzen du
	 * 
	 * @param mota Zenbakia dugun profilaren mota
	 * @param deskribapena Zenbakia nahi dugun profilaren deskribapena
	 * @return Emandako profil mota eta deskribapenari dagokion identifikatzailea. Existitzen ez bada 0 itzuliko du
	 * @throws SQLException
	 */
	public int profilZenbakia(String mota, String deskribapena) throws SQLException {
		int profZenb = 0;
		String c2 = "SELECT id FROM profilak WHERE mota ='" + mota + "' AND deskribapena = '"+deskribapena+"'";
		ResultSet rs = agindua.executeQuery(c2);
		if (rs.next())
			profZenb = rs.getInt("id");
		return profZenb;
	}

}
