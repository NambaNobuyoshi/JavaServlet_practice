package practice02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JSPからIDを受け取り、IDに紐づくデータを次画面へ渡す
 * @author nanba
 */
@WebServlet("/FindById")
public class FindById extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*前画面からパラメータを取得*/
		String idStr = request.getParameter("id");
		/*ID検索、IDに紐づくデータをDTOに格納*/
		Memo memo = MemoDao.findById(idStr);
		
		/*DTOデータをリクエストスコープに格納*/
		request.setAttribute("memo", memo);
		/*詳細画面へ遷移*/
		request.getRequestDispatcher("/memoapp/detail.jsp").forward(request, response);
	}

}
