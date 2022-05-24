package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 削除確認画面へ遷移する。その際、パラメータの受け渡しを行う
 * @author nanba
 */
@WebServlet("/ToDeleteCheck")
public class ToDeleteCheck extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータを取得、格納*/
		Memo memo = new Memo();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		memo.setId(id);
		memo.setTitle(request.getParameter("title"));
		memo.setContent(request.getParameter("content"));
		
		/*パラメータが格納されているMemoクラスのオブジェクトをスコープに登録*/
		request.setAttribute("memo", memo);
		/*削除確認画面へ遷移*/
		request.getRequestDispatcher("/memoapp/deleteCheck.jsp").forward(request, response);
	}

}
