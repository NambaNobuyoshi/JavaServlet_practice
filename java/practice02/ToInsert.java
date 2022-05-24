package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登録内容確認画面から登録画面へ遷移する。
 * @author nanba
 */
@WebServlet("/ToInsert")
public class ToInsert extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータを取得、格納*/
		Memo memo = new Memo();
		memo.setTitle(request.getParameter("title"));
		memo.setContent(request.getParameter("content"));
		
		/*パラメータを格納したオブジェクトをスコープに登録する*/
		request.setAttribute("memo", memo);
		/*登録画面へ遷移*/
		request.getRequestDispatcher("/memoapp/insert.jsp").forward(request, response);
	}

}
