package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 更新画面へ遷移する
 * @author nanba
 */
@WebServlet("/ToUpdate")
public class ToUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータを取得し、格納する*/
		Memo memo = new Memo();
		String idStr=request.getParameter("id");
		int id = Integer.parseInt(idStr);
		memo.setId(id);
		memo.setTitle(request.getParameter("title"));
		memo.setContent(request.getParameter("content"));
		
		/*DTOをスコープに登録*/
		request.setAttribute("memo", memo);
		/*編集画面へ遷移*/
		request.getRequestDispatcher("/memoapp/update.jsp").forward(request, response);
	}

}
