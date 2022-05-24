package practice02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**Memoテーブルアクセス用クラス
 * @author nanba
 * */
public class MemoDao {
	
	/**全件検索用メソッド
	 * @return List<Memo> :メモクラスのリスト。1行分のデータがリストの要素となる
	 * */
	public static List<Memo> selectAll() {
		/*変数の用意*/
		Connection con = null;
		PreparedStatement ps = null;
		List<Memo> memoList = new ArrayList<>();
		
		try {
			
			/*DB接続*/
			con = DBManager.getConnection();
			/*SQL定義
			 *  削除フラグが立っていないデータのみを全件検索する*/
			ps = con.prepareStatement("SELECT * FROM memo WHERE del_flg != 1 ");
			/*SQLの実行結果を変数に入れる*/
			ResultSet rs = ps.executeQuery();
			
			/*実行結果を一行ずつ処理していく*/
			while(rs.next()) {
				/*現在の行のデータを取得し、オブジェクトクラスに格納する*/
				Memo memo = new Memo();
				memo.setId(rs.getInt("memo_id"));
				memo.setTitle(rs.getString("memo_title"));
				memo.setContent(rs.getString("memo_content"));
				
				/*現在の行のデータを格納したクラスをリストに追加する*/
				memoList.add(memo);
			}
		}catch (SQLException e) {
			/*SQLエラーが発生した場合、キャッチする*/
			e.printStackTrace();
		}finally{
			/*DB接続を切る*/
			DBManager.close(ps,con);
		}
		
		return memoList;
		
	}
	
	/**ID検索メソッド
	 *  引数に受け取ったIDに対応するデータを検索し、DTOに格納して返す。
	 * @param String idStr : データのID。
	 * @return Memo : IDに対応するデータを持つMemoクラスのオブジェクト
	 * */
	public static Memo findById(String idStr){
		/*変数用意*/
		Connection con = null;
		PreparedStatement ps = null;
		int id = Integer.parseInt(idStr);
		Memo memo = new Memo();
		
		try {
			/*DB接続*/
			con = DBManager.getConnection();
			/*SQL定義
			 *  IDに対応するデータを検索*/
			ps = con.prepareStatement("SELECT * FROM memo WHERE memo_id = ?");
			ps.setInt(1, id);
			/*SQLの実行結果を変数に格納*/
			ResultSet rs = ps.executeQuery();
			rs.next();
			/*SQLの実行結果をMemoクラスのオブジェクトに格納*/
			memo.setId(rs.getInt("memo_id"));
			memo.setTitle(rs.getString("memo_title"));
			memo.setContent(rs.getString("memo_content"));
			
		}catch (SQLException e) {
			/*SQLエラーが発生した場合、キャッチする*/
			e.printStackTrace();
			
		}finally {
			/*DB接続を切る*/
			DBManager.close(ps,con);
		}
		
		return memo;
		
	}
	
	/**登録用メソッド
	 *  引数に受け取った内容で、memoテーブルにデータを挿入する。
	 * @param String title : メモのタイトル
	 * @param String content : メモの内容
	 * */
	public static void insert(String title ,String content) {
		/*変数の用意*/
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			/*DB接続*/
			con = DBManager.getConnection();
			/*SQL発行
			 *  引数を使用して、INSERT文を発行する。
			 *   memo_id の値はシーケンスを利用して設定する
			 *   del_flg の値は、登録時は 0 を設定する*/
			ps = con.prepareStatement("INSERT INTO memo VALUES (NEXT VALUE FOR memo_sequence ,? ,? ,0)");
			ps.setString(1, title);
			ps.setString(2, content);
			/*SQLを実行する*/
			ps.executeQuery();
		}catch (SQLException e) {
			/*SQLエラーが発生した場合、キャッチする*/
			e.printStackTrace();
		}finally {
			/*DB接続を切る*/
			DBManager.close(ps, con);
		}
		
	}
	
	/**削除用メソッド(論理削除)
	 *  引数に受け取ったIDに対応するデータを論理削除する
	 * @param String idStr : メモのIDの値
	 * */
	public static void delete(String idStr) {
		/*変数の用意*/
		Connection con = null;
		PreparedStatement ps = null;
		int id =Integer.parseInt(idStr);
		
		try {
			/*DB接続*/
			con = DBManager.getConnection();
			/*SQL発行
			 *  IDを受け取り、該当IDのdel_flg(削除フラグ)を１に更新する*/
			ps = con.prepareStatement("UPDATE memo SET del_flg = 1 WHERE memo_id = ?");
			ps.setInt(1, id);
			/*SQL実行*/
			ps.executeQuery();
			
		}catch (SQLException e) {
			/*SQLエラーが発生した場合、キャッチする*/
			e.printStackTrace();
		}finally {
			/*DB接続を切る*/
			DBManager.close(ps, con);
		}
	}
	
	/**更新用メソッド
	 *  引数に受け取ったIDに対応するデータを、引数に受けとったtitle、contentで更新する
	 * @param String idStr : メモのID
	 * @param String title : メモのタイトル
	 * @param String content : メモの内容
	 * */
	public static void update(String idStr ,String title ,String content) {
		/*変数の用意*/
		Connection con = null;
		PreparedStatement ps = null;
		int id = Integer.parseInt(idStr);
		
		try {
			/*DB接続*/
			con = DBManager.getConnection();
			/*SQL発行
			 * IDに対応するデータのタイトルと内容を更新する*/
			ps = con.prepareStatement("UPDATE memo SET memo_title = ?,"
					+ " memo_content = ? WHERE memo_id = ?");
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, id);
			/*SQL実行*/
			ps.executeQuery();
			
		}catch (SQLException e) {
			/*SQLエラーが発生した場合、キャッチする*/
			e.printStackTrace();
		}finally {
			/*DB接続を切る*/
			DBManager.close(ps, con);
		}
	}

}
