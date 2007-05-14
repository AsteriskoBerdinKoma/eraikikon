package zerbitzaria.kudeatzaileak;

import java.sql.Connection;
import java.sql.ResultSet;
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
		 */
		public AteKud(Connection kon) {
			try {
				this.konexioa = kon;
				this.agindua = (Statement) konexioa.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void IrekiAteak(){
			String query = "UPDATE ateak SET egoera = 'irekita'";
				try {
					this.agindua.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		public void ItxiAteak(){
			String query = "UPDATE ateak SET egoera = 'itxita'";
			try {
				this.agindua.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
