package practice02;

/*接続に必要なクラスのインポート*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**DB接続用のクラス
 * @author nanba
 * */
public class DBManager {
	
	/**DBへの接続を行うメソッド
	 *@return Connection : 接続情報を持ったConnection型クラス
	 **/
	public static Connection getConnection() {
		try {
			
			/*接続用のドライバ*/
			String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			/*接続用のドライバを入力*/
			Class.forName(driver);
			
			/*接続情報
			 * DatabaseName :接続先のDB名
			 * encrypt ：暗号化接続の有無。今回は暗号化は行わない*/
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName = memoDB; encrypt =false";
			/* user :ユーザー名 ,
			 * pw :userのパスワード*/
			String user = "user01";
			String pw = "pass";
			
			/*接続情報を入力*/
			Connection con = DriverManager.getConnection(url,user,pw);
			
			return con;
		}catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	/**DBとの接続を切るメソッド
	 * 	接続情報を持っているConnectionクラスが与えられた場合、接続を切る
	 * @param Connection con
	 * */
	public static void close(Connection con) {
		
		/*接続が存在していれば、接続を切る動作を行う。*/
		if (con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**DBとの接続を切るメソッド
	 *	接続情報を持っているConnectionクラス、またはPreparedStatementクラスが与えられた場合、接続を切る
	 *@param Connection con
	 *@param PreparedStatement ps
	 * */
	public static void close(PreparedStatement ps, Connection con) {
		
		/*接続が存在していれば、接続を切る動作を行う。*/
		if (con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
