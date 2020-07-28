package httpSessionListener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("userID");
		String pw = req.getParameter("passwd");
		
		HttpSession session = req.getSession();
		if(session.isNew()){
			session.setAttribute("login", id);
		}
		
		out.println("<html><body>");
		out.println("userID: " + id + "<br>");
		out.println("password: " + pw + "<br>");
		out.println("총 접속자 수는 " + SessionListener.activeSessions);
		out.println("</body></html>");
	}
}
