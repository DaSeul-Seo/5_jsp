package jsp_ex16_EL;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/el_test")
public class ElTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("req_msg", "request message");
		
		HttpSession session = request.getSession();
		session.setAttribute("ses_msg", "session message");
		
		String viewName="/WEB-INF/views/el_test.jsp";
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
