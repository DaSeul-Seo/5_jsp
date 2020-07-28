package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 나중에 DB에서 가져올 부분
	String loginId = "kim";
	String loginPass = "1111";

	@Override
	// forword 역할만 ==> 화면 전환
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/login_form.jsp";
		
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// Encoding 하고 나서 작성
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		if(session.isNew()){
			out.print("<p>Welcom! <br> Create New Session </p>");
		}
		String userId = req.getParameter("userId");
		String passwd = req.getParameter("passwd");
		
		if(session.getAttribute("login.id") !=null){
			out.println("<p>이미 로그인 되어있습니다.</p>");
		}else if(userId.equals(loginId)&& passwd.equals(loginPass)){
			session.setAttribute("login.id", userId);
			out.println("<p>Login Success</p>");
			out.println("");			
		} else{
			out.println("<p>Login Fail</p>");
		}
		out.println("<p><a href=login.do>Login Page</a></p>");
	}
}
