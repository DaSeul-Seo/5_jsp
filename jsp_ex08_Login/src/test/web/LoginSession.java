package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/pptlogin")
public class LoginSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		HttpSession session = req.getSession();
		
		if(session.isNew()) {
			session.setAttribute("login.name", name);
			session.setAttribute("login.id", id);
			session.setAttribute("login.pass", pass);			
		}
		out.print("<html><body><center>�ȳ��ϼ���");
		out.print(name);
		out.print("��</center>");
		out.print("<a href=pptshow>ȸ����������</a>");
		out.print("</body></html>");
	}
	
}