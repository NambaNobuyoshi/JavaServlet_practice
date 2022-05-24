package practice02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全件検索を行い、結果を一覧画面へ渡す
 * @author nanba
 */
@WebServlet("/SelectAll")
public class SelectAll extends HttpServlet {
	
	/**URLを直打ちする場合はGetメソッド
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*全件検索を行う*/
		List<Memo> memoList = MemoDao.selectAll();
		
		/*全件検索で取得したオブジェクトのリストをスコープに渡す*/
		request.setAttribute("memoList", memoList);
		/*一覧画面へ遷移*/
		request.getRequestDispatcher("/memoapp/list.jsp").forward(request, response);
	}
	
	/**サーブレットから呼ばれる場合は、Postメソッドが使用される
	 * 値を秘匿するために、ほかサーブレットでは基本的にPostメソッドを使用している。
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*全件検索を行う。
		 * 結果はMemoクラスのリストに格納する*/
		List<Memo> memoList = MemoDao.selectAll();
		
		/*全件検索で取得したMemoクラスのリストをスコープに渡す*/
		request.setAttribute("memoList", memoList);
		/*一覧画面へ遷移*/
		request.getRequestDispatcher("/memoapp/list.jsp").forward(request, response);
	}

}
