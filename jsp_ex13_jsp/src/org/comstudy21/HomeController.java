package org.comstudy21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/*")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Hashtable<String, ArrayList<LeftItem>> leftMenuMapping = new Hashtable<>();
	static{
		// static 초기화
		ArrayList<LeftItem> javaList = new ArrayList<>();
		javaList.add(new LeftItem("변수와 함수", "/java/ch01/"));
		javaList.add(new LeftItem("클래스", "/java/ch02/"));
		javaList.add(new LeftItem("다형성", "/java/ch03/"));
		javaList.add(new LeftItem("객체지향프로그래밍", "/java/ch04/"));
		javaList.add(new LeftItem("디자인패턴", "/java/ch05/"));
		leftMenuMapping.put("java", javaList);
		
		ArrayList<LeftItem> databaseList = new ArrayList<>();
		databaseList.add(new LeftItem("DDL", "/db/ch01/?dir=db&page=db_ch01"));
		databaseList.add(new LeftItem("DML", "/db/ch02/"));
		databaseList.add(new LeftItem("DCL", "/db/ch03/"));
		databaseList.add(new LeftItem("SQL", "/db/ch04/"));
		databaseList.add(new LeftItem("Back Up", "/db/ch05/"));
		leftMenuMapping.put("database", databaseList);
		
		ArrayList<LeftItem> servletList = new ArrayList<>();
		servletList.add(new LeftItem("servlet1", "/servlet/ch01/?dir=db&page=db_ch01"));
		servletList.add(new LeftItem("servlet2", "/servlet/ch02/"));
		servletList.add(new LeftItem("servlet3", "/servlet/ch03/"));
		servletList.add(new LeftItem("servlet4", "/servlet/ch04/"));
		servletList.add(new LeftItem("servlet5", "/servlet/ch05/"));
		leftMenuMapping.put("servlet", servletList);
		
		ArrayList<LeftItem> jqueryList = new ArrayList<>();
		jqueryList.add(new LeftItem("jquery1", "/jquery/ch01/?dir=db&page=db_ch01"));
		jqueryList.add(new LeftItem("jquery2", "/jquery/ch02/"));
		jqueryList.add(new LeftItem("jquery3", "/jquery/ch03/"));
		jqueryList.add(new LeftItem("jquery4", "/jquery/ch04/"));
		jqueryList.add(new LeftItem("jquery5", "/jquery/ch05/"));
		leftMenuMapping.put("jquery", jqueryList);
		
		ArrayList<LeftItem> pythonList = new ArrayList<>();
		pythonList.add(new LeftItem("python1", "/python/ch01/?dir=db&page=db_ch01"));
		pythonList.add(new LeftItem("python2", "/python/ch02/"));
		pythonList.add(new LeftItem("python3", "/python/ch03/"));
		pythonList.add(new LeftItem("python4", "/python/ch04/"));
		pythonList.add(new LeftItem("python5", "/python/ch05/"));
		leftMenuMapping.put("python", pythonList);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("page") != null){
			String key = req.getParameter("page");
			System.out.println(key);
			ArrayList<LeftItem> leftItems = leftMenuMapping.get(key);
			System.out.println(leftItems);
			req.setAttribute("leftItems", leftItems);
		}
		String viewName = "/WEB-INF/views/home.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		view.forward(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

}
