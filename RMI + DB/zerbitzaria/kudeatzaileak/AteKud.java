package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AteKud {

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
	public AteKud(Connection kon) throws SQLException {
		this.konexioa = kon;
		this.agindua = (Statement) konexioa.createStatement();
	}

	public void IrekiAteak() throws SQLException {
		String query = "UPDATE ateak SET egoera = 'irekita'";
		this.agindua.executeUpdate(query);
	}

	public void ItxiAteak() throws SQLException {
		String query = "UPDATE ateak SET egoera = 'itxita'";
		this.agindua.executeUpdate(query);
	}

}
