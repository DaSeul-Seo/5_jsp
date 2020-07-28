package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method ...");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method ...");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("hello servlet ... doGet");
		
		// printWriter 객체 리턴
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>안녕 서블릿!</h1>");
		out.println("</body></html>");
		
		out.close();
	}
}

