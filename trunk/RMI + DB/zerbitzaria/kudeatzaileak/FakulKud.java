package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Propietario
 *
 */
public class FakulKud {

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
	 */
	public FakulKud(Connection kon) {
		try {
			this.konexioa = kon;
			this.agindua = (Statement) konexioa.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Eraikinean dauden pertsonen kopurua itziltzen du. 
	 * @return int batean eraikinean dauden pertsonen kopurua.
	 * @throws SQLException
	 */
	public int getEraikinekoPertsonKop() {
		int kop = 0;
			String query = "SELECT Count(erId) AS kopuru FROM fakultatea";
			ResultSet rs;
			try {
				rs = this.agindua.executeQuery(query);
				if (rs.next())
					kop = rs.getInt("kopuru");
				return kop;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}	
	}
	
	public void pertsonakAteraEraikinetik(){
		String query = "DELETE FROM fakultatea";
		try {
			this.agindua.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
