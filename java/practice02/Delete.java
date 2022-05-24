package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DBに接続し、論理削除を実行する
 * @author nanba
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータの取得*/
		String idStr = request.getParameter("id");
		
		/*論理削除を実行*/
		MemoDao.delete(idStr);
		
		/*一覧画面へ戻る*/
		request.getRequestDispatcher("/SelectAll").forward(request, response);
	}

}
