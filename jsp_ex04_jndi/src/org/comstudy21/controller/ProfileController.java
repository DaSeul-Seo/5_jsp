package org.comstudy21.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileController extends HttpServlet {
	private String userName = "홍길동";
	private String userAddr = "서울시 종로구 견지동";
	int age = 21;
	
	@Override
	public void init() throws ServletException {
		System.out.println("init method ...");
	}
	private void destory() {
		System.out.println("destroy method ...");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("doGet - ProfileController");
		
		req.setAttribute("USER_NAME", userName);
		req.setAttribute("USER_ADDR", userAddr);
		req.setAttribute("USER_AGE", age);
		
		// printWriter 객체 
//		PrintWriter out = resp.getWriter();
//		out.println("<html><body>");
//		out.println("<h1>profile page</h1>");
//		out.println("</body></html>");
		
		String path = "/WEB-INF/jsp/profile.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		// req는 주소가 바뀌면 사라진다.
		// qpplication 톰캣이 꺼지기 전까지는 살아있다.
		view.forward(req, resp);
		
	}
}