package org.comstudy21.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.command.CartCommand;
import org.comstudy21.command.Command;
import org.comstudy21.command.DetailCommand;
import org.comstudy21.command.ListCommand;
import org.comstudy21.command.Resolve;

@WebServlet("*.do")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Hashtable<String, Command> commandMap = new Hashtable<>();
	public ShopController() {
		commandMap.put("list", new ListCommand());
		commandMap.put("cart", new CartCommand());
		commandMap.put("detail", new DetailCommand());
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet과 doPost 함침
		String method = req.getMethod();
		System.out.println("process >> " + method);
		
		PrintWriter out = resp.getWriter();
		
		String path = (String)req.getAttribute("path");
		path = path.substring("car/".length());
		
		System.out.println("path>>>> " + path);
		
		if("GET".equals(method)){
//			System.out.println("GET으로 요청");
//			out.println("<p>GET으로 요청" + req.getAttribute("path") + "</p>");
			Command cmd = commandMap.get(path);
			Resolve res = cmd.action(req, resp);
			res.forword(req, resp);
			
		} else if("POST".equals(method)){
			System.out.println("POST로 요청");	
			out.println("<p>POST으로 요청" + req.getAttribute("path") + "</p>");
			String carName = req.getParameter("name");
			out.println("차종: " + carName);
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doGet >> ShopController");
		process(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("doPost >> ShopController");
		process(req,resp);
	}
}
