package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 更新内容確認画面へ遷移する
 * @author nanba
 */
@WebServlet("/ToUpdateCheck")
public class ToUpdateCheck extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータを取得*/
		Memo memo = new Memo();
		String idStr=request.getParameter("id");
		int id = Integer.parseInt(idStr);
		memo.setId(id);
		memo.setTitle(request.getParameter("title"));
		memo.setContent(request.getParameter("content"));
		
		/*DTOをスコープに登録*/
		request.setAttribute("memo", memo);
		/*編集内容確認画面へ遷移*/
		request.getRequestDispatcher("/memoapp/updateCheck.jsp").forward(request, response);
	}

}
