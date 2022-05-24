package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前画面から渡された各種データを使用して、memoテーブルの更新を行う
 * @author nanba
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*パラメータの取得*/
		String idStr = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		/*UPDATE文を発行*/
		MemoDao.update(idStr, title, content);
		
		/*UPDATEした行をDTOに格納*/
		Memo memo =MemoDao.findById(idStr);
		
		/*DTOオブジェクトをスコープに登録*/
		request.setAttribute("memo", memo);
		/*詳細画面へ遷移*/
		request.getRequestDispatcher("/memoapp/detail.jsp").forward(request, response);
	}

}
