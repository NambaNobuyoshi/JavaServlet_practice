package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前画面からtitle、contentを取得し、DBへ登録を行う
 * @author nanba
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*前画面からパラメータの取得*/
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		/*INSERT文を実行*/
		MemoDao.insert(title, content);
		/*登録完了後、一覧画面へ戻る (その前段階として、全件検索を行う)*/
		request.getRequestDispatcher("/SelectAll").forward(request, response);
		
	}

}
