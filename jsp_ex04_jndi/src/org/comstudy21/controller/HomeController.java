package org.comstudy21.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dto.Person;

public class HomeController extends HttpServlet {
	private Person person = new Person("kim", "1111", 28);
	
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
		System.out.println("doGet - HomeController");
		
		req.setAttribute("PERSON", person);
		
		// printWriter 출력 
//		PrintWriter out = resp.getWriter();
//		out.println("<html><body>");
//		out.println("<h1>home page</h1>");
//		out.println("</body></html>");
		
		String path = "/WEB-INF/jsp/home.jsp";
		RequestDispatcher view = req.getRequestDispatcher(path);
		view.forward(req, resp);
	}
}